package eNum;

public enum eTarget {
    WEIGHT_AGAIN("TANG CAN"),LOSING_WEIGHT("GIAM CAN")
    ,MUSCLE_AGAIN("TANG CO BAP");
    private final String name;

    eTarget(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
