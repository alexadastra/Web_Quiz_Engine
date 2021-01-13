package engine.quiz;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuizDBService implements QuizService{
    final
    QuizRepository quizRepository_;
    private static final String NOT_FOUND_MESSAGE = "No such quiz";

    public QuizDBService(QuizRepository quizRepository_) {
        this.quizRepository_ = quizRepository_;
    }

    public Quiz add(Quiz quiz) {
        return quizRepository_.save(quiz);
    }

    public Quiz get(Integer id) {
        if (quizRepository_.findById(id).isPresent()) {
            return quizRepository_.findById(id).get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    NOT_FOUND_MESSAGE);
        }
    }

    public List<Quiz> getAll() {
        return new ArrayList<>(quizRepository_.findAll());
    }

    public Integer size() {
        return (int) quizRepository_.count();
    }

    public void delete(Quiz quiz) {
        quizRepository_.delete(quiz);
    }
}