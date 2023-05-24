package finki.learnify_backend.models;

import finki.learnify_backend.enumerators.Category;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "quiz_id")
    private Long id;

    @Column(name = "time", nullable = false)
    private Integer time;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "category", nullable = false)
    private Category category;

    @Column(name = "numberOfQuestions", nullable = false)
    private Integer numberOfQuestions;

    @Column(name = "scoreToPass", nullable = false)
    private Integer scoreToPass;
    @OneToMany
    private List<Question> question;

    public Quiz(Integer time, Category category, Integer numberOfQuestions, Integer scoreToPass) {
        this.time = time;
        this.category = category;
        this.numberOfQuestions = numberOfQuestions;
        this.scoreToPass = scoreToPass;
    }
}
