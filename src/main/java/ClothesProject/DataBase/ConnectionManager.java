package ClothesProject.DataBase;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.function.Consumer;

public class ConnectionManager {

    //Для установления связи используем данный класс

    @SneakyThrows
    public void workWithConnection(ThrowableConsumer<Connection> connectionConsumer) {
        //передадим интерфейс consumer
        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/clothes?serverTimezone=UTC", "root", "sasha_voronchuk99")) {
            connectionConsumer.accept(connection);

            {
            }
        }
    }
}