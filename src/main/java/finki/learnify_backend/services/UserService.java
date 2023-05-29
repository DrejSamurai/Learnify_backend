package finki.learnify_backend.services;

import finki.learnify_backend.models.User;
import finki.learnify_backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User updateUserNameAndLastname(Long id, String name, String lastname){
        User user = userRepository.findById(id).orElseThrow();
        user.setFirst_name(name);
        user.setLast_name(lastname);
        userRepository.save(user);
        return user;
    }
}
