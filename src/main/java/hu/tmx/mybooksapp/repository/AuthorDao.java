package hu.tmx.mybooksapp.repository;

import hu.tmx.mybooksapp.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorDao extends JpaRepository<Author, Integer>{

}
