package finki.learnify_backend.services;

import finki.learnify_backend.dto.ReviewRequest;
import finki.learnify_backend.models.User;
import finki.learnify_backend.repository.CourseRepository;
import finki.learnify_backend.repository.ReviewRepository;
import finki.learnify_backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final CourseRepository courseRepository;
    private final UserRepository userRepository;
    private final ReviewRepository reviewRepository;

    public void addCourseRating(ReviewRequest request, Long userId){
    }

}
