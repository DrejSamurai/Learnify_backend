package finki.learnify_backend.models;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Entity
@NoArgsConstructor
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    private Long id;

    @Column(name = "text", nullable = false)
    private String text;

    @Column(name = "createdAt")
    private Instant createdAt;

    @OneToMany
    private List<Answer> answers;

    public Question(String text, Instant createdAt) {
        this.text = text;
        this.createdAt = createdAt;
    }
}
