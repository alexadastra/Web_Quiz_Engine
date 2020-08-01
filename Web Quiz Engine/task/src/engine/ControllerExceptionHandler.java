package engine;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import static org.springframework.http.HttpStatus.NOT_FOUND;

import java.util.HashMap;

@RestControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(IndexOutOfBoundsException.class)
    public HashMap<String, String> handleIndexOutOfBoundsException(Exception err) {
        HashMap<String, String> response = new HashMap<String, String>();
        response.put("message", "Information not found");
        response.put("error", err.getClass().getSimpleName());
        return response;
    }
}

/*
        try {
            return quizArray.get(id - 1);
        } catch (IndexOutOfBoundsException err) {
            throw new ResponseStatusException(NOT_FOUND, "Unable to find resource");
        }
 */