package persons.repositories;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import persons.models.Persons;

import java.util.List;

public interface PersonsRepository extends CrudRepository<Persons, Long> {


    List<Persons> findAll(Sort login);
}
