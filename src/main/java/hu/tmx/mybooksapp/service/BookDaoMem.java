package hu.tmx.mybooksapp.service;

import hu.tmx.mybooksapp.interfaces.BookDao;
import hu.tmx.mybooksapp.model.BaseData;
import hu.tmx.mybooksapp.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookDaoMem implements BookDao {

    @Override
    public List<Book> getAllBooksWithAuthor() {
        return BaseData.books;
    }
}
