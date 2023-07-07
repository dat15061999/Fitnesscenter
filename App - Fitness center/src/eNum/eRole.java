package eNum;

public enum eRole {
    ADMIN("Admin"),CLIENT("Client"),PT("Trainer");
    private final String name;

    eRole(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
