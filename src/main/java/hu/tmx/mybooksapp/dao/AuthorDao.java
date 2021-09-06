package hu.tmx.mybooksapp.dao;

import hu.tmx.mybooksapp.model.Author;
import hu.tmx.mybooksapp.model.Book;

import java.sql.SQLException;
import java.util.List;

public interface AuthorDao {
   List<Author> getAllAuthorFromList();

   Author getAuthorByIdFromList(int id);

   int getMaxIdFromList();

   void saveToList(Author author);

   void deleteFromList(Author authorById);

   void updateList(int id, Author author);

    void addOneBookToList(Book book);

    void saveToListFirst(Author author);
}
