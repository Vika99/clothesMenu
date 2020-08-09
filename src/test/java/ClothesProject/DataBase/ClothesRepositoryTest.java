package ClothesProject.DataBase;

import ClothesProject.Clothes;
import ClothesProject.context.TestConrextHandler;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class ClothesRepositoryTest {

    @Test
    void addClothesTest(){
        ApplicationContext context = TestConrextHandler.getContext();

        ClothesRepository clothesRepository=context.getBean(ClothesRepository.class);
        clothesRepository.add(new Clothes(null,34,32,"red","red"));

        Clothes firstClothes = clothesRepository.getAll().iterator().next();
        assertNotNull(firstClothes);
    }

}