package se331.rest.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import se331.rest.entity.Patient;
import se331.rest.security.entity.User;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    @Query(value = "select u from User u where u.authorities is EMPTY")
    List<User> findUserWithNoAuth();

}
