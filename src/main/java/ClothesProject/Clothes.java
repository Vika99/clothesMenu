package ClothesProject;

import java.io.Serializable;

public class Clothes <E extends Clothes<E>>implements Comparable<Clothes<?>>, Serializable {
    private int price;
    private String material;
    private int size;
    private String article;
    private String color;

    @Override
    public int compareTo(Clothes o) {
        if (price>o.getPrice()){
            return 1;
        }
        if(price<o.getPrice()){
            return -1;
        }
        return 0;
    }// Это переопределение метода из interface comparable

    public Clothes() {
    } // конструктор по умолчанию


    public Clothes(int price, int size, String article, String color) {
        this.price = price;
        this.size = size;
        this.article = article;
        this.color = color;

    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;

    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;

    }


    public boolean equals (Object o) {
        if (o == null) {
            return false;
        }
        if (o == this) {
            return true;
        }
        if (getClass()!= o.getClass())
        {
            return false;
        }
        Clothes Tshirt =(Clothes)o;
        return(this.getPrice()==(Tshirt.getPrice()) && this.getSize()==Tshirt.getSize());
    }


    @Override
    public int hashCode() {
        int result = size;
        result = 31 * result + ( article != null ? article.hashCode() : 0);
        return result;
    }
    @Override
    public String toString() {
        return "Clothes" +"\t"+
                "Price" +"\t"+ getPrice() +"\t"+
                "Size" + getSize() +"\t"+
                "Article" + "\t"+  getArticle() +"\t"+
                "Color" + "\t"+ getColor() +"\t"+
                "} ";
    }

    public String toProtocolString(){
        return price+ "|" +size +"|"+article+"|"+color; //Это необходимо для разделения строк, и вывод
        // объектов на консоли из моего метода load в меню!!
    }
}



