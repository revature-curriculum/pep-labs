import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import Application.Application;
import Application.DAO.AuthorDAO;
import Application.DAO.BookDAO;
import Application.Model.Author;
import Application.Model.Book;
import Application.Service.AuthorService;
import Application.Service.BookService;

public class LibraryAppTest {
    public AuthorDAO authorDAO;
    public AuthorService authorService;
    public AuthorDAO mockAuthorDAO;
    public BookDAO bookDAO;
    public BookService bookService;
    public BookDAO mockBookDAO;

    /**
     * Before every test, reset the database and re-instantiate a new AuthorDAO.
     */
    @Before
    public void setUp(){
        Application.databaseSetup();
        authorDAO = new AuthorDAO();
        mockAuthorDAO = Mockito.mock(AuthorDAO.class);
        authorService = new AuthorService(mockAuthorDAO);
        bookDAO = new BookDAO();
        mockBookDAO = Mockito.mock(BookDAO.class);
        bookService = new BookService(mockBookDAO);
    }

    //AUTHOR TESTS

    /**
     * getAllAuthors should return all authors.
     */
    @Test
    public void getAllAuthorsDAOTest(){
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



    /**
     * When getAllAuthors is called, getAllAuthors should return all the authors retrieved from the mockAuthorDAO.
     */
    @Test
    public void getAllAuthorsServiceTest(){
        List<Author> authors = new ArrayList<>();
        Author a1 = new Author(1, "James Joyce");
        Author a2 = new Author(2, "Leo Tolstoy");
        authors.add(a1);
        authors.add(a2);
        Mockito.when(mockAuthorDAO.getAllAuthors()).thenReturn(authors);
        List<Author> returnedAuthors = authorService.getAllAuthors();
        if(returnedAuthors == null){
            Assert.fail();
        }else{
            Assert.assertTrue(returnedAuthors.contains(a1));
            Assert.assertTrue(returnedAuthors.contains(a2));
        }
        
    }

    /**
     * When addAuthor is called and the mockAuthorDAO does not yet contain some author, the method should return
     * the added author, and the insertAuthor method of authorDAO should have been called at some point.
     */
    @Test
    public void addAuthorTest(){
        Author newAuthor = new Author("James Joyce");
        Author persistedAuthor = new Author(1, "James Joyce");
        Mockito.when(mockAuthorDAO.insertAuthor(newAuthor)).thenReturn(persistedAuthor);
        Author actualAuthor = authorService.addAuthor(newAuthor);
        Assert.assertEquals(persistedAuthor, actualAuthor);
    }



    //BOOK TESTS

    /**
     * getAllBooks should return all books.
     */
    @Test
    public void getAllBooksTest(){
        List<Book> books = bookDAO.getAllBooks();
    }
    /**
     * getBookByIsbn should return a Book object where the fields of the object (int isbn, int author_id,
     * String title, int copies_available) match the data in the database record.
     */
    @Test
    public void getBookByIsbnTest(){
        Book b1 = new Book(100, 1, "ficciones", 2);
        Book book = bookDAO.getBookByIsbn(100);
        Assert.assertEquals(b1, book);
    }
    /**
     * Inserting a book should make that book visible when getting all books.
     */
    @Test
    public void insertBookCheckWithGetAllTest(){
        Book b1 = new Book(108, 1,"cosmicomics", 1);
        bookDAO.insertBook(b1);
        List<Book> books = bookDAO.getAllBooks();
        Assert.assertTrue(books.contains(b1));
    }
    /**
     * Inserting a book should make the BookDAO able to retrieve it by its ISBN.
     */
    @Test
    public void insertBookCheckWithGetByIdTest(){
        Book b1 = new Book(108, 1,"cosmicomics", 1);
        bookDAO.insertBook(b1);
        Book book = bookDAO.getBookByIsbn(108);
        Assert.assertEquals(b1, book);
    }
    /**
     * Getting all available books should retrieve all books with copies_available over 0, but should not return
     * any other books.
     */
    @Test
    public void getBooksWithBookCountOverZeroTest(){
        Book b0 = new Book(100, 1, "ficciones", 2);
        Book b1 = new Book(102, 2, "mr palomar", 1);
        Book b2 = new Book(103, 2, "invisible cities", 3);
        Book b3 = new Book(106, 4, "understanding media", 1);
        Book b4 = new Book(107, 5, "critique of pure reason", 7);
        List<Book> availableBooks = bookDAO.getBooksWithBookCountOverZero();
        Assert.assertTrue(availableBooks.contains(b0));
        Assert.assertTrue(availableBooks.contains(b1));
        Assert.assertTrue(availableBooks.contains(b2));
        Assert.assertTrue(availableBooks.contains(b3));
        Assert.assertTrue(availableBooks.contains(b4));
        Assert.assertTrue(availableBooks.size()==5);
    }

    /**
     * When getAllBooks is called, all books should be retrieved from the database using the BookDAO.
     */
    @Test
    public void getAllBooksTest1(){
        List<Book> bookList = new ArrayList<Book>();
        Book b1 = new Book(101, 1, "Ulysses", 2);
        Book b2 = new Book(102, 1, "Finnegan's Wake", 0);
        Book b3 = new Book(103, 2, "War and Peace", 1);
        bookList.add(b1);
        bookList.add(b2);
        bookList.add(b3);
        Mockito.when(mockBookDAO.getAllBooks()).thenReturn(bookList);
        List<Book> returnedBooks = bookService.getAllBooks();
        if(returnedBooks == null){
            Assert.fail();
        }else{
            Assert.assertTrue(returnedBooks.contains(b1));
            Assert.assertTrue(returnedBooks.contains(b2));
            Assert.assertTrue(returnedBooks.contains(b3));
        }
    }

    /**
     * When addBook is called and the mockBookDAO does not yet contain some author, the method should return
     * the added book, and the insertBook method of authorDAO should have been called at some point.
     */
    @Test
    public void addBookVerifyNotNullOnSuccessfulAddTest(){
        List<Book> bookList = new ArrayList<Book>();
        Book b1 = new Book(101, 1, "Ulysses", 2);
        Book b2 = new Book(102, 1, "Finnegan's Wake", 0);
        Book b3 = new Book(103, 2, "War and Peace", 1);
        Book b4 = new Book(104, 3, "Roadside Picnic", 1);
        bookList.add(b1);
        bookList.add(b2);
        bookList.add(b3);
        Mockito.when(mockBookDAO.getAllBooks()).thenReturn(bookList);
        Mockito.when(mockBookDAO.getBookByIsbn(104)).thenReturn(null);
        Mockito.when(mockBookDAO.insertBook(b4)).thenReturn(b4);
        Assert.assertEquals(b4, bookService.addBook(b4));
        Mockito.verify(mockBookDAO).insertBook(b4);
    }
    /**
     * When addBook is called and the mockBookDAO already contains the author, the method should return null
     * and the insertBook method of BookDAO should not have been called.
     */
    @Test
    public void addBookVerifyNullOnUnsuccessfulAdd(){
        List<Book> bookList = new ArrayList<Book>();
        Book b1 = new Book(101, 1, "Ulysses", 2);
        Book b2 = new Book(102, 1, "Finnegan's Wake", 0);
        Book b3 = new Book(103, 2, "War and Peace", 1);
        bookList.add(b1);
        bookList.add(b2);
        bookList.add(b3);
        Mockito.when(mockBookDAO.getAllBooks()).thenReturn(bookList);
        Mockito.when(mockBookDAO.getBookByIsbn(103)).thenReturn(b3);
        Assert.assertEquals(null, bookService.addBook(b3));
        Mockito.verify(mockBookDAO, Mockito.never()).insertBook(b3);
    }

    /**
     * When getAllAvailableBooks is called, all books in the database with copies_available over 0 should be returned.
     */
    @Test
    public void getAllAvailableBooksTest(){
        List<Book> bookList = new ArrayList<>();
        List<Book> bookListOverZero = new ArrayList<>();
        Book b1 = new Book(101, 1, "Ulysses", 2);
        Book b2 = new Book(102, 1, "Finnegan's Wake", 0);
        Book b3 = new Book(103, 2, "War and Peace", 1);
        bookList.add(b1);
        bookList.add(b2);
        bookList.add(b3);
        bookListOverZero.add(b1);
        bookListOverZero.add(b3);
        Mockito.when(mockBookDAO.getAllBooks()).thenReturn(bookList);
        Mockito.when(mockBookDAO.getBooksWithBookCountOverZero()).thenReturn(bookListOverZero);
        List<Book> returnedBooks = bookService.getAllAvailableBooks();
        if(returnedBooks == null){
            Assert.fail();
        }else{
            Assert.assertTrue(returnedBooks.contains(b1));
            Assert.assertTrue(returnedBooks.contains(b3));
            Assert.assertFalse(returnedBooks.contains(b2));
        }
        
    }
}
