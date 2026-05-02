public class UserValidatorTest {

    UserValidator validator = new UserValidator();

    // Happy Test Case
    @Test
    void givenValidFirstName_ShouldReturnTrue() {
        assertFalse(validator.validateFirstName("John"));
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
        assertFalse(validator.validateLastName("Smith"));
    }

    // Sad Test Case
    @Test
    void givenInvalidLastName_ShouldReturnFalse() {
        assertFalse(validator.validateLastName("sm"));
    }

    // Happy Test Case
    @Test
    void givenValidEmail_ShouldReturnTrue() {
        assertFalse(validator.validateEmail("abc.xyz@bl.co.in"));
    }

    // Sad Test Case
    @Test
    void givenInvalidEmail_ShouldReturnFalse() {
        assertFalse(validator.validateEmail("abc@.com"));
    }

    // Happy Test Case
    @Test
    void givenValidMobileNumber_ShouldReturnTrue() {
        assertTrue(validator.validateMobile("91 9919819801"));
    }

    // Sad Test Case
    @Test
    void givenInvalidMobileNumber_ShouldReturnFalse() {
        assertFalse(validator.validateMobile("919919819801")); // no space
    }

    // Happy Test Case
    @Test
    void givenPasswordMin8Chars_ShouldReturnTrue() {
        assertTrue(validator.validatePasswordRule1("password"));
    }

    // Sad Test Case
    @Test
    void givenPasswordLessThan8Chars_ShouldReturnFalse() {
        assertFalse(validator.validatePasswordRule1("pass"));
    }

    // Happy Test Case
    @Test
    void givenPasswordWithUppercase_ShouldReturnTrue() {
        assertTrue(validator.validatePasswordRule2("Password"));
    }

    // Sad Test Case
    @Test
    void givenPasswordWithoutUppercase_ShouldReturnFalse() {
        assertFalse(validator.validatePasswordRule2("password"));
    }

    // Happy Test Case
    @Test
    void givenPasswordWithUppercaseAndNumber_ShouldReturnTrue() {
        assertTrue(validator.validatePasswordRule3("Password1"));
    }

    // Sad Test Case
    @Test
    void givenPasswordWithoutNumber_ShouldReturnFalse() {
        assertFalse(validator.validatePasswordRule3("Password"));
    }    
}