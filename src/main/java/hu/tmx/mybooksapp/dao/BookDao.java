package hu.tmx.mybooksapp.dao;

import hu.tmx.mybooksapp.model.Book;

import java.util.List;

public interface BookDao {
//
//    List<Book> getAllBooksWithAuthor();

    Book getBookWithAuthorById(long id);
//
//    void saveToDatabase(Book book);
//
//    void deleteFromDatabase(Book book);
//
//    void update(int id, Book book);
}
