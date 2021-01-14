package engine.quiz;

import engine.result.Result;
import engine.result.RightResult;
import engine.result.WrongResult;
import engine.user.User;
import engine.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("api")
public class QuizController {

    @Autowired
    QuizDBService quizService;
    @Autowired
    UserService userService;

    @GetMapping(path = "/hello_api")
    public String hello () {
        return "hello, user!";
    }

    @PostMapping("/quizzes")
    public Quiz addQuiz(@RequestBody @Valid Quiz newQuiz) {
        User user = getCurrentUser();
        newQuiz.setUser(user);
        quizService.add(newQuiz);

        return newQuiz.clone();
    }

    @GetMapping("/quizzes/{id}")
    public Quiz getQuiz(@PathVariable int id) throws ResponseStatusException {
        if (id > 0 && id <= quizService.size()) {
            return quizService.get(id);
        }
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "entity " + id + " not found"
        );
    }

    @GetMapping("/quizzes")
    public ResponseEntity<Page<Quiz>> getAllQuizzes() {
        Pageable paging = PageRequest.of(0, 10);

        Page<Quiz> pagedResult = quizService.getAll(paging);
        return new ResponseEntity<Page<Quiz>>(pagedResult, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/quizzes?page={n}")
    public ResponseEntity<Page<Quiz>> getAllQuizzes(@PathVariable int n) {
        Pageable paging = PageRequest.of(n, 10);

        Page<Quiz> pagedResult = quizService.getAll(paging);
        return new ResponseEntity<Page<Quiz>>(pagedResult, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping(value = "/quizzes/{id}/solve")
    public Result solveQuiz(@PathVariable @Min(1) int id, @RequestBody @NotNull Answer answer)
            throws ResponseStatusException {

        Quiz quiz = getQuiz(id);
        return quiz.getAnswer().toString().equals(answer.getAnswer().toString()) ?
                new RightResult("Congratulations, you're right!") :
                new WrongResult("Wrong answer! Please, try again.");
    }

    @PutMapping("/quizzes/{id}")
    public ResponseEntity<Quiz> updateQuiz(@PathVariable(value = "id") int id,
                                           @Valid @RequestBody Quiz quizDetails)
            throws ResponseStatusException {
        Quiz quiz = quizService.get(id);
        checkUserQuiz(quiz);

        quiz.setId(quizDetails.getId());
        quiz.setAnswer(quizDetails.getAnswer());
        quiz.setOptions(quizDetails.getOptions());
        quiz.setText(quizDetails.getText());
        quiz.setTitle(quizDetails.getTitle());

        final Quiz updatedQuiz = quizService.add(quiz);
        return ResponseEntity.ok(updatedQuiz);
    }

    @DeleteMapping("/quizzes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteQuizByID(@PathVariable int id) throws ResponseStatusException {
        Quiz quiz = getQuiz(id);
        checkUserQuiz(quiz);
        quizService.delete(quiz);
    }

    private void checkUserQuiz(Quiz quiz) {
        User user = getCurrentUser();
        User quizUser = quiz.getUser();
        if (quizUser.getId() != user.getId()) {
            throw new ResponseStatusException(
                    HttpStatus.FORBIDDEN, "Quiz does not belong to the current user!"
            );
        }
    }

    private User getCurrentUser() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        return userService.getByEmail(email);
    }
}