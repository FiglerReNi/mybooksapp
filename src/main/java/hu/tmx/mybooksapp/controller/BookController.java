package hu.tmx.mybooksapp.controller;

import hu.tmx.mybooksapp.interfaces.AuthorDao;
import hu.tmx.mybooksapp.interfaces.BookDao;
import hu.tmx.mybooksapp.model.Author;
import hu.tmx.mybooksapp.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping(path = "/books")
public class BookController {

    private BookDao bookDao;
    private AuthorDao authorDao;

    @Autowired
    @Qualifier("BookDaoMem")
    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Autowired
    @Qualifier("AuthorDaoMem")
    public void setBookDao(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @RequestMapping(path = " ", method = RequestMethod.GET)
    public String allBooksWithAuthor(Model model){
        model.addAttribute("books", bookDao.getAllBooksWithAuthor());
        return "view/allBooksWithAuthor";
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public String bookWithAuthorById(@PathVariable(value = "id") int id, Model model){
        model.addAttribute("book", bookDao.getBookWithAuthorById(id));
        return "view/bookWithAuthorById";
    }

    @PostMapping(" ")
    public String saveNewBook(@RequestParam("title") String title, @RequestParam("releaseDate") String releaseDate, @RequestParam("authorId") String authorId){
        Author authorOfBook = authorDao.getAuthorById(Integer.parseInt(authorId));
        Book book = new Book((bookDao.getMaxId()+1), title, Integer.parseInt(releaseDate), authorOfBook);
        bookDao.save(book);
        return "index";
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable(value = "id") int id){
        bookDao.delete(bookDao.getBookWithAuthorById(id));
        return "index";
    }

    @RequestMapping(path = "/new", method = RequestMethod.GET)
    public String newBook(Model model){
        model.addAttribute("authors", authorDao.getAllAuthor());
        return "view/newBook";
    }


}
