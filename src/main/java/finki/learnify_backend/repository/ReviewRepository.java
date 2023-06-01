package finki.learnify_backend.repository;

import finki.learnify_backend.models.Course;
import finki.learnify_backend.models.CourseReviewId;
import finki.learnify_backend.models.Review;
import finki.learnify_backend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, CourseReviewId> {
    Review findByCourseAndUser(Course course, User user);
    void deleteByCourseAndUser(Course course, User user);
}
