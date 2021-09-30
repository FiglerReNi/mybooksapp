package hu.tmx.mybooksapp.dao.impl;

import hu.tmx.mybooksapp.dao.BookDao;
import hu.tmx.mybooksapp.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Transactional
public class BookDaoImpl implements BookDao {

    @Autowired
    EntityManager entityManager;

    @Override
    public List<Book> getAllBooksWithAuthor() {
        return entityManager.createQuery(SELECT_BOOK.toString(), Book.class)
                .getResultList();
    }

    @Override
    public Book getBookWithAuthorById(long id) {
            return (Book) entityManager.createQuery(SELECT_BOOK_BY_ID.toString())
                    .setParameter("id", id)
                    .getSingleResult();
    }

    @Override
    public void insertIntoDatabase(Book book) {
        hu.tmx.mybooksapp.entity.Book bookParam
                = hu.tmx.mybooksapp.entity.Book.builder()
                .releaseDate(book.getReleaseDate()).title(book.getTitle()).author(book.getAuthor())
                .build();
        entityManager.persist(bookParam);
    }

    @Override
    public void deleteFromDatabase(Book book) {
        entityManager.createQuery(DELETE_BOOK_BY_ID.toString())
                .setParameter("id", book.getId())
                .executeUpdate();
    }

    @Override
    public void update(Book book) {
        entityManager.createQuery(UPDATE_BOOK.toString())
                .setParameter("title", book.getTitle())
                .setParameter("releaseDate", book.getReleaseDate())
                .setParameter("author", book.getAuthor())
                .setParameter("id", book.getId())
                .executeUpdate();
    }
}
