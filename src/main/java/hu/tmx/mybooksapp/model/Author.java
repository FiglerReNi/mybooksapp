package hu.tmx.mybooksapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Author {

    private int id;
    private String firstName;
    private String lastName;
    private Integer age;

}
