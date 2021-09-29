package hu.tmx.mybooksapp.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
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
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
}
