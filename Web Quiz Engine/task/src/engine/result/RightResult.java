package engine.result;

// classes for wright and wrong answers, so we are able to create
// a singleton for each of them and store as beans
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
