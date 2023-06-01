package finki.learnify_backend.models.dto;

import finki.learnify_backend.models.CourseReviewId;
import lombok.Getter;

@Getter
public class CourseReviewDtoWithCompositeIdDto {
    CourseReviewDto courseReviewDto;
    CourseReviewId courseReviewId;
}
