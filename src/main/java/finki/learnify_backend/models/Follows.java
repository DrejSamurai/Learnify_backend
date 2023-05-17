package finki.learnify_backend.models;

import finki.learnify_backend.models.embededIds.FollowsId;
import jakarta.persistence.*;

@Entity
@Table(name = "slushanje")
public class Follows {
    @EmbeddedId
    private FollowsId id;

    @Column(name = "plateno")
    private Boolean isPayed;

    @Column(name = "feedback")
    private String feedback;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "id_payment")
    private Payment payment;
}
