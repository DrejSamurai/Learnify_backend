package finki.learnify_backend.repository;

import finki.learnify_backend.models.enumerators.Category;
import finki.learnify_backend.models.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepository extends CrudRepository<Quiz, Long> {
}
