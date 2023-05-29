package finki.learnify_backend.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class EnrollmentDTO {
    String email;
    Long courseId;
}