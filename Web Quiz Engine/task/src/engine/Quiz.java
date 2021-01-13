package engine;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jdk.jshell.spi.ExecutionControl;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;

@Entity
public class Quiz {
    @NotEmpty
    protected String title;
    @NotEmpty
    protected String text;
    @Transient
    @NotNull
    @Size(min = 2)
    protected ArrayList<String> options;
    @Id
    protected Long id;

    @Transient
    @JsonProperty( value = "answer", access = JsonProperty.Access.WRITE_ONLY)
    ArrayList<Integer> answer;

    public Quiz() { }

    public Quiz(String title, String text, ArrayList<String> options, ArrayList<Integer> answer) throws ExecutionControl.NotImplementedException {
        if (options == null) {
            throw new ExecutionControl.NotImplementedException("null options!");
        }
        this.title = title;
        this.text = text;
        this.options = options;
        this.answer = answer;
    }

    // standard setters and getters
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) { this.title = title; }

    public String getText() {
        return text;
    }
    public void setText(String text) { this.text = text; }

    public ArrayList<String> getOptions() {
        return options;
    }
    public void setOptions(ArrayList<String> options) { this.options = options; }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public ArrayList<Integer> getAnswer() { return answer; }
    public void setAnswer(ArrayList<Integer> answer) { this.answer = answer; }

    boolean isCorrect(ArrayList<Integer> index) {
        if (index == null){
            if (this.answer == null) {
                return true;
            }
            return this.answer.size() == 0;
        }
        if (this.answer == null) {
            return index.size() == 0;
        }
        return index.equals(this.answer);
    }
}

