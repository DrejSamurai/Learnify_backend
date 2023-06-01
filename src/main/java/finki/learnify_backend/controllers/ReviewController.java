package finki.learnify_backend.controllers;

import finki.learnify_backend.models.CourseReviewId;
import finki.learnify_backend.models.Review;
import finki.learnify_backend.models.dto.CourseReviewDto;
import finki.learnify_backend.models.dto.CourseReviewDtoWithCompositeIdDto;
import finki.learnify_backend.services.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/course-reviews")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000")
public class ReviewController {
    private final ReviewService reviewService;

    @PostMapping("/add-review")
    private ResponseEntity<Review> addReview(@RequestBody CourseReviewDto courseReviewDto){
        return ResponseEntity.ok().body(this.reviewService.addReview(courseReviewDto));
    }
    @PutMapping("/edit-review")
    private ResponseEntity<Review> editReview(@RequestBody CourseReviewDtoWithCompositeIdDto courseReviewDtoWithCompositeIdDto){
        return ResponseEntity.ok().body(this.reviewService.editReview(courseReviewDtoWithCompositeIdDto));
    }
    @DeleteMapping("/delete-review")
    private void deleteReview(@RequestBody CourseReviewId courseReviewId){
        this.reviewService.deleteReview(courseReviewId);
    }
}
