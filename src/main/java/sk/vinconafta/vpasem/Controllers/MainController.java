package sk.vinconafta.vpasem.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import sk.vinconafta.vpasem.Models.Teacher;
import sk.vinconafta.vpasem.Repos.TeacherRepo;

@Controller
public class MainController {
    @GetMapping("/")
    public String index() {
        return  "index";
    }

}
