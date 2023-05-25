package finki.learnify_backend.controllers;

import finki.learnify_backend.dto.QuestionRequest;
import finki.learnify_backend.dto.RegisterRequest;
import finki.learnify_backend.models.Question;
import finki.learnify_backend.security.auth.AuthenticationResponse;
import finki.learnify_backend.services.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/question")
@RequiredArgsConstructor
public class QuestionsController {
    private final QuestionService questionService;

    @PostMapping("/addQuestion") public ResponseEntity<Question> register(
            @RequestBody QuestionRequest request){
        return ResponseEntity.ok(questionService.addQuestion(request));
    }
}
