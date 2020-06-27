package ClothesProject.MenuWithGeneric;

import ClothesProject.Factory;
import ClothesProject.NotSimpleMenu.Container;
import ClothesProject.NotSimpleMenu.LocalContainer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AddMenuItemTest {
    private Container<String> container = new LocalContainer<>();
    // private Factory<String> factory = ()->"hello"; ----it's a stub object
    private Factory factory= mock(Factory.class);
    private AddMenuItem<String> testObject = new AddMenuItem<>(container, factory);

    @BeforeEach
    void init(){
        when(factory.create()).thenReturn("hello");
    }

    @Test
    void testGetOrder(){
        int  order = testObject.getOrder();
        assertEquals(1,order);
    }

    @Test
    void testGetTitle(){
        String title = testObject.getTitle();
        assertEquals("Add element", title);
    }
    @Test

    void TestExecute(){
        testObject.execute();

        //постараемся убедиться,что там есть элемент:
        String values = container.getAll().iterator().next();
        //потом смотрим,что размер контейнера стал единица
        assertEquals(1, container.size());
        //и убеждаемся, что конкретно hello сложилось к нам в фабрику
        assertEquals("hello", values);

        verify(factory,times(1)).create();
        verifyNoMoreInteractions(factory);
    }

}

