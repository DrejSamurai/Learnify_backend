package finki.learnify_backend.repository;

import finki.learnify_backend.models.Course;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findAllByCategory(String category);

    @Query("select distinct c from Course c order by c.dateCreated desc")
    Page<Course> findAllPaged(Pageable pageable);

    List<Course> getCourseByAuthor(String author);

    List<Course> getCourseByPrice(Long price);
}
