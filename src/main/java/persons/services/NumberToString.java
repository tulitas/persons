package persons.services;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class NumberToString {

//    @RequestMapping(value = "numberToString", method = RequestMethod.POST)
//    public String getNum(Integer num, Model model) {
//        System.out.println(num);
//        return "numberToString/numberToString";
//    }

    @RequestMapping(value = "numberToString")
    public String getNum() {
        return "numberToString/numberToString";
    }

    @RequestMapping(value = "numberConvert", method = RequestMethod.POST)
    public String convrtNum(Integer num, Model model) {
        NumbersTransformer numbersTransformer = new NumbersTransformer();
        if (num < 0 || num > 100) {
            System.out.println("error");
        }
        numbersTransformer.setNumFromWeb(num);
        numbersTransformer.transfer();
        String numString = numbersTransformer.getText();

        model.addAttribute("numString", numString);
        return "result2";
    }
}
