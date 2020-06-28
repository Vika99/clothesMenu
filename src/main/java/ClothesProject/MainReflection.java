package ClothesProject;

import ClothesProject.NotSimpleMenu.ScannerWrapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

public class MainReflection {

    @SneakyThrows
    public static void main(String[]args){
        Factory<Clothes> factory= new ReflectionFactory<>(Clothes.class, new ScannerWrapper());

        Clothes clothes = factory.create();
        System.out.println(clothes);


        ObjectMapper mapper = new ObjectMapper();
        String clothesJeans = mapper.writeValueAsString(clothes);
        System.out.println(clothesJeans);
    }
}
