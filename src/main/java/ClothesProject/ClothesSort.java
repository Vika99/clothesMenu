package ClothesProject;

import java.util.Arrays;

public class ClothesSort {
    public static void main(String[] args) {
        Clothes[] clothes = new Clothes[6];
        clothes[0] = new Jeans(50, 34, "ggg", "pink");
        clothes[1] = new Jeans(54, 34, "gigg", "black");
        clothes[2] = new Jeans(30, 34, "ggig", "red");
        clothes[3] = new Tshirt(20, 34, "ggg", "gray");
        clothes[4] = new Tshirt(23, 34, "gigg", "purple");
        clothes[5] = new Tshirt(26, 34, "ggig", "red");

        Arrays.sort(clothes);
        System.out.println(Arrays.toString(clothes));
        System.out.println();
    }
}



