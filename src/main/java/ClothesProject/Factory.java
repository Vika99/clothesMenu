package ClothesProject;

import org.springframework.stereotype.Component;

@Component
public interface Factory <T> {

    T create();
}

