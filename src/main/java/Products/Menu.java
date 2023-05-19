package Products;

import java.util.HashMap;
import java.util.Map;



public class Menu {
    private Map<Integer, Item> systemItems = new HashMap<>();

    public Menu() {
        this.systemItems = new HashMap<>();
        Item item1 = new Item(1, "Coca Cola", 5, 10);
        addItem(item1.getItemID(),item1);

        Item item2 = new Item(2, "Pepsi", 5, 10);
        addItem(item2.getItemID(),item2);

        Item item3 = new Item(3, "Cookies White", 7, 10);
        addItem(item3.getItemID(),item3);

        Item item4 = new Item(4, "Cookies Black", 6, 10);
        addItem(item4.getItemID(),item4);

    }

    public void addItem(int id, Item item) {
        systemItems.put(id, item);
    }

    public void updateMenuItemInfo(int itemID, String name, int price, int quantity) {
        Item itemToUpdate = systemItems.get(itemID);
        if (itemToUpdate != null) {
            itemToUpdate.setName(name);
            itemToUpdate.setPrice(price);
            itemToUpdate.setQuantity(quantity);
        }
    }

    public Map<Integer, Item> getMenuItems() {
        return systemItems;
    }
}
