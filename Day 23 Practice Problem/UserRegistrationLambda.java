import java.util.regex.Pattern;

@FunctionalInterface
interface Validate {
    boolean check(String input);
}

public class UserRegistrationLambda {

    Validate firstName = name -> Pattern.matches("^[A-Z][a-z]{2,}$", name);

    Validate lastName = name -> Pattern.matches("^[A-Z][a-z]{2,}$", name);

    Validate email = mail -> Pattern.matches(
            "^[a-zA-Z0-9]+([._+-][a-zA-Z0-9]+)?@[a-zA-Z0-9]+\\.[a-z]{2,}(\\.[a-z]{2,})?$",
            mail);

    Validate mobile = mob -> Pattern.matches("^[0-9]{2} [0-9]{10}$", mob);

    Validate password = pass -> Pattern.matches(
            "^(?=.*[A-Z])(?=.*[0-9])(?=[^@#$%^&*]*[@#$%^&*][^@#$%^&*]*$).{8,}$",
            pass);
}