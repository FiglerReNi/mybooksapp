package hu.tmx.mybooksapp.service.impl;

import hu.tmx.mybooksapp.dao.AuthorDao;
import hu.tmx.mybooksapp.model.Author;
import hu.tmx.mybooksapp.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorDao authorDao;
//    @Autowired
//    private BookDao bookDao;
//
//    @Override
//    public List<Author> getAllAuthor() {
//        return authorDao.findAll();
//    }
//
    @Override
    public Author getAuthorById(long id) {
        return authorDao.getAuthorById(id);
//        if(null != Author)
//        return .orElseThrow(()->new NoSuchElementException(id + ". id doesn't exists."));
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
