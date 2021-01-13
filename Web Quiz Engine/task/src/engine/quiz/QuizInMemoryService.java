package engine.quiz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class QuizInMemoryService implements QuizService {
    private final HashMap<Integer, Quiz> quizRepository_;

    QuizInMemoryService(){
        quizRepository_= new HashMap<>();
    }

    public Quiz add(Quiz quiz) {
        quizRepository_.put(quiz.getId(), quiz);
        return quizRepository_.get(quiz.getId());
    }

    public Quiz get(Integer id) {
        return quizRepository_.getOrDefault(id, null);
    }

    public List<Quiz> getAll() {
        return new ArrayList<>(quizRepository_.values());
    }

    public Integer size() {
        return quizRepository_.size();
    }

    public void delete(Quiz quiz) {
        quizRepository_.remove(quiz);
    }
}
