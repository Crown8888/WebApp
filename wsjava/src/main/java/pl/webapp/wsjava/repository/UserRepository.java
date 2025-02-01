package pl.webapp.wsjava.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import pl.webapp.wsjava.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.username = ?1")
    User findByUsername(String username);
}
