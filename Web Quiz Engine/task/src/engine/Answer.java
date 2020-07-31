package engine;

public class Answer{
    protected boolean success;
    protected String feedback;

    public Answer() {}

    public Answer(boolean success, String feedback) {
        this.success = success;
        this.feedback = feedback;
    }

    //standart setters and getters
    public boolean getSuccess() {
        return success;
    }
    public void setSuccess(boolean success) { this.success = success; }

    public String getFeedback() {
        return feedback;
    }
    public void setFeedback(String feedback) { this.feedback = feedback; }
}

// classes for wright and wrong answers, so we are able to create
// a singleton for each of them and store as beans
class RightAnswer extends Answer {
    public RightAnswer(boolean success, String feedback) {
        this.success = true;
        this.feedback = feedback;
    }

    public RightAnswer(String feedback){
        this.success = true;
        this.feedback = feedback;
    }
}

class WrongAnswer extends Answer {
    public WrongAnswer(boolean success, String feedback) {
        this.success = false;
        this.feedback = feedback;
    }

    public WrongAnswer(String feedback){
        this.success = false;
        this.feedback = feedback;
    }
}