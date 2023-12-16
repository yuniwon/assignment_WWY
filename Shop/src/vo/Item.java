package vo;

public class Item {
	private String name;
	private int price;
	private static String[] category; // 카테고리 // 육류 , 과자 , 어류 , 과일 등등

	public Item(String name, int price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {

		return name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "{" +
				" name='" + getName() + "'" +
				", price='" + getPrice() + "'" +
				"}";
	}
}
