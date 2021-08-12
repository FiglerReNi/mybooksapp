package hu.tmx.mybooksapp.service;

import hu.tmx.mybooksapp.interfaces.AuthorDao;
import hu.tmx.mybooksapp.model.Author;
import hu.tmx.mybooksapp.model.BaseData;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Qualifier("AuthorDaoMem")
public class AuthorDaoMem implements AuthorDao {

    @Override
    public List<Author> getAllAuthor() {
        return BaseData.authors.stream()
                .sorted(Comparator.comparing(Author::getFirstName))
                .collect(Collectors.toList());
    }

    @Override
    public Author getAuthorById(int id) {
        return BaseData.authors.stream()
                .filter(b -> b.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
