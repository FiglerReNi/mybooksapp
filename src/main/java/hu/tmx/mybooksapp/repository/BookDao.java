package hu.tmx.mybooksapp.repository;

import hu.tmx.mybooksapp.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookDao extends JpaRepository<Book, Integer> {

   List<Book> findAllByAuthorId(int id);
}
