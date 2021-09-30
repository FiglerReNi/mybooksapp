package hu.tmx.mybooksapp.model.ext;

import hu.tmx.mybooksapp.model.Author;
import hu.tmx.mybooksapp.model.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AuthorExt extends Author {

    private List<Book> books;

    public AuthorExt(long id, String firstName, String lastName, Integer age, List<Book> books) {
        super(id, firstName, lastName, age);
        this.books = books;
    }
}
