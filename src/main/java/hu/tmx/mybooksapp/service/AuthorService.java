package hu.tmx.mybooksapp.service;

import hu.tmx.mybooksapp.model.Author;
import hu.tmx.mybooksapp.model.Book;

import java.util.List;

public interface AuthorService {

    List<Author> getAllAuthor();

    Author getAuthorById(int id);

    void save(Author author);

    void delete(Author authorById);

    void update(int id, Author author);
}
