package finki.learnify_backend.controllers;

import finki.learnify_backend.models.dto.UpdateUserDTO;
import finki.learnify_backend.models.User;
import finki.learnify_backend.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/profile")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000")
public class ProfileController {
    private final UserService userService;

    @PutMapping("/api/profile/{userId}")
    public ResponseEntity<String> updateUser(@PathVariable Long userId, @RequestBody UpdateUserDTO updateUserDto) {
        User user = userService.updateUserNameAndLastname(userId, updateUserDto.getFirstname(), updateUserDto.getLastname());
        return ResponseEntity.ok("User updated successfully.");
    }
}
