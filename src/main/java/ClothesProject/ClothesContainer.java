package ClothesProject;

public class ClothesContainer {
    private Clothes[] array = new Clothes[10];
    private int count = 0;
    public int i = 0;


    public void add(Clothes element) {
        if (count == array.length) {
            Clothes[] newarray = new Clothes[(int) (array.length * 1.5)];
            System.arraycopy(array, 0, newarray, 0, count);
            array = newarray;
        }
        array[count++] = element;

    }

    public void update(int index, Clothes element) {
        array[index] = element;
    }

    public void delete(int index) {
        for (int i = index; i < count - 1; i++) {
            array[i] = array[i + 1];
        }
        count--;
    }

    public Clothes[] getArray() {
        return array;
    }

    public int size() {
        return count;
    }

    public void averagePrice() {
        double averagePrice = 0;
        if (array[10].getPrice() > 0) {
            double sum = 0;
            for (int i = 0; i < array[10].getPrice(); i++) {
                sum += array[10].getPrice();
            }
            averagePrice = sum / array[10].getPrice();
            System.out.println(averagePrice);
        }

    }
}


    /*@Override
    public void run() {
        System.out.println("My thread " + Thread.currentThread().getId() + " is getting " + i++);//попробуем посмотреть изменения переменной i
        for(int i = 0; i < 5; i++) {
            try {
                // Приостанавливаем поток
                Thread.sleep(1000);
                System.out.println("Thread ");
            }catch(InterruptedException e){}
    }
        public static void main (String[]args){
            ClothesContainer myMultithread = new ClothesContainer(); //создаем экземпляр нашего класса
            new Thread(myMultithread).start();//создаем первый поток и одновременно запускаем его
            new Thread(myMultithread).start();//второй
            new Thread(myMultithread).start();//третий !!! порядок потоков в методе вовсе не означает, что они выполняться в таком порядке
        }
    }*/


