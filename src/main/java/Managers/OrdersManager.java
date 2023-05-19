package Managers;

import Ordering.Order;
import Ordering.ShoppingCart;

public class OrdersManager {
    private static Order order;

    public static void addOrder(ShoppingCart cart) {
        order = new Order(cart);
        order.setPaid(true);
    }


    public static void viewOrder() {
        order.getOrderInfo();
    }


}
