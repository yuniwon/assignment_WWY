package vo;

public class Category {
    private String name; // 카테고리 이름

    public Category(String name) {
        this.name = name;
    }

    public String getCategoryName() {
        return name;
    }

    public void setCategoryName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "{" +
                " name='" + getCategoryName() + "'" +
                "}";
    }
}
