package sk.vinconafta.vpasem.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.vinconafta.vpasem.Models.Event;

public interface EventRepo extends JpaRepository<Event, Long> {


}
