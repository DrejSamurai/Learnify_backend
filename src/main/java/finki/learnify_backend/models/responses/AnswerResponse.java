package finki.learnify_backend.models.responses;

import finki.learnify_backend.models.Answer;
import finki.learnify_backend.models.Quiz;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AnswerResponse {
    private Long id;
    private String content;
    private Long questionId;
    private Long userId;
    // Add any other properties or relationships you need

    // Constructors, getters, and setters
}