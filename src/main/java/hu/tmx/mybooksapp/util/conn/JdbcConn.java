package hu.tmx.mybooksapp.util.conn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.sql.*;

@Component
public class JdbcConn {

    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;
    private Connection conn = null;
    private Statement createStatement = null;
    private DatabaseMetaData dbmd = null;
    Logger logger = LoggerFactory.getLogger(this.getClass());

    public Connection getConn() {
        return conn;
    }

    @PostConstruct
    public void JdbcConnection() {
        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            logger.info("connection:" + ex);
        }
        if (conn != null) {
            try {
                createStatement = conn.createStatement();
            } catch (SQLException ex) {
                logger.info("createStatement: " + ex);
            }

            try {
                dbmd = conn.getMetaData();
            } catch (SQLException ex) {
                logger.info("getMetaData:" + ex);
            }
        }

        try {
            ResultSet rs = dbmd.getTables(null, null, "AUTHORS", null);
            if (!rs.next()) {
                createStatement.execute(
                        "create table AUTHORS(id int not null primary key, " +
                                "firstname varchar(100) not null, lastname varchar(100) not null, age int not null)");
            }
            rs = dbmd.getTables(null, null, "BOOKS", null);
            if (!rs.next()) {
                createStatement.execute(
                        "create table BOOKS(id int not null primary key, " +
                                "title varchar(100) not null, release_date year not null, id_author int not null, foreign key(id_author) REFERENCES AUTHORS (id))");
            }
        } catch (SQLException ex) {
            logger.info("createTable: " + ex);
        }
    }
}
