package hu.tmx.mybooksapp.repository;

import hu.tmx.mybooksapp.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<Book, Integer> {

   List<Book> findAllByAuthorId(int id);
}
