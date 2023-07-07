package eNum;

public enum eTrainerSchedule {
    SANG1("6H 2-4-6"),SANG2("6H 3-5-7"),CHIEU1("15H 2-4-6"),CHIEU2("15H 3-5-7");
    private final String name;

    eTrainerSchedule(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
