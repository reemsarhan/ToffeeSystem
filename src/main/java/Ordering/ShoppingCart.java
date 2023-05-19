package Ordering;

import Products.Item;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    public static Map<Item, Integer> scItems = new HashMap<>();
    private static double cartPrice;


    public ShoppingCart() {
    }

    public static Map<Item, Integer> getItems() {
        return scItems;
    }


    public static void addItemtoSC(Item item, int quantity) {

        scItems.put(item, quantity);
    }

    public double getCartPrice() {
        return cartPrice;
    }

    public void setCartPrice(double cartPrice) {
        this.cartPrice = cartPrice;
    }

}
