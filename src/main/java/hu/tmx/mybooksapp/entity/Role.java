package hu.tmx.mybooksapp.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.HashSet;
import java.util.Set;

@Entity(name="roles")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Role {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private int id;
    @NotNull
    @Pattern(regexp = "^[a-zA-Z]+$")
    private String role;
    @ManyToMany(mappedBy="roles")
    private Set<User> users = new HashSet<>();

    public Role(String role) {
        this.role = role;
    }
}
