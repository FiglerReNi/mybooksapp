package hu.tmx.mybooksapp.util;

import hu.tmx.mybooksapp.model.Author;
import hu.tmx.mybooksapp.model.Book;

import java.util.List;

public interface DBInitializer {

    void authorInitializer(List<Author> authors);

    void bookInitializer(List<Book> books);
}
