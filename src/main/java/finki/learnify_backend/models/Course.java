package finki.learnify_backend.models;

import finki.learnify_backend.enumerators.Category;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Table
@EqualsAndHashCode
@NoArgsConstructor
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
    @Enumerated(value = EnumType.STRING)
    private Category category;
    @Column(name = "price", nullable = false)
    private Long price;
    @Column(name = "rating")
    private long rating;

    public Course(String title, String author, Category category, Long price, long rating) {
        this.title = title;
        this.author = author;
        this.category = category;
        this.price = price;
        this.rating = rating;
    }
}
