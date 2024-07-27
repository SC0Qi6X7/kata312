package spring_crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring_crud.model.User;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> { }
