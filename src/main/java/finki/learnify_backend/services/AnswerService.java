package finki.learnify_backend.services;

import finki.learnify_backend.models.Answer;
import finki.learnify_backend.repository.AnswerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnswerService {
    private final AnswerRepository answerRepository;

    // to do findAll, delete, update
    public List<Answer> findAllAnswers(){
        return answerRepository.findAll();
    }

   public List<Answer> findAllCorrect(){
        return answerRepository.findAllByIsCorrectIsTrue();
   }

   public void deleteAnswer(Long id){
        answerRepository.delete(answerRepository.findById(id).orElseThrow());
   }
}
