package hu.tmx.mybooksapp.dao.mem;

import hu.tmx.mybooksapp.dao.AuthorDao;
import hu.tmx.mybooksapp.model.Author;
import hu.tmx.mybooksapp.model.Book;
import hu.tmx.mybooksapp.service.BookService;
import hu.tmx.mybooksapp.util.conn.JdbcConn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Primary
@Component
public class AuthorDaoJdbc implements AuthorDao {

    JdbcConn jdbcConn;
    Logger logger = LoggerFactory.getLogger(this.getClass());
    BookService bookService;

    @Autowired
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    @Autowired
    public void setJdbcConn(JdbcConn jdbcConn) {
        this.jdbcConn = jdbcConn;
    }

    @Override
    public List<Author> getAllAuthorFromList() {
        List<Author> authors = null;
        try {
            String sql = "select * from authors order by firstname";
            PreparedStatement pstm = jdbcConn.getConn().prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            authors = new ArrayList<>();
            while (rs.next()) {
                authors.add(Author.builder()
                        .id(rs.getInt("id"))
                        .firstName(rs.getString("firstname"))
                        .lastName(rs.getString("lastname"))
                        .age(rs.getInt("age"))
                        .books(booksList(rs.getInt("id"))).build());
            }
        } catch (SQLException ex) {
            logger.info("getAllAuthorFromList: " + ex);
        }
        return authors;
    }

    @Override
    public Author getAuthorByIdFromList(int id) {
        Author author = null;
        try {
            String sql = "select * from authors where id = ?";
            PreparedStatement pstm = jdbcConn.getConn().prepareStatement(sql);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                author = Author.builder()
                        .id(rs.getInt("id"))
                        .firstName(rs.getString("firstname"))
                        .lastName(rs.getString("lastname"))
                        .age(rs.getInt("age"))
                        .books(booksList(id)).build();
            }
        } catch (SQLException ex) {
            logger.info("getAuthorByIdFromList: " + ex);
        }
        if (author == null) {
            throw new NoSuchElementException(id + ". id doesn't exists.");
        } else {
            return author;
        }
    }

    @Override
    public void saveToList(Author author) {
        try {
            String sql = "insert into authors (firstname, lastname, age) values(?,?,?)";
            PreparedStatement pstm = jdbcConn.getConn().prepareStatement(sql);
            pstm.setString(1, author.getFirstName());
            pstm.setString(2, author.getLastName());
            pstm.setInt(3, author.getAge());
            pstm.execute();
        } catch (SQLException ex) {
            logger.info("saveToList: " + ex);
        }
    }

    @Override
    public void deleteFromList(Author author) {
        List<Book> books = booksList(author.getId());
        books.forEach(book -> bookService.delete(book));
        try {
            String sql = "delete from authors where id = ?";
            PreparedStatement pstm = jdbcConn.getConn().prepareStatement(sql);
            pstm.setInt(1, author.getId());
            pstm.execute();
        } catch (SQLException ex) {
            logger.info("deleteFromList: " + ex);
        }
    }

    @Override
    public void updateList(int id, Author author) {
        try {
            String sql = "update authors set firstname = ?, lastname = ?, age = ? where id = ?";
            PreparedStatement pstm = jdbcConn.getConn().prepareStatement(sql);
            pstm.setString(1, author.getFirstName());
            pstm.setString(2, author.getLastName());
            pstm.setInt(3, author.getAge());
            pstm.setInt(4, author.getId());
            pstm.execute();
        } catch (SQLException ex) {
            logger.info("updateList: " + ex);
        }
    }

    private List<Book> booksList(int id) {
        List<Book> books = null;
        try {
            String sql = "select * from books where id_author = ?";
            PreparedStatement pstm = jdbcConn.getConn().prepareStatement(sql);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            books = new ArrayList<>();
            while (rs.next()) {
                books.add(Book.builder()
                        .id(rs.getInt("id"))
                        .title(rs.getString("title"))
                        .releaseDate(rs.getInt("release_date")).build());
            }
        } catch (SQLException ex) {
            logger.info("booksList: " + ex);
        }
        return books;
    }
}
