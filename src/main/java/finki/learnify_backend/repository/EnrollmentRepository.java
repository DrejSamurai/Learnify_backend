package finki.learnify_backend.repository;

import finki.learnify_backend.dto.EnrollmentDTO;
import finki.learnify_backend.models.Enrollment;
import finki.learnify_backend.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Repository
public interface EnrollmentRepository {
    boolean existsByUserIdAndCourseId(Integer userId, Integer courseId);
    long countEnrollmentByUserAndIsCompleted(User user, Boolean isCompleted);
    long countEnrollmentByUser(User user);
    Optional<Enrollment> getByUserIdAndEnrollId(Integer userId, Integer enrollId);
    List<EnrollmentDTO> findByUserId(Integer userId, Pageable pageable);
    Optional<Enrollment> getByUserIdAndCourseId(Integer userId, Integer courseId);
}
