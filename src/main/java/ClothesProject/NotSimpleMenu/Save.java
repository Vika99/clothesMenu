package ClothesProject.NotSimpleMenu;

import ClothesProject.ClothesContainer;
import ClothesProject.ClothesFactory;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Save implements IMenuItem {
    private Scanner sc = new Scanner(System.in);
    private ClothesContainer container;
    private ClothesFactory factory;
    static String text = "";

    public Save(ClothesContainer container, ClothesFactory factory)
    {
        this.container = container;
        this.factory=factory;
    }

    @Override
    public int getOrder() {
        return 6;
    }

    @Override
    public String getTitle() {
        return "save file";
    }

    @Override
    public void execute() throws Exception{//записываем данные в файл
        if(!(new File("src/lab3/Clothes/ClothesGenericSave").exists())) {//если файла не существует создаём его
            File file = new File("src/lab3/Clothes/ClothesGenericSave");
            file.createNewFile();
            System.out.println("Новый файл создан: src/lab3/Clothes/ClothesGenericSave");
        }
        FileWriter clothesFile = new FileWriter("src/lab3/Clothes/ClothesGenericSave");//запись моих данных в файл
        clothesFile.write(text);
        clothesFile.close();
        System.out.println("Данные записаны: src/lab3/Clothes/ClothesGenericSave");
    }
}



