package eNum;

public enum eGender {
    MALE("Male"), FEMALE("Female");

    private final String name;

    eGender(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
