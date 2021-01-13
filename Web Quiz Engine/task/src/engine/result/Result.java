package engine.result;

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

