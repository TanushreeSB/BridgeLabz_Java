import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserValidatorTest {

    UserValidator validator = new UserValidator();

    // Happy Test Case
    @Test
    void givenValidFirstName_ShouldReturnTrue() {
        assertTrue(validator.validateFirstName("John"));
    }

    // Sad Test Case
    @Test
    void givenInvalidFirstName_ShouldReturnFalse() {
        assertFalse(validator.validateFirstName("jo"));
    }
}