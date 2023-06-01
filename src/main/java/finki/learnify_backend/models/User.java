package finki.learnify_backend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import finki.learnify_backend.models.enumerators.Role;
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
@Table(name = "course_users")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class User implements UserDetails {
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Long id;

      @Column(name = "first_name")
      private String first_name;

      @Column(name = "last_name")
      private String last_name;

      @Column(name = "email")
      private String email;

      @Column(name = "password")
      private String password;

      @Enumerated(EnumType.STRING)
      @Column(name = "role")
      private Role role;

      @Column(name = "user_bio")
      private String bio;

      @ManyToMany
      @JoinTable(
              name = "course_has_participants",
              joinColumns = @JoinColumn(name = "user_id"),
              inverseJoinColumns = @JoinColumn(name = "course_id"))
      @JsonBackReference
      private List<Course> courses;

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
