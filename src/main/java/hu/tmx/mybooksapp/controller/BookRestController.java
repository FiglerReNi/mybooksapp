package hu.tmx.mybooksapp.controller;

import hu.tmx.mybooksapp.exception.ListItemNotFoundException;
import hu.tmx.mybooksapp.entity.Book;
import hu.tmx.mybooksapp.service.AuthorService;
import hu.tmx.mybooksapp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/rest/books")
public class BookRestController {

    @Autowired
    private BookService bookService;
    @Autowired
    private AuthorService authorService;

    @GetMapping(path = " ")
    public List<Book> allBooksWithAuthor() throws ListItemNotFoundException {
        if (bookService.getAllBooksWithAuthor().isEmpty()) {
            throw new ListItemNotFoundException();
        }
        return bookService.getAllBooksWithAuthor();
    }

    @GetMapping(path = "/{id}")
    public Book bookWithAuthorById(@PathVariable(value = "id") int id) {
        return bookService.getBookWithAuthorById(id);
    }

    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> deleteBook(@PathVariable(value = "id") int id) {
        bookService.delete(bookService.getBookWithAuthorById(id));
        return ResponseEntity.status(HttpStatus.OK).body(Map.of(
                "status", HttpStatus.OK.value(),
                "message", "successful deletion"));
    }

    @PostMapping(" ")
    public ResponseEntity<Object> saveNewBook(@Valid @RequestBody Book book) {
        if (null != authorService.getAuthorById(book.getAuthor().getId())) {
            bookService.save(book);
        }
        return ResponseEntity.status(HttpStatus.OK).body(Map.of(
                "status", HttpStatus.OK.value(),
                "message", "book saved"));
    }


    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateBook(@PathVariable(value = "id") int id, @Valid @RequestBody Book book) {
        if(null != bookService.getBookWithAuthorById(id)){
            Book updatedBook = Book.builder()
                    .id(id)
                    .title(book.getTitle())
                    .releaseDate(book.getReleaseDate())
                    .author(authorService.getAuthorById(book.getAuthor().getId())).build();
            bookService.save(updatedBook);
        }
        return ResponseEntity.status(HttpStatus.OK).body(Map.of(
                "status", HttpStatus.OK.value(),
                "message", "book updated"));
    }
}
