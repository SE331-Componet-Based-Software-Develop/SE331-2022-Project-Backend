package se331.rest.repository;



import org.springframework.data.repository.CrudRepository;
import se331.rest.entity.Authority;
import se331.rest.entity.AuthorityName;

public interface AuthorityRepository extends CrudRepository<Authority, Long> {
    Authority findByName(AuthorityName input);
}
