package vo;

public class Item {
	private String name;
	private int price;
	private static String category; // 카테고리 // 육류 , 과자 , 어류 , 과일 등등

    public String getName() {

        return name;
    }

	public int getPrice() {
		return price;
	}

	public static String getCategory() {
		return category;
	}

}
