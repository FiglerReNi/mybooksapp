package hu.tmx.mybooksapp.dao.mem;

import hu.tmx.mybooksapp.dao.AuthorDao;
import hu.tmx.mybooksapp.model.Author;
import org.springframework.stereotype.Component;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class AuthorDaoMem implements AuthorDao {

    public static List<Author> authors = new ArrayList<>();

    @Override
    public List<Author> getAllAuthorFromList() {
        return authors.stream()
                .sorted(Comparator.comparing(Author::getFirstName))
                .collect(Collectors.toList());
    }

    @Override
    public Author getAuthorByIdFromList(int id) {
        return authors.stream()
                .filter(b -> b.getId() == id)
                .findFirst()
                .orElseThrow(()->new NoSuchElementException(id + ". id doesn't exists."));
    }

    @Override
    public int getMaxIdFromList() {
        return authors.stream()
                .mapToInt(Author::getId)
                .max()
                .orElseThrow(()->new NoSuchElementException("Maximum id not found."));
    }

    @Override
    public void saveToList(Author author) {
        authors.add(author);
    }

    @Override
    public void deleteFromList(Author author) {
        authors.remove(author);
    }

    @Override
    public void updateList(int id, Author author) {
        int authorIndex = authors.indexOf(getAuthorByIdFromList(id));
        System.out.println(authorIndex);
        authors.set(authorIndex, author);
    }
}
