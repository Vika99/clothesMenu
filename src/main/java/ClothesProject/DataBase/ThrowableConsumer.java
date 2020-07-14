package ClothesProject.DataBase;

public interface ThrowableConsumer<T> {//для работы с проверяемыми  исключениями необходимо

    void accept (T t) throws Exception;
}
