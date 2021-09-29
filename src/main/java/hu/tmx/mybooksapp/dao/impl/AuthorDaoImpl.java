package hu.tmx.mybooksapp.dao.impl;

import hu.tmx.mybooksapp.dao.AuthorDao;
import hu.tmx.mybooksapp.model.Author;
import hu.tmx.mybooksapp.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class AuthorDaoImpl implements AuthorDao {

    @Autowired
    EntityManager entityManager;

    @Override
    public List<Author> getAllAuthor() {
          return entityManager.createQuery(SELECT_AUTHOR.toString(), Author.class)
                   .getResultList();
    }

    @Override
    public Author getAuthorById(long id) {
            return (Author) entityManager.createQuery(SELECT_AUTHOR_BY_ID.toString())
                    .setParameter("id", id)
                    .getSingleResult();
    }

    @Override
    public List<Book> getBooksByAuthorId(Author author) {
        return entityManager.createQuery(SELECT_BOOKS_BY_AUTHOR_ID.toString(), Book.class)
                .setParameter("author", author)
                .getResultList();
    }
//
//    @Override
//    public void saveToDatabase(Author author) {
//
//    }
//
//    @Override
//    public void deleteFromDatabase(Author authorById) {
//
//    }
//
//    @Override
//    public void update(int id, Author author) {
//
//    }
}
