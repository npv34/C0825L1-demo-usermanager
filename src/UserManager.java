package src;

import src.entites.User;
import src.exceptions.UserNotFoundException;
import src.validate.UserValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class UserManager implements Manager {
    private List<User> users;
    private Scanner scanner = new Scanner(System.in);

    public UserManager() {
        this.users = new ArrayList<>();
        initializeData();
    }

    public void initializeData() {
        users.add(new User("1","0123456789", "nam@gmail.com"));
        users.add(new User("2","0987654321", "quan@gmail.com"));
        users.add(new User("3","0982233445", "hoang@gmail.com"));
    }

    public void add() {
        String phoneNumber;
        String email;

        while (true) {
            System.out.println("Enter phone number:");
            phoneNumber = scanner.nextLine();
            if (!UserValidator.isValidPhoneNumber(phoneNumber)) {
                System.out.println("Invalid phone number. It must start with '0' followed by 9 digits.");
                continue;
            }
            // check phone number not exist
            break;
        }

        while (true) {
            System.out.println("Enter email address:");
            email = scanner.nextLine();
            if (!UserValidator.isValidGmail(email)) {
                System.out.println("Invalid email address. It must be a valid Gmail address.");
                continue;
            }
            // check email not exist
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
        System.out.println("Choose delete method: ");
        System.out.println("1. Delete by phone number:");
        System.out.println("2. Delete by email:");
        int choice = Integer.parseInt(scanner.nextLine());
        User userSearched = null;
        if (choice == 1) {
            System.out.println("Enter phone number to search:");
            String phone = scanner.nextLine();
            try {
                userSearched = findUserByPhoneNumber(phone);
                users.remove(userSearched);
            }catch (UserNotFoundException e){
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public void update() {
        System.out.println("Choose update method: ");
        System.out.println("1. Update by phone number:");
        System.out.println("2. Update by email:");
        int choice = Integer.parseInt(scanner.nextLine());
        User userUpdate = null;
        if (choice == 1) {
            System.out.println("Enter phone number to search:");
            String phone = scanner.nextLine();
            try {
                userUpdate = findUserByPhoneNumber(phone);
                System.out.println("----- Updating User -----");
                System.out.println("Enter new phone number:");
                String newPhone = scanner.nextLine();
                // check valid phone number
                // check newphone not exist
                System.out.println("Enter new email:");
                String newEmail = scanner.nextLine();
                userUpdate.setPhoneNumber(newPhone);
                userUpdate.setEmail(newEmail);
                System.out.println("User updated successfully!");
            }catch (UserNotFoundException e){
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public void search() {
        System.out.println("Choose search method: ");
        System.out.println("1. Search by phone number:");
        System.out.println("2. Search by email:");
        int choice = Integer.parseInt(scanner.nextLine());
        User userSearched = null;
        if (choice == 1){
            System.out.println("Enter phone number to search:");
            String phone = scanner.nextLine();
            try {
                userSearched = findUserByPhoneNumber(phone);
                System.out.println(userSearched);
            }catch (UserNotFoundException e){
                System.out.println(e.getMessage());
            }
        }

    }

    @Override
    public User findUserByPhoneNumber(String phone) throws UserNotFoundException {
        User userSearched = null;
        for (User u: users){
            if (u.getPhoneNumber().equals(phone)){
                userSearched = u;
                break;
            }
        }
        if (userSearched == null) {
            throw new UserNotFoundException("User with phone number " + phone + " not found.");
        }

        return userSearched;
    }

    @Override
    public void saveDataToFile() {

    }
}
