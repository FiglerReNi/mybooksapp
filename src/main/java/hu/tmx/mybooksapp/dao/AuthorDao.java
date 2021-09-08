package hu.tmx.mybooksapp.dao;

import hu.tmx.mybooksapp.model.Author;
import hu.tmx.mybooksapp.model.Book;

import java.util.List;

public interface AuthorDao {
    List<Author> getAllAuthorFromList();

    Author getAuthorByIdFromList(int id);

    void saveToList(Author author);

    void deleteFromList(Author authorById);

    void updateList(int id, Author author);

}
