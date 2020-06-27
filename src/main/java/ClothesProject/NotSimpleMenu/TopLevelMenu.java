package ClothesProject.NotSimpleMenu;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class TopLevelMenu implements IMenuItem {
    private IMenuItem[] items;

    private Scanner sc = new Scanner(System.in);
    private String title;
    private int order;

    public TopLevelMenu(IMenuItem[] items, String title, int order) {

        Arrays.sort(items, new Comparator<IMenuItem>() {
            @Override
            public int compare(IMenuItem o1, IMenuItem o2) {
                return Integer.compare(o1.getOrder(), o2.getOrder());// МЫ СОРТИРУЕМ НАШЕ МЕНЮ
            }
        });
        this.items = items;
        this.title = title;
        this.order = order;
    }

    @Override
    public int getOrder() {
        return order;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void execute() throws Exception {
        run();
    }

    public void run() throws Exception {
        while (true) {
            printHelp();
            int choice = sc.nextInt();
            if (choice == 0) {
                return;
            }
            for (IMenuItem item : items) {
                if (item.getOrder() == choice) {
                    item.execute();
                    break;
                }
            }
        }

    }

    private void printHelp() {
        for (IMenuItem item : items) {
            System.out.println(item.getOrder() + " - " + item.getTitle());
        }
        System.out.println("0 - exit");
    }
}

