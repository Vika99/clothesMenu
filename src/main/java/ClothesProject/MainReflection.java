package ClothesProject;

import ClothesProject.NotSimpleMenu.ScannerWrapper;

public class MainReflection {

    public static void main(String[]args){
        Factory<Clothes> factory= new ReflectionFactory<>(Clothes.class, new ScannerWrapper());

        Clothes clothes = factory.create();
        System.out.println(clothes);
    }
}
