package persons.repositories;

import org.springframework.data.repository.CrudRepository;
import persons.models.Persons;

public interface PersonsRepository extends CrudRepository<Persons, Long> {

}
