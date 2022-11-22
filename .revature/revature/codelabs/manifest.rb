require 'fileutils'
require 'yaml'

class Codelabs::Manifest
  def run
    Codelabs::Manifest::PepLabs.new.run
  end
end

class Codelabs::Manifest::PepLabs
  def run
    FileUtils.mkdir_p(".codelab")
    manifest = {template: 'revpro.yml', labs: []}
    
    Dir.glob("**/pom.xml").each do |pom_path|
      manifest[:labs] << pom_path.gsub(/\/pom.xml/, '')
    end

    File.write(".codelab/manifest.yml", manifest.to_yaml)
  end
end
