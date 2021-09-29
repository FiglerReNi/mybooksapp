package hu.tmx.mybooksapp.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "authors")
public class Author {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
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
