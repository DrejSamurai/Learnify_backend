package finki.learnify_backend.services;

import finki.learnify_backend.models.CourseReviewId;
import finki.learnify_backend.models.dto.CourseReviewDto;
import finki.learnify_backend.models.dto.CourseReviewDtoWithCompositeIdDto;
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
    private final CourseService courseService;
    private final UserService userService;
    private final ReviewRepository reviewRepository;

    public Review editReview(CourseReviewDtoWithCompositeIdDto courseReviewDtoWithCompositeIdDto) {
        if(courseReviewDtoWithCompositeIdDto.getCourseReviewId().getCourse() != null
                && courseReviewDtoWithCompositeIdDto.getCourseReviewId().getUser() != null) {
            Review courseReview = this.reviewRepository.findByCourseAndUser(this.courseService.findById(courseReviewDtoWithCompositeIdDto.getCourseReviewId().getCourse()),
                    this.userService.findById(courseReviewDtoWithCompositeIdDto.getCourseReviewId().getUser()));
            courseReview.setCourse(this.courseService.findById(courseReviewDtoWithCompositeIdDto.getCourseReviewDto().getCourseId()));
            courseReview.setUser(this.userService.findByEmail(courseReviewDtoWithCompositeIdDto.getCourseReviewDto().getEmail()));
            courseReview.setRating(courseReviewDtoWithCompositeIdDto.getCourseReviewDto().getRating());
            courseReview.setComment(courseReviewDtoWithCompositeIdDto.getCourseReviewDto().getComment());
            courseReview.setCreatedAt(courseReviewDtoWithCompositeIdDto.getCourseReviewDto().getCreatedAt());
            return this.reviewRepository.save(courseReview);
        }else{
            throw new RuntimeException();
        }
    }
    public Review addReview(CourseReviewDto courseReviewDto) {
        Course course = this.courseService.findById(courseReviewDto.getCourseId());
        User user = this.userService.findByEmail(courseReviewDto.getEmail());
        Review courseReview = new Review();
        courseReview.setCourse(course);
        courseReview.setUser(user);
        courseReview.setRating(courseReviewDto.getRating());
        courseReview.setComment(courseReviewDto.getComment());
        courseReview.setCreatedAt(courseReviewDto.getCreatedAt());
        return this.reviewRepository.save(courseReview);
    }

    @Transactional
    public void deleteReview(CourseReviewId courseReviewId) {
        if(courseReviewId.getCourse() != null && courseReviewId.getUser() != null) {
            this.reviewRepository.deleteByCourseAndUser(this.courseService.findById(courseReviewId.getCourse()),
                    this.userService.findById(courseReviewId.getUser()));
        }
    }
}
