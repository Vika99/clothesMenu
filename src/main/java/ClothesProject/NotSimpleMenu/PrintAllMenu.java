package ClothesProject.NotSimpleMenu;

import ClothesProject.ClothesContainer;

public class PrintAllMenu implements IMenuItem {


    private ClothesContainer container;

    public PrintAllMenu(ClothesContainer container) {
        this.container = container;
    }

    @Override
    public int getOrder() {
        return 4;
    }

    @Override
    public String getTitle() {
        return "Print all";
    }

    @Override
    public void execute() {

    }
}

