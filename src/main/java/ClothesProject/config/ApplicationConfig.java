package ClothesProject.config;

import ClothesProject.Clothes;
import ClothesProject.ClothesFactory;
import ClothesProject.DataBase.ClothesRepository;
import ClothesProject.DataBase.ConnectionManager;
import ClothesProject.DataBase.RowMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("ClothesProject")
public class ApplicationConfig {

    @Bean
    public ClothesFactory clothesFactory() {
        return new ClothesFactory();
    }
        @Bean
         public ClothesRepository clothesRepository(ConnectionManager manager, RowMapper<Clothes> mapper){
            return new ClothesRepository(manager,mapper);
        }

        @Bean
    public ConnectionManager connectionManager(){
        return new ConnectionManager();
    }
}
