package engine;

public class Result{
    protected boolean success;
    protected String feedback;

    public Result() {}

    public Result(boolean success, String feedback) {
        this.success = success;
        this.feedback = feedback;
    }

    //standard setters and getters
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
class RightResult extends Result {
    public RightResult(boolean success, String feedback) {
        this.success = true;
        this.feedback = feedback;
    }

    public RightResult(String feedback){
        this.success = true;
        this.feedback = feedback;
    }
}

class WrongResult extends Result {
    public WrongResult(boolean success, String feedback) {
        this.success = false;
        this.feedback = feedback;
    }

    public WrongResult(String feedback){
        this.success = false;
        this.feedback = feedback;
    }
}