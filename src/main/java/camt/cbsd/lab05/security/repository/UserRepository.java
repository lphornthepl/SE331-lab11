package camt.cbsd.lab05.security.repository;



import camt.cbsd.lab05.entity.security.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

/**
 * Created by stephan on 20.03.16.
 */
@RepositoryRestResource(exported = false)
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
