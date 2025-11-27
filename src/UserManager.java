package src;

import src.entites.User;
import src.validate.UserValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserManager implements Manager {
    private List<User> users;

    public UserManager() {
        this.users = new ArrayList<>();
    }

    public void add() {
        Scanner scanner = new Scanner(System.in);
        String phoneNumber;
        String email;

        while (true) {
            System.out.println("Enter phone number:");
            phoneNumber = scanner.nextLine();
            if (!UserValidator.isValidPhoneNumber(phoneNumber)) {
                System.out.println("Invalid phone number. It must start with '0' followed by 9 digits.");
                continue;
            }
            break;
        }

        while (true) {
            System.out.println("Enter email address:");
            email = scanner.nextLine();
            if (!UserValidator.isValidGmail(email)) {
                System.out.println("Invalid email address. It must be a valid Gmail address.");
                continue;
            }
            break;
        }

        User user = new User(phoneNumber, email);
        System.out.println("User created successfully!");
        users.add(user);
    }

    public void showList() {
        if (users.isEmpty()) {
            System.out.println("No users to display.");
            return;
        }

        for (User user : users) {
            System.out.println(user);
        }
    }

    @Override
    public void delete() {

    }

    @Override
    public void update() {

    }

    @Override
    public void search() {

    }
}
