package view;

import models.Bill;
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
                createBill();
                break;
            case 2:
                //deleteBill();
                break;
            case 3:
                updateBill();
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

    private static void createBill() {
        billService.create(new Bill());
    }

    private static void updateBill() {
        printUpdate();
        choose = GetValue.getInt("Enter your choice :");
        switch (choose) {
            case 1:
                printBill();
                billService.update(GetValue.getInt("Chon id bill can sua"));
                break;
            case 2:
                printBill();
                billService.updateProduct(GetValue.getInt("Chon id bill can sua"));
                break;
            case 0:
                billView();
                break;
        }
        updateBill();
    }


    private static void printUpdate() {
        System.out.println("               ===================================");
        System.out.println("               |           Bill Update           |");
        System.out.println("               ===================================");
        System.out.println("               | Options:                        |");
        System.out.println("               |        1. Update Coach          |");
        System.out.println("               |        2. Update Product        |");
        System.out.println("               |        0. Back to program       |");
        System.out.println("               ===================================");
    }
}
