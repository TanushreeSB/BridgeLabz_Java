public class UserRegistration {

    public boolean validateFirstName(String firstName)
            throws UserRegistrationException {

        String regex = "^[A-Z][a-z]{2,}$";

        if (Pattern.matches(regex, firstName)) {
            return true;
        } else {
            throw new UserRegistrationException("Invalid First Name");
        }
    }
}