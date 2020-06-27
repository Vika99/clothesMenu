package ClothesProject.NetWork;

import java.io.Serializable;

public class Request implements Serializable {

    private final Type type; //final, т.к. мы отправляем запрос 1-н раз
    private final Serializable payload  ;

    public Request(Type type,Serializable payload ) {
        this.type = type;
        this.payload= payload; //,полезная нагрузка, передаем информацию,необходимую для совершения соответст.операций

    }

    public Type getType() {
        return type;
    }

    public Serializable getPayload()
    {

        return payload;
    }
    @Override
    public String toString() {
        return "Request{" +
                "type=" + type +
                ", payload=" + payload +
                '}';
    }
}


