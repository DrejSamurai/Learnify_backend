package finki.learnify_backend.controllers;

import finki.learnify_backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/profile")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000")
public class ProfileController {
    private final UserRepository userRepository;


}
