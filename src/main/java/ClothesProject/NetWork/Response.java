package ClothesProject.NetWork;

import java.io.Serializable;

public class Response implements Serializable {

    private final Serializable payload;

    public Response(Serializable payload)
    {
        this.payload = payload;
    }

    public Serializable getPayload() {
        return payload;
    }
}

