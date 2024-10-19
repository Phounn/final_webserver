package web.group.two.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.group.two.user.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByAccount_username(String username);

}
