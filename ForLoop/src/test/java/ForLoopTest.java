import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class ForLoopTest {
    static ForLoop floop;
    @BeforeClass
    public static void setUp(){
        floop = new ForLoop();
    }

    /**
     * Given input 1 and 6, returnNumber should return 1 2 3 4 5.
     */
    @Test
    public void returnStringTest1(){
        int input = 5;
        String expected = "1 2 3 4 5";
        String actual = floop.returnNumbers(1,6).trim();
        Assert.assertEquals(expected,actual);
    }
    /**
     * Given input 1 and 4, returnNumber should return 1 2 3.
     */
    @Test
    public void returnStringTest2(){
        int input = 3;
        String expected = "1 2 3";
        String actual = floop.returnNumbers(1,4).trim();
        Assert.assertEquals(expected,actual);
    }
    /**
     * Given input 3 and 7, returnNumber should return 3 4 5 6.
     */
    @Test
    public void returnStringTest3(){
        int input = 3;
        String expected = "3 4 5 6";
        String actual = floop.returnNumbers(3, 7).trim();
        Assert.assertEquals(expected,actual);
    }
}
