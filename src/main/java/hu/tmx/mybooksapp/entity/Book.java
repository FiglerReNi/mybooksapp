package hu.tmx.mybooksapp.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name="books")
public class Book {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private int id;
    @NotNull
    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9- ']+$")
    private String title;
    @NotNull
    @Positive
    @DecimalMin("1000")
    @DecimalMax("9999")
    private int releaseDate;
    @Valid
    @ManyToOne
    @JsonBackReference
    private Author author;

}
