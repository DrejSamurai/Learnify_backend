package finki.learnify_backend.controllers;

import finki.learnify_backend.models.Quiz;
import finki.learnify_backend.models.requests.QuestionRequest;
import finki.learnify_backend.models.Question;
import finki.learnify_backend.services.QuestionService;
import finki.learnify_backend.services.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/course-reviews")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000")
public class QuestionsController {
    private final QuestionService questionService;
    private final QuizService quizService;

    @PostMapping("/addQuestion")
    public ResponseEntity<List<QuestionRequest>> addQuestion(
            @RequestBody List<QuestionRequest> request){
        Quiz quiz = new Quiz();
        quiz.setQuestion(Arrays.asList(request.stream().toArray(Question[]::new)));
        quizService.addQuiz(quiz);
        return ResponseEntity.ok(questionService.addQuestion(request));
    }
}
