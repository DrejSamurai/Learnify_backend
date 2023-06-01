package finki.learnify_backend.models.dto;

import finki.learnify_backend.models.enumerators.Category;
import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Getter
public class CourseDTO {
    private String title;
    private Long userID;
    private String author;
    private String description;
    private Category category;
    private Double rating;
    private Date dateCreated;
}
