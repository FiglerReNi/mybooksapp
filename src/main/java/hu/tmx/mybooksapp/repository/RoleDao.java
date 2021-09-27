package hu.tmx.mybooksapp.repository;

import hu.tmx.mybooksapp.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Role, Integer> {
    Role findByRole(String user_role);
}
