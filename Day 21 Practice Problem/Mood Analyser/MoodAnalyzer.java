public class MoodAnalyzer {

    private String message;

    // Default constructor
    public MoodAnalyzer() {
    }

    // Parameterized constructor
    public MoodAnalyzer(String message) {
        this.message = message;
    }

    // Analyse mood
    public String analyseMood() {
        if (message == null) {
            return "HAPPY";
        }
        if (message.toLowerCase().contains("sad")) {
            return "SAD";
        } else {
            return "HAPPY";
        }
    }
}