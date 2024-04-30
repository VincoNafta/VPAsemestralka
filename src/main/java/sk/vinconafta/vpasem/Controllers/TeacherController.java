package sk.vinconafta.vpasem.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import sk.vinconafta.vpasem.Models.Teacher;
import sk.vinconafta.vpasem.Repos.TeacherRepo;

import java.util.List;

@Controller
public class TeacherController {

    @Autowired
    private TeacherRepo teacherRepo;

    @GetMapping("/teacher")
    public String defefaultPage() {
        return "deafaultTeacher";
    }
    @GetMapping("teachers")
    public String getTeahers(Model model) {
        model.addAttribute("list", teacherRepo.findAll());
        return "teachers";
    }

    @GetMapping("/register")
    public String newRegister(Model model) {
        model.addAttribute("teacher", new Teacher());
        return "register";
    }
    @PostMapping("/register_user")
    public String reg_usr(Teacher teacher) {
        teacherRepo.save(teacher);
        return "register";
    }
}


