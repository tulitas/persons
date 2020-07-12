package persons.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import persons.models.Persons;
import persons.repositories.PersonsRepository;
import persons.services.PersonsService;

import javax.validation.Valid;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.List;
import java.util.Optional;

import static java.nio.charset.StandardCharsets.UTF_8;

@Controller
@RequestMapping("/")
public class OptionsController {
    private PersonsRepository personsRepository;
    private PersonsService personsService;
    private static Logger logger = LoggerFactory.getLogger(OptionsController.class);
    @Autowired
    public OptionsController(PersonsService personsService) {
        this.personsService = personsService;
    }

    @RequestMapping(value = "/options/create", method = RequestMethod.POST)
    public String options(Persons persons, String password,Model model) throws NoSuchAlgorithmException {

        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        MessageDigest md = MessageDigest.getInstance("SHA-512");
        md.update(salt);
        byte[] hashedPassword = md.digest(password.getBytes(UTF_8));
        persons.setPassword(String.valueOf(hashedPassword));
        personsService.addPersons(persons);
        model.addAttribute("personToPopUp", persons);
        System.out.println("654654 " + model);
        logger.info(persons.getRegDate() + " " + persons.getFullName() + " " + "Was Created");

        return "create";
    }

    @RequestMapping(value = "options/personsList")
    public String getAll(Model model) throws InterruptedException {
        List<Persons> personsForms = personsService.getAll();

        model.addAttribute("personsList", personsForms);

//        Thread.sleep(1000);
        return "personsList";
    }



    @RequestMapping(value = "/options/delete{id}", method = RequestMethod.GET)
    public String removeJobform(@PathVariable("id") long id) {
        personsService.removeJobForm(id);
        return "redirect:personsList";
    }

    @RequestMapping(value = "/options/edit{id}", method = RequestMethod.GET)
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Optional<Persons> personsList = personsService.findById(id);
        model.addAttribute("personToEdit", personsList);
        return "edit";
    }

    @RequestMapping(value = "/options/edit{id}", method = RequestMethod.POST)
    public String updateUser(@PathVariable("id") long id, @Valid Persons persons
            , BindingResult result, Model model) {
        if (result.hasErrors()) {
            persons.setId(id);
            return "registration";
        }

        personsService.addPersons(persons);
        model.addAttribute("persons", personsService.getAll());
        return "personsList";
    }
}
