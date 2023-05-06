package finki.learnify_backend.models;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "kategorija")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_kategorija")
    private Long id_Category;

    @Column(name = "ka_ime", nullable = false)
    private String category_name;
}
