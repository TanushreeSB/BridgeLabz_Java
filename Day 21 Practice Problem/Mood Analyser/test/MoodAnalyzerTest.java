import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MoodAnalyzerTest {

    // UC1 - Sad Mood
    @Test
    void givenSadMood_ShouldReturnSAD() {
        MoodAnalyzer mood = new MoodAnalyzer("I am in Sad Mood");
        assertEquals("SAD", mood.analyseMood());
    }

    // UC2 - Any Mood
    @Test
    void givenAnyMood_ShouldReturnHAPPY() {
        MoodAnalyzer mood = new MoodAnalyzer("I am in Any Mood");
        assertEquals("HAPPY", mood.analyseMood());
    }

    // Refactor test - constructor usage
    @Test
    void givenHappyMoodInConstructor_ShouldReturnHAPPY() {
        MoodAnalyzer mood = new MoodAnalyzer("I am in Happy Mood");
        assertEquals("HAPPY", mood.analyseMood());
    }
}