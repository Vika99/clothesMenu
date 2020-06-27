package ClothesProject.NotSimpleMenu;

import ClothesProject.ClothesContainer;
import ClothesProject.ClothesFactory;

public class ComplexMenu {
    public static void main(String[] args) throws Exception {
        ClothesContainer container = new ClothesContainer();
        ClothesFactory factory = new ClothesFactory();

        IMenuItem[] innerMenu = {
                new PrintAllMenu(container),
                new PrintAllMenu(container)
        };

        IMenuItem[] array = {
                new AddMenuItem(container,factory),
                new DeleteMenuItem(container),
                new PrintAllMenu(container),
                new SerializationMain(container,factory),
                new Save(container, factory),
                new Load(container,factory),
                new TopLevelMenu(innerMenu, "inner menu", 8)
        };

        new TopLevelMenu(array, "top menu", 0).run();
    }
}



