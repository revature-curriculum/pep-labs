package DAO;

import Application.Application;
import Application.DAO.AuthorDAO;
import Application.Model.Author;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * This class will use the dummy data inserted in the Application.databaseSetup() method.
 * It contains the following records:
 *      (0, 'jorge luis borges'),
 *      (1, 'italo calvino'),
 *      (2, 'thomas pynchon'),
 *      (3, 'marshall mcluhan'),
 *      (4, 'immanuel kant')
 */
public class AuthorDAOTest {
    AuthorDAO authorDAO;

    /**
     * Before every test, reset the database and re-instantiate a new AuthorDAO.
     */
    @Before
    public void setUp(){
        Application.databaseSetup();
        authorDAO = new AuthorDAO();
    }
    /**
     * getAllAuthors should return all authors.
     */
    @Test
    public void getAllAuthorsTest(){
        List<Author> authors = authorDAO.getAllAuthors();
        Author a1 = new Author(1, "jorge luis borges");
        Author a2 = new Author(2, "italo calvino");
        Author a3 = new Author(3, "thomas pynchon");
        Author a4 = new Author(4, "marshall mcluhan");
        Author a5 = new Author(5, "immanuel kant");
        Assert.assertTrue(authors.contains(a1));
        Assert.assertTrue(authors.contains(a2));
        Assert.assertTrue(authors.contains(a3));
        Assert.assertTrue(authors.contains(a4));
        Assert.assertTrue(authors.contains(a5));
    }
    /**
     * Inserting an author should make that author visible when getting all authors.
     */
    @Test
    public void insertAuthorCheckWithGetAllTest(){
        Author a6 = new Author(6, "james joyce");
        authorDAO.insertAuthor(a6);
        List<Author> authors = authorDAO.getAllAuthors();
        Assert.assertTrue(authors.contains(a6));
    }
}
