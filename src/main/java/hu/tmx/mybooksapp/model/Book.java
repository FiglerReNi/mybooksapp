package hu.tmx.mybooksapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

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
    @JsonIgnore
    @Valid
    private Author author;

}
