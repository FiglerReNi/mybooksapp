package hu.tmx.mybooksapp.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.*;
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
    @OneToMany(mappedBy = "author")
    @JsonManagedReference
    private List<Book> books;

}
