package sk.vinconafta.vpasem.Models;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Events")
public class Event  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String name;
    private LocalDateTime eventDate;
    private LocalDateTime endTime;
    private String miestnost;
    @OneToOne
    @JoinColumn
    private Teacher creator;
    private boolean aktualneBezi;

    public boolean isVerejny() {
        return verejny;
    }

    public Teacher getCreator() {
        return creator;
    }

    public void setCreator(Teacher creator) {
        this.creator = creator;
    }

    public void setVerejny(boolean verejny) {
        this.verejny = verejny;
    }

    private boolean verejny;

    public LocalDateTime getEventDate() {
        return eventDate;
    }

    public String getMiestnost() {
        return miestnost;
    }

    public void setMiestnost(String miestnost) {
        this.miestnost = miestnost;
    }

    public void setEventDate(LocalDateTime eventDate) {
        this.eventDate = eventDate;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
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

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
