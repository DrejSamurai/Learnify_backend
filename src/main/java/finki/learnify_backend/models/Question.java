package finki.learnify_backend.models;

import jakarta.persistence.*;

@Entity
@Table(name = "prashanja")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_prashanje")
    private Long question_id;

    @Column(name = "p_prashanje")
    private String p_question;

    @ManyToOne
    @JoinColumn(name = "id_quiz")
    private Quiz quiz;
}
