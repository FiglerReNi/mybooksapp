package hu.tmx.mybooksapp.model;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Author {

    @Setter(AccessLevel.NONE)
    private long id;

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
}
