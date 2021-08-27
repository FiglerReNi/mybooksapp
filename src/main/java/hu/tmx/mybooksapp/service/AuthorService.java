package hu.tmx.mybooksapp.service;

import hu.tmx.mybooksapp.model.Author;

import java.util.List;

public interface AuthorService {

    List<Author> getAllAuthor();

    Author getAuthorById(int id);

    int getMaxId();

    void save(Author author);

    void delete(Author authorById);

    void update(int id, Author author);
}
