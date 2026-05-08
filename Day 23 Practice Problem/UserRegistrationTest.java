import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserRegistrationTest {

    UserRegistration user = new UserRegistration();

    @Test
    public void givenValidFirstName_ShouldReturnTrue() {
        assertTrue(user.validateFirstName("Tanu"));
    }

    @Test
    public void givenInvalidFirstName_ShouldReturnFalse() {
        assertFalse(user.validateFirstName("ta"));
    }
}