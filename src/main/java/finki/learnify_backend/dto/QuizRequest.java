package finki.learnify_backend.dto;

import finki.learnify_backend.enumerators.Category;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuizRequest {
    private Integer time;
    private Category category;

    private Integer numberOfQuestions;

    private Integer scoreToPass;
}
