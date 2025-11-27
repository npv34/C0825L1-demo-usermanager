package src.validate;

public class UserValidator {
    public static boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber.matches("0+[0-9]{9}");
    }

    public static boolean isValidGmail(String email) {
        return email.matches("^[A-Za-z0-9._]+@gmail\\.com$");
    }
}
