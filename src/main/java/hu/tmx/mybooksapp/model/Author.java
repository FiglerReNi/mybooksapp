package hu.tmx.mybooksapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    //@JsonIgnore - a Lista változathoz kell, jdbc-hez nem
    private List<Book> books;

}
