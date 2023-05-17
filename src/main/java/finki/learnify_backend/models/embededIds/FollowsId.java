package finki.learnify_backend.models.embededIds;

import finki.learnify_backend.models.Courses;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;

public class FollowsId implements Serializable {
    @Column(name = "id_slushanje")
    private Long idSlushanje;

    @ManyToOne
    @JoinColumn(name = "id_kursevi")
    private Courses kursevi;
}
