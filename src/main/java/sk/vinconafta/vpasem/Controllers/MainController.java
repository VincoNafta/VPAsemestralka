package sk.vinconafta.vpasem.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import sk.vinconafta.vpasem.Models.Event;
import sk.vinconafta.vpasem.Models.Teacher;
import sk.vinconafta.vpasem.Repos.EventRepo;
import sk.vinconafta.vpasem.Repos.TeacherRepo;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    EventRepo eventRepo;
    @GetMapping("/")
    public String index() {
        return  "index";
    }

    @GetMapping("/events")
    public String events() {
        List<Event> events = eventRepo.getActiveEvents();
        return "actualEvents";
    }

}
