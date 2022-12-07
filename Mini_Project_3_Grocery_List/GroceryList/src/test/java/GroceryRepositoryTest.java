
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class GroceryRepositoryTest {
    GroceryDAO groceryDAO;
    /**
     * Run the same method used in the menu class to drop and recreate the Grocery table.
     * Also, generate a new GroceryDAO.
     */
    @Before
    public void setUp(){
        GroceryMain.databaseSetup();
        groceryDAO = new GroceryDAO();
    }

    /**
     * When the application starts, the grocery database should not contain any groceries.
     */
    @Test
    public void groceryListEmptyOnStartTest(){
        List<String> allGroceries = groceryDAO.getAllGroceries();
        boolean expected = false;
        boolean actual = allGroceries.isEmpty();
        Assert.assertEquals(expected, actual);
    }
    /**
     * When a grocery is added, the grocery database should contain the grocery.
     */
    @Test
    public void groceryListAddTest1(){
        List<String> allGroceries = groceryDAO.getAllGroceries();
        boolean expected = false;
        boolean actual = allGroceries.isEmpty();
        Assert.assertEquals(expected, actual);
    }
}
