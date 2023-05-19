package Ordering;

import Products.Item;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class Order {
    private Map<Item, Integer> items;
    private double totalCost;
    private boolean isPaid;
    private boolean isDelivered;

    LocalDate currentDate = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    String currentDateString = currentDate.format(formatter);
    private String Date = currentDateString;

    private ShoppingCart cart;

    private static int orderID = 0;

    public Order() {
        this.orderID = ++orderID;
    }

    public Order(ShoppingCart userCart) {
        this.orderID = ++orderID;
        this.cart = userCart;
    }


    public void setPaid(boolean isPaid) {
        this.isPaid = isPaid;
    }


    public void getOrderInfo() {
        System.out.println("Order ID: " + orderID);
        System.out.println("Order Date: " + Date);

    }

}
