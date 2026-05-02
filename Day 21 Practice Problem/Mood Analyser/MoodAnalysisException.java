public class MoodAnalysisException extends Exception {

    public MoodType type;

    public MoodAnalysisException(MoodType type, String message) {
        super(message);
        this.type = type;
    }
}