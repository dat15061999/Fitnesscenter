package utils;

import eNum.eCoachingStyle;
import eNum.eGender;
import eNum.eTarget;
import eNum.eTrainerSchedule;

import java.util.Scanner;

public class GetValue {
    public static Scanner input = new Scanner(System.in);
    public static int choose = -1;

    public static String getString(String str) {
        System.out.println(str);
        return input.nextLine();
    }

    public static int getInt(String str) {
        try {
            choose = Integer.parseInt(GetValue.getString(str));
            if (choose < 0 || choose > 100000000) {
                throw new NumberFormatException("Number invalid");
            }
            return choose;
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return getInt(str);
        }
    }
    public static double getDou(String str) {
        double choice = 0;
        try {
            choice = Double.parseDouble(GetValue.getString(str));
            if (choice < 0 || choice > 1000000) {
                throw new NumberFormatException("Double NumberOfType invalid");
            }
            return choice;
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return getDou(str);
        }
    }

    public static int getPhone(String str) {
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

    public static int getCccd(String str) {
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

    public static String getGender(String str) {
        try {
            System.out.println(str);
            System.out.println("1. Male");
            System.out.println("2. FeMale");
            System.out.println("3. Other");
            choose = Integer.parseInt(getString("Enter your choice: "));
            if (choose < 0 || choose > 1000) {
                throw new NumberFormatException("Number invalid");
            }
            switch (choose) {
                case 1:
                    return eGender.MALE.getName();
                case 2:
                    return eGender.FEMALE.getName();
                case 3:
                    return eGender.ORTHERS.getName();
            }
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return getGender(str);
        }

        return getGender(str);
    }

    public static String getStyle(String str) {
        try {
            System.out.println(str);
            System.out.println("1. Strong");
            System.out.println("2. Healthy");
            System.out.println("3. Men");
            System.out.println("4. Young");
            choose = Integer.parseInt(getString("Enter your choice: "));
            if (choose < 0 || choose > 1000) {
                throw new NumberFormatException("Number invalid");
            }
            switch (choose) {
                case 1:
                    return eCoachingStyle.STRONG.getName();
                case 2:
                    return eCoachingStyle.HEALTHY.getName();
                case 3:
                    return eCoachingStyle.MEN.getName();
                case 4:
                    return eCoachingStyle.YOUNG.getName();
            }
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return getStyle(str);
        }
        return getStyle(str);
    }

    public static void main(String[] args) {
        System.out.println(getStyle("123"));
    }
    public static String[] getSchedule(String str) {
        try {
            System.out.println(str);
            System.out.println("1. Sang 1 (6H 2-4-6) va Chieu 1 (15H 2-4-6)");
            System.out.println("2. Sang 1 (6H 2-4-6) va Chieu 2 (15H 3-5-7)");
            System.out.println("3. Sang 2 (15H 3-5-7) va Chieu 1 (15H 2-4-6)");
            System.out.println("4. Sang 2 (15H 3-5-7) va Chieu 2 (15H 3-5-7)");
            choose = Integer.parseInt(getString("Enter your choice: "));
            if (choose < 0 || choose > 1000) {
                throw new NumberFormatException("Number invalid");
            }
            switch (choose) {
                case 1:
                    return new String[] { eTrainerSchedule.SANG1.getName(),eTrainerSchedule.CHIEU1.getName() };
                case 2:
                    return new String[] { eTrainerSchedule.SANG1.getName(),eTrainerSchedule.CHIEU2.getName() };
                case 3:
                    return new String[] { eTrainerSchedule.SANG2.getName(),eTrainerSchedule.CHIEU1.getName() };
                case 4:
                    return new String[] { eTrainerSchedule.SANG2.getName(),eTrainerSchedule.CHIEU2.getName() };
            }
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return getSchedule(str);
        }
        return getSchedule(str);
    }
    public static String getTarget(String str) {
        try {
            System.out.println(str);
            System.out.println("1. Tang can");
            System.out.println("2. Giam can");
            System.out.println("3. Tang co bap");
            choose = Integer.parseInt(getString("Enter your choice: "));
            if (choose < 0 || choose > 1000) {
                throw new NumberFormatException("Number invalid");
            }
            switch (choose) {
                case 1:
                    return eTarget.WEIGHT_AGAIN.getName();
                case 2:
                    return eTarget.LOSING_WEIGHT.getName();
                case 3:
                    return eTarget.MUSCLE_AGAIN.getName();
            }
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return getTarget(str);
        }
        return getTarget(str);
    }


}
