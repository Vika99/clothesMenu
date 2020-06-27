package ClothesProject.NotSimpleMenu;

import ClothesProject.ClothesContainer;
import ClothesProject.ClothesFactory;

import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class Load implements IMenuItem{
    private Scanner sc = new Scanner(System.in);
    private ClothesContainer container;
    private ClothesFactory factory;

    public Load(ClothesContainer container, ClothesFactory factory) {
        this.container = container;
        this.factory = factory;
    }

    @Override
    public int getOrder() {
        return 7;
    }

    @Override
    public String getTitle() {
        return "load from file";
    }

    @Override
    public void execute() throws Exception {
        if (new File("src/lab3/Clothes/ClothesGenericSave").exists()) {//если файл существует,то дальше читаем его:
            FileReader clothesFile = new FileReader("src/lab3/Clothes/ClothesGenericSave");
            Scanner scanner = new Scanner(clothesFile);
            int i = 1;
            while (scanner.hasNextLine()) {
                String myfile = "src/lab3/Clothes/ClothesGenericSave";
                String[] split = myfile.split(", ");
                //for(int i = 0; i< split.length;i++)
                {
                }
                System.out.println(i + " : " + scanner.nextLine());
                i++; //hasNextLine() - метод, который возвращает boolean - true или false, показывая, есть ли следующая строка.
            }
            clothesFile.close();
        }
    }

}
