package sk.vinconafta.vpasem.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import sk.vinconafta.vpasem.Models.Teacher;

@Controller
public class MainController {

    @GetMapping("/")
    public String index() {
        return  "index";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("teacher", new Teacher());
        return "register";
    }

}
