package persons.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import persons.models.Persons;


public interface PersonsRepository extends CrudRepository<Persons, Long> {

    @Query(value = "SELECT login from persons.persons where login = :login", nativeQuery = true)
    String chekLogin(String login);
}
