package engine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
class QuizApi {
    ArrayList<Quiz> quizArray;
    Answer correctAnswer, wrongAnswer;
    QuizApi() {
        quizArray = new ArrayList<Quiz>();
        correctAnswer = new RightAnswer("Congratulations, you're right!");
        wrongAnswer = new WrongAnswer("Wrong answer! Please, try again.");
    }
    // just a bit of courtecy for the engine
    @GetMapping(path = "/api/hello_api")
    public String hello () {
        return "hello, user!";
    }

    @PostMapping(path = "api/quizzes")
    public void createQuiz(@RequestBody Quiz newQuiz) {
        newQuiz.setId(quizArray.size() + 1);
        quizArray.add(newQuiz);
    }

    @GetMapping(path = "/api/quizzes/{id}")
    public Quiz getQuiz(@PathVariable Integer id) {
        try {
            return quizArray.get(id - 1);
        } catch (IndexOutOfBoundsException err) {
            throw new ResponseStatusException(NOT_FOUND, "Unable to find resource");
        }
    }

    @GetMapping(path = "/api/quizzes")
    public ArrayList<Quiz> getAllQuizzes() {
        return quizArray;
    }

    @PostMapping(path = "api/quizzes/{id}/solve/answer={answ}")
    public Answer checkAnswer(@PathVariable Integer id, Integer answ) {
        return quizArray.get(id).isCorrect(answ) ? correctAnswer : wrongAnswer;
    }

    @PostMapping(path = "api/quizzes/{id}/solve")
    public Answer checkAnswer(@PathVariable Integer id, @RequestBody String answ) {
        Quiz quiz = getQuiz(id);
        Integer answer = Integer.parseInt(answ.substring("answer=".length()));
        return quiz.isCorrect(answer) ? correctAnswer : wrongAnswer;
    }
}

@SpringBootApplication
public class WebQuizEngine {

    public static void main(String[] args) {
        SpringApplication.run(WebQuizEngine.class, args);
    }

}

/*
        ArrayList<String> array = new ArrayList<String>();
        array.add("Robot");
        array.add("Tea leaf");
        array.add("Cup of coffee");
        array.add("Bug");
        currentQuiz = new Quiz("The Java Logo",
                "What is depicted on the Java logo?", array, 2);
 */
