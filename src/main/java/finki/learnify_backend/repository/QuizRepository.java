package finki.learnify_backend.repository;

import finki.learnify_backend.enumerators.Category;
import finki.learnify_backend.models.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {
    Quiz findAllByCategory(Category category);
}
