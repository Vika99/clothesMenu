package ClothesProject.NotSimpleMenu;

import ClothesProject.Clothes;
import ClothesProject.ClothesContainer;
import ClothesProject.ClothesFactory;

import java.util.Scanner;

public class NotSimpleMenu {
    private Scanner sc = new Scanner(System.in);
    private ClothesFactory factory = new ClothesFactory();
    private ClothesContainer container = new ClothesContainer();
    static String text = "";
    public void run() throws Exception {

        while (true) {
            printHelp();
            int choice = sc.nextInt();

            switch (choice) {
                case 1: addElement(); break;
                case 2: update(); break;
                case 3: delete(); break;
                case 4: printAll(); break;
                case 5: serializeAll();break;
                case 6:save();break;
                case 7:load();break;
                case 0: return;
            }
        }
    }

    private void addElement() {
        container.add(factory.create());
    }

    private void update() {
        System.out.println("Input index");
        int choice = sc.nextInt();
        container.update(choice, factory.create());
    }

    private void printAll() {
        Clothes[] array = container.getArray();
        for (int i = 0; i < container.size(); i++) {
            System.out.println(array[i]);
        }
    }

    private void delete() {
        System.out.println("Input index");
        int choice = sc.nextInt();

        container.delete(choice);
    }

    private void serializeAll(){

    }
    private void save () {

    }

    private void load(){

    }

    //CRUD - create, read, upd, del
    private void printHelp() {
        System.out.println("1 - add element");
        System.out.println("2 - update element");
        System.out.println("3 - delete element");
        System.out.println("4 - print all");
        System.out.println("5 - serialize all");
        System.out.println("6- save to file");
        System.out.println("7- load from file");
        System.out.println("0 - exit");
    }
}


