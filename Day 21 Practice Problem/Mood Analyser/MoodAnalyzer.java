public class MoodAnalyzer {

    private String message;

    // Default constructor
    public MoodAnalyzer() {
    }

    // Parameterized constructor
    public MoodAnalyzer(String message) {
        this.message = message;
    }

    public String analyseMood() throws MoodAnalysisException {

        if (message == null) {
            throw new MoodAnalysisException(MoodType.NULL, "Mood is NULL");
        }

        if (message.isEmpty()) {
            throw new MoodAnalysisException(MoodType.EMPTY, "Mood is EMPTY");
        }

        if (message.toLowerCase().contains("sad")) {
            return "SAD";
        } else {
            return "HAPPY";
        }
    }
}