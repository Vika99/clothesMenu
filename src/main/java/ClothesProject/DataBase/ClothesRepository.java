package ClothesProject.DataBase;

import ClothesProject.Clothes;
import ClothesProject.Jeans;
import ClothesProject.Tshirt;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.*;

public class ClothesRepository extends BaseRepository<Clothes> {

    public ClothesRepository(ConnectionManager manager, JdbcTemplate jdbcTemplate, RowMapper<Clothes> clothesRowMapper) {
        super(manager, clothesRowMapper, jdbcTemplate);
    }




    @Override
    protected String getTableName() {
        return "complex_clothes";
    }

    @Override
    protected PreparedStatement createInsertStatement(Connection connection, Clothes element) throws SQLException {
     PreparedStatement statement=connection.prepareStatement("insert into complex_clothes(price,size, article, color, type, jeans_t, tshirt_t) values (?,?,?,?,?,?,?)",
             Statement.RETURN_GENERATED_KEYS
     );

      statement.setInt(1,element.getPrice());
      statement.setInt(2,element.getSize());
      statement.setString(3,element.getArticle());
      statement.setString(4,element.getColor());

      if (element instanceof Jeans){
          statement.setString(5,"j");
          statement.setString(6,((Jeans)element).getJeans());
          statement.setNull(7, Types.VARCHAR);
      } else
          if (element instanceof Tshirt){
              statement.setString(5,"t");
              statement.setNull(6,Types.VARCHAR);
              statement.setString(7,((Tshirt)element).getTshirt());
          }
      return  statement;
    }
}
