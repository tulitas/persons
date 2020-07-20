package persons.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import persons.services.PalindromCheck;

@Controller
@RequestMapping("/")
public class PalindromController {

    @RequestMapping(value = "/palindrom/word", method = RequestMethod.POST)
    public String getWord(String word, Model model) {
        PalindromCheck palindrom = new PalindromCheck();
        palindrom.chekWord(word);
        String palindromChek = palindrom.getResultPalindrom();
        String result = word;

        model.addAttribute("result", result);
        model.addAttribute("palindromChek", palindromChek);
        return "result";
    }
}
