public class UserValidator {

    public boolean validateFirstName(String firstName) {
        String regex = "^[A-Z][a-zA-Z]{2,}$";
        return firstName.matches(regex);
    }


    public boolean validateLastName(String lastName) {
        String regex = "^[A-Z][a-zA-Z]{2,}$";
        return lastName.matches(regex);
    }
}