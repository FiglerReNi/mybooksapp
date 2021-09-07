package hu.tmx.mybooksapp.model;

import lombok.*;

import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Author {

    private int id;
    @NotBlank
    @Pattern(regexp = "^[a-zA-Z-]+$")
    private String firstName;
    @NotBlank
    @Pattern(regexp = "^[a-zA-Z-]+$")
    private String lastName;
    @NotNull
    @Positive
    private Integer age;
    @ToString.Exclude
    private List<Book> books;

    public void addBook(Book book) {
        if (books == null) {
            books = new ArrayList<>();
        }
        books.add(book);
    }
}
