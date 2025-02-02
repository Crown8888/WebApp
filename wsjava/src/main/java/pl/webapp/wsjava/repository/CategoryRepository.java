package pl.webapp.wsjava.repository;

import org.springframework.data.repository.CrudRepository;
import pl.webapp.wsjava.model.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {

    Category findByName(String name);

}
