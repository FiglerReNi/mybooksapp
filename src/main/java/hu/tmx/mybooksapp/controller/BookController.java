package hu.tmx.mybooksapp.controller;

import hu.tmx.mybooksapp.interfaces.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


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

}
