package hu.tmx.mybooksapp.service;

import hu.tmx.mybooksapp.model.Author;
import hu.tmx.mybooksapp.model.ext.AuthorExt;

import java.util.List;

public interface AuthorService {

    List<AuthorExt> getAllAuthor();

    Author getAuthorById(long id);
//
//    Author save(Author author);
//
//    void delete(Author authorById);
}
