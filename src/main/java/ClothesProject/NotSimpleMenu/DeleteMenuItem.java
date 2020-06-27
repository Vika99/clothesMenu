package ClothesProject.NotSimpleMenu;

import ClothesProject.ClothesContainer;

import java.util.Scanner;

public class DeleteMenuItem implements IMenuItem {
    private Scanner sc = new Scanner(System.in);
    private ClothesContainer container;

    public DeleteMenuItem(ClothesContainer container) {
        this.container = container;
    }

    @Override
    public int getOrder() {
        return 3;
    }

    @Override
    public String getTitle() {
        return "Delete element";
    }

    @Override
    public void execute() {
        System.out.println("Input index");
        int choice = sc.nextInt();
        container.delete(choice);
    }
}



