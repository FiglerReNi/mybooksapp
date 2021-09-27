package hu.tmx.mybooksapp.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name="authors")
public class Author {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private int id;
    @NotNull
    @NotBlank
    @Pattern(regexp = "^[a-zA-Z- ]+$")
    private String firstName;
    @NotNull
    @NotBlank
    @Pattern(regexp = "^[a-zA-Z- ]+$")
    private String lastName;
    @NotNull
    @Positive
    private Integer age;
    @ToString.Exclude
    @OneToMany(mappedBy = "author")
    @JsonManagedReference
    private List<Book> books;

}
