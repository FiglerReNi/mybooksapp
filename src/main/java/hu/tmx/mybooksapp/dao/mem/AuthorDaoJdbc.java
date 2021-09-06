package hu.tmx.mybooksapp.dao.mem;

import hu.tmx.mybooksapp.dao.AuthorDao;
import hu.tmx.mybooksapp.model.Author;
import hu.tmx.mybooksapp.model.Book;
import hu.tmx.mybooksapp.util.conn.JdbcConn;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.NoSuchElementException;

@Primary
@Component
public class AuthorDaoJdbc implements AuthorDao {

    JdbcConn jdbcConn;
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public void setJdbcConn(JdbcConn jdbcConn) {
        this.jdbcConn = jdbcConn;
    }

    @Override
    public List<Author> getAllAuthorFromList() {
        return null;
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
                        .age(rs.getInt("age")).build();
            }
        } catch (SQLException ex) {
            logger.info("getSpecificAuthor: " + ex);
        }
        if (author == null) {
            throw new NoSuchElementException(id + ". id doesn't exists.");
        } else {
            return author;
        }
    }

    @Override
    public int getMaxIdFromList() {
        return 0;
    }

    @Override
    public void saveToList(Author author) {
        try {
            String sql = "insert into authors (firstname, lastname, age) values(?,?,?)";
            PreparedStatement pstm = jdbcConn.getConn().prepareStatement(sql);
            pstm.setString(1, author.getFirstName());
            pstm.setString(2, author.getFirstName());
            pstm.setInt(3, author.getAge());
            pstm.execute();
        } catch (SQLException ex) {
            logger.info("saveToList: " + ex);
        }
    }

    @Override
    public void deleteFromList(Author authorById) {

    }

    @Override
    public void updateList(int id, Author author) {

    }

    @Override
    public void addOneBookToList(Book book) {

    }

    @Override
    public void saveToListFirst(Author author) {
        if (!existsAuthor(author)) {
            saveToList(author);
        }
    }

    private boolean existsAuthor(Author author) {
        boolean result = true;
        try {
            String sql = "select * from authors where firstname = ? and lastname = ? and age = ?";
            PreparedStatement pstm = jdbcConn.getConn().prepareStatement(sql);
            pstm.setString(1, author.getFirstName());
            pstm.setString(2, author.getFirstName());
            pstm.setInt(3, author.getAge());
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
