package finki.learnify_backend.repository;

import finki.learnify_backend.models.EnrollProgress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EnrollProgressRepository extends JpaRepository<EnrollProgress, Long> {

    long countByEnrollmentId(Long id);

    @Query("SELECT e FROM EnrollProgress e WHERE e.enrollment.id = ?1 AND e.lesson.id = ?2")
    Optional<EnrollProgress> findByEnrollIdAndLessonId(Long enrollId, Long lessonId);
}
