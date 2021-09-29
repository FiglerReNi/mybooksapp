package hu.tmx.mybooksapp.dao;

import hu.tmx.mybooksapp.model.Author;
import hu.tmx.mybooksapp.model.Book;
import hu.tmx.mybooksapp.model.ext.AuthorExt;

import java.util.List;

public interface AuthorDao {

    StringBuilder SELECT_AUTHOR = new StringBuilder()
            .append("SELECT NEW ")
            .append("hu.tmx.mybooksapp.model.Author")
            .append("(authors.id, authors.firstName, authors.lastName, authors.age) ")
            .append("FROM Author authors");

    StringBuilder SELECT_AUTHOR_BY_ID = new StringBuilder()
            .append("SELECT NEW ")
            .append("hu.tmx.mybooksapp.model.Author")
            .append("(authors.id, authors.firstName, authors.lastName, authors.age) ")
            .append("FROM Author authors WHERE authors.id = :id");

    StringBuilder SELECT_BOOKS_BY_AUTHOR_ID = new StringBuilder()
            .append("SELECT NEW ")
            .append("hu.tmx.mybooksapp.model.Book")
            .append("(books.id, books.title, books.releaseDate, books.author) ")
            .append("FROM Book books WHERE books.author = :author");


    List<Author> getAllAuthor();

    Author getAuthorById(long id);

    List<Book> getBooksByAuthorId(Author author);
//
//    void saveToDatabase(Author author);
//
//    void deleteFromDatabase(Author authorById);
//
//    void update(int id, Author author);

}
