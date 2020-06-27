package ClothesProject.NetWork;

import ClothesProject.Clothes;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerContainer {
    private static ExecutorService executorService;
    private static CopyOnWriteArrayList<Clothes<?>> list = new CopyOnWriteArrayList<>();


    public static void main(String[] args) throws IOException {
        executorService = Executors.newCachedThreadPool();
        ServerSocket serverSocket = new ServerSocket(8080);

        System.out.println("Server Started");

        while (true) {

            Socket socket = serverSocket.accept();
            System.out.println("New connection opened");

            process(socket);
        }
    }

    private static void process(Socket socket) {    // Будет обрабатывать отдельно каждое новое соединение


        // Как только новое соединение мы отправляем новую задачу на выполнение
        executorService.submit(() -> {

            try {
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                System.out.println("Ready to communicate");


                while (true) {
                    communicate(ois, oos);

                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        });
    }


    private static void communicate(ObjectInputStream ois, ObjectOutputStream out) throws IOException, ClassNotFoundException, InterruptedException {    //Отвечает за взаимодействие

        Request request = (Request) ois.readObject();
        System.out.println(request);


        switch (request.getType()) {
            case ADD: {
                Clothes<?> element = (Clothes<?>) request.getPayload();
                list.add(element);
                break;
            }

            case SET: {
                PayLoad updateData = (PayLoad)request.getPayload();
                Clothes<?> element =( Clothes<?>) updateData.getElement();
                list.set(updateData.getIndex(), element);
                break;
            }
            case DELETE:
                int index = (Integer) request.getPayload();
                list.remove(index);
                break;

            case GET: {
                Response response = new Response(new ArrayList<>(list));
                for( Clothes<?> clothes:list){
                    Thread.sleep(1_000);
                    System.out.println(clothes);
                }
                ObjectOutputStream oos = new ObjectOutputStream(out);
                oos.writeObject(response);
                oos.flush();
                break;
            }


        }
    }


}

