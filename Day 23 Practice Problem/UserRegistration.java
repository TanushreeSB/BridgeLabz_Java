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

    
}