package engine;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
public class QuizApi {
    ArrayList<Quiz> quizArray;
    final Result correctResult, wrongResult;
    QuizApi() {
        quizArray = new ArrayList<Quiz>();
        correctResult = new RightResult("Congratulations, you're right!");
        wrongResult = new WrongResult("Wrong answer! Please, try again.");
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
        return quizArray.get(id - 1);
    }

    @GetMapping(path = "/api/quizzes")
    public ArrayList<Quiz> getAllQuizzes() {
        return quizArray;
    }

    // @PostMapping(path = "api/quizzes/{id}/solve/answer={answ}")
    // public Answer checkAnswer(@PathVariable Integer id, Integer answ) {
    //     return quizArray.get(id).isCorrect(answ) ? correctAnswer : wrongAnswer;
    // }

    @PostMapping(path = "api/quizzes/{id}/solvewithstring")
    public Result checkAnswerWithString(@PathVariable Integer id, @RequestBody String answ) {
        final Quiz quiz = getQuiz(id);
        answ = answ.substring("answer: [".length());
        ArrayList<Integer> answer = new ArrayList<Integer>();
        while (true) {
            if (answ.equals("]")){
                break;
            } else{
                answer.add(Integer.parseInt(answ));
            }
            if (answ.startsWith(",")){
                answ = answ.substring(1);
            }
        }
        return quiz.isCorrect(answer) ? correctResult : wrongResult;
    }

    @PostMapping(path = "api/quizzes/{id}/solve")
    public Result checkAnswer(@PathVariable Integer id, @RequestBody Answer answ) {
        final Quiz quiz = getQuiz(id);
        return quiz.isCorrect(answ.getAnswer()) ? correctResult : wrongResult;
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