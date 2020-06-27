package ClothesProject;

import java.util.Arrays;

public class ClothesMain {
    public static void main(String[] args) {



        Material m1= Material.COTTON;// проверка enum
        Material m2 = Material.SILK;
        Material m3 = Material.JEANS;
        Material m4 = Material.LINEN;
        System.out.println(m1.ordinal());//--возвращает порядковый номер
        System.out.println(m1.getShmaterial());
        System.out.println(m2.compareTo(m1));
        System.out.println(m2.hashCode());
        System.out.println(m2.toString());
        Material [] materials = Material.values();
        System.out.println(Arrays.toString(materials));
        System.out.println(Material.valueOf("COTTON").ordinal());




        Clothes Tshirt = new Tshirt(35, 34,  "S2354", "white", 80 );
        Clothes Tshirt2= new Tshirt(36, 34, "S2354", "white", 80);
        System.out.println(Tshirt.equals(Tshirt2));
        Clothes Jeans = new Jeans(25,  34, "S2356", "black", 60);
        Clothes Jeans2 = new Jeans(23,  34, "S2356", "black", 60);
        System.out.println(Jeans.equals(Jeans2));
        System.out.println("Tshirt :" + "Price:" + Tshirt.getPrice() + "\t"  + "size:"+ Tshirt.getSize()+ "\t"  +"article:"+ Tshirt.getArticle()+ "\t" + "color:"+ Tshirt.getColor()+ "\t" + "Chaist:"+((Tshirt) Tshirt).getChest());
        System.out.println("Jeans :" + "Price:" + Jeans.getPrice() + "\t" +  "\t" + "size:"+ Jeans.getSize()+ "\t" +"article:"+ Jeans.getArticle()+ "\t" + "color:"+ Jeans.getColor()+ "\t" + "Waist:"+((Jeans) Jeans).getWaist());
        System.out.println(Tshirt);
        System.out.println(Jeans);
        System.out.println(Tshirt.hashCode());
        System.out.println(Tshirt2.hashCode());
        System.out.println(Jeans.hashCode());
        System.out.println(Jeans2.hashCode());


    }

}

