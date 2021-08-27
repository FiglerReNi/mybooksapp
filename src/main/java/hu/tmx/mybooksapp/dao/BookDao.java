package hu.tmx.mybooksapp.dao;

import hu.tmx.mybooksapp.model.Book;
import java.util.List;

public interface BookDao {
   List<Book> getAllBooksWithAuthorFromList();

   Book getBookWithAuthorByIdFromList(int id);

   int getMaxIdFromList();

   void saveToList(Book book);

   void deleteFromList(Book book);
}