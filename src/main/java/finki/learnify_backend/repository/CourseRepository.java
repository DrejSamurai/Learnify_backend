package finki.learnify_backend.repository;

import finki.learnify_backend.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findAllByCategory(String category);

    List<Course> getCourseByAuthor(String author);

    List<Course> getCourseByPrice(Long price);
}
