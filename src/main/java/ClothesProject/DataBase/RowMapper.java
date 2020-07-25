package ClothesProject.DataBase;

import org.springframework.stereotype.Component;

import java.sql.ResultSet;

@Component
public interface RowMapper <E extends IEntity>{
    //как конкретнуюстроку првератить в конкретный объект показывает
    //+ добавляем как зависиомсть в базовый репозиторий
    E mapRow(ResultSet rs);// в цикле будем вызывать данный метод и получать результат для каждой следующей строки

}
