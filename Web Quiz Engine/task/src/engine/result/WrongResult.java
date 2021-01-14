package engine.result;

public class WrongResult extends Result {
    public WrongResult(boolean success, String feedback) {
        this.success = false;
        this.feedback = feedback;
    }

    public WrongResult(String feedback) {
        this.success = false;
        this.feedback = feedback;
    }
}