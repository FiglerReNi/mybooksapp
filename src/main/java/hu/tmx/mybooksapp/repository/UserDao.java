package hu.tmx.mybooksapp.repository;

import hu.tmx.mybooksapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer> {

    User findByUsername(String username);

    User findByEmail(String email);

    User findByActivation(String code);
}
