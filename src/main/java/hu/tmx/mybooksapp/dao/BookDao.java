package hu.tmx.mybooksapp.dao;

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

    List<Book> getAllBooksWithAuthor();

    Book getBookWithAuthorById(long id);
//
//    void saveToDatabase(Book book);
//
//    void deleteFromDatabase(Book book);
//
//    void update(int id, Book book);
}
