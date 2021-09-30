package hu.tmx.mybooksapp.service;

import hu.tmx.mybooksapp.model.Author;
import hu.tmx.mybooksapp.model.ext.AuthorExt;

import java.util.List;

public interface AuthorService {

    List<AuthorExt> getAllAuthor();

    AuthorExt getAuthorById(long id);

    void insert(Author author);

    void delete(Author author);

    void update(Author author);
}
