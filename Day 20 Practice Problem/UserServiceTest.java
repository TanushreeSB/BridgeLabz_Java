package BridgeLabz_Java.Day 20 Practice Problem;

public class UserServiceTest.java {
    @Test
    void testNullUser() {

        Exception exception = assertThrows(
                InvalidUserException.class,
                () -> userService.registerUser(null)
        );

        assertEquals("User cannot be null", exception.getMessage());
    }

    @Test
    void testEmailMissingAtSymbol() {

        User user = new User("John", "gmail.com", 22);

        Exception exception = assertThrows(
                InvalidUserException.class,
                () -> userService.registerUser(user)
        );

        assertEquals("Invalid email format", exception.getMessage());
    }

    @Test
    void testExactAge18() {

        User user = new User("John", "john@gmail.com", 18);

        String result = userService.registerUser(user);

        assertEquals("User registered successfully", result);
    }
}
