import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserValidatorTestUC10 {

    UserValidator validator = new UserValidator();

    @Test
    void givenValidFirstName_ShouldReturnTrue() {
        assertTrue(validator.validateFirstName("John"));
    }

    @Test
    void givenInvalidFirstName_ShouldReturnFalse() {
        assertFalse(validator.validateFirstName("jo"));
    }

    @Test
    void givenValidLastName_ShouldReturnTrue() {
        assertTrue(validator.validateLastName("Smith"));
    }

    @Test
    void givenInvalidLastName_ShouldReturnFalse() {
        assertFalse(validator.validateLastName("sm"));
    }

    @Test
    void givenValidEmail_ShouldReturnTrue() {
        assertTrue(validator.validateEmail("abc.xyz@bl.co.in"));
    }

    @Test
    void givenInvalidEmail_ShouldReturnFalse() {
        assertFalse(validator.validateEmail("abc@.com"));
    }

    @Test
    void givenValidMobile_ShouldReturnTrue() {
        assertTrue(validator.validateMobile("91 9919819801"));
    }

    @Test
    void givenInvalidMobile_ShouldReturnFalse() {
        assertFalse(validator.validateMobile("919919819801"));
    }

    @Test
    void givenValidPasswordLength_ShouldReturnTrue() {
        assertTrue(validator.validatePasswordRule1("password"));
    }

    @Test
    void givenInvalidPasswordLength_ShouldReturnFalse() {
        assertFalse(validator.validatePasswordRule1("pass"));
    }

    @Test
    void givenPasswordWithUppercase_ShouldReturnTrue() {
        assertTrue(validator.validatePasswordRule2("Password"));
    }

    @Test
    void givenPasswordWithoutUppercase_ShouldReturnFalse() {
        assertFalse(validator.validatePasswordRule2("password"));
    }

    @Test
    void givenPasswordWithNumber_ShouldReturnTrue() {
        assertTrue(validator.validatePasswordRule3("Password1"));
    }

    @Test
    void givenPasswordWithoutNumber_ShouldReturnFalse() {
        assertFalse(validator.validatePasswordRule3("Password"));
    }
    
    @Test
    void givenPasswordWithOneSpecialChar_ShouldReturnTrue() {
        assertTrue(validator.validatePasswordRule4("Pass@123"));
    }

    @Test
    void givenPasswordWithMultipleSpecialChars_ShouldReturnFalse() {
        assertFalse(validator.validatePasswordRule4("Pass@@123"));
    }
}