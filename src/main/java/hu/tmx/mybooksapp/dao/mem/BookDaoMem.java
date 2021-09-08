package hu.tmx.mybooksapp.dao.mem;

import hu.tmx.mybooksapp.dao.BookDao;
import hu.tmx.mybooksapp.model.Book;
import hu.tmx.mybooksapp.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class BookDaoMem implements BookDao {

    private List<Book> books = new ArrayList<>();

    @Autowired
    private AuthorService authorService;

    @Override
    public List<Book> getAllBooksWithAuthorFromList() {
        return books.stream()
                .sorted(Comparator.comparing(Book::getTitle))
                .collect(Collectors.toList());
    }

    @Override
    public Book getBookWithAuthorByIdFromList(int id)  {
        return books.stream()
                        .filter(b -> b.getId() == id)
                        .findFirst()
                        .orElseThrow(()->new NoSuchElementException(id + ". id doesn't exists."));
    }

    @Override
    public int getMaxIdFromList() {
        return books.stream()
                .mapToInt(Book::getId)
                .max()
                .orElseThrow(()->new NoSuchElementException("Maximum id not found."));
    }

    @Override
    public void saveToList(Book book) {
        books.add(book);
    }

    @Override
    public void deleteFromList(Book book) {
        books.remove(book);
    }

    @Override
    public void updateList(int id, Book book) {
        int bookIndex = books.indexOf(getBookWithAuthorByIdFromList(id));
        books.set(bookIndex, book);
    }

    @Override
    public void saveToListFirst(Book book) {
        books.add(book);
        authorService.addOneBook(book);
    }
}
