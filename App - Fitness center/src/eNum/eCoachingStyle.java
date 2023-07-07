package eNum;

public enum eCoachingStyle {
    STRONG("Strong"),HEALTHY("Healthy"),YOUNG("Young"),MENLY("Menly");
    private final String name;

    eCoachingStyle(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
