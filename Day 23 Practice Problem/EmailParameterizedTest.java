import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class EmailParameterizedTest {

    UserRegistration user = new UserRegistration();

    @ParameterizedTest
    @ValueSource(strings = {
            "abc@yahoo.com",
            "abc-100@yahoo.com",
            "abc.100@yahoo.com",
            "abc111@abc.com",
            "abc.xyz@bl.co.in"
    })
    public void givenMultipleEmails_ShouldReturnTrue(String email) {
        assertTrue(user.validateEmail(email));
    }
}