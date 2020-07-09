package ClothesProject.DataBase;

import ClothesProject.Clothes;
import ClothesProject.Jeans;
import ClothesProject.Tshirt;
import lombok.SneakyThrows;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class DBMain {
    @SneakyThrows
    public static void main(String[] args) {

        Class.forName("com.mysql.cj.jdbc.Driver");

        /*try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/clothes?serverTimezone=UTC", "root", "sasha_voronchuk");
             //System.out.println(connection);
             PreparedStatement preparedStatement = connection.prepareStatement( "insert into user (login, type) values (?, 't')")) {

            Clothes ClothesToSave = new Clothes(null,50,34,"ert4","red");

            preparedStatement.setString(1, ClothesToSave.getPrice(),ClothesToSave.getSize(),ClothesToSave.getArticle(),ClothesToSave.getColor());
            int count = preparedStatement.executeUpdate();

            System.out.println(count);

        }*/


        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/clothes?serverTimezone=UTC", "root", "sasha_voronchuk");
             //System.out.println(connection);

             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("select * from complex_clothes")) {// ВЫПОЛНИМ ЗАПРОС для выборки данных
            //executeUpdate -для внесения изменений данных


            List <Clothes> clothes = new ArrayList<>();
            while (resultSet.next()) {

                clothes.add(parseClothes(resultSet));


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
        String type = resultSet.getString("type");

        Clothes result;

        switch (type) {
            case "j": {

                String jeans = resultSet.getString("jeans_t");
                result = new Jeans(id, price, size, article, color,jeans);
                break;
            }
            case "t": {
                String tshirt = resultSet.getString("tshirt_t");
                result = new Tshirt(id, price, size, article, color,tshirt);
                break;
            }
            default:
                throw new IllegalArgumentException("unknown type of clothes");

        }
        return result;
    }
}