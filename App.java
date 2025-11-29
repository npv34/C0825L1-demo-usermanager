import src.UserManager;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserManager userManager = new UserManager();
        while (true) {
            printMainMenu();
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    userManager.add();
                    break;
                case 2:
                    userManager.showList();
                    break;
                case 3:
                    userManager.search();
                    break;
                case 4:
                    userManager.delete();
                    break;
                case 5:
                    userManager.update();
                    break;
                default:
                    System.out.println("Exiting the program. Goodbye!");
                    System.exit(0);
            }
        }
    }

    private static void printMainMenu() {
        System.out.println("-------------------------------");
        System.out.println("Welcome to the User Management System!");
        System.out.println("1: Add User");
        System.out.println("2: Show Users");
        System.out.println("3: Search User");
        System.out.println("4: Delete User");
        System.out.println("5: Update User");
        System.out.println("0: Exit");

        System.out.println("-------------------------------");
        System.out.println("Please enter your choice: ");
    }
}
