package ClothesProject.NotSimpleMenu;

import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class LocalContainerTest {

    private LocalContainer<String> testObject = new LocalContainer<>();

    @Test
    void size() {
    /* (example 1)
    assertEquals(0, testObject.size());// изначальный размер нашей коллекции равен нулю проверяем(вначале 0,т.к. никакой логики мы не выполняли
        testObject.add("someVal");
        assertEquals(1,testObject.size());//теперь проверяем, увеличился ли на 1.*/

    int originalSize = testObject.size();
    testObject.add("someVal");
    assertEquals(originalSize+1,testObject.size());
    testObject.delete(0);
    assertEquals(originalSize,testObject.size());// после delete наш размер должен стать изначальным


    }

    @Test
    void add() {

        int originalSize = testObject.size();
        testObject.add("someVal");
        assertEquals(originalSize+1,testObject.size());
        assertTrue(testObject.getAll().contains("someVal"));//проверим на содержание строки добавленной
    }

    @Test
    void set() {
        int originalSize = testObject.size();
        testObject.add("someVal");
        assertEquals(originalSize+1,testObject.size());
        assertTrue(testObject.getAll().contains("someVal"));
        testObject.set(0,"someValNew");
        assertEquals(originalSize+1,testObject.size());

    }

    @Test
    void delete() {
        testObject.add("valueForDelete");// объект для удаления добавим
        int originalSize = testObject.size();//смотрим, что получилось
        testObject.delete(originalSize-1);// -1 т.к. элемент добавляется в конец коллекции
        assertEquals(originalSize-1,testObject.size());


    }

    @Test
    void getAll() {
        int originalSize = testObject.size();

        Collection<String> collectionToTest = testObject.getAll();//запрашиваем нашу коллекцию

        //проверяем эквивалентность между нашим тестовым объектом и его внутренним представлением
        assertEquals(originalSize, collectionToTest.size());

    }


}