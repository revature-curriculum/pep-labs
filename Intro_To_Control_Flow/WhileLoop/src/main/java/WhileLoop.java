
public class WhileLoop {
    /**
     * A while loop uses a conditional statement (within parentheses) and runs the code {within curly braces}
     * as long as the conditional is true.
     *
     * Usually while loops are used for I/O, like waiting for input from the user or waiting for data from the web,
     * which are situations where the code has no capability of knowing how many times it should do something
     * (like how many times the program should it should check if it's received user input yet).
     *
     * For this example, let's use a while loop to get the sum of all numbers between 0 and end (exclusive).
     * At the 'code here' point, let's write a while loop that runs on the condition
     *     i<end
     * and contains within its block (within its curly braces) the code
     *     sum = sum + i;
     *     i = i + 1;
     *
     * Meaning, so long as as a number i, which we've defined, is less that some number end,
     * let's add the number i to sum and increase it by 1.
     * So: counting from 0 to end = 6 (excluding 6), we add the numbers to a total count
     *     (ie as i goes from 0 -> 1 -> 2 -> 3 -> 4 -> 5 sum goes from 0 -> 1 -> 3 -> 6 -> 10 -> 15)
     *
     * Another guide on while loops: https://www.w3schools.com/java/java_while_loop.asp
     *
     * I also recommend adding a line such as System.out.println(sum); and System.out.println(i);, or using your IDE's
     * debugger tool, to help you understand what is really happening when the loop is running.
     *
     * If you program doesn't stop running, that means the condition you defined is never broken as the code executes.
     * This could either be a result of a mistake in writing the condition i < end or in writing the line i = i + 1;
     *
     * @param end a number representing the number to which the sum of all numbers starting from 0 should be calculated
     *            (exclusive - for example, when end is 5, we calculate 0+1+2+3+4)
     *
     **/
    public int whileExample(int end){
        int sum = 0;
        int i = 0;

//        code here

        return sum;
    }
}
