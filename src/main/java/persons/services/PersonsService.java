package persons.services;

import persons.models.Persons;

import java.util.List;
import java.util.Optional;

public interface PersonsService {


    void addPersons(Persons persons);

    List<Persons> getAll();

    void removeJobForm(long id);

    Optional<Persons> findById(long id);
}
