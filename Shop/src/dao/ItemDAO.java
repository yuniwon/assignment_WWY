package dao;

import java.util.ArrayList;
import vo.Item;
import vo.Cart;

public class ItemDAO {
    public ArrayList<Item> items = new ArrayList<Item>();
    public ArrayList<Cart> carts = new ArrayList<Cart>();

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

    public void cartList(String id) {
        for (Cart cart : carts) {
            if (cart.getUserId().equals(id)) {
                System.out.println(cart);
            }
        }
    }
    public void cartList() {
        for (Cart cart : carts) {
            System.out.println(cart);
        }
    }
    public void deleteItemById(String id) {
        for (Cart cart : carts) {
            if (cart.getUserId().equals(id)) {
                carts.remove(cart);
                return;
            }
        }
    }

    public void buyItem(String id) {
        // 아이템리스트 출력
        printItems();
        // 아이템 선택
        String name = Utils.InnputManger.inputStr("구입할 아이템을 선택해주세요.");
        // 아이템 존재여부 확인
        Item item = getItem(name);
        if (item == null) {
            System.out.println("존재하지 않는 아이템입니다.");
            return;
        }
        // 장바구니에 아이템 추가
        carts.add(new Cart(id, name));
        System.out.println("장바구니에 추가되었습니다.");
        return;
    }

    public void addCategory() {
        // 카테고리 추가
        String name = Utils.InnputManger.inputStr("추가할 카테고리를 입력해주세요.");
        // 카테고리 존재여부 확인
        Item item = getItem(name);
        if (item != null) {
            System.out.println("이미 존재하는 카테고리입니다.");
            return;
        }
        // 카테고리 추가
        
        System.out.println("카테고리가 추가되었습니다.");
        return;
    }


}
