package hu.tmx.mybooksapp.service.impl;

import hu.tmx.mybooksapp.dao.BookDao;
import hu.tmx.mybooksapp.model.Book;
import hu.tmx.mybooksapp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public List<Book> getAllBooksWithAuthor() {
        return bookDao.getAllBooksWithAuthor();
    }

    @Override
    public Book getBookWithAuthorById(long id) {
        try {
            return bookDao.getBookWithAuthorById(id);
        } catch (Exception exception) {
            throw new NoSuchElementException(id + ". id doesn't exists.");
        }
    }

    @Override
    public void insert(Book book) {
        bookDao.insertIntoDatabase(book);
    }

    @Override
    public void delete(Book book) {
        bookDao.deleteFromDatabase(book);
    }


}
