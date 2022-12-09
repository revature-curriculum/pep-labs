import org.junit.Assert;
import org.junit.Test;


public class ObjectToBeComparedTest {

    /**
     * If obj1 and obj2 are equivalent, compareTo should return 0.
     */
    @Test
    public void comparableObjectTest1(){
        SampleClassC obj1 = new SampleClassC();
        obj1.val = 1;
        SampleClassC obj2 = new SampleClassC();
        obj2.val = 1;
        Assert.assertTrue(obj1.compareTo(obj2) == 0);
    }

    /**
     * If obj1 has a smaller value than that of obj1, obj1.compareTo(obj2) should return a value less than 0.
     */
    @Test
    public void comparableObjectTest2(){
        SampleClassC obj1 = new SampleClassC();
        obj1.val = 0;
        SampleClassC obj2 = new SampleClassC();
        obj2.val = 1;
        Assert.assertTrue(obj1.compareTo(obj2) < 0);
    }
    /**
     * If obj1 has a greater value than that of obj1, obj1.compareTo(obj2) should return a value greater than 0.
     */
    @Test
    public void comparableObjectTest3(){
        SampleClassC obj1 = new SampleClassC();
        obj1.val = 1;
        SampleClassC obj2 = new SampleClassC();
        obj2.val = 0;
        Assert.assertTrue(obj1.compareTo(obj2) > 0);
    }
}
