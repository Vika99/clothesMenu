package ClothesProject.MenuWithGeneric;

import ClothesProject.Clothes;
import ClothesProject.NotSimpleMenu.Container;
import org.springframework.stereotype.Component;

@Component
public class PrintAll <T extends Comparable<T>> implements MenuItem<T> {
    private Container<T> container;

    public PrintAll(Container<T> container)

    {
        this.container =  container;
    }

    @Override
    public int getOrder() {
        return 3;
    }

    @Override
    public String getTitle() {
        return "Print all";
    }

    @Override
    public void execute() {
        container.printAll();
    }
}


