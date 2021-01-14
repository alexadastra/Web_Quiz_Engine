package engine.quiz;

import engine.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
/*
@Service
public class QuizCompletedService {
    @Autowired
    QuizCompletedRepository quizCompletedRepository;

    public QuizCompleted add(QuizCompleted quiz) {
        return quizCompletedRepository.save(quiz);
    }

    public Page<QuizCompleted> getByUser(User user, Pageable paging) {
        return quizCompletedRepository.findByUserId(paging);
    }
}


 */