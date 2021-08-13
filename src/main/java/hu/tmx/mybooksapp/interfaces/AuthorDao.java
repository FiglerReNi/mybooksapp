package hu.tmx.mybooksapp.interfaces;

import hu.tmx.mybooksapp.model.Author;
import java.util.List;

public interface AuthorDao {
   List<Author> getAllAuthor();

   Author getAuthorById(int id);

   int getMaxId();

   void save(Author author);

    void delete(Author authorById);

    void update(Author author);
}
