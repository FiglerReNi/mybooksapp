package hu.tmx.mybooksapp.controller;

import hu.tmx.mybooksapp.interfaces.AuthorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path = "/authors")
public class AuthorController {

    private AuthorDao authorDao;

    @Autowired
    @Qualifier("AuthorDaoMem")
    public void setBookDao(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @RequestMapping(path = " ", method = RequestMethod.GET)
    public String allAuthor(Model model){
        model.addAttribute("authors", authorDao.getAllAuthor());
        return "view/allAuthor";
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public String bookWithAuthorById(@PathVariable(value = "id") int id, Model model){
        model.addAttribute("author", authorDao.getAuthorById(id));
        return "view/authorById";
    }
}
