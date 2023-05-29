package finki.learnify_backend.services;

import finki.learnify_backend.models.requests.ReviewRequest;
import finki.learnify_backend.models.Course;
import finki.learnify_backend.models.Review;
import finki.learnify_backend.models.User;
import finki.learnify_backend.repository.CourseRepository;
import finki.learnify_backend.repository.ReviewRepository;
import finki.learnify_backend.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final CourseRepository courseRepository;
    private final UserRepository userRepository;
    private final ReviewRepository reviewRepository;

    @Transactional
    public void addCourseRating(ReviewRequest request, Long userId){
       User user = userRepository.findById(userId).orElseThrow();
       Course course = courseRepository.findById(request.getCourseId()).orElseThrow();
       Review review = new Review(
               request.getRating(),
               request.getContent(),
               user,
               course);
       reviewRepository.save(review);
    }

    @Transactional
    public void updateCourseRating(ReviewRequest request, Long reviewId){
        Review review = reviewRepository.findById(reviewId).orElseThrow();
        Course course = courseRepository.findById(request.getCourseId()).orElseThrow();
        review.setRating(request.getRating());
        review.setContent(request.getContent());
        reviewRepository.save(review);
    }
}
