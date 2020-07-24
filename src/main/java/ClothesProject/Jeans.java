package ClothesProject;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Objects;
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Jeans extends Clothes {
    private int waist;


    private String jeans;


    public Jeans() {
    } // конструктор по умолчанию

    public Jeans(int price, int size, String article, String color) {
        super(price, size, article, color);
    }



    public Jeans(int price, int size, String article, String color, int waist) {
        super(price, size, article, color);
        this.waist = waist;

    }




    public Jeans(Integer id, int price, int size, String article, String color, String jeans) {
        super(id,price,size,article,color);
        this.jeans=jeans;
    }

    public int getWaist() {
        return waist;
    }

    public void setWaist(int waist) {

        this.waist = waist;
    }

    @Override
    public String toString() {
        return "Jeans{" +
                "Waist=" + getWaist() + ", " +
                super.toString() +
                "} ";
    }
    public String toProtocolString(){
        return "j|"+waist +"|"+ super.toProtocolString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Jeans)) return false;
        if (!super.equals(o)) return false;
        Jeans jeans = (Jeans) o;
        return getWaist() == jeans.getWaist();
    }


    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getWaist());
    }


}
   /* public boolean equals (Object o) {
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
        //Jeans jeans =(Jeans)o;
       // return(this.getWaist() == (jeans.getWaist()));
        //&& super.toString() == Jeans.super.toString());///);------как правильно сделать??
    }*/



