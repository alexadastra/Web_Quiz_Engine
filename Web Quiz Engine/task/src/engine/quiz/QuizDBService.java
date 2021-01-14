package engine.quiz;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuizDBService {
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

    //public List<Quiz> getAll() {
      //   return new ArrayList<>(quizRepository_.findAll());
    //}

    public Page<Quiz> getAll(Pageable paging) {
        return quizRepository_.findAll(paging);
    }
   /*
    public List<Quiz> getAll(Integer pageNo)
    {
        Pageable paging = PageRequest.of(pageNo, 10);

        Page<Quiz> pagedResult = quizRepository_.findAll(paging);

        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Quiz>();
        }
    }
    */

    public Integer size() {
        return (int) quizRepository_.count();
    }

    public void delete(Quiz quiz) {
        quizRepository_.delete(quiz);
    }
}