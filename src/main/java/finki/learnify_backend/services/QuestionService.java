package finki.learnify_backend.services;

import finki.learnify_backend.models.requests.QuestionRequest;
import finki.learnify_backend.models.Question;
import finki.learnify_backend.repository.QuestionRepository;
import finki.learnify_backend.repository.QuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionService {
    private final QuestionRepository questionRepository;

    private final QuizRepository quizRepository;

    public List<Question> findAllQuestionsByQuiz(Long quizId){
        return questionRepository.findAllByQuiz(quizRepository.findById(quizId).orElseThrow());
    }

    public void deleteQuestion(Long questionId){
        questionRepository.delete(questionRepository.findById(questionId).orElseThrow());
    }

    public Question addQuestion(QuestionRequest request){
        Question question = new Question(request.getText(),request.getCreatedAt());
        question.setAnswers(request.getAnswers());
        question.setQuiz(request.getQuiz());
        return question;
    }

    public Question updateQuestion(QuestionRequest request, Long questionId){
        Question question = questionRepository.findById(questionId).orElseThrow();
        question.setQuiz(request.getQuiz());
        question.setText(request.getText());
        question.setAnswers(request.getAnswers());
        question.setCreatedAt(request.getCreatedAt());
        questionRepository.save(question);
        return question;
    }
}
