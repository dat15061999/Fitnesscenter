package utils;

import java.util.Scanner;

public class GetValue {
    public static Scanner input = new Scanner(System.in);
    public static int choose = -1;

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
    public static int getPhone (String str) {
        try {
            choose = Integer.parseInt(GetValue.getString(str));
            if (choose < 1 || choose > 1000000) {
                throw new NumberFormatException("Phone invalid: Phone to 1 from 1000000 ");
            }
            return choose;
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return getInt(str);
        }
    }
    public static int getCccd (String str) {
        try {
            choose = Integer.parseInt(GetValue.getString(str));
            if (choose < 1 || choose > 1000000) {
                throw new NumberFormatException("CCCD invalid: CCCD to 1 from 1000000 ");
            }
            return choose;
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return getInt(str);
        }
    }
}
