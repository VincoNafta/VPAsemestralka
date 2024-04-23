package sk.vinconafta.vpasem.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import sk.vinconafta.vpasem.Models.User;
import sk.vinconafta.vpasem.Repos.UserRepo;

@Controller
public class VoteController {

    @Autowired
    UserRepo repo;

    @GetMapping("/writeUser")
    public String getNewUser(Model model) {
        model.addAttribute("user", new User());
        return "zapis";
    }

}
