import java.util.regex.*;

public class UserValidation {

    public static boolean validate(String pattern, String input) {
        return Pattern.matches(pattern, input);
    }

    public static void main(String[] args) {

        String firstName = "John";
        String lastName = "Doe";
        String email = "abc.xyz@bl.co.in";
        String mobile = "91 9876543210";
        String password = "Passw0rd!";

        System.out.println("First Name: " + validate("^[A-Z][a-zA-Z]{2,}$", firstName));
        System.out.println("Last Name: " + validate("^[A-Z][a-zA-Z]{2,}$", lastName));
        System.out.println("Email: " + validate("^[a-zA-Z0-9]+([._+-][a-zA-Z0-9]+)?@[a-zA-Z0-9]+\\.[a-zA-Z]{2,}(\\.[a-zA-Z]{2,})?$", email));
        System.out.println("Mobile: " + validate("^[0-9]{2} [0-9]{10}$", mobile));
        System.out.println("Password: " + validate("^(?=.*[A-Z])(?=.*[0-9])(?=[^!@#$%^&*]*[!@#$%^&*][^!@#$%^&*]*$).{8,}$", password));
    }
}