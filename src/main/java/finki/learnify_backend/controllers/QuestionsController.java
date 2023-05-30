package finki.learnify_backend.controllers;

import finki.learnify_backend.models.requests.QuestionRequest;
import finki.learnify_backend.models.Question;
import finki.learnify_backend.services.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/course-reviews")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000")
public class QuestionsController {
    private final QuestionService questionService;
    @PostMapping("/addQuestion")
    public ResponseEntity<Question> addQuestion(
            @RequestBody QuestionRequest request){
        return ResponseEntity.ok(questionService.addQuestion(request));
    }
}
