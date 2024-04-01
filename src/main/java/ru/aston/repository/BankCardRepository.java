package main.java.ru.aston.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankCardRepository extends CrudRepository<ru.aston.model.BankCardIsAlreadyAssignedException, Long> {
}