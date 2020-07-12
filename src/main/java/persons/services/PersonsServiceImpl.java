package persons.services;

import org.hibernate.sql.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import persons.models.Persons;
import persons.repositories.PersonsRepository;

import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Service
public class PersonsServiceImpl implements PersonsService {
    private final PersonsRepository personsRepository;

    @Autowired
    public PersonsServiceImpl(PersonsRepository personsRepository) {
        this.personsRepository = personsRepository;
    }


    @Override
    @Transactional
    public void addPersons(Persons persons) {
        personsRepository.save(persons);

    }

    @Override
    public List<Persons> getAll() {
        return (List<Persons>) personsRepository.findAll();
    }

    @Override
    public void removeJobForm(long id) {
        personsRepository.deleteById(id);
    }

    @Override
    public Optional<Persons> findById(long id) {
        return personsRepository.findById(id);
    }




}
