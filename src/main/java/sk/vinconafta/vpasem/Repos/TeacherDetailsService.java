package sk.vinconafta.vpasem.Repos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import sk.vinconafta.vpasem.Models.Teacher;

import javax.sql.DataSource;
import java.util.List;

public class TeacherDetailsService implements UserDetailsService {
    @Autowired
    private TeacherRepo teacherRepo ;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Teacher teacher = teacherRepo.findByEmail(email);
        if (teacher == null) {
            throw new UsernameNotFoundException("User not found");
        } else {
            return new TeacherDetails(teacher);
        }
    }
}
