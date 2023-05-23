package finki.learnify_backend.models;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

@Entity
@Table
@EqualsAndHashCode
@RequiredArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Long id;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "author", nullable = false, length = 100)
    private String author;
    @Column(name = "category", nullable = false)
    private String category;
    @Column(name = "price", nullable = false)
    private Long price;
    @Column(name = "rating")
    private long rating;
}
