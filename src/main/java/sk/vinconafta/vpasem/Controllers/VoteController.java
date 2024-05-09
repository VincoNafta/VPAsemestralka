package sk.vinconafta.vpasem.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sk.vinconafta.vpasem.Models.Event;
import sk.vinconafta.vpasem.Models.User;
import sk.vinconafta.vpasem.Repos.EventRepo;
import sk.vinconafta.vpasem.Repos.UserRepo;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/qr")
public class VoteController {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private EventRepo eventRepo;

    @GetMapping("/writeUser")
    public String getNewUser(Model model) {
        model.addAttribute("user", new User());
        return "zapis";
    }

    @GetMapping("/dochadzka/{eventId}")
    public String getDochadzaPage(@PathVariable Long eventId, Model model) {
        Optional<Event> selectedEvent = eventRepo.findById(eventId);

        // ...
        if (selectedEvent.isPresent()) {
            if (selectedEvent.get().isAktualneBezi()) {
                model.addAttribute("event", selectedEvent.get());
                User u = new User();
                u.setEvent(selectedEvent.get());
                model.addAttribute("user", u);
                return "dochadzka";
            } else {
                return "index";
            }


        }
        return "index";

    }

    @PostMapping("/zapis_dochadzku")
    public String zapis(User user) {
        userRepo.save(user);
        return "index";
    }
    @GetMapping("showPeople/{id}")
    public String showPeoples(@PathVariable Long id, Model model) {
        Optional<Event> e = eventRepo.findById(id);
        if (e.isPresent()) {
            List<User> usersOnEvent = userRepo.getAllOnEvent(id);
            model.addAttribute("users", usersOnEvent);
            model.addAttribute("event", e.get());
            return "who";
        }
        return "redirect:/eventsEditor";
    }

}
