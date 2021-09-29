package hu.tmx.mybooksapp.dao;

import hu.tmx.mybooksapp.model.Author;

public interface AuthorDao {

    StringBuilder SELECT_AUTHOR_BY_ID = new StringBuilder()
            .append("SELECT NEW ")
            .append("hu.tmx.mybooksapp.model.Author")
            .append("(authors.id, authors.firstName, authors.lastName, authors.age) ")
            .append("FROM Author authors WHERE authors.id = :id");

//    List<Author> getAllAuthor();

    Author getAuthorById(long id);
//
//    void saveToDatabase(Author author);
//
//    void deleteFromDatabase(Author authorById);
//
//    void update(int id, Author author);

}
