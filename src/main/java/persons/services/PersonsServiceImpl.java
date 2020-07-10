package persons.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import persons.models.Persons;
import persons.repositories.PersonsRepository;

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
        System.out.println(persons);

    }
}
