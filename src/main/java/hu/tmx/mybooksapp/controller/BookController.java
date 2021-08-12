package hu.tmx.mybooksapp.controller;

import hu.tmx.mybooksapp.interfaces.BookDao;
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

    @Autowired
    @Qualifier("BookDaoMem")
    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
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
    public String saveNewBook(@ModelAttribute Book book){
        //valami sikeres mentés is
        return "index";
    }

    @RequestMapping(path = "/new", method = RequestMethod.GET)
    public String newBook(Model model){
        model.addAttribute("book", new Book());
        return "view/newBook";
    }

}
