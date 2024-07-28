package spring.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.crud.model.User;

public interface UserRepository extends JpaRepository<User, Integer> { }
