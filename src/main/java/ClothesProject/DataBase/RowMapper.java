package ClothesProject.DataBase;

import org.springframework.stereotype.Component;

import java.sql.ResultSet;

public interface RowMapper <E extends IEntity> extends org.springframework.jdbc.core.RowMapper<E> {
    //как конкретнуюстроку првератить в конкретный объект показывает
    //+ добавляем как зависиомсть в базовый репозиторий
   // E mapRow(ResultSet rs);// в цикле будем вызывать данный метод и получать результат для каждой следующей строки

}
