package sk.vinconafta.vpasem.Models;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

@Entity
@Table(name = "Events")
public class Event  {

    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;
    @Column(nullable = false)
    private String name;
    private boolean aktualneBezi;
    @jakarta.persistence.Id
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAktualneBezi() {
        return aktualneBezi;
    }

    public void setAktualneBezi(boolean aktualneBezi) {
        this.aktualneBezi = aktualneBezi;
    }
}
