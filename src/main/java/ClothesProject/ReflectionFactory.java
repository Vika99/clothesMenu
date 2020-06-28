package ClothesProject;

import ClothesProject.NotSimpleMenu.ScannerWrapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
@RequiredArgsConstructor
public class ReflectionFactory <T> implements Factory<T>{
    //private final List<Class<T>> classes;
    private final Class<T> aClass;
    private  final ScannerWrapper wrapper;



@SneakyThrows
    public T create() {

        Field[] fields= aClass.getDeclaredFields();
        T instance = aClass.getConstructor().newInstance();// создадим объект перед вызовом его нашим клиентом

    for (Field field:fields){
        System.out.println("input val for"+ field.getName());
        String input = wrapper.nextLine();
        Object value = convert(field,input);


        field.setAccessible(true);
        field.set(instance,value);


    }



        return instance;
    }

    private Object convert( Field field, String value){
        Class<?> type = field.getType();
        if (String.class.equals(type)){
            return  value;
        }
        if( int.class.equals(type)|| Integer.class.equals(type)){
            return Integer.valueOf(value);
            // and with each type....


            // ПОПРОБОВАТЬ С МАССИВОМ ЕЩЕ!!!(НАДО СПРОСИТЬ, СКОЛЬКО ОБЪЕКТОВ  ОН ХОЧЕТ СОЗДАТЬ СООТВЕТСТ. ТИПА И ЗАПУСКАТЬ ФАБРИКУ.......





        }
        if (type.isEnum()){
            Object[] constants = type.getEnumConstants(); //если мы имеем enum
            for(Object constant:constants){
                if (((Enum)constant).name().equalsIgnoreCase(value)){
                    return constant;
                }
            }
            throw new IllegalArgumentException("wrong enum value");//при условии, если выбрали неправильно пользователь

        }
        throw new IllegalArgumentException();
    }
}

