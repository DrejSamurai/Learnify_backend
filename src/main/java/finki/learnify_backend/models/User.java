package finki.learnify_backend.models;

import finki.learnify_backend.enumerators.Role;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;


@Data
@Builder
@Entity
@Table(name = "korisnici")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class User implements UserDetails {
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      @Column(name = "user_id")
      private Long id;

      @Column(name = "k_ime")
      private String name;

      @Column(name = "k_prezime")
      private String last_name;

      @Column(name = "k_mail")
      private String email;

      @Column(name = "k_password")
      private String password;

      @Enumerated(EnumType.STRING)
      private Role role;

      @Override
      public Collection<? extends GrantedAuthority> getAuthorities() {
            return List.of(new SimpleGrantedAuthority(role.name()));
      }

      // The username for  this app is the email
      @Override
      public String getUsername() {
            return this.getEmail();
      }

      @Override
      public boolean isAccountNonExpired() {
            return true;
      }

      @Override
      public boolean isAccountNonLocked() {
            return true;
      }

      @Override
      public boolean isCredentialsNonExpired() {
            return true;
      }

      @Override
      public boolean isEnabled() {
            return true;
      }
}
