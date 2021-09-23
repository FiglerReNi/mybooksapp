package hu.tmx.mybooksapp.repository;

import hu.tmx.mybooksapp.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorDao extends JpaRepository<Author, Integer>{

}
