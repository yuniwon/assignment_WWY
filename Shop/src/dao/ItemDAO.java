package dao;

import java.util.ArrayList;

import vo.Item;
import vo.Cart;
import vo.Category;

public class ItemDAO {
    public ArrayList<Item> items = new ArrayList<Item>();
    public ArrayList<Cart> carts = new ArrayList<Cart>();
    public ArrayList<Category> category = new ArrayList<Category>();

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
        for (Category c : category) {
            if (c.getCategoryName().equals(name)) {
                System.out.println("이미 존재하는 카테고리입니다.");
                return;
            }
        }
        // 카테고리 추가
        category.add(new Category(name));
        System.out.println("카테고리가 추가되었습니다.");
        return;
    }

    public void deleteCategory() {
        if (category.size() == 0) {
            System.out.println("삭제할 카테고리가 없습니다.");
            return;
        }
        // 카테고리 삭제
        String name = Utils.InnputManger.inputStr("삭제할 카테고리를 입력해주세요.");
        // 카테고리 존재여부 확인
        for (Category c : category) {
            if (c.getCategoryName().equals(name)) {
                category.remove(c);
                System.out.println("카테고리가 삭제되었습니다.");
                return;
            }
        }
        System.out.println("존재하지 않는 카테고리입니다.");
        return;
    }

    public void updateCategory() {
        // 카테고리 수정
        String name = Utils.InnputManger.inputStr("수정할 카테고리를 입력해주세요.");
        // 카테고리 존재여부 확인
        for (Category c : category) {
            if (c.getCategoryName().equals(name)) {
                // 카테고리 수정
                String newName = Utils.InnputManger.inputStr("수정할 카테고리를 입력해주세요.");
                c.setCategoryName(newName);
                System.out.println("카테고리가 수정되었습니다.");
                return;
            }
        }
        System.out.println("존재하지 않는 카테고리입니다.");
        return;
    }

    public void addItem() {
        // 카테고리 선택
        String name = Utils.InnputManger.inputStr("추가할 카테고리를 입력해주세요.");
        // 카테고리 존재여부 확인
        for (Category c : category) {
            if (c.getCategoryName().equals(name)) {
                // 아이템 추가
                String itemName = Utils.InnputManger.inputStr("추가할 아이템을 입력해주세요.");
                // 아이템 존재여부 확인
                for (Item item : items) {
                    if (item.getName().equals(itemName)) {
                        System.out.println("이미 존재하는 아이템입니다.");
                        return;
                    }
                }
                // 아이템 가격 입력
                int price = Utils.InnputManger.inputInt("추가할 아이템의 가격을 입력해주세요.");

                // 아이템 추가
                items.add(new Item(itemName, price, c.getCategoryName()));
                System.out.println("아이템이 추가되었습니다.");
                return;
            }
        }
    }

    public void deleteItem() {
        // 아이템 삭제
        String name = Utils.InnputManger.inputStr("삭제할 아이템을 입력해주세요.");
        // 아이템 존재여부 확인
        for (Item item : items) {
            if (item.getName().equals(name)) {
                items.remove(item);
                System.out.println("아이템이 삭제되었습니다.");
                return;
            }
        }
        System.out.println("존재하지 않는 아이템입니다.");
        return;
    }

    public void updateItem() {
        // 아이템 수정
        String name = Utils.InnputManger.inputStr("수정할 아이템을 입력해주세요.");
        // 아이템 존재여부 확인
        for (Item item : items) {
            if (item.getName().equals(name)) {
                // 수정할 항목 선택
                int num = Utils.InnputManger.inputInt("수정할 항목을 선택해주세요.\n1.이름 2.가격 3.카테고리", 1, 3);
                if(num == 1){
                // 이름 수정
                String newName = Utils.InnputManger.inputStr("수정할 이름을 입력해주세요.");
                // 중복이름 존재여부 확인
                for (Item i : items) {
                    if (i.getName().equals(newName)) {
                        System.out.println("이미 존재하는 이름입니다.");
                        return;
                    }
                }
                item.setName(newName);
                }else if(num == 2){
                // 아이템 가격 입력
                int price = Utils.InnputManger.inputInt("수정할 아이템의 가격을 입력해주세요.");
                // 가격 수정
                item.setPrice(price);
                }else if (num == 3) {
                                    // 카테고리 수정
                String categoryName = Utils.InnputManger.inputStr("수정할 카테고리를 입력해주세요.");
                // 카테고리 존재여부 확인
                for (Category c : category) {
                    if (c.getCategoryName().equals(categoryName)) {
                        item.setCategory(categoryName);
                        System.out.println("카테고리가 수정되었습니다.");
                        break;
                    }
                }
                System.out.println("존재하지 않는 카테고리입니다.");
                return;
                }

                return;
            }
        }
    }

}
