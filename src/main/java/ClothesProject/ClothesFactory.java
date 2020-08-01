package ClothesProject;

import ClothesProject.NotSimpleMenu.ScannerWrapper;
import org.springframework.stereotype.Component;


@Component
public class ClothesFactory implements Factory<Clothes>{
    //private Scanner sc = new Scanner(System.in);
    private ScannerWrapper sc = new ScannerWrapper();
    public Clothes<?> create() {
        System.out.println("1-create Tshirt");
        System.out.println("2-create Jeans");

        int choice = sc.nextInt();
        Clothes result;
        //Внешняя переменная и в конце мы ее вернем и в ветках пишем result=..
        if (choice ==1){
            Tshirt tshirt = new Tshirt();
            System.out.println("Input Tshirt chest");
            int chest = sc.nextInt();
            tshirt.setChest(chest);
            result =  tshirt;
        }else {

            Jeans jeans = new Jeans();
            System.out.println("Input Jeans waist");
            int waist= sc.nextInt();
            jeans.setWaist(waist);
            result = jeans;
        }

        System.out.println("Input Clothes color");
        String color = sc.nextLine();
        result.setColor(color);

        System.out.println("Input Clothes price");
        int price = sc.nextInt();
        result.setPrice(price);

        System.out.println("Input Clothes size");
        int size = sc.nextInt();
        result.setSize(size);

        System.out.println("Input Clothes article");
        String article = sc.nextLine();
        result.setArticle(article);
        return result;
    }
}




