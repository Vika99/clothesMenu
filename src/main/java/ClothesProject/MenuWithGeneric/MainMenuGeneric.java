package ClothesProject.MenuWithGeneric;

import ClothesProject.Clothes;
import ClothesProject.ClothesFactory;
import ClothesProject.Factory;
import ClothesProject.NetWork.NetworkClientContainer;
import ClothesProject.NotSimpleMenu.Container;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class MainMenuGeneric {
    public static void main(String[] args) throws IOException {
        Factory<Clothes> factory = new ClothesFactory();
        Container<Clothes> container = new NetworkClientContainer<Clothes>("localhost", 8080);


        // Создаем верхнеуровн. меню!
       MenuItem<Clothes>[] items= new MenuItem[3];
        items[0]=  new AddMenuItem<>(container, factory);
        items[1] = new DeleteMenuItem<>(container);

        items[2] = new PrintAll<>(container);
        TopLevelMenu clothesMenu = new TopLevelMenu<>(items, "clothes menu", 0);
        clothesMenu.execute();
    }
    }

