package Managers;
import Products.Item;
import Products.Menu;

import java.util.Map;


public class MenuManager {
    private static Menu menu = new Menu();
    public MenuManager() {
    }
    public static Map<Integer, Item> getSysItems() {
        return menu.getMenuItems();
    }
    public static void viewMenu() {
        Map<Integer, Item> menuItems = menu.getMenuItems();
        System.out.println("\nToffee's Menu:");
        for (Map.Entry<Integer, Item> entry : menuItems.entrySet()) {
            int id = entry.getKey(); //Return Item ID
            Item item = entry.getValue(); //Return Item Object
            String itemName = item.getName();
            System.out.println("ID: " + id + ", Item: " + itemName);
        }
        System.out.println();

    }
}
