package engine;

import java.util.ArrayList;

public class Quiz {
    String title;
    String text;
    ArrayList<String> options;
    Integer correctOptionIndex;

    public Quiz() { }

    public Quiz(String title, String text, ArrayList<String> options, Integer index) {
        this.title = title;
        this.text = text;
        this.options = options;
        this.correctOptionIndex = index;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public ArrayList<String> getOptions() {
        return options;
    }

    boolean isCorrect(Integer index) {
        return index == this.correctOptionIndex;
    }
}
