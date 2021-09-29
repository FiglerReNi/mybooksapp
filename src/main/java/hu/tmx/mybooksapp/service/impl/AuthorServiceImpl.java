package hu.tmx.mybooksapp.service.impl;

import hu.tmx.mybooksapp.dao.AuthorDao;
import hu.tmx.mybooksapp.model.Author;
import hu.tmx.mybooksapp.model.ext.AuthorExt;
import hu.tmx.mybooksapp.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;


@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorDao authorDao;
//    @Autowired
//    private BookDao bookDao;
//
    @Override
    public List<AuthorExt> getAllAuthor() {
    return authorDao.getAllAuthor().stream()
            .map(a -> new AuthorExt(a.getId(), a.getFirstName(), a.getLastName(), a.getAge(), authorDao.getBooksByAuthorId(a)))
            .collect(Collectors.toList());
}

    @Override
    public Author getAuthorById(long id) {
        try {
            return authorDao.getAuthorById(id);
        } catch (Exception exception) {
            throw new NoSuchElementException(id + ". id doesn't exists.");
        }
    }
//
//    @Override
//    public Author save(Author author) {
//       return authorDao.save(author);
//    }
//
//    @Override
//    public void delete(Author author) {
//        bookDao.deleteAll(bookDao.findAllByAuthorId(author.getId()));
//        authorDao.delete(author);
//    }



}
