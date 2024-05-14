package sk.vinconafta.vpasem.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;
import sk.vinconafta.vpasem.LoginSecurity.SecurityLogin;
import sk.vinconafta.vpasem.Models.Event;
import sk.vinconafta.vpasem.Repos.EventRepo;
import sk.vinconafta.vpasem.Repos.TeacherDetails;

import java.security.Principal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

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
    public String getNewEvent(Event event, Authentication authentication) {
        LocalDateTime aktualnyCas = LocalDateTime.now();


        event.setEventDate(LocalDateTime.now());
        TeacherDetails td = (TeacherDetails) authentication.getPrincipal();
        event.setCreator(td.getTeacher());
        eventRepo.save(event);
        return "index";
    }
    @GetMapping("/gen_qr/{eventId}")
    public String getGeneratedQR(@PathVariable Long eventId, Model model) {
        Optional<Event> selectedEvent = eventRepo.findById(eventId);

        // ...
        if (selectedEvent.isPresent()) {
            if (selectedEvent.get().isAktualneBezi()) {
                model.addAttribute("event", selectedEvent.get());
                return "show_qr";
            } else {
                return "redirect:/";
            }
        }
        return  "index";
    }

    @GetMapping("/changepublicement/{id}")
    public String changePublicists(@PathVariable Long id) {
        Optional<Event> e = eventRepo.findById(id);
        if (e.isPresent()) {
            Event event = e.get();
            event.setVerejny(!event.isVerejny());
            eventRepo.save(event);
        }
        return "redirect:/eventsEditor";
    }
    @GetMapping("/changeActive/{id}")
    public String changeActive(@PathVariable Long id) {
        Optional<Event> e = eventRepo.findById(id);
        if (e.isPresent()) {
            Event event = e.get();
            event.setAktualneBezi(!event.isAktualneBezi());
            eventRepo.save(event);
        }
        return "redirect:/eventsEditor";
    }

    @GetMapping("/eventsEditor")
    public String getEvents(Model model, Authentication authentication) {
        TeacherDetails teacherDetails = (TeacherDetails) authentication.getPrincipal();
        model.addAttribute("pageTitle", "Moje udalosti");
        model.addAttribute("editable", true);
        model.addAttribute("events", eventRepo.getMyEvents(teacherDetails.getTeacher().getId()));
        return "allEvents";
    }

    @GetMapping("/TeacherEvents")
    public String getAllEvents(Model model, Authentication authentication) {
        TeacherDetails teacherDetails = (TeacherDetails) authentication.getPrincipal();
        model.addAttribute("pageTitle", "Všetky udalosti");
        model.addAttribute("editable", false);
        model.addAttribute("events", eventRepo.getMyEvents(teacherDetails.getTeacher().getId()));
        return "allEvents";
    }





}
