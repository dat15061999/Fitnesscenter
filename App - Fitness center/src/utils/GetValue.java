package utils;

import java.util.Scanner;

public class GetValue {
    public static Scanner input = new Scanner(System.in);
    public static int choose;

    public static String getString(String str) {
        System.out.println(str);
        return input.nextLine();
    }
    public static int getInt (String str) {
        try {
            choose = Integer.parseInt(GetValue.getString(str));
            if (choose < 0 || choose > 1000) {
                throw new NumberFormatException("Number invalid");
            }
            return choose;
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return getInt(str);
        }
    }
}
