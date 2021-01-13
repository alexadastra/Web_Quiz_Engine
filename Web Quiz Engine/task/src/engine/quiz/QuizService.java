package engine.quiz;

import engine.quiz.Quiz;

import java.util.List;

public interface QuizService {
    Quiz add(Quiz quiz);

    Quiz get(Integer id);

    List<Quiz> getAll();

    Integer size();

    void delete(Quiz quiz);
}
