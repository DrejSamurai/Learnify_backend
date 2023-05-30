package finki.learnify_backend.models.dto;

import lombok.Getter;

import java.util.Date;

@Getter
public class CourseReviewDto {
    Long courseId;
    String email;
    Double rating;
    String comment;
    Date createdAt;
}
