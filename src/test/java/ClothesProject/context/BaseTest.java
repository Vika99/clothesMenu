package ClothesProject.context;

import ClothesProject.config.ApplicationConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BaseTest { //на проверку подниается ли контекст вообще, снего стоит начинать проверку!!

    @Test
    void contextUpTest(){
        ApplicationContext context =new AnnotationConfigApplicationContext(ApplicationConfig.class);

        assertNotNull(context);
    }
}
