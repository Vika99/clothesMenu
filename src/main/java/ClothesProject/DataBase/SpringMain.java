package ClothesProject.DataBase;

import ClothesProject.ClothesFactory;
import ClothesProject.config.ApplicationConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringMain {

    public static void main(String[]args){
        ApplicationContext context =new AnnotationConfigApplicationContext(ApplicationConfig.class);

       // ClothesFactory clothesFactory= context.getBean(ClothesFactory.class);
       // clothesFactory.create();

    }
}
