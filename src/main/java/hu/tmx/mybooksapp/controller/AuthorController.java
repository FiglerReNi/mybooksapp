package hu.tmx.mybooksapp.controller;

import hu.tmx.mybooksapp.model.Author;
import hu.tmx.mybooksapp.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/view/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping(path = " ")
    public String allAuthor(Model model){
        model.addAttribute("authors", authorService.getAllAuthor());
        return "view/allAuthor";
    }

    @GetMapping(path = "/{id}")
    public String authorById(@PathVariable(value = "id") int id, Model model){
        model.addAttribute("author", authorService.getAuthorById(id));
        return "view/authorById";
    }

    @PostMapping(" ")
    public String saveNewAuthor(@ModelAttribute Author author){
        authorService.save(Author.builder()
                .id(authorService.getMaxId()+1)
                .firstName(author.getFirstName())
                .lastName(author.getLastName())
                .age(author.getAge()).build());
        return "index";
    }

    @DeleteMapping("/{id}")
    public String deleteAuthor(@PathVariable(value = "id") int id){
        authorService.delete(authorService.getAuthorById(id));
        return "index";
    }

    @PutMapping(value = "/{id}")
    public String updateAuthor(@PathVariable(value = "id") int id, @RequestBody Author author){
        authorService.update(id, author);
        return "index";
    }

    @GetMapping(path = "/new")
    public String newAuthor(Model model){
        model.addAttribute("author", new Author());
        return "view/newAuthor";
    }

    @GetMapping(path = "/update/{id}")
    public String updateAuthorView(Model model, @PathVariable(value = "id") int id){
        model.addAttribute("authorUpdate", authorService.getAuthorById(id));
        return "view/updateAuthor";
    }
}
