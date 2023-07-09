package eNum;

public enum eStatusTrainer {
    AVAILABLE("SAN SANG"),UNAVAILABLE("KIN LICH");
    private final String name;

    eStatusTrainer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
