package hu.tmx.mybooksapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {

    private int id;
    @NotBlank
    @Pattern(regexp = "^[a-zA-Z- ]+$")
    private String title;
    @NotNull
    @Positive
    @DecimalMin("1000")
    @DecimalMax("9999")
    private int releaseDate;
    @Valid
    private Author author;

}
