package hu.tmx.mybooksapp.interfaces;

import hu.tmx.mybooksapp.model.Book;
import java.util.List;

public interface BookDao {
   List<Book> getAllBooksWithAuthor();

   Book getBookWithAuthorById(int id);

   int getMaxId();

   void save(Book book);
}
