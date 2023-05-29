package finki.learnify_backend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.UUID;

@Entity
@Data
@RequiredArgsConstructor
@Table(name = "lessons", uniqueConstraints = @UniqueConstraint(columnNames = {"course_id", "position"}))
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "lesson_id")
    private Long id;

    @Column(name = "lesson_name")
    private String lessonName;

    @Column(name = "videokey", nullable = false, unique = true, length = 20)
    private String videokey;

    @ColumnDefault("0")
    @Column(name = "lenght_seconds")
    private Integer lengthSeconds;
    @Column(name = "position", nullable = false)
    private Integer position;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonBackReference
    private Course course;
}
