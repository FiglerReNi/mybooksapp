package hu.tmx.mybooksapp.dao.mem;

import hu.tmx.mybooksapp.dao.BookDao;
import hu.tmx.mybooksapp.model.Book;
import hu.tmx.mybooksapp.service.AuthorService;
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
public class BookDaoJdbc implements BookDao {

    JdbcConn jdbcConn;
    Logger logger = LoggerFactory.getLogger(this.getClass());
    private AuthorService authorService;

    @Autowired
    public void setAuthorService(AuthorService authorService) {
        this.authorService = authorService;
    }

    @Autowired
    public void setJdbcConn(JdbcConn jdbcConn) {
        this.jdbcConn = jdbcConn;
    }

    @Override
    public List<Book> getAllBooksWithAuthorFromList() {
        List<Book> books = null;
        try {
            String sql = "select * from books ORDER BY title";
            PreparedStatement pstm = jdbcConn.getConn().prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            books = new ArrayList<>();
            while (rs.next()) {
                books.add(Book.builder()
                        .id(rs.getInt("id"))
                        .title(rs.getString("title"))
                        .releaseDate(rs.getInt("release_date"))
                        .author(authorService.getAuthorById(rs.getInt("id_author"))).build());
            }
        } catch (SQLException ex) {
            logger.info("getAllAuthorFromList: " + ex);
        }
        return books;
    }

    @Override
    public Book getBookWithAuthorByIdFromList(int id) {
        Book book = null;
        try {
            String sql = "select * from books where id = ?";
            PreparedStatement pstm = jdbcConn.getConn().prepareStatement(sql);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                book = Book.builder()
                        .id(rs.getInt("id"))
                        .title(rs.getString("title"))
                        .releaseDate(rs.getInt("release_date"))
                        .author(authorService.getAuthorById(rs.getInt("id_author"))).build();
            }
        } catch (SQLException ex) {
            logger.info("getAuthorByIdFromList: " + ex);
        }
        if (book == null) {
            throw new NoSuchElementException(id + ". id doesn't exists.");
        } else {
            return book;
        }
    }

    @Override
    public int getMaxIdFromList() {
        int result = 0;
        try {
            String sql = "select MAX(id) as 'max' from books";
            PreparedStatement pstm = jdbcConn.getConn().prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                result = rs.getInt("max");
            }
        } catch (SQLException ex) {
            logger.info("getMaxIdFromList: " + ex);
        }
        if (result == 0) {
            throw new NoSuchElementException("Maximum id not found.");
        } else {
            return result;
        }
    }

    @Override
    public void saveToList(Book book) {
        try {
            String sql = "insert into books (id, title, release_date, id_author) values(?,?,?,?)";
            PreparedStatement pstm = jdbcConn.getConn().prepareStatement(sql);
            pstm.setInt(1, book.getId());
            pstm.setString(2, book.getTitle());
            pstm.setInt(3, book.getReleaseDate());
            pstm.setInt(4, book.getAuthor().getId());
            pstm.execute();
        } catch (SQLException ex) {
            logger.info("saveToList" + ex);
        }
    }

    @Override
    public void deleteFromList(Book book) {
        try {
            String sql = "delete from books where id = ?";
            PreparedStatement pstm = jdbcConn.getConn().prepareStatement(sql);
            pstm.setInt(1, book.getId());
            pstm.execute();
        } catch (SQLException ex) {
            logger.info("deleteFromList: " + ex);
        }
    }

    @Override
    public void updateList(int id, Book book) {
        try {
            String sql = "update books set title = ?, release_date = ?, id_author = ? where id = ?";
            PreparedStatement pstm = jdbcConn.getConn().prepareStatement(sql);
            pstm.setString(1, book.getTitle());
            pstm.setInt(2, book.getReleaseDate());
            pstm.setInt(3, book.getAuthor().getId());
            pstm.setInt(4, book.getId());
            pstm.execute();
        } catch (SQLException ex) {
            logger.info("updateList: " + ex);
        }
    }

    @Override
    public void saveToListFirst(Book book) {
        if (!existsBook(book)) {
            saveToList(book);
        }
    }

    private boolean existsBook(Book book) {
        boolean result = true;
        try {
            String sql = "select * from books where title = ? and release_date = ? and id_author = ?";
            PreparedStatement pstm = jdbcConn.getConn().prepareStatement(sql);
            pstm.setString(1, book.getTitle());
            pstm.setInt(2, book.getReleaseDate());
            pstm.setInt(3, book.getAuthor().getId());
            ResultSet rs = pstm.executeQuery();
            if (!rs.next()) {
                result = false;
            }
        } catch (SQLException ex) {
            logger.info("existsBook: " + ex);
        }
        return result;
    }
}
