package hu.tmx.mybooksapp.dao.impl;

import hu.tmx.mybooksapp.dao.AuthorDao;
import hu.tmx.mybooksapp.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.NoSuchElementException;

@Component
public class AuthorDaoImpl implements AuthorDao {

    @Autowired
    EntityManager entityManager;



//    @Override
//    public List<Author> getAllAuthor() {
//        return null;
//    }

    @Override
    public Author getAuthorById(long id) {
        try{
            return (Author) entityManager.createQuery(SELECT_AUTHOR_BY_ID.toString())
                    .setParameter("id", id)
                    .getSingleResult();
        }catch (Exception exception){
            throw new NoSuchElementException(id + ". id doesn't exists.");
        }
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
