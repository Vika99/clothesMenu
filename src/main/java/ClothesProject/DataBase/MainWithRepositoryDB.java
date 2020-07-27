package ClothesProject.DataBase;

import ClothesProject.Clothes;
import ClothesProject.ClothesFactory;
import ClothesProject.Factory;
import ClothesProject.MenuWithGeneric.*;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

@Component
public class MainWithRepositoryDB  {

    @SneakyThrows
    public static void main(String []args)  {
        ConnectionManager manager = new ConnectionManager();
        ClothesMapper clothesMapper = new ClothesMapper();
        ClothesRepository clothesRepository = new ClothesRepository(manager, clothesMapper);

        Factory<Clothes<?>> clothesFactory = new ClothesFactory();
               MenuItem<Clothes<?>>[] clothesItems = new MenuItem[3];
               clothesItems[0] = new AddMenuItem<>(clothesRepository, clothesFactory);
               clothesItems[1] = new DeleteMenuItem<>(clothesRepository);
               clothesItems[2] = new PrintAll<>(clothesRepository);


        TopLevelMenu<Clothes<?>> clothesMenu = new TopLevelMenu<>(clothesItems, "clothes", 1);
         clothesMenu.run();



       // System.out.println(clothesRepository.size());
       // System.out.println(clothesRepository.getAll());


    }
}
