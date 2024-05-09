package sk.vinconafta.vpasem.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sk.vinconafta.vpasem.Models.User;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Long> {

    @Query("SELECT s from students s WHERE s.event.id = ?1")
    public List<User> getAllOnEvent(Long eventId);
}
