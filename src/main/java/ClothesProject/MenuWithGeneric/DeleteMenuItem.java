package ClothesProject.MenuWithGeneric;

import ClothesProject.Clothes;
import ClothesProject.NotSimpleMenu.Container;

import java.util.Scanner;

public class DeleteMenuItem <T> implements MenuItem<T>{
    private Container<T> container;
    private Scanner sc = new Scanner(System.in);

    public DeleteMenuItem(Container<Clothes<?>> container) {
        this.container = container;
    }

    @Override
    public int getOrder() {
        return 2;
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


