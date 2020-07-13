package persons.controllers;

import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.opencsv.CSVWriter;
import org.h2.tools.Csv;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;
import persons.models.Persons;
import persons.services.PersonsService;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.nio.charset.StandardCharsets.UTF_8;

@Controller
@RequestMapping("/")
public class OptionsController {
    private PersonsService personsService;
    private static Logger logger = LoggerFactory.getLogger(OptionsController.class);
    private String data = null;
    @Autowired
    public OptionsController(PersonsService personsService) {
        this.personsService = personsService;
    }

    @RequestMapping(value = "/options/create", method = RequestMethod.POST)
    public String options(Persons persons, String password, Model model) throws NoSuchAlgorithmException {

        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        MessageDigest md = MessageDigest.getInstance("SHA-512");
        md.update(salt);
        byte[] hashedPassword = md.digest(password.getBytes(UTF_8));
        persons.setPassword(String.valueOf(hashedPassword));
        personsService.addPersons(persons);
        model.addAttribute("personToPopUp", persons);
        logger.info(persons.getRegDate() + " " + persons.getFullName() + " " + "Was Created");
        return "create";
    }

    @RequestMapping(value = "options/personsList")
    public String getAll(Model model) throws InterruptedException {
        List<Persons> personsForms = personsService.getAll();
        model.addAttribute("personsList", personsForms);
        setData(String.valueOf(model));
        return "personsList";
    }


    //    @RequestMapping(value = "options/sort")
//    public String sortAsc(Model model) {
//        List<Persons> asc = personsService.getAll(Sort.by(Sort.Direction.ASC, "age"));
//        model.addAttribute("asc", asc);
//        System.out.println("asc" + asc);
//        return "personsList";
//    }
    @GetMapping(value = "options/csv")
    public void exportToCsv(HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        String fileName = "file.csv";
        String headerKey = "Content-Desposition";
        String headerValue = "attachment; filename " + fileName;
        response.setHeader(headerKey, headerValue);
        List<Persons> personsList = personsService.getAll();
        ICsvBeanWriter csvBeanWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);

        String[] csvHeader = {"User Id", "Login", "Password"};
        String[] nameMaping = {"id", "login", "password"};

        csvBeanWriter.writeHeader(csvHeader);
        for (Persons persons : personsList) {
            csvBeanWriter.write(persons, nameMaping);
        }
        csvBeanWriter.close();
    }
//    @RequestMapping(value = "options/csv")
//    public String getCsv() {
//        return Stream.of(getData())
//
//                .map(this::escapeSpecialCharacters)
//                .collect(Collectors.joining(","));
//    }
//
//    private String escapeSpecialCharacters(String data) {
//        String escapedData = data.replaceAll("\\R", " ");
//        if (data.contains(",") || data.contains("\"") || data.contains("'")) {
//            data = data.replace("\"", "\"\"");
//            escapedData = "\"" + data + "\"";
//        }
//        givenDataArray();
//        return escapedData;
//
//
//    }
//    public void givenDataArray()  {
//        File csvOutputFile = new File("src/main/resources/file.csv");
//        try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
//        int d =     data.compareTo(String.valueOf(csvOutputFile));
//
//            System.out.println("d " + d);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//
//    }


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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
