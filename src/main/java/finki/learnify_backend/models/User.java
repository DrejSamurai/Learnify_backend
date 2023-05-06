package finki.learnify_backend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "korisnici")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      @Column(name = "id_korisnik")
      private Long id;

      @Column(name = "k_ime")
      private String name;

      @Column(name = "k_prezime")
      private String last_name;

      @Column(name = "k_mail")
      private String email;

      @Column(name = "k_password")
      private String password;
}
