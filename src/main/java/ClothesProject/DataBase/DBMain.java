package ClothesProject.DataBase;

import ClothesProject.Clothes;
import ClothesProject.Jeans;
import ClothesProject.Tshirt;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBMain {
    @SneakyThrows
    public static void main(String[] args) {

        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/clothes?serverTimezone=UTC", "root", "sasha_voronchuk");
             //System.out.println(connection);

             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("select * from complex_clothes")) {// ВЫПОЛНИМ ЗАПРОС


            List <Clothes> complex_clothes = new ArrayList<>();
            while (resultSet.next()) {

                complex_clothes.add(parseClothes(resultSet));


            }

            System.out.println(resultSet);
        }
        /*resultSet.close();
        statement.close();
        connection.close();*/ //если использовать try ,то можно не писать close


    }

    @SneakyThrows
    private static Clothes parseClothes(ResultSet resultSet) {
        int id = resultSet.getInt("id");
        int price = resultSet.getInt("price");
        int size = resultSet.getInt("size");
        String article = resultSet.getString("article");
        String color = resultSet.getString("color");
        String material = resultSet.getString("material");
        String type = resultSet.getString("type");

        Clothes result;

        switch (type) {
            case "j": {

                String jeans = resultSet.getString("jeans_t");
                result = new Jeans(id, price, size, article, color, material);
                break;
            }
            case "t": {
                String tshirt = resultSet.getString("tshirt_t");
                result = new Tshirt(id, price, size, article, color, material);
                break;
            }
            default:
                throw new IllegalArgumentException("unknown type of clothes");

        }
        return result;
    }
}