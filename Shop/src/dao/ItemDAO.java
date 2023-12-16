package dao;

import java.util.ArrayList;
import vo.Item;
import vo.User;
import vo.Cart;

public class ItemDAO {
    private ArrayList<Item> items = new ArrayList<Item>();
    private ArrayList<Cart> carts = new ArrayList<Cart>();

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public void printItems() {
        for (Item item : items) {
            System.out.println(item);
        }
    }

    public Item getItem(String name) {
        for (Item item : items) {
            if (item.getName().equals(name)) {
                return item;
            }
        }
        return null;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

}
