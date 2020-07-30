package engine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
class QuizApi {
    Quiz currentQuiz;
    Answer correctAnswer;
    Answer wrongAnswer;
    QuizApi() {
        correctAnswer = new Answer(true,
                "Congratulations, you're right!");
        wrongAnswer = new Answer(false,
                "Wrong answer! Please, try again.");

        ArrayList<String> array = new ArrayList<String>();
        array.add("Robot");
        array.add("Tea leaf");
        array.add("Cup of coffee");
        array.add("Bug");
        currentQuiz = new Quiz("The Java Logo",
                "What is depicted on the Java logo?", array, 2);
    }

    @GetMapping(path = "/api/hello_api")
    public String hello () {
        return "hello, user!";
    }

    @GetMapping(path = "/api/quiz")
    public Quiz getQuiz() {
        return currentQuiz;
    }

    @PostMapping(path = "api/quiz/answer={answ}")
    public Answer checkAnswer(@PathVariable Integer answ) {
        return currentQuiz.isCorrect(answ) ? correctAnswer : wrongAnswer;
    }
}

@SpringBootApplication
public class WebQuizEngine {

    public static void main(String[] args) {
        SpringApplication.run(WebQuizEngine.class, args);
    }

}
