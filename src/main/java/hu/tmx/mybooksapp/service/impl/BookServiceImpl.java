package hu.tmx.mybooksapp.service.impl;

import hu.tmx.mybooksapp.dao.BookDao;
import hu.tmx.mybooksapp.model.Book;
import hu.tmx.mybooksapp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private BookDao bookDao;

    @Autowired
    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public List<Book> getAllBooksWithAuthor() {
        return bookDao.getAllBooksWithAuthorFromList();
    }

    @Override
    public Book getBookWithAuthorById(int id) {
        return bookDao.getBookWithAuthorByIdFromList(id);
    }

    @Override
    public int getMaxId() {
        return bookDao.getMaxIdFromList();
    }

    @Override
    public void save(Book book) {
        bookDao.saveToList(book);
    }

    @Override
    public void delete(Book book) {
        bookDao.deleteFromList(book);
    }
}
