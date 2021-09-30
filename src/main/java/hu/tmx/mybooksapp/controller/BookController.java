package hu.tmx.mybooksapp.controller;

import hu.tmx.mybooksapp.model.Author;
import hu.tmx.mybooksapp.model.Book;
import hu.tmx.mybooksapp.service.AuthorService;
import hu.tmx.mybooksapp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(path = "/view/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    @GetMapping(path = " ")
    public String allBooksWithAuthor(Model model) {
        model.addAttribute("books", bookService.getAllBooksWithAuthor());
        return "view/allBooksWithAuthor";
    }

    @GetMapping(path = "/{id}")
    public String bookWithAuthorById(@PathVariable(value = "id") int id, Model model) {
        model.addAttribute("book", bookService.getBookWithAuthorById(id));
        return "view/bookWithAuthorById";
    }

    @PostMapping(" ")
    public String saveNewBook(@RequestParam("title") String title, @RequestParam("releaseDate") String releaseDate, @RequestParam("authorId") String authorId) {
        Author author = authorService.getAuthorById(Integer.parseInt(authorId));
        hu.tmx.mybooksapp.entity.Author authorParam
                = hu.tmx.mybooksapp.entity.Author.builder()
                .id(author.getId()).firstName(author.getFirstName()).lastName(author.getLastName()).age(author.getAge())
                .build();
        Book book = Book.builder()
                .title(title)
                .releaseDate(Integer.parseInt(releaseDate))
                .author(authorParam).build();
        bookService.insert(book);
        return "index";
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable(value = "id") int id) {
        bookService.delete(bookService.getBookWithAuthorById(id));
        return "index";
    }

    @PutMapping(value = "/{id}")
    public String updateBook(@PathVariable(value = "id") int id, @Valid @RequestBody Book book) {
        bookService.update(book);
        return "index";
    }

    @GetMapping(path = "/new")
    public String newBook(Model model) {
        model.addAttribute("authors", authorService.getAllAuthor());
        return "view/newBook";
    }

    @GetMapping(path = "/update/{id}")
    public String updateBookView(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("book", bookService.getBookWithAuthorById(id));
        model.addAttribute("authors", authorService.getAllAuthor());
        return "view/updateBook";
    }
}
