package persons.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import persons.models.Persons;
import persons.services.PersonsService;

@Controller
@RequestMapping("/")
public class OptionsController {

    private PersonsService personsService;

    @Autowired
    public OptionsController(PersonsService personsService) {
        this.personsService = personsService;
    }

    @RequestMapping(value = "/options/create", method = RequestMethod.POST)
    public String options(Persons persons) {
        personsService.addPersons(persons);

        return "create";
    }
}
