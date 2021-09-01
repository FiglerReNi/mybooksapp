package hu.tmx.mybooksapp.dao.mem;

import hu.tmx.mybooksapp.dao.AuthorDao;
import hu.tmx.mybooksapp.model.Author;
import hu.tmx.mybooksapp.model.Book;
import hu.tmx.mybooksapp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class AuthorDaoMem implements AuthorDao {

    public static List<Author> authors = new ArrayList<>();

    private BookService bookService;

    @Autowired
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

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
        Author oldAuthor = getAuthorByIdFromList(id);
        Author updatedAuthor = Author.builder()
                .id(id)
                .firstName(author.getFirstName())
                .lastName(author.getLastName())
                .age(author.getAge())
                .books(oldAuthor.getBooks()).build();
        authors.set(authorIndex, updatedAuthor);
        bookService.getAllBooksWithAuthor().stream()
                .filter(book -> book.getAuthor().getId() == id)
                .forEach(b -> {
                    Book updatedBook = Book.builder()
                            .id(b.getId())
                            .title(b.getTitle())
                            .releaseDate(b.getReleaseDate())
                            .author(updatedAuthor).build();
                    bookService.update(b.getId(), updatedBook);
                });
    }

    public void addOneBookToList(Book book){
        book.getAuthor().addBook(book);
    }
}
