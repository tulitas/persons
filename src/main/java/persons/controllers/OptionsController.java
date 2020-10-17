package persons.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;
import persons.models.Persons;
import persons.repositories.PersonsRepository;
import persons.services.PersonsService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.*;
import java.util.List;
import java.util.Optional;
import java.util.logging.FileHandler;


@Controller
@RequestMapping("/")
public class OptionsController {
    private PersonsService personsService;
//    private static Logger logger = LoggerFactory.getLogger(OptionsController.class);
    private String data = null;
    private String line = "";
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    private FileHandler fh;
    @PersistenceContext
    private EntityManager em;
    @Autowired
    PersonsRepository personsRepository;

    @Autowired
    public OptionsController(PersonsService personsService) {
        this.personsService = personsService;
    }

    @RequestMapping(value = "/options/create", method = RequestMethod.POST)
    public String loginValidation(Persons persons, String password, Model model, String login,
                                  @RequestParam(value = "error", required = false)
            String error)  {
        Persons personFromBd = personsRepository.getLogin(login);
        if (personFromBd != null) {
            model.addAttribute(error, "login exist");
            return "error";
        } else {
            persons.setPassword(encoder.encode(password));
            personsService.addPersons(persons);
            model.addAttribute("personToPopUp", persons);
//            logger.info(persons.getDateOfBirth() + " " + persons.getFullName() + " " + "Was Created");
            return "created";
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
        String[] csvHeader = {"User Id", "Login", "Name", "DateOfBirth"};
        String[] nameMaping = {"id", "login", "fullName", "dateOfBirth"};
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
                persons.setFullName(data[2]);
                persons.setPassword(data[3]);               ;
                persons.setDateOfBirth(data[4]);
                persons.setGender(data[5]);
                personsService.addPersons(persons);
                System.out.println(3);
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

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String login(  Model model, Persons persons, String login) {

       model.addAttribute("welcome", persons.getLogin()) ;
        return "welcome";
    }

    public String getData() {
        return data;
    }

    private void setData(String data) {
        this.data = data;
    }


}
