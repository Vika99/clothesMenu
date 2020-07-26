package ClothesProject.config;

import ClothesProject.Clothes;
import ClothesProject.ClothesFactory;
import ClothesProject.DataBase.ClothesRepository;
import ClothesProject.DataBase.ConnectionManager;
import ClothesProject.DataBase.RowMapper;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

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
    public ClothesFactory clothesFactory() {
        return new ClothesFactory();
    }
        @Bean
         public ClothesRepository clothesRepository(ConnectionManager manager, RowMapper<Clothes> mapper){
            return new ClothesRepository(manager,mapper);
        }


}
