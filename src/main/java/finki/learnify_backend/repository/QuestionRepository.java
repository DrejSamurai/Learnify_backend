package finki.learnify_backend.repository;

import finki.learnify_backend.models.Question;
import finki.learnify_backend.models.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findAllByQuiz(Quiz quiz);
}
