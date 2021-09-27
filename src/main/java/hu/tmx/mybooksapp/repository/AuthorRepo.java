package hu.tmx.mybooksapp.repository;

import hu.tmx.mybooksapp.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepo extends JpaRepository<Author, Integer>{

}
