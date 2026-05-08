public class EmailSamples {
    public static void main(String[] args) {
        UserRegistration user = new UserRegistration();

        String[] emails = {
                "abc@yahoo.com",
                "abc-100@yahoo.com",
                "abc.100@yahoo.com",
                "abc111@abc.com",
                "abc.xyz@bl.co.in"
        };

        for (String email : emails) {
            System.out.println(email + " -> " + user.validateEmail(email));
        }
    }
}