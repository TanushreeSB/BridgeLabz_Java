import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class UserValidatorTest {

    UserValidator validator = new UserValidator();

    // =========================
    // First Name
    // =========================

    @Test
    void givenValidFirstName_ShouldReturnTrue() throws Exception {
        assertTrue(validator.validateFirstName("John"));
    }

    @Test
    void givenInvalidFirstName_ShouldThrowException() {
        assertThrows(UserRegistrationException.class, () -> {
            validator.validateFirstName("jo");
        });
    }

    // =========================
    // Last Name
    // =========================

    @Test
    void givenValidLastName_ShouldReturnTrue() throws Exception {
        assertTrue(validator.validateLastName("Smith"));
    }

    @Test
    void givenInvalidLastName_ShouldThrowException() {
        assertThrows(UserRegistrationException.class, () -> {
            validator.validateLastName("sm");
        });
    }

    // =========================
    // Email - Parameterized
    // =========================

    @ParameterizedTest
    @ValueSource(strings = {
        "abc@yahoo.com",
        "abc.xyz@bl.co.in",
        "user.name@domain.co"
    })
    void givenValidEmails_ShouldReturnTrue(String email) throws Exception {
        assertTrue(validator.validateEmail(email));
    }

    @ParameterizedTest
    @ValueSource(strings = {
        "abc@.com",
        "@gmail.com",
        "abc#mail.com"
    })
    void givenInvalidEmails_ShouldThrowException(String email) {
        assertThrows(UserRegistrationException.class, () -> {
            validator.validateEmail(email);
        });
    }

    // =========================
    // Mobile
    // =========================

    @Test
    void givenValidMobile_ShouldReturnTrue() throws Exception {
        assertTrue(validator.validateMobile("91 9919819801"));
    }

    @Test
    void givenInvalidMobile_ShouldThrowException() {
        assertThrows(UserRegistrationException.class, () -> {
            validator.validateMobile("919919819801");
        });
    }

    // =========================
    // Password
    // =========================

    @Test
    void givenValidPassword_ShouldReturnTrue() throws Exception {
        assertTrue(validator.validatePassword("Pass@123"));
    }

    @Test
    void givenInvalidPassword_ShouldThrowException() {
        assertThrows(UserRegistrationException.class, () -> {
            validator.validatePassword("pass");
        });
    }
}