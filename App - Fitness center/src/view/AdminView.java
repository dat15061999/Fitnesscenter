package view;

import utils.GetValue;

public class AdminView {
    public static int choose;
    public static void main(String[] args) {
        do {
            switch (adminMenu()) {
                case 1:

            }
        } while(choose != 0);
    }
    private static int adminMenu() {
        System.out.println("               ===================================");
        System.out.println("               |            Admin Page           |");
        System.out.println("               ===================================");
        System.out.println("               | Options:                        |");
        System.out.println("               |        1. User management       |");
        System.out.println("               |        2. Trainer management    |");
        System.out.println("               |        3. Product               |");
        System.out.println("               |        4. Payment               |");
        System.out.println("               |        5. Updating              |");
        System.out.println("               |        0. Exit to program       |");
        System.out.println("               ===================================");
        return GetValue.getInt( "Enter your choice:");
    }

}
