package finki.learnify_backend.models;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "answer_id")
    private Long id;

    @Column(name = "answer", nullable = false)
    private String answer;

    @Column(name = "is_correct", columnDefinition = "BOOLEAN default FALSE")
    private Boolean isCorrect;

    public Answer(String answer, Boolean isCorrect) {
        this.answer = answer;
        this.isCorrect = isCorrect;
    }
}
