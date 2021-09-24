package hu.tmx.mybooksapp.service.impl;

import hu.tmx.mybooksapp.repository.AuthorRepo;
import hu.tmx.mybooksapp.repository.BookRepo;
import hu.tmx.mybooksapp.entity.Author;
import hu.tmx.mybooksapp.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepo authorRepo;
    @Autowired
    private BookRepo bookRepo;

    @Override
    public List<Author> getAllAuthor() {
        return authorRepo.findAll();
    }

    @Override
    public Author getAuthorById(int id) {
        return authorRepo.findById(id).orElseThrow(()->new NoSuchElementException(id + ". id doesn't exists."));
    }

    @Override
    public Author save(Author author) {
       return authorRepo.save(author);
    }

    @Override
    public void delete(Author author) {
        bookRepo.deleteAll(bookRepo.findAllByAuthorId(author.getId()));
        authorRepo.delete(author);
    }



}
