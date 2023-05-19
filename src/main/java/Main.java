import Managers.*;
import Ordering.ShoppingCart;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static UsersManager usersManager = new UsersManager();
    private static CartManager cartManager = new CartManager();

    public static void showMenu() {
        System.out.println();
        if (usersManager.getUser() == null) { // For not-registered users
            System.out.println("Please choose the option you would like to do:");
            System.out.println("1. Register a new user");
            System.out.println("2. Log in");
            System.out.println("3. View Menu");
            System.out.println("4. Exit");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    usersManager.addUser();
                    break;
                case 2:
                    usersManager.verifyLogIn();
                    break;
                case 3:
                    MenuManager.viewMenu();
                    break;
                default:
                    System.exit(0);
            }
        } else { // For registered users
            System.out.println("Please choose the option you would like to do:");
            System.out.println("1. View Menu");
            System.out.println("2. View shopping cart");
            System.out.println("3. Logout");
            System.out.println("4. Exit");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    MenuManager.viewMenu();
                    break;
                case 2:
                    ShoppingCart cart = new ShoppingCart();
                    MenuManager.viewMenu();
                    cartManager.dealingWithCart(cart);
                    break;
                case 3:
                    usersManager.logout();
                    System.out.println("Logged out successfully.");
                    break;
                default:
                    System.exit(0);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Toffee Shop..");
        UsersManager userManager = new UsersManager();

        while (true) {
            showMenu();
        }
    }
}
