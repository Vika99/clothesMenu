package ClothesProject.context;

import ClothesProject.config.ApplicationConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestConrextHandler {

    private static ApplicationContext context;

    public static ApplicationContext getContext(){
        if(context==null){
            context=new AnnotationConfigApplicationContext(ApplicationConfig.class);
        }
        return  context;
    }
}
