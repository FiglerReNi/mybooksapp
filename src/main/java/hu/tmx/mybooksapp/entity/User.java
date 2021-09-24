package hu.tmx.mybooksapp.entity;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;
    @NotNull
    @Email
    @Pattern(regexp=".+@.+\\..+")
    @Column(unique=true)
    private String email;
    @NotNull
    @Pattern(regexp = "^[a-zA-Z0-9-]+$")
    private String password;
    @NotNull
    @Pattern(regexp = "^[a-zA-Z0-9-]+$")
    @Column(unique=true)
    private String username;

}
