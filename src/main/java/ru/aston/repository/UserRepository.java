package main.java.ru.aston.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import main.java.ru.aston.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}