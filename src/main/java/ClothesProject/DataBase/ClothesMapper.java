package ClothesProject.DataBase;

import ClothesProject.Clothes;
import ClothesProject.Jeans;
import ClothesProject.Tshirt;
import lombok.SneakyThrows;

import java.sql.ResultSet;

public class ClothesMapper implements  RowMapper<Clothes> {

    @Override
    @SneakyThrows
    public Clothes mapRow(ResultSet resultSet) {
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

