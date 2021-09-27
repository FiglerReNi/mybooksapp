package hu.tmx.mybooksapp.service.impl;

import hu.tmx.mybooksapp.entity.Book;
import hu.tmx.mybooksapp.repository.BookDao;
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
        return bookDao.findAll();
    }

    @Override
    public Book getBookWithAuthorById(int id) {
        return bookDao.findById(id).orElseThrow(()->new NoSuchElementException(id + ". id doesn't exists."));
    }

    @Override
    public Book save(Book book) {
        return bookDao.save(book);
    }

    @Override
    public void delete(Book book) {
        bookDao.delete(book);
    }


}
