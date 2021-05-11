package dao;

import java.util.List;

import entity.Book;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.Query;
import util.HibernateUtil;

public class BookDao {

    public List<Book> getBooks() {
        Session session = HibernateUtil.getSession();
        Query query = session.createQuery(" from Book");
        List<Book> books = query.list();
        session.close();
        return books;
    }

    public List<Book> getBookById(int bookId) {
        Session session = HibernateUtil.getSession();
        String hql = "get Book with where id = :id";
        Query query = session.createQuery(hql);
        query.setInteger("id", bookId);
        List<Book> books = query.list();
        session.close();
        return books;
    }

    public void saveBook(String title, int authorId, int seriesId) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Book book = new Book();
            book.setTitle(title);
            book.setAuthorId(authorId);
            book.setSeriesId(seriesId);

            session.save(book);
            transaction.commit();
            System.out.println("Records inserted sucessessfully");
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void updateBook(int bookId, String title, int authorId, int seriesId) {
        System.out.println("Now Updating SQL BookID : " + bookId);
        Session session = HibernateUtil.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Book book = session.load(Book.class, bookId);
            book.setTitle(title);
            book.setAuthorId(authorId);
            book.setSeriesId(seriesId);

            session.update(book);
            transaction.commit();
            System.out.println("Records updated sucessessfully");
        } catch (HibernateException e) {
            System.out.println("Some exception while updating the Records");
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public int deleteBook(int id) {
        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        String hql = "delete from Book where id = :id";
        Query query = session.createQuery(hql);
        query.setInteger("id", id);
        int rowCount = query.executeUpdate();
        System.out.println("Rows affected: " + rowCount);
        tx.commit();
        session.close();
        return rowCount;
    }
}
