package ClothesProject.MenuWithGeneric;

import org.springframework.stereotype.Component;

@Component
public interface MenuItem <T>{
    int getOrder();

    String getTitle();

    void execute();
}



