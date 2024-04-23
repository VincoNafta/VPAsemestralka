package sk.vinconafta.vpasem.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import sk.vinconafta.vpasem.Models.Event;
import sk.vinconafta.vpasem.Repos.EventRepo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Controller
public class EventController {

    @Autowired
    private EventRepo eventRepo;
    @GetMapping("/createEvent")
    public String getEvenent(Model model) {
        model.addAttribute("event", new Event());
        return "createevent";
    }

    @PostMapping("/saveNewEvent")
    public String getNewEvent(Event event) {
        LocalDateTime aktualnyCas = LocalDateTime.now();


        event.setEventDate(LocalDateTime.now());
        eventRepo.save(event);
        return "index";
    }



}
