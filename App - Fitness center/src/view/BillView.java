package view;

import services.BillService;
import utils.GetValue;

import static view.UserView.userView;


public class BillView {
    private static BillService billService = new BillService();
    static {
        billService.readFile();
    }
    private static int choose;
    public static void billView() {
        printMenu();
        choose = GetValue.getInt("Enter your choice:");
        switch (choose) {
            case 1:
                //addProduct();
                break;
            case 2:
                //deleteProduct();
                break;
            case 3:
                //updateProduct();
                break;
            case 4:
                printBill();
                break;
            case 5:
                System.exit(5);
                break;
            case 0:
                userView();
                break;
            default:
                billView();
                break;
        }
        billView();
    }

    public static void main(String[] args) {
        billView();
    }
    private static void printMenu() {
        System.out.println("               ===================================");
        System.out.println("               |              Bill List          |");
        System.out.println("               ===================================");
        System.out.println("               | Options:                        |");
        System.out.println("               |        1. Create Bill           |");
        System.out.println("               |        2. Delete Bill           |");
        System.out.println("               |        3. Update Bill           |");
        System.out.println("               |        4. Print all Bill        |");
        System.out.println("               |        5. Exit All              |");
        System.out.println("               |        0. Back to program       |");
        System.out.println("               ===================================");
    }
    private static void printBill() {
        billService.getAll();
    }
}
