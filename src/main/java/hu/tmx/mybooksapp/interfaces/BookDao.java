package hu.tmx.mybooksapp.interfaces;

import hu.tmx.mybooksapp.model.Book;
import java.util.List;

public interface BookDao {
   List<Book> getAllBooksWithAuthor();
}
