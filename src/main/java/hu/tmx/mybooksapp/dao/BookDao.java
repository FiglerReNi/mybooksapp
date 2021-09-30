package hu.tmx.mybooksapp.dao;

import hu.tmx.mybooksapp.model.Author;
import hu.tmx.mybooksapp.model.Book;

import java.util.List;

public interface BookDao {

    StringBuilder SELECT_BOOK = new StringBuilder()
            .append("SELECT NEW ")
            .append("hu.tmx.mybooksapp.model.Book")
            .append("(books.id, books.title, books.releaseDate, books.author) ")
            .append("FROM Book books");

    StringBuilder SELECT_BOOK_BY_ID = new StringBuilder()
            .append("SELECT NEW ")
            .append("hu.tmx.mybooksapp.model.Book")
            .append("(books.id, books.title, books.releaseDate, books.author) ")
            .append("FROM Book books WHERE books.id = :id");

    StringBuilder DELETE_BOOK_BY_ID = new StringBuilder()
            .append("DELETE FROM Book books WHERE books.id = :id");

//    StringBuilder INSERT_AUTHOR = new StringBuilder()
//            .append("INSERT INTO authors (release_date, title, author_id) ")
//            .append("VALUES (:releaseDate, :title, :authorID)");

    List<Book> getAllBooksWithAuthor();

    Book getBookWithAuthorById(long id);

    void insertIntoDatabase(Book book);

    void deleteFromDatabase(Book book);
//
//    void update(int id, Book book);
}
