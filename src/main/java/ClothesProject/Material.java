package ClothesProject;

public enum Material {
    SILK ("a123"),
    JEANS ("b456"),
    COTTON ("c789"),
    LINEN("d000");
    private String shmaterial;
    Material( String shmaterial){
        this.shmaterial= shmaterial;
    }
    public String getShmaterial() {
        return shmaterial;
    }
}

