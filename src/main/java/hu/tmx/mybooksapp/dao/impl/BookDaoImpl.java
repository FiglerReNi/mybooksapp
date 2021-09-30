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


//    @Override
//    public void saveToDatabase(Book book) {
//
//    }
//
    @Override
    public void deleteFromDatabase(Book book) {
        entityManager.createQuery(DELETE_BOOK_BY_ID.toString())
                .setParameter("id", book.getId())
                .executeUpdate();
    }
//
//    @Override
//    public void update(int id, Book book) {
//
//    }
}
