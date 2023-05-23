package finki.learnify_backend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "mentor")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Mentor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mentor_id")
    private Long mentorId;

    @Column(name = "m_bio", nullable = false)
    private String mBio;

    @Column(name = "id_korisnik", nullable = false)
    private Long id_User;

   // @OneToOne
   // @JoinColumn(name = "id_korisnik", referencedColumnName = "id_korisnik", insertable = false, updatable = false)
   // private User users;
}