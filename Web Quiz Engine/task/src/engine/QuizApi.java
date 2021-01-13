package engine;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class QuizApi {
    final QuizRepository quizRepository;
    final Result correctResult, wrongResult;

    QuizApi(QuizRepository quizRepository){
        correctResult = new RightResult("Congratulations, you're right!");
        wrongResult = new WrongResult("Wrong answer! Please, try again.");
        this.quizRepository = quizRepository;
    }

    // just a bit of courtesy for the engine
    @GetMapping(path = "/hello_api")
    public String hello () {
        return "hello, user!";
    }

    @PostMapping(path = "/quizzes")
    public Quiz createQuiz(@RequestBody Quiz newQuiz) {
        newQuiz.setId(quizRepository.count() + 1);
        return quizRepository.save(newQuiz);
    }

    @GetMapping(path = "/quizzes/{id}")
    public ResponseEntity<Quiz> getQuiz(@PathVariable Integer id) throws ResourceNotFoundException {
        Quiz quiz = quizRepository.findById(id - 1)
                .orElseThrow(() -> new ResourceNotFoundException("Quiz not found"));
        return ResponseEntity.ok().body(quiz);
    }

    @GetMapping(path = "/quizzes")
    public List<Quiz> getAllQuizzes() {
        List<Quiz> quizzes = new ArrayList<>();
        quizRepository.findAll().forEach(quizzes::add);
        return quizzes;
    }

    @PostMapping(path = "/quizzes/{id}/solve", params = "answer")
    public Result checkAnswerWithString(@PathVariable Integer id, @RequestParam ArrayList<Integer> answer) throws ResourceNotFoundException {
        Quiz quiz = getQuiz(id).getBody();
        return quiz.isCorrect(new ArrayList<Integer>(answer)) ? correctResult : wrongResult;
    }

    @PostMapping(path = "/quizzes/{id}/solve", consumes = "application/json")
    public Result checkAnswer(@PathVariable Integer id, @RequestBody Answer answer) throws ResourceNotFoundException {
        final Quiz quiz = getQuiz(id).getBody();
        return quiz.isCorrect(answer.getAnswer()) ? correctResult : wrongResult;
    }
}

/*
{
  "title": "Coffee drinks",
  "text": "Select only coffee drinks.",
  "options": ["Americano","Tea","Cappuccino","Sprite"],
  "answer": [0,2]
}

{
  "answer": [0, 2]
}
 */