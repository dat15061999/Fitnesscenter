package view;
import models.Admin;
import services.AdminService;
import utils.GetValue;
import static view.UserView.userView;

public class AdminView {
    public static AdminService adminService = new AdminService();
    public static int choose;
    public static String address = "admin.txt";

    static {
        adminService.readFile();
    }

    public static void adminView() {
        printMenu();
        choose = GetValue.getInt("Enter your choice:");
        switch (choose) {
            case 1:
                addAdmin();
                break;
            case 2:
                deleteAdmin();
                break;
            case 3:
                updateAdmin();
                break;
            case 4:
                printAdmin();
                break;
            case 5:
                System.exit(5);
                break;
            case 0:
                userView();
                break;
            default:
                adminView();
                break;
        }
        adminView();
    }

    private static void printMenu() {
        System.out.println("               ===================================");
        System.out.println("               |             Admin List          |");
        System.out.println("               ===================================");
        System.out.println("               | Options:                        |");
        System.out.println("               |        1. Create admin          |");
        System.out.println("               |        2. Delete admin          |");
        System.out.println("               |        3. Update admin          |");
        System.out.println("               |        4. Print All             |");
        System.out.println("               |        5. Exit All              |");
        System.out.println("               |        0. Back to program       |");
        System.out.println("               ===================================");

    }

    private static void addAdmin() {
        adminService.create(new Admin());
    }
    private static void deleteAdmin() {
        adminService.delete(GetValue.getInt("Nhap id muon xoa"));
    }

    private static void updateAdmin() {
        adminService.update(GetValue.getInt("Nhap id muon update"));
    }

    private static void printAdmin() {
       adminService.getAll();
    }
}
