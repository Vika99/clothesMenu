package ClothesProject.DataBase;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.function.Consumer;
@Component
public class ConnectionManager {


    @Value("${dburl}")
    private String url;

    @Value("${dbuser}")
    private String user;

    @Value("${dbpassword}")
    private String password;


    //Для установления связи используем данный класс

    @SneakyThrows
    public void workWithConnection(ThrowableConsumer<Connection> connectionConsumer) {
        //передадим интерфейс consumer
        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection connection = DriverManager.getConnection(url,user,password)) {
            connectionConsumer.accept(connection);


          //  try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/clothes?serverTimezone=UTC", "root", "sasha_voronchuk99")) {
           // connectionConsumer.accept(connection);

            {
            }
        }
    }
}