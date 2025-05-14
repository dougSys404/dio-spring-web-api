package spring_web_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring_web_api.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByLogin(String username);
}
