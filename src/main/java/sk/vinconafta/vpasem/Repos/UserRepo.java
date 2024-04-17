package sk.vinconafta.vpasem.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.vinconafta.vpasem.Models.User;

public interface UserRepo extends JpaRepository<User, Long> {
}
