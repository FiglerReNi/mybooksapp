package hu.tmx.mybooksapp.util.impl;

import hu.tmx.mybooksapp.model.Author;
import hu.tmx.mybooksapp.model.Book;
import hu.tmx.mybooksapp.service.AuthorService;
import hu.tmx.mybooksapp.service.BookService;
import hu.tmx.mybooksapp.util.DBInitializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class DBInitializerImpl implements DBInitializer {

    @Autowired
    private AuthorService authorService;
    @Autowired
    private BookService bookService;

    @Override
    public void authorInitializer(List<Author> authors) {
        authors.forEach(author -> authorService.saveFirst(author));
    }

    @Override
    public void bookInitializer(List<Book> books) {
        books.forEach(book -> bookService.saveFirst(book));
    }
}
