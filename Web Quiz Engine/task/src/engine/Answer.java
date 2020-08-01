package engine;

import java.util.ArrayList;

public class Answer {
    protected ArrayList<Integer> answer;

    public Answer() { }

    public Answer(ArrayList<Integer> answers) {
        this.answer = answers;
    }

    public ArrayList<Integer> getAnswer() {
        return this.answer;
    }

    public void setAnswer(ArrayList<Integer> answers) {
        this.answer = answers;
    }
}
