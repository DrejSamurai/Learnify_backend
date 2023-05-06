package finki.learnify_backend.models.embededIds;

import jakarta.persistence.Column;

import java.io.Serializable;

public class HaveId implements Serializable {
    @Column(name = "id_kategorija", nullable = false)
    private Long id_category;

    @Column(name = "id_kursevi", nullable = false)
    private Long idKursevi;
}
