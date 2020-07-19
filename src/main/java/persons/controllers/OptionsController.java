package persons.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;
import persons.models.Persons;
import persons.repositories.PersonsRepository;
import persons.security.PasswordCoder;
import persons.services.PersonsService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.List;
import java.util.Optional;

import static java.nio.charset.StandardCharsets.UTF_8;

@Controller
@RequestMapping("/")
public class OptionsController {
    private PersonsService personsService;
    private static Logger logger = LoggerFactory.getLogger(OptionsController.class);
    private String data = null;
    private String line = "";

    @PersistenceContext
    private EntityManager em;
    @Autowired
    PersonsRepository personsRepository;

    @Autowired
    public OptionsController(PersonsService personsService) {
        this.personsService = personsService;
    }

    @RequestMapping(value = "/options/create", method = RequestMethod.POST)
    public String loginValidation(Persons persons, String password, Model model, String login, BindingResult result, @RequestParam(value = "error", required = false) String error) throws NoSuchAlgorithmException {

        Persons personFromBd = personsRepository.getLogin(login);
        if (personFromBd != null) {
            model.addAttribute("error", login);
            return "error";
        } else {
            PasswordCoder passwordCoder = new PasswordCoder(password);
            persons.setPassword(String.valueOf(passwordCoder.getHashtext() + " " + passwordCoder.getHashedPassword()));
            personsService.addPersons(persons);
            model.addAttribute("personToPopUp", persons);
            logger.info(persons.getRegDate() + " " + persons.getFullName() + " " + "Was Created");
            return "create";
        }
    }

    @RequestMapping(value = "options/personsList")
    public String getAll(Model model) throws InterruptedException {
        List<Persons> personsForms = personsService.getAll();
        model.addAttribute("personsList", personsForms);
        setData(String.valueOf(model));
        return "personsList";
    }


    @GetMapping(value = "options/csv")
    public String exportToCsv(HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        String fileName = "file.csv";
        String headerKey = "Content-Desposition";
        String headerValue = "attachment; filename " + fileName;
        response.setHeader(headerKey, headerValue);
        List<Persons> personsList = personsService.getAll();

        ICsvBeanWriter csvBeanWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);

        String[] csvHeader = {"User Id", "Login", "Name", "Age"};
        String[] nameMaping = {"id", "login", "fullName", "age"};

        csvBeanWriter.writeHeader(csvHeader);
        for (Persons persons : personsList) {
            csvBeanWriter.write(persons, nameMaping);
        }
        csvBeanWriter.close();
        return "personsList";
    }

    @RequestMapping(value = "options/uploadCsv")
    public void uploadCsvInDb() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/upload.csv"));
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                Persons persons = new Persons();
                persons.setId(Long.parseLong(data[0]));
                persons.setLogin(data[1]);
                persons.setPassword(data[2]);
                persons.setFullName(data[3]);
                persons.setAge(Integer.parseInt(data[4]));
                persons.setRegDate(data[5]);
                personsService.addPersons(persons);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

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

    @RequestMapping(value = "/loginn")
    public String login(@RequestParam(name = "error", required = false) Boolean error,
                        Model model) {
        if (Boolean.TRUE.equals(error)) {
            model.addAttribute("error", true);
        }
        return "personsList";
    }

    public String getData() {
        return data;
    }

    private void setData(String data) {
        this.data = data;
    }
}
