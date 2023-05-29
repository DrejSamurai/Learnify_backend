package finki.learnify_backend.models;

import finki.learnify_backend.models.enumerators.Category;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "course")
@EqualsAndHashCode
@NoArgsConstructor
@Data
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "author", nullable = false, length = 100)
    private String author;

    @Column(name = "description")
    private String description;
    @Column(name = "category", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Category category;
    @Column(name = "rating")
    private Double rating;
    @CreationTimestamp
    @Column(name = "date_created")
    private Date dateCreated;

    @ManyToOne
    @JoinColumn(
            name = "user_creator",
            referencedColumnName = "id",
            nullable = false
    )
    private User creator;
    @ManyToMany
    @JoinTable(
            name = "course_has_admins",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> admins;

    @ManyToMany
    @JoinTable(
            name = "course_has_participants",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> participants;

    public Course(String title, String author, Category category, Double rating) {
        this.title = title;
        this.author = author;
        this.category = category;
        this.rating = rating;
    }
}
