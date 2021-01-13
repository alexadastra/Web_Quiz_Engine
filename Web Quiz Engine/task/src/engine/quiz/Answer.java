package engine.quiz;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/*
public class Answer {

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Integer> answer;

    public Answer() { }

    public List<Integer> getAnswer() {
        return answer;
    }

    public void setAnswer(List<Integer> answer) {
        this.answer = new ArrayList<>(answer);
    }

}

 */

import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.List;

@Validated
public class Answer {
    @NotNull
    private List<Integer> answer;

    public List<Integer> getAnswer() {
        return answer;
    }

    public void setAnswer(List<Integer> answer) {
        this.answer = answer;
    }
}
