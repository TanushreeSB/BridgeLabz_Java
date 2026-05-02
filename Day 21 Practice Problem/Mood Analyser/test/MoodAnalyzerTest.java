import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/* */
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

public class MoodAnalyzerTest {

    @Test
    void givenNullMood_ShouldThrowException() {
        MoodAnalyzer mood = new MoodAnalyzer(null);

        Exception exception = assertThrows(MoodAnalysisException.class, () -> {
            mood.analyseMood();
        });

        assertEquals(MoodType.NULL, ((MoodAnalysisException) exception).type);
    }

    @Test
    void givenEmptyMood_ShouldThrowException() {
        MoodAnalyzer mood = new MoodAnalyzer("");

        Exception exception = assertThrows(MoodAnalysisException.class, () -> {
            mood.analyseMood();
        });

        assertEquals(MoodType.EMPTY, ((MoodAnalysisException) exception).type);
    }
}
}