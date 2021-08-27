package hu.tmx.mybooksapp.dao;

import hu.tmx.mybooksapp.model.Author;
import java.util.List;

public interface AuthorDao {
   List<Author> getAllAuthorFromList();

   Author getAuthorByIdFromList(int id);

   int getMaxIdFromList();

   void saveToList(Author author);

   void deleteFromList(Author authorById);

   void updateList(int id, Author author);
}
