package finki.learnify_backend.services;

import finki.learnify_backend.models.requests.QuizRequest;
import finki.learnify_backend.models.Question;
import finki.learnify_backend.models.Quiz;
import finki.learnify_backend.repository.QuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuizService {
    private final QuizRepository quizRepository;

    public Quiz addQuiz(QuizRequest request){
        Quiz quiz = new Quiz(
                request.getTime(),
                request.getCategory(),
                request.getNumberOfQuestions(),
                request.getScoreToPass());
        quizRepository.save(quiz);
        return quiz;
    }

    public Quiz updateQuiz(QuizRequest request, Long quizId){
        Quiz quiz = quizRepository.findById(quizId).orElseThrow();
        quiz.setTime(request.getTime());
        quiz.setCategory(request.getCategory());
        quiz.setScoreToPass(request.getScoreToPass());
        quiz.setNumberOfQuestions(request.getNumberOfQuestions());
        quizRepository.save(quiz);
        return quiz;
    }

    public void removeQuiz(Long quizId){
        quizRepository.delete(quizRepository.findById(quizId).orElseThrow());
    }

    public List<Question> getQuestionsForQuiz(Long quizId){
        Quiz quiz = quizRepository.findById(quizId).orElseThrow();
        return quiz.getQuestion();
    }
}
