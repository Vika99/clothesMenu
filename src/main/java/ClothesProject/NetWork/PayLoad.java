package ClothesProject.NetWork;

import java.io.Serializable;

public class PayLoad implements Serializable {
    private int index;
    private Serializable element;

    public PayLoad(int index, Serializable element) {
        this.index = index;
        this.element=element;
    }


    public void setIndex(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public void setElement(Serializable element) {
        this.element = element;
    }

    public Serializable getElement() {
        return element;
    }
}


