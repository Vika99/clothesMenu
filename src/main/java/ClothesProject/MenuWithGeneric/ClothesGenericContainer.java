package ClothesProject.MenuWithGeneric;
import org.springframework.stereotype.Component;

import java.util.Arrays;

public class ClothesGenericContainer <T extends Comparable<T>> {

    private T[] array = (T[]) new Object[10];
    private int count = 0;

    public void add(T element) {
        if (count == array.length) {
            T[] newarray = (T[]) new Object[(int) (array.length * 1.5)];
            System.arraycopy(array, 0, newarray, 0, count);
            array = newarray;
        }
        array[count++] = element;

    }

    public void update(int index, T element) {
        array[index] = element;
    }

    public void delete(int index) {
        for (int i = index; i < count - 1; i++) {
            array[i] = array[i + 1];
        }
        count--;
    }

    public T[] getArray() {
        return array;
    }

    public void sort() {
        Arrays.sort(array);
    }

    public int size() {
        return count;
    }

    public void averagePrice() {

    }

}

