package sk.vinconafta.vpasem.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sk.vinconafta.vpasem.Models.Teacher;

import java.util.List;

public interface TeacherRepo extends JpaRepository<Teacher, Long> {
    @Query("SELECT t FROM Teacher t WHERE t.titul IS NOT NULL")
    public List<Teacher> findWithoutTitul();
}
