package hu.tmx.mybooksapp.repository;

import hu.tmx.mybooksapp.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorDao extends JpaRepository<Author, Integer>{

    @Override
    List<Author> findAll();

    @Override
    List<Author> findAllById(Iterable<Integer> iterable);

    @Override
    <S extends Author> S save(S s);

    @Override
    void delete(Author author);

    @Override
    void deleteAll();

}
