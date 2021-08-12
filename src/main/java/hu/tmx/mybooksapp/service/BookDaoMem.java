package hu.tmx.mybooksapp.service;

import hu.tmx.mybooksapp.interfaces.BookDao;
import hu.tmx.mybooksapp.model.BaseData;
import hu.tmx.mybooksapp.model.Book;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Qualifier("BookDaoMem")
public class BookDaoMem implements BookDao {

    @Override
    public List<Book> getAllBooksWithAuthor() {
        return BaseData.books.stream()
                .sorted(Comparator.comparing(Book::getTitle))
                .collect(Collectors.toList());
    }

    @Override
    public Book getBookWithAuthorById(int id) {
        return BaseData.books.stream()
                        .filter(b -> b.getId() == id)
                        .findFirst()
                        .orElse(null);
    }
}
