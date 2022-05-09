package pl.javastart.devicrent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.javastart.devicrent.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}