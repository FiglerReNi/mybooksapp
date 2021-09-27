package hu.tmx.mybooksapp.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity(name="users")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
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

    private String activation;

    private Boolean enabled;
    @ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinTable(
            name="users_roles",
            joinColumns= {@JoinColumn(name="user_id")},
            inverseJoinColumns= {@JoinColumn(name="role_id")}
    )

    private Set<Role> roles = new HashSet<Role>();

}
