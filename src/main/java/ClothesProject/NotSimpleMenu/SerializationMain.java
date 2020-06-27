package ClothesProject.NotSimpleMenu;

import ClothesProject.*;

public class SerializationMain implements  IMenuItem{
    ClothesContainer container = new ClothesContainer();
    ClothesFactory factory = new ClothesFactory();

    public SerializationMain(ClothesContainer container, ClothesFactory factory) {
        this.container = container;
        this.factory=factory;
    }

    @Override
    public int getOrder() {
        return 5;
    }

    @Override
    public String getTitle() {
        return "serialize all";
    }

    @Override
    public void execute() throws Exception {

        Jeans jeans = new Jeans(30,34,"qweasd","black",90);
        Tshirt tshirt=new Tshirt(25,34,"ertd","red",80);
        System.out.println(jeans.toProtocolString());
        System.out.println(tshirt.toProtocolString());

        String s1="j|30|34|qweasd|black|90";
        String s2="t|25|34|ertd|red|80";

        Clothes c1 = parse(s1);
        Clothes c2 = parse (s2);

        System.out.println(c1);
        System.out.println(c2);
    }
    public static Clothes parse(String s){//Метод parseInt() преобразует строку в число
        String [] string = s.split("\\|");// мы получим массив строк, \\ нужен,т.к. split регулярное выражение..
        if ("j".equals(string[0])){
            Jeans jeans =new Jeans();
            jeans.setPrice(Integer.parseInt(string[1]));
            jeans.setSize(Integer.parseInt(string[2]));
            jeans.setArticle(string[3]);
            jeans.setColor(string[4]);
            jeans.setWaist(Integer.parseInt(string[5]));

            return jeans;
        }else{
            Tshirt tshirt = new Tshirt();
            tshirt.setPrice(Integer.parseInt(string[1]));
            tshirt.setSize(Integer.parseInt(string[2]));
            tshirt.setArticle(string[3]);
            tshirt.setColor(string[4]);
            tshirt.setChest(Integer.parseInt(string[5]));

            return tshirt;
        }

    }
}



