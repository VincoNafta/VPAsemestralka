package sk.vinconafta.vpasem.Repos;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import sk.vinconafta.vpasem.Models.Teacher;

import java.util.Collection;

public class TeacherDetails implements UserDetails {
    private Teacher teacher;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public TeacherDetails(Teacher teacher) {
        this.teacher = teacher;
    }

    public Teacher getTeacher() {
        return this.teacher;
    }

    @Override
    public String getPassword() {
        return teacher.getPassword();
    }

    public String getFullName() {
        if (teacher.getTitul() != null) {
            return teacher.getTitul() + " " + teacher.getMeno() + " " + teacher.getPriezvisko();
        }
        return teacher.getMeno() + " " + teacher.getPriezvisko();
    }

    @Override
    public String getUsername() {
        return teacher.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
