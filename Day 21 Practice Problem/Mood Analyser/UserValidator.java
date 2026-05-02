public class UserValidator {

    public boolean validateFirstName(String firstName) {
        String regex = "^[A-Z][a-zA-Z]{2,}$";
        return firstName.matches(regex);
    }


    public boolean validateLastName(String lastName) {
        String regex = "^[A-Z][a-zA-Z]{2,}$";
        return lastName.matches(regex);
    }

    public boolean validateEmail(String email) {
        String regex = "^[a-zA-Z0-9]+(\\.[a-zA-Z0-9]+)?@[a-zA-Z]+\\.[a-z]{2,}(\\.[a-z]{2})?$";
        return email.matches(regex);
    }

    public boolean validateMobile(String mobile) {
        String regex = "^[0-9]{2}\\s[0-9]{10}$";
        return mobile.matches(regex);
    }

    public boolean validatePasswordRule1(String password) {
        String regex = "^.{8,}$";
        return password.matches(regex);
    }

    public boolean validatePasswordRule2(String password) {
        String regex = "^(?=.*[A-Z]).{8,}$";
        return password.matches(regex);
    }

    public boolean validatePasswordRule3(String password) {
        String regex = "^(?=.*[A-Z])(?=.*[0-9]).{8,}$";
        return password.matches(regex);
    }

    public boolean validatePasswordRule4(String password) {
        String regex = "^(?=.*[A-Z])(?=.*[0-9])(?=[^@#$%^&+=]*[@#$%^&+=][^@#$%^&+=]*$).{8,}$";
        return password.matches(regex);
    }

    // Happy Test Cases
    @Test
    void givenMultipleValidEmails_ShouldReturnTrue() {
        assertTrue(validator.validateEmail("abc@bl.co"));
        assertTrue(validator.validateEmail("abc.xyz@bl.co.in"));
        assertTrue(validator.validateEmail("abc123@bl.co"));
    }

    // Sad Test Cases
    @Test
    void givenMultipleInvalidEmails_ShouldReturnFalse() {
        assertFalse(validator.validateEmail("abc@.com"));     // missing domain
        assertFalse(validator.validateEmail("abc@bl"));        // missing .com
        assertFalse(validator.validateEmail("abc.bl.co.in"));  // missing @
        assertFalse(validator.validateEmail("@bl.co.in"));     // missing username
    }

    

}