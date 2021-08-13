package hu.tmx.mybooksapp.controller;

import hu.tmx.mybooksapp.interfaces.AuthorDao;
import hu.tmx.mybooksapp.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(" ")
    public String saveNewAuthor(@ModelAttribute Author author){
        authorDao.save(new Author((authorDao.getMaxId()+1), author.getFirstName(), author.getLastName(), author.getAge()));
        return "index";
    }

    @DeleteMapping("/{id}")
    public String deleteAuthor(@PathVariable(value = "id") int id){
        authorDao.delete(authorDao.getAuthorById(id));
        return "index";
    }

    @PutMapping(value = "/{id}")
    public String updateAuthor(@PathVariable(value = "id") int id, @RequestBody Author author){
        authorDao.delete(authorDao.getAuthorById(id));
        authorDao.save(author);
        return "index";
    }

    @RequestMapping(path = "/new", method = RequestMethod.GET)
    public String newAuthor(Model model){
        model.addAttribute("author", new Author());
        return "view/newAuthor";
    }

    @RequestMapping(path = "/update/{id}", method = RequestMethod.GET)
    public String updateAuthor(Model model, @PathVariable(value = "id") int id){
        model.addAttribute("authorUpdate", authorDao.getAuthorById(id));
        return "view/updateAuthor";
    }



}
