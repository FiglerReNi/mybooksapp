package hu.tmx.mybooksapp.service.impl;

import hu.tmx.mybooksapp.dao.AuthorDao;
import hu.tmx.mybooksapp.model.Author;
import hu.tmx.mybooksapp.model.Book;
import hu.tmx.mybooksapp.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private AuthorDao authorDao;

    @Autowired
    public void setAuthorDao(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @Override
    public List<Author> getAllAuthor() {
        return authorDao.getAllAuthorFromList();
    }

    @Override
    public Author getAuthorById(int id) {
        return authorDao.getAuthorByIdFromList(id);
    }

    @Override
    public int getMaxId() {
        return authorDao.getMaxIdFromList();
    }

    @Override
    public void saveFirst(Author author) {
        authorDao.saveToListFirst(author);
    }

    @Override
    public void save(Author author) {
        authorDao.saveToList(author);
    }

    @Override
    public void delete(Author authorById) {
        authorDao.deleteFromList(authorById);
    }

    @Override
    public void update(int id, Author author) {
        authorDao.updateList(id, author);
    }

    @Override
    public void addOneBook(Book book){
        authorDao.addOneBookToList(book);
    }

}
