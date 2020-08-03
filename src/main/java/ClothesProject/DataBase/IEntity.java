package ClothesProject.DataBase;

public interface IEntity {
    Integer getId();
    void setId(Integer id);

    Integer getPrice();
    void setPrice(Integer price);

    Integer getSize();
    void setSize(Integer size);

    String getArticle();
    void setArticle(String article);

    String getColor();
    void setColor(String color);

    String getType();
    void setType(String type);

    String getJeans();
    void setJeans(String jeans);

    String getTshirt();
    void setTshirt(String tshirt);
}
