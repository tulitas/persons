package persons.services;

import org.springframework.data.domain.Sort;
import persons.models.Persons;

import java.util.List;
import java.util.Optional;

public interface PersonsService {


    void addPersons(Persons persons);

    List<Persons> getAll();

    void removeJobForm(long id);

    Optional<Persons> findById(long id);


    String getLogin(String login);
}
