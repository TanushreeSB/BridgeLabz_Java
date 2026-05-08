import java.util.regex.Pattern;

public class UserRegistration {

    public boolean validateFirstName(String firstName) {
        String regex = "^[A-Z][a-z]{2,}$";
        return Pattern.matches(regex, firstName);
    }

     public boolean validateLastName(String lastName) {
        String regex = "^[A-Z][a-z]{2,}$";
        return Pattern.matches(regex, lastName);
    }

     public boolean validateEmail(String email) {
        String regex = "^[a-zA-Z0-9]+([._+-][a-zA-Z0-9]+)?@[a-zA-Z0-9]+\\.[a-z]{2,}(\\.[a-z]{2,})?$";
        return Pattern.matches(regex, email);
    }

    public boolean validateMobile(String mobile) {
        String regex = "^[0-9]{2} [0-9]{10}$";
        return Pattern.matches(regex, mobile);
    }

    public boolean validatePasswordRule1(String password) {
        String regex = ".{8,}";
        return Pattern.matches(regex, password);
    }

    public boolean validatePasswordRule2(String password) {
        String regex = ".*[A-Z].*";
        return Pattern.matches(regex, password);
    }

    public boolean validatePasswordRule3(String password) {
        String regex = ".*[0-9].*";
        return Pattern.matches(regex, password);
    }

    public boolean validatePasswordRule4(String password) {
        String regex = "^(?=[^@#$%^&*]*[@#$%^&*][^@#$%^&*]*$).*$";
        return Pattern.matches(regex, password);
    }
    
}