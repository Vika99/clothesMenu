package ClothesProject.DataBase;

import ClothesProject.NotSimpleMenu.Container;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Collection;
import java.util.function.Consumer;

@RequiredArgsConstructor
public class BaseRepository <E> implements Container<E> {


    private final ConnectionManager manager;

    @Override
    public int size() {
        manager.workWithConnection(new Consumer<Connection>() {
            @SneakyThrows
            @Override
            public void accept(Connection connection) {
                try(Statement statement=connection.createStatement()){
                    statement.executeQuery("select count(*) from");
                }

            }
        });
        return 0;
    }

    @Override
    public void add(E element) {

    }

    @Override
    public void set(int index, E element) {

    }

    @Override
    public void delete(int index) {

    }

    @Override
    public Collection<E> getAll() {
        return null;
    }

    @Override
    public void printAll() {

    }
}
