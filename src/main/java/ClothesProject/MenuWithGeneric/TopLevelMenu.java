package ClothesProject.MenuWithGeneric;
import ClothesProject.NotSimpleMenu.ScannerWrapper;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class TopLevelMenu  <T> implements MenuItem <T> {
    //private MenuItem<T>[] items;
    private List<MenuItem<T>> items;
    //private Scanner sc = new Scanner(System.in);
    private ScannerWrapper sc;
    private String title;
    private int order;

    public TopLevelMenu(ScannerWrapper sc, List<MenuItem<T>> items, String title, int order) {

        this.items = items.stream()
                .sorted(Comparator.comparingInt(MenuItem::getOrder))
                .collect(Collectors.toList());;
                this.title=title;
                this.order=order;
                this.sc=sc;

                /* Arrays.sort(items, new Comparator<MenuItem<T>>() {
            @Override
            public int compare(MenuItem<T> o1, MenuItem<T> o2) {
                return Integer.compare(o1.getOrder(), o2.getOrder());
            }
        });
        this.items = items;
        this.title = title;
        this.order = order;*/
    }

    public TopLevelMenu(MenuItem<T>[] items, String clothes_menu, int i) {
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
    public void execute() {
        run();
    }

    public void run() {
        while (true) {
            printHelp();
            int choice = sc.nextInt();
            if (choice == 0) {
                return;
            }
            for (MenuItem<T> item : items) {
                if (item.getOrder() == choice) {
                    item.execute();
                    break;
                }
            }
        }

    }

    private void printHelp() {
        for (MenuItem<T> item : items) {
            System.out.println(item.getOrder() + " - " + item.getTitle());
        }
        System.out.println("0 - exit");
    }
}

