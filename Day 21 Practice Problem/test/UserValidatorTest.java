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

    private void assertFalse(boolean validateFirstName) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'assertFalse'");
    }

    // Happy Test Case
    @Test
    void givenValidLastName_ShouldReturnTrue() {
        assertTrue(validator.validateLastName("Smith"));
    }

    // Sad Test Case
    @Test
    void givenInvalidLastName_ShouldReturnFalse() {
        assertFalse(validator.validateLastName("sm"));
    }
}