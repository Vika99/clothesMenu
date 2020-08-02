package ClothesProject.config;

import ClothesProject.Clothes;
import ClothesProject.ClothesFactory;
import ClothesProject.DataBase.ClothesRepository;
import ClothesProject.DataBase.ConnectionManager;
import ClothesProject.DataBase.RowMapper;
import ClothesProject.Factory;
import ClothesProject.MenuWithGeneric.*;

import ClothesProject.NotSimpleMenu.Container;
import ClothesProject.NotSimpleMenu.ScannerWrapper;
import liquibase.integration.spring.SpringLiquibase;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.List;

@Configuration
@ComponentScan("ClothesProject")
@PropertySource("classpath:application.properties")
public class ApplicationConfig {


    @Value("${dburl}")
    private String url;

    @Value("${dbuser}")
    private String user;

    @Value("${dbpassword}")
    private String password;

    @Bean
    @SneakyThrows
    public DataSource dataSource() {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return new DriverManagerDataSource(url, user, password);
    }

    @Bean
public JdbcTemplate jdbcTemplate (DataSource dataSource){
        return new JdbcTemplate(dataSource);
}

    @Bean
    public SpringLiquibase springLiquibase(DataSource ds){
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setDataSource(ds);
        liquibase.setChangeLog("classpath:db/changelog-master.xml");  //где лежат наши скрипты для базы

        return liquibase;
    }

    @Bean
    public ClothesFactory clothesFactory() {
        return new ClothesFactory();
    }
       /* @Bean
         public ClothesRepository clothesRepository(ConnectionManager manager, RowMapper mapper){
            return new ClothesRepository(manager,mapper);
        }*/




     @Bean

    public AddMenuItem<Clothes> clothesAddMenuItem( Container<Clothes> container, Factory<Clothes> factory){
        return new AddMenuItem<>(container,factory);

     }

     @Bean

    public MenuItem<Clothes> clothesPrintAllMenuItem(Container<Clothes> container){
        return new PrintAll<>(container);
     }

     @Bean
    public MenuItem<Clothes> clothesDeleteMenuItem(Container<Clothes> container){
        return new DeleteMenuItem<>(container);
     }

     @Bean
    public TopLevelMenu<Clothes> clothesTopLevelMenu(ScannerWrapper sc, List<MenuItem<Clothes>> items){
        return new TopLevelMenu<>(sc,items,"clothes",1);
     }

}
