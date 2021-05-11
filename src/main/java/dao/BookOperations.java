package dao;

import dto.bookDto;
import entity.Book;

import java.util.List;

/*****
 * Class with CRUD Example w.r.t rest call's
 * CRUD	    SQL	    HTTP
 * -----------------------
 * Create	INSERT	POST
 * Read	    SELECT	GET
 * Update	UPDATE	PUT
 * Delete	DELETE	DELETE
 * *****/
public class BookOperations {

    public String getBook() {
        System.out.println("\n\nGetting a book from Database now !\n\n");
        BookDao bookDaoObj = new BookDao();
        List<Book> bookObj = bookDaoObj.getBooks();

        System.out.println("\n\n -- READ/SELECT (GET) Operation completed, Book Title : " + bookObj.get(0).getTitle() + " -- \n\n");
        return bookObj.get(0).getTitle();
    }

    public String fetchBookById(int bookId) {
        System.out.println("\n\nGetting a book from Database with ID " + bookId + "\n\n");
        BookDao bookDaoObj = new BookDao();
        List<Book> bookObj = bookDaoObj.getBooks();

        System.out.println("\n\n -- READ/SELECT (GET) Operation completed, Book Title : " + bookObj.get(bookId - 1).getTitle() + " -- \n\n");
        return bookObj.get(bookId - 1).getTitle();
    }

    public void addBookNew(bookDto bookDtoPojo) {
        System.out.println("\n\nAdding a new Book into Database now... \n\n");
        BookDao bookDaoObj = new BookDao();
        bookDaoObj.saveBook(bookDtoPojo.getTitle(), bookDtoPojo.getAuthorId(), bookDtoPojo.getSeriesId());
        System.out.println("\n\n -- CREATE/INSERT (POST) Operation completed -- \n\n");
    }

    public void updateBookWithId(int bookId, bookDto bookDtoPojo) {
        System.out.println("\n\n Updating Book into Database with ID : " + bookId + "\n\n");
        BookDao bookDaoObj = new BookDao();
        bookDaoObj.updateBook(bookId, bookDtoPojo.getTitle(), bookDtoPojo.getAuthorId(), bookDtoPojo.getSeriesId());
        System.out.println("\n\n -- PUT/UPDATE (UPDATE) Operation completed for BookID : " + bookId + "  -- \n\n");
    }

    public int deleteBook(int bookId) {
        System.out.println("\n\n Deleting Book from Database with ID:  " + bookId + "\n\n");
        BookDao bookDaoObj = new BookDao();
        int rowsDeleted = bookDaoObj.deleteBook(bookId);
        System.out.println("\n\n -- DELETE/DELETE (UPDATE) Operation completed for BookID : " + bookId + " -- \n\n");
        return rowsDeleted;
    }
}