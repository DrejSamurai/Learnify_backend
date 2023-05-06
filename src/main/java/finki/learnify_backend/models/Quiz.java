package finki.learnify_backend.models;

import jakarta.persistence.*;

@Entity
@Table(name = "kviz")
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_kviz")
    private long id;

    @Column(name = "id_kursevi", nullable = false)
    private Integer idKursevi;

    @ManyToOne
    @JoinColumn(name = "id_kursevi", referencedColumnName = "id_kursevi", insertable = false, updatable = false)
    private Courses courses;
}
