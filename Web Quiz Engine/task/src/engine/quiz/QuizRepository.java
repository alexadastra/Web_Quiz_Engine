package engine.quiz;

import engine.quiz.Quiz;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizRepository extends CrudRepository<Quiz, Integer> {
    List<Quiz> findAll();
}