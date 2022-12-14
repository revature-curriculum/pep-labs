import org.junit.Assert;
import org.junit.Test;

public class ToStringMethodTest {
    /**
     * Whatever the output that a toString contains, if an object is created with the values 1, 1, true it should
     * contain all of those values.
     */
    @Test
    public void toStringTest1(){
        SampleClass ts = new SampleClass();
        ts.a=1;
        ts.b=true;
        String output = ts.toString();
        Assert.assertTrue(output.contains("1"));
        Assert.assertFalse(output.contains("2"));
        Assert.assertTrue(output.contains("true"));
        Assert.assertFalse(output.contains("false"));
    }
    /**
     * Whatever the output that a toString contains, if an object is created with the values 1, 2, true it should
     * contain all of those values.
     */
    @Test
    public void toStringTest2(){
        SampleClass ts = new SampleClass();
        ts.a=2;
        ts.b=true;
        String output = ts.toString();
        Assert.assertFalse(output.contains("1"));
        Assert.assertTrue(output.contains("2"));
        Assert.assertTrue(output.contains("true"));
        Assert.assertFalse(output.contains("false"));
    }
    /**
     * Whatever the output that a toString contains, if an object is created with the values 1, 1, false it should
     * contain all of those values.
     */
    @Test
    public void toStringTest3(){
        SampleClass ts = new SampleClass();
        ts.a=1;
        ts.b=false;
        String output = ts.toString();
        Assert.assertTrue(output.contains("1"));
        Assert.assertFalse(output.contains("2"));
        Assert.assertFalse(output.contains("true"));
        Assert.assertTrue(output.contains("false"));
    }
    /**
     * Whatever the output that a toString contains, if an object is created with the values 1, 2, false it should
     * contain all of those values.
     */
    @Test
    public void toStringTest4(){
        SampleClass ts = new SampleClass();
        ts.a=2;
        ts.b=false;
        String output = ts.toString();
        Assert.assertFalse(output.contains("1"));
        Assert.assertTrue(output.contains("2"));
        Assert.assertFalse(output.contains("true"));
        Assert.assertTrue(output.contains("false"));
    }
}
