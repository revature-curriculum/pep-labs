package Application.Controller;

import Application.Model.Author;
import Application.Model.Book;
import Application.Service.AuthorService;
import Application.Service.BookService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.Javalin;
import io.javalin.http.Context;

import java.util.List;
/**
 * There is no need to modify anything in this class. This class will create a Javalin API with endpoints when the
 * startAPI method is called.
 *
 *  You can interact with the Javalin controller by
 *  a) for GET requests, using the CURL command in your terminal (eg curl localhost:8080/flights). you can use post,
 *     but it's trickier to format with CURL: https://linuxize.com/post/curl-post-request/
 *  b) If you are working on your local machine and not in a browser-based IDE, navigating to an endpoint in your web
 *     browser (eg localhost:8080/flights) will perform a GET request.
 *  c) If you are working on your local machine and not in a browser-based IDE, using the desktop version of Postman
 *     for any type of request. Be sure to set the request type to the intended one (GET/POST/PUT/DELETE), and to
 *     properly format the body (setting the body content type to raw JSON).
 *
 *  The included endpoints:
 *
 *  GET localhost:8080/books : retrieve all books
 *
 *  POST localhost:8080/books : post a new book. a new book should be contained in the body of the request as a
 *  JSON representation. It must contain an ISBN field, because the ISBN field will not be generated
 *  automatically. example:
 *      {
 *          "isbn":1234,
 *          "author_id":1,
 *          "title":"my favorite book",
 *          "copies_available":1
 *      }
 *
 *  GET localhost:8080/books/available : retrieve all books with a copies_available of at least 1
 *
 *  GET localhost:8080/authors : retrieve all authors
 *
 *  POST localhost:8080/authors : post a new author. a new author should be contained in the body of the request as a
 *  JSON representation. It should not include the author_id field as this will be automatically generated. example:
 *      {
 *          "name":"mrs writer"
 *      }
 */
public class LibraryController {
    BookService bookService;
    AuthorService authorService;

    public LibraryController(){
        this.bookService = new BookService();
        this.authorService = new AuthorService();
    }

    /**
     * Method defines the structure of the Javalin Library API. Javalin methods will use handler methods
     * to manipulate the Context object, which is a special object provided by Javalin which contains information about
     * HTTP requests and can generate responses.
     */
    public void startAPI(){
        Javalin app = Javalin.create();
        app.get("/books", this::getAllBooksHandler);
        app.post("/books", this::postBookHandler);
        app.get("/authors", this::getAllAuthorsHandler);
        app.post("/authors", this::postAuthorHandler);
        app.get("/books/available", this::getAvailableBooksHandler);
        app.start(8080);
    }

    /**
     * Handler to post a new author.
     * The Jackson ObjectMapper will automatically convert the JSON of the POST request into an Author object.
     * If AuthorService returns a null author (meaning posting an Author was unsuccessful), the API will return a 400
     * message (client error). There is no need to change anything in this method.
     * @param ctx the context object handles information HTTP requests and generates responses within Javalin. It will
     *            be available to this method automatically thanks to the app.post method.
     * @throws JsonProcessingException will be thrown if there is an issue converting JSON into an object.
     */
    private void postAuthorHandler(Context ctx) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Author author = mapper.readValue(ctx.body(), Author.class);
        Author addedAuthor = authorService.addAuthor(author);
        if(addedAuthor!=null){
            ctx.json(mapper.writeValueAsString(addedAuthor));
        }else{
            ctx.status(400);
        }
    }
    /**
     * Handler to retrieve all authors. There is no need to change anything in this method.
     * @param ctx the context object handles information HTTP requests and generates responses within Javalin. It will
     *            be available to this method automatically thanks to the app.put method.
     */
    private void getAllAuthorsHandler(Context ctx) {
        List<Author> authors = authorService.getAllAuthors();
        ctx.json(authors);
    }
    /**
     * Handler to post a new book. There is no need to change anything in this method.
     * The Jackson ObjectMapper will automatically convert the JSON of the POST request into a Book object.
     * If BookService returns a null book (meaning posting a Book was unsuccessful), the API will return a 400
     * message (client error).
     * @param ctx the context object handles information HTTP requests and generates responses within Javalin. It will
     *            be available to this method automatically thanks to the app.post method.
     * @throws JsonProcessingException will be thrown if there is an issue converting JSON into an object.
     */
    private void postBookHandler(Context ctx) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Book book = mapper.readValue(ctx.body(), Book.class);
        Book addedBook = bookService.addBook(book);
        if(addedBook!=null){
            ctx.json(mapper.writeValueAsString(addedBook));
        }else{
            ctx.status(400);
        }
    }
    /**
     * Handler to retrieve all books. There is no need to change anything in this method.
     * @param ctx the context object handles information HTTP requests and generates responses within Javalin. It will
     *            be available to this method automatically thanks to the app.put method.
     */
    public void getAllBooksHandler(Context ctx){
        List<Book> books = bookService.getAllBooks();
        ctx.json(books);
    }
    /**
     * Handler to retrieve all books with a book count over zero. There is no need to change anything in this method.
     * @param context the context object handles information HTTP requests and generates responses within Javalin.
     *                It will be available to this method automatically thanks to the app.put method.
     */
    private void getAvailableBooksHandler(Context context) {
        context.json(bookService.getAllAvailableBooks());
    }
}
