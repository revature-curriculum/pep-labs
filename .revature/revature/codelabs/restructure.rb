class Codelabs::Restructure
  def run
    Codelabs::Restructure::PepLabs.new.run
  end
end

class Codelabs::Restructure::PepLabs
  REVATURE_PEP_POM_FILE_PATH = File.expand_path("./revature/codelabs/restructure/pep/pom_sample.xml")

  def run
    @completed = false
    original_lab_paths
    create_tmp_lab_folder
    restructure_labs
    copy_tmp_lab_folder    
  end

  def copy_tmp_lab_folder
    # make a folder name with the date and time
    lab_folder_path = "./restructured_labs/#{Time.now.strftime("%Y%m%d_%H%M%S")}"
    FileUtils.mkdir_p(lab_folder_path)
    FileUtils.mv("./restructure_tmp", lab_folder_path)    
  end

  def original_lab_paths
    @original_lab_paths ||= Dir.glob("./src/**/main/java/**/**/*Test.java").map do |path|
      folder_path = path.split("/").slice(0..-2).join("/")
    end.uniq
  end

  def restructure_labs
    original_lab_paths.each do |path|
      project_path = "#{path.gsub("src/main/java", "restructure_tmp")}/src"
      test_files = Dir.glob("#{path}/*Test.java")
      project_files = Dir.glob("#{path}/*.java") - test_files
      
      code_path = "#{project_path}/main/java"
      test_path = "#{project_path}/test/java"

      FileUtils.mkdir_p(code_path)
      FileUtils.mkdir_p(test_path)
      project_files.each do |file|
        file_name = file.split("/").last
        File.write("#{code_path}/#{file_name}", correct_java_file(file))
      end
      test_files.each do |file|
        file_name = file.split("/").last
        File.write("#{test_path}/#{file_name}", correct_java_file(file))
      end

      add_pom_file_to_project(project_path)
    end
  end

  def add_pom_file_to_project(project_path)    
    # copy REVAUTOMATION_POM_FILE_PATH to project_path as pom.xml
    FileUtils.cp(REVATURE_PEP_POM_FILE_PATH, "#{project_path}/../pom.xml")
  end

  def correct_java_file(file)
    original_file_content = File.read(file)
    new_file_content = original_file_content.gsub(/package.*\n/, "").gsub(/\n;\n/, "")
  end

  def create_tmp_lab_folder
    FileUtils.mkdir_p("./restructure_tmp")
  end

  def delete_tmp_lab_folder
    FileUtils.rm_rf("./restructure_tmp")
  end
end