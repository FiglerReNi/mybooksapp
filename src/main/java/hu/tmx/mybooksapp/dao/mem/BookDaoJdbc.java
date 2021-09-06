package hu.tmx.mybooksapp.dao.mem;

import hu.tmx.mybooksapp.dao.BookDao;
import hu.tmx.mybooksapp.model.Author;
import hu.tmx.mybooksapp.model.Book;
import hu.tmx.mybooksapp.util.conn.JdbcConn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Primary
@Component
public class BookDaoJdbc implements BookDao {

    JdbcConn jdbcConn;
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public void setJdbcConn(JdbcConn jdbcConn) {
        this.jdbcConn = jdbcConn;
    }

    @Override
    public List<Book> getAllBooksWithAuthorFromList() {
        return null;
    }

    @Override
    public Book getBookWithAuthorByIdFromList(int id) {
        return null;
    }

    @Override
    public int getMaxIdFromList() {
        return 0;
    }

    @Override
    public void saveToList(Book book) {
        try {
            String sql = "insert into books (title, release_date, id_author) values(?,?,?)";
            PreparedStatement pstm = jdbcConn.getConn().prepareStatement(sql);
            pstm.setString(1, book.getTitle());
            pstm.setInt(2, book.getReleaseDate());
            pstm.setInt(3, book.getAuthor().getId());
            pstm.execute();
        } catch (SQLException ex) {
            logger.info("saveToList" + ex);
        }
    }

    @Override
    public void deleteFromList(Book book) {

    }

    @Override
    public void updateList(int id, Book book) {

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
            logger.info("getSpecificAuthor: " + ex);
        }
        return result;
    }
}
