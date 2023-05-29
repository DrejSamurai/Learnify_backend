package finki.learnify_backend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import org.hibernate.annotations.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Instant;


@Entity
@Data
@Table(name = "enrollments", uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "course_id"}))
@EqualsAndHashCode
@NoArgsConstructor
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "enrollment_id")
    private Long id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinColumn(name = "user_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    @JsonBackReference
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Course course;

    @Column(name = "is_completed", nullable = false)
    @ColumnDefault(value = "false")
    private Boolean isCompleted = false;

    @Column(name = "next_position")
    @ColumnDefault(value = "1")
    private Integer nextPosition = 1;

    @ColumnDefault("0")
    @Column(name = "progress", nullable = false, precision = 6, scale = 2)
    private BigDecimal progress = BigDecimal.ZERO;

    @CreationTimestamp
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @UpdateTimestamp
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Column(name = "updated_at")
    private Instant updatedAt = null;

    public BigDecimal getProgress() {
        return progress.setScale(0, RoundingMode.HALF_UP);
    }

    public Enrollment(User user, Course course) {
        this.user = user;
        this.course = course;
    }

    public Enrollment(User user, Course course, Boolean isCompleted, Instant createdAt, Instant updatedAt) {
        this.user = user;
        this.course = course;
        this.isCompleted = isCompleted;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
