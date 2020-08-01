package engine;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;

public class Quiz {
    String title;
    String text;
    ArrayList<String> options;
    @JsonIgnore
    ArrayList<Integer> answer;
    Integer id;

    public Quiz() { }

    public Quiz(String title, String text, ArrayList<String> options, ArrayList<Integer> answer) {
        this.title = title;
        this.text = text;
        this.options = options;
        this.answer = answer;
    }

    // standart setters and getters
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) { this.title = title; }

    public String getText() {
        return text;
    }
    public void setText(String Text) { this.text = text; }

    public ArrayList<String> getOptions() {
        return options;
    }
    public void setOptions(ArrayList<String> options) { this.options = options; }

    public ArrayList<Integer> getAnswer() { return answer; }
    public void setAnswer(ArrayList<Integer> answer) { this.answer = answer; }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    // cheking if passed integer is correct answer
    boolean isCorrect(ArrayList<Integer> index) {
        return index.equals(this.answer);
    }
}
