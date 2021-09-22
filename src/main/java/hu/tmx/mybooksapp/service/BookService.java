package hu.tmx.mybooksapp.service;

import hu.tmx.mybooksapp.entity.Book;
import java.util.List;

public interface BookService {
    List<Book> getAllBooksWithAuthor();

    Book getBookWithAuthorById(int id);

    Book save(Book book);

    void delete(Book book);

}
