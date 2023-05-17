package finki.learnify_backend.models;

import finki.learnify_backend.models.embededIds.HaveId;
import jakarta.persistence.*;

@Entity
@Table(name = "imaat")
public class Have {

    @EmbeddedId
    private HaveId id;
    @ManyToOne
    @JoinColumn(name = "id_kategorija", referencedColumnName = "id_kategorija", insertable = false, updatable = false)
    private Category category;

    @ManyToOne
    @JoinColumn(name = "id_kursevi", referencedColumnName = "id_kursevi", insertable = false, updatable = false)
    private Courses courses;
}
