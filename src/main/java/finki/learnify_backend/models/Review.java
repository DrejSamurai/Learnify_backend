package finki.learnify_backend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jayway.jsonpath.internal.function.numeric.Max;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.Instant;
import java.util.Date;
import java.util.Objects;

@Entity(name = "course_reviews")
@Data
@RequiredArgsConstructor
@IdClass(CourseReviewId.class)
public class Review {
    @Id
    @ManyToOne
    @JoinColumn(
            name = "course_id",
            referencedColumnName = "id",
            nullable = false
    )
    @JsonBackReference
    private Course course;

    @Id
    @ManyToOne
    @JoinColumn(
            name = "user_id",
            referencedColumnName = "id",
            nullable = false
    )
    private User user;

    @Column(name = "rating_value", nullable = false)
    private Double rating;

    @Column(name = "rating_comment", nullable = false)
    private String comment;

    @Column(nullable = false)
    private Date createdAt;
}
