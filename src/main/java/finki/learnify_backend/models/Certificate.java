package finki.learnify_backend.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "sertifikat")
public class Certificate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sertifikat")
    private Long id_Certificate;

    @Column(name = "s_datum", nullable = false)
    private LocalDate submited_date;

    @Column(name = "id_kviz", nullable = false)
    private Long quiz_id;

    @ManyToOne
    @JoinColumn(name = "id_kviz", referencedColumnName = "id_kviz", insertable = false, updatable = false)
    private Quiz kviz;
}
