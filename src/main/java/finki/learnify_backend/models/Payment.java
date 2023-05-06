package finki.learnify_backend.models;

import jakarta.persistence.*;

@Entity
@Table(name = "plakjanje")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_plakjanje")
    private Long id_payment;

    @Column(name = "p_iznos", nullable = false)
    private Integer payment_amount;

    @Column(name = "id_korisnik", nullable = false)
    private Long id_user;

    @ManyToOne
    @JoinColumn(name = "id_korisnik", referencedColumnName = "id_korisnik", insertable = false, updatable = false)
    private Mentor mentor;
}
