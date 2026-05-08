import java.util.regex.Pattern;

public class UserRegistration {

    public boolean validateFirstName(String firstName) {
        String regex = "^[A-Z][a-z]{2,}$";
        return Pattern.matches(regex, firstName);
    }

    
}