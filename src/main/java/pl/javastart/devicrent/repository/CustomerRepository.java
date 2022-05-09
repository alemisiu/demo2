package pl.javastart.devicrent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.javastart.devicrent.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}