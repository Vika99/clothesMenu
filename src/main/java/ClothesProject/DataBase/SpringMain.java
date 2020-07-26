package ClothesProject.DataBase;

import ClothesProject.Clothes;
import ClothesProject.ClothesFactory;
import ClothesProject.config.ApplicationConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class SpringMain {

    public static void main(String[]args){
        ApplicationContext context =new AnnotationConfigApplicationContext(ApplicationConfig.class);


        JdbcTemplate jdbcTemplate =context.getBean(JdbcTemplate.class);
        RowMapper rowMapper = context.getBean(RowMapper.class);
        List<Clothes> clothes = jdbcTemplate.query("select * from complex_clothes", rowMapper);
        System.out.println(clothes);
        //ClothesFactory clothesFactory= context.getBean(ClothesFactory.class);
      // clothesFactory.create();

    }
}
