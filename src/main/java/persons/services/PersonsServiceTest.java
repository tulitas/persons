package persons.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import persons.models.Persons;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class PersonsServiceTest {

    @Autowired

    PersonsService personsService;

    @Test
    public void addPersons(Persons persons) {
        String agent = personsService.getLogin("");
        assertTrue("yo", agent.contains("Tulitas"));
    }
}