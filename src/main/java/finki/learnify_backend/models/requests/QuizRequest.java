package finki.learnify_backend.models.requests;

import finki.learnify_backend.models.enumerators.Category;
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
