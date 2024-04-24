package sk.vinconafta.vpasem.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sk.vinconafta.vpasem.Models.Event;

import java.util.List;

public interface EventRepo extends JpaRepository<Event, Long> {

    @Query("SELECT e FROM Event e WHERE e.aktualneBezi = true")
    public List<Event> getActiveEvents();
}
