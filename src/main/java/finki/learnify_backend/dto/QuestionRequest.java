package finki.learnify_backend.dto;

import finki.learnify_backend.models.Answer;
import finki.learnify_backend.models.Quiz;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuestionRequest {
    private String text;
    private Instant createdAt;
    private List<Answer> answers;
    private Quiz quiz;
}
