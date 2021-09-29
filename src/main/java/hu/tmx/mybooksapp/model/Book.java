package hu.tmx.mybooksapp.model;

import hu.tmx.mybooksapp.entity.Author;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {

    @Setter(AccessLevel.NONE)
    private long id;

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
    private Author author;

    public Book(long id, String title, int releaseDate) {
        this.id = id;
        this.title = title;
        this.releaseDate = releaseDate;
    }
}
