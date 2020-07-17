package persons.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/")
public class SiteController {
    @RequestMapping("/")
    public ModelAndView index() {
        return new ModelAndView("index");
    }

    @RequestMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("login");
    }

    @RequestMapping("/registration")
    public ModelAndView registration() {
        return new ModelAndView("registration");

    }
    @RequestMapping("/personsList")
    public ModelAndView personsList() {
        return new ModelAndView("personsList");
    }

    @RequestMapping("/edit")
    public ModelAndView edit() {
        return new ModelAndView("edit");
    }
}
