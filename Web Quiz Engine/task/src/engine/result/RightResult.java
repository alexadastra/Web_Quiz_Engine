package engine.result;

public class RightResult extends Result {
    public RightResult(boolean success, String feedback) {
        this.success = true;
        this.feedback = feedback;
    }

    public RightResult(String feedback) {
        this.success = true;
        this.feedback = feedback;
    }
}

