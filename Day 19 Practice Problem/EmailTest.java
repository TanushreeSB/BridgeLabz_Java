import java.util.regex.*;

public class EmailTest {

    static String regex = "^(?![.])(?!.*[.]{2})[a-zA-Z0-9]+([._+-][a-zA-Z0-9]+)*@[a-zA-Z0-9]+(\\.[a-zA-Z]{2,}){1,2}$"; // Final Email Validation Regex

    public static void validate(String email) {
        boolean result = Pattern.matches(regex, email);
        System.out.println(email + " -> " + result);
    }

    public static void main(String[] args) {

        // Valid Emails
        validate("abc@yahoo.com");
        validate("abc-100@yahoo.com");
        validate("abc.100@yahoo.com");
        validate("abc111@abc.com");
        validate("abc-100@abc.net");
        validate("abc.100@abc.com.au");
        validate("abc@1.com");
        validate("abc@gmail.com.com");
        validate("abc+100@gmail.com");

        System.out.println("\nInvalid Emails:\n");

        // Invalid Emails
        validate("abc");
        validate("abc@.com.my");
        validate("abc123@gmail.a");
        validate("abc123@.com");
        validate(".abc@abc.com");
        validate("abc()*@gmail.com");
        validate("abc@%*.com");
        validate("abc..2002@gmail.com");
        validate("abc.@gmail.com");
        validate("abc@abc@gmail.com");
        validate("abc@gmail.com.1a");
        validate("abc@gmail.com.aa.au");
    }
}