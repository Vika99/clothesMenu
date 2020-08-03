package ClothesProject.DataBase;

import ClothesProject.NotSimpleMenu.Container;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.jdbc.core.JdbcTemplate;


import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RequiredArgsConstructor
public abstract class BaseRepository <E extends IEntity> implements Container<E> {


    protected final ConnectionManager manager;
    protected final RowMapper<E> mapper;
    protected final JdbcTemplate jdbcTemplate;


    protected abstract String getTableName();//получим табличку нужную и создаем отдельный репозиторий

    @Override
    public int size() { //количесто элементов в контейнере

        List<Integer> query = jdbcTemplate.query("select count(*) from" + getTableName(), (rs, rowNum) -> rs.getInt(1));
        return query.stream().findFirst().orElse(0);

    }

        /*AtomicInteger result = new AtomicInteger(0);

        manager.workWithConnection(connection -> {
            try(Statement statement=connection.createStatement()){
                ResultSet resultSet = statement.executeQuery("select count(*) from" + getTableName());{
                   resultSet.next();
                    result.set(resultSet.getInt(1));
                }
            }

        });
        return result.get();*/




    @Override
    @SneakyThrows
    public void add(E element) {

        List<E> update = jdbcTemplate.update("insert into (price, size, article, color, type, jeans_t, tshirt_t) values (?,?,?,?,?,?)" + getTableName(), (rs, rowNum) -> rs.getInt(1));
                return update;

        /*manager.workWithConnection(connection -> {
            try (PreparedStatement statement = createInsertStatement(connection,element)){

                statement.executeUpdate();
                ResultSet resultSet = statement.getGeneratedKeys();
                if (resultSet.next()){
                    int id = resultSet.getInt(1);
                    element.setId(id);
                }
            }
        });*/




    }

    //protected abstract PreparedStatement createInsertStatement(Connection connection,E element) throws  SQLException;//БУДЕМ ОТДАВАТЬ РЕАЛИЗАЦИЮ В КЛАССЫ НАСЛЕДНИКИ

    @Override
    public void set(int index, E element) {

    }

    @Override
    public void delete(int index) {
        int remove = jdbcTemplate.update("DELETE FROM * WHERE id = ?" + getTableName(),(rs, rowNum) -> rs.getInt(1));
        return remove;





        /*manager.workWithConnection(connection -> {
            try (PreparedStatement st = connection.prepareStatement("DELETE FROM * WHERE id = ?")) {
                st.setInt(1, index);
                st.executeUpdate();
            }
        });*/

    }
    @Override
    public Collection<E> getAll() {
        List<E> result = new ArrayList<>();
        manager.workWithConnection(connection -> {
            try (Statement statement =connection.createStatement();
            ResultSet resultSet=statement.executeQuery("select * from " + getTableName())){

            while(resultSet.next())    {
                E element = mapper.mapRow(resultSet,0);// вызываем метод преобразования и получаем какой-то результат
             result.add(element);
            }
            }

        });
        return result;
    }

    @Override
    public void printAll() {

    }

}