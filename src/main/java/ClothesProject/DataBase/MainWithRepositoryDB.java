package ClothesProject.DataBase;

import lombok.SneakyThrows;

public class MainWithRepositoryDB {

    @SneakyThrows
    public static void main(String []args){

        ConnectionManager manager = new ConnectionManager();
        ClothesMapper clothesMapper = new ClothesMapper();
        ClothesRepository clothesRepository = new ClothesRepository(manager,clothesMapper);

        System.out.println(clothesRepository.size());
        System.out.println(clothesRepository.getAll());
    }
}
