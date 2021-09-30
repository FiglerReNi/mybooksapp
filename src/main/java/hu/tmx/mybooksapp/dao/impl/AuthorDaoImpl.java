package hu.tmx.mybooksapp.dao.impl;

import hu.tmx.mybooksapp.dao.AuthorDao;
import hu.tmx.mybooksapp.model.Author;
import hu.tmx.mybooksapp.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Transactional
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
        hu.tmx.mybooksapp.entity.Author authorParam
                = hu.tmx.mybooksapp.entity.Author.builder()
                .id(author.getId()).firstName(author.getFirstName()).lastName(author.getLastName()).age(author.getAge())
                .build();
        return entityManager.createQuery(SELECT_BOOKS_BY_AUTHOR_ID.toString(), Book.class)
                .setParameter("author", authorParam)
                .getResultList();
    }

    @Override
    public void insertIntoDatabase(Author author) {
        entityManager.createNativeQuery(INSERT_AUTHOR.toString())
                .setParameter("firstName", author.getFirstName())
                .setParameter("lastName", author.getLastName())
                .setParameter("age", author.getAge())
                .executeUpdate();
    }

    @Override
    public void deleteFromDatabase(Author author) {
        hu.tmx.mybooksapp.entity.Author authorParam
                = hu.tmx.mybooksapp.entity.Author.builder()
                .id(author.getId()).firstName(author.getFirstName()).lastName(author.getLastName()).age(author.getAge())
                .build();
        entityManager.createQuery(DELETE_AUTHOR_BY_ID.toString())
                .setParameter("id", author.getId())
                .executeUpdate();
        entityManager.createQuery(DELETE_BOOK_BY_AUTHOR_ID.toString())
                .setParameter("author", authorParam)
                .executeUpdate();
    }

    @Override
    public void update(Author author) {
        entityManager.createQuery(UPDATE_AUTHOR.toString())
                .setParameter("firstName", author.getFirstName())
                .setParameter("lastName", author.getLastName())
                .setParameter("age", author.getAge())
                .setParameter("id", author.getId())
                .executeUpdate();
    }
}
