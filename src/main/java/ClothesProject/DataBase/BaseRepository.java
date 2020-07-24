package ClothesProject.DataBase;

import ClothesProject.NotSimpleMenu.Container;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;


import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@RequiredArgsConstructor
public abstract class BaseRepository <E extends IEntity> implements Container<E> {


    private final ConnectionManager manager;
    private final RowMapper<E> mapper;


    protected abstract String getTableName();//получим табличку нужную и создаем отдельный репозиторий

    @Override
    public int size() { //количесто элементов в контейнере
        AtomicInteger result = new AtomicInteger(0);

        manager.workWithConnection(connection -> {
            try(Statement statement=connection.createStatement()){
                ResultSet resultSet = statement.executeQuery("select count(*) from" + getTableName());{
                   resultSet.next();
                    result.set(resultSet.getInt(1));
                }
            }

        });
        return result.get();
    }

    @Override
    @SneakyThrows
    public void add(E element) {
        manager.workWithConnection(connection -> {
            try (PreparedStatement statement = createInsertStatement(connection,element)){

                statement.executeUpdate();
                ResultSet resultSet = statement.getGeneratedKeys();
                if (resultSet.next()){
                    int id = resultSet.getInt(1);
                    element.setId(id);
                }
            }
        });




    }

    protected abstract PreparedStatement createInsertStatement(Connection connection,E element) throws  SQLException;//БУДЕМ ОТДАВАТЬ РЕАЛИЗАЦИЮ В КЛАССЫ НАСЛЕДНИКИ

    @Override
    public void set(int index, E element) {

    }

    @Override

    public void delete(int index) {
        manager.workWithConnection(connection -> {
            try (PreparedStatement st = connection.prepareStatement("DELETE FROM * WHERE id = ?")) {
                st.setInt(1, index);
                st.executeUpdate();
            }


        });

    }
    @Override
    public Collection<E> getAll() {
        List<E> result = new ArrayList<>();
        manager.workWithConnection(connection -> {
            try (Statement statement =connection.createStatement();
            ResultSet resultSet=statement.executeQuery("select * from " + getTableName())){

            while(resultSet.next())    {
                E element = mapper.mapRow(resultSet);// вызываем метод преобразования и получаем какой-то результат
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