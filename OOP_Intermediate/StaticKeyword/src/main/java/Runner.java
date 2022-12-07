
public class Runner {
    /**
     * This challenge is about interacting with static variables.
     *
     * You task is simply to change the variable global_var from Class to the value of 'in' given in the parameters.
     * As you do so, notice that you're interacting with the CLASS and not an OBJECT. This is because due to the static
     * keyword. The static keyword causes methods and variables to belong to the class definition rather than an
     * object. We've seen Static used plenty of times: the main method is static because no objects could possibly
     * exist before the program starts (but classes can), System.out.println is a static method as we never have to
     * create a System object, and variables like Integer.MAX_VALUE or Math.PI are static variables because it wouldn't
     * make sense to create a Integer or Math object just to access unchanging mathematical values.
     *
     * For this problem, that means that there is only a single global_var shared across your whole application,
     * rather than there being a global_var for every object. I have named it global_var to help you imagine how
     * this variable differs from a field of an object: it exists, globally and independently, across the entire Java
     * program.
     *
     * Using the static keyword is an intentional decision. If you are using the static keyword and don't know why,
     * you are making a mistake. More on static here: https://www.baeldung.com/java-static
     *
     * @param in the String value you should change global_var to in.
     */
    public void changeClassVar(String in){

    }
}
