package persons.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import persons.models.Persons;
import persons.repositories.PersonsRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Service
public class PersonsServiceImpl implements PersonsService {
    @Autowired
    private final PersonsRepository personsRepository;
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    public PersonsServiceImpl(PersonsRepository personsRepository) {
        this.personsRepository = personsRepository;
    }
//    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    @Transactional
    public boolean addPersons(Persons persons) {


        personsRepository.save(persons);
        return true;


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

    @Override
    public String getLogin(String login) {
        return personsRepository.getLogin(login);
    }


}
