package Managers;

import Ordering.ShoppingCart;
import Products.Item;

import java.util.Map;
import java.util.Scanner;


public class CartManager {
    private static int LOOSE_MAX = 10, PACKAGE_MAX = 50;
    private ShoppingCart userCart = new ShoppingCart();
    private OrdersManager orderManager;
    MenuManager menuController = new MenuManager();
    Map<Integer, Item> menuItems = menuController.getSysItems();

    public void addItemToCart() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the item's ID in the Displayed MENU:");
        int ID = sc.nextInt();
        System.out.println("Enter the quantity you would like to add:");
        int quantity = sc.nextInt();
        int oldQuantity = 0, maxQuantity;
        if (menuItems.get(ID).isLoose() == true) {
            maxQuantity = LOOSE_MAX;
        } else {
            maxQuantity = PACKAGE_MAX;
        }
        if (userCart.getItems().containsKey(menuItems.get(ID)))
            oldQuantity = userCart.getItems().get(menuItems.get(ID));

        if (quantity < 0) {
            System.out.println("Invalid quantity, please enter correct quantity.");
            return;
        }
        if (quantity + oldQuantity > maxQuantity) {
            userCart.addItemtoSC(menuItems.get(ID), maxQuantity - oldQuantity);
            userCart.setCartPrice(userCart.getCartPrice() + menuItems.get(ID).getPrice() * (maxQuantity));
            System.out.println("The maximum quantity allowed for this product is: " + maxQuantity + ", your cart is now max");
            return;
        }
        userCart.addItemtoSC(menuItems.get(ID), quantity);
        userCart.setCartPrice(userCart.getCartPrice() + menuItems.get(ID).getPrice() * quantity);
        displayCart();
    }

    public void removeItemFromCart() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the ID of the item you want to remove: ");
        int ID = input.nextInt();
        if (userCart.getItems().containsKey(menuItems.get(ID))) {
            userCart.setCartPrice(userCart.getCartPrice() - menuItems.get(ID).getPrice() * userCart.getItems().get(menuItems.get(ID)));
            userCart.getItems().remove(menuItems.get(ID));
            System.out.println("Removed " + menuItems.get(ID).getName() + " from cart.");
            displayCart();
        } else {
            System.out.println("Item not found in cart.");
        }
    }

    public Map<Item, Integer> getCartItems() {
        return userCart.getItems();
    }

    public void displayCart() {
        System.out.println("--------------------------------------------------------");
        System.out.println("| Index | Name               | Quantity | Price        |");
        System.out.println("--------------------------------------------------------");
        int index = 1;
        for (Map.Entry item : getCartItems().entrySet()) {
            String name = ((Item) item.getKey()).getName();
            int quantity = ((Integer) item.getValue());
            double price = ((Item) item.getKey()).getPrice();
            System.out.printf("| %5d | %-18s | %8d | $%10.2f |\n", index++, name, quantity, price * quantity);
        }
        System.out.println("--------------------------------------------------------");
        System.out.println("Total: " + userCart.getCartPrice());
    }

    public void dealingWithCart(ShoppingCart userCart) {
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Add item to cart\n2. Remove item from cart\n3. Place Order\n4. Back to main menu\n5. Exit");
        int option = sc.nextInt();
        switch (option) {
            case 1:
                addItemToCart();
                break;
            case 2:
                removeItemFromCart();
                break;
            case 3:
                placeOrder();
                break;
            case 4:
                break;
            default:
                System.exit(0);
        }
    }

    public void placeOrder() {
        orderManager.addOrder(userCart);
        System.out.println("Order placed.");
        orderManager.viewOrder();
        displayCart();

    }


}