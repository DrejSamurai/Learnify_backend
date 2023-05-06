package finki.learnify_backend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "kursevi")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Courses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_kursevi")
    private Long course_id;

    @Column(name = "kuVideo")
    private String course_video;

    @Column(name = "kuNaslov")
    private String course_title;

    @Column(name = "kuOpis")
    private String course_bio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_korisnik", nullable = false)
    private Mentor mentor;
}
