package finki.learnify_backend.repository;

import finki.learnify_backend.models.Lesson;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.Optional;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {
    @Query(value = "SELECT s FROM Lesson s where s.course.id = ?1 ORDER BY s.position")
    Slice<Lesson> getLessonsByCourseId(Integer courseId, Pageable pageable);
    @Query("SELECT s FROM Lesson s where s.course.id = ?1 and s.position = ?2")
    Optional<Lesson> findByCourseIdAndPosition(Integer courseId, Integer position);
    @Query("SELECT count(s) from Lesson s where s.course.id = ?1")
    long countByCourseId(Integer id);
}
