package ClothesProject.NetWork;

import ClothesProject.NotSimpleMenu.Container;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.Collection;
import java.util.Collections;

public class NetworkClientContainer <T extends Serializable> implements Container<T> {

    private Socket socket;//Далее для параметризации создаем контейнер
    //Scanner in;
    private final ObjectInputStream ois;
    private final ObjectOutputStream oos;

    public NetworkClientContainer(String host, int port) throws IOException {
        socket = new Socket(host, port);
        //in = new Scanner(socket.getInputStream());
        oos = new ObjectOutputStream(socket.getOutputStream());
        ois = new ObjectInputStream(socket.getInputStream());
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void add(T element) {
        Request request = new Request(Type.ADD, element.toString());// Создаем объект запроса

        try {
            oos.writeObject(request);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void set (int index, T element){
        Request request = new Request(Type.SET, new PayLoad(index, element));
        try {
            oos.writeObject(request);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void delete(int index) {
        Request request = new Request(Type.DELETE, index);
        try {
            oos.writeObject(request);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    //Аннотация,чтобы подавитьпредупреждение
    @SuppressWarnings("unchecked")

    public Collection<T> getAll() {

        Request request = new Request(Type.GET, null);

        try {
            oos.writeObject(request);
            oos.flush(); //Метод выводит данные из буфера и помещает их в предназначенное для них место

            Response response= (Response) ois.readObject();
            return (Collection<T>)response.getPayload();


        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();// ВЕРНЕМ ПУСТОЙ ЛИСТ
    }



    @Override
    public void printAll() {

    }
}


