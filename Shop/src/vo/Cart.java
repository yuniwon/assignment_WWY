package vo;

public class Cart {
	private String userId; // 구입한 유저 id
	private String itemName; // 구입한 아이템

	public Cart(String id, String name) {
		this.userId = id;
		this.itemName = name;
	}

	public String getUserId() {
		return userId;
	}

	public String getItemName() {
		return itemName;
	}

}
