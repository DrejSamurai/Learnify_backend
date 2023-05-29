package finki.learnify_backend.dto;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class EnrollmentDTO {
    private Long id;
    private BigDecimal progress;
    private String title;
    private String thumbUrl;
    private Integer courseId;

    public EnrollmentDTO() {
    }

    public EnrollmentDTO(Long id, BigDecimal progress, String title, String thumbUrl, Integer courseId) {
        this.id = id;
        this.progress = progress;
        this.title = title;
        this.thumbUrl = thumbUrl;
        this.courseId = courseId;
    }
}