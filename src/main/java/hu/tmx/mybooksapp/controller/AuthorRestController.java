package hu.tmx.mybooksapp.controller;

import hu.tmx.mybooksapp.exception.ListItemNotFoundException;
import hu.tmx.mybooksapp.model.Author;
import hu.tmx.mybooksapp.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/rest/authors")
public class AuthorRestController {

    private AuthorService authorService;

    @Autowired
    public void setAuthorService(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping(path = " ")
    public List<Author> allAuthor() throws ListItemNotFoundException {
        if(authorService.getAllAuthor().isEmpty()){
            throw new ListItemNotFoundException();
        }
        return authorService.getAllAuthor();
    }

    @GetMapping(path = "/{id}")
    public Author authorById(@PathVariable(value = "id") int id){
        return authorService.getAuthorById(id);

    }

    @DeleteMapping(path="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> deleteAuthor(@PathVariable(value = "id") int id){
        authorService.delete(authorService.getAuthorById(id));
        return ResponseEntity.status(HttpStatus.OK).body(Map.of(
                "status", HttpStatus.OK.value(),
                "message", "successful deletion"));
    }

    @PostMapping(" ")
    public ResponseEntity<Object> saveNewAuthor(@Valid @RequestBody Author author){
        authorService.save(Author.builder()
                .id(authorService.getMaxId()+1)
                .firstName(author.getFirstName())
                .lastName(author.getLastName())
                .age(author.getAge()).build());
        return ResponseEntity.status(HttpStatus.OK).body(Map.of(
                "status", HttpStatus.OK.value(),
                "message", "author saved"));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateAuthor(@PathVariable(value = "id") int id,@Valid @RequestBody Author author){
        Author updatedAuthor = Author.builder()
                .id(id)
                .firstName(author.getFirstName())
                .lastName(author.getLastName())
                .age(author.getAge()).build();
        authorService.update(id, updatedAuthor);
        return ResponseEntity.status(HttpStatus.OK).body(Map.of(
                "status", HttpStatus.OK.value(),
                "message", "author updated"));
    }

}
