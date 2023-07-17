package page;
import utils.GetValue;
import static services.AdminService.printHistoryLogin;
import static services.BillService.*;
import static view.BillView.billView;
import static view.LoginView.loginUser;
import static view.ProductView.productView;
import static view.UserView.userView;
public class AdminPage {
    public static int choose;

    public static void main(String[] args) {
        adminPage();
    }

    public static void adminPage() {
        printMenu();
        choose = GetValue.getInt("Enter your choice:");
        switch (choose) {
            case 1:
                userView();
                break;
            case 2:
                productView();
                break;
            case 3:
                billView();
                break;
            case 4:
                payPage();
                break;
            case 5:
                printHistoryLogin();
                break;
            case 0:
                loginUser();
                break;
        }
        adminPage();
    }

    private static void printMenu() {
        System.out.println("               ===================================");
        System.out.println("               |            Admin Page           |");
        System.out.println("               ===================================");
        System.out.println("               | Options:                        |");
        System.out.println("               |        1. User management       |");
        System.out.println("               |        2. Product management    |");
        System.out.println("               |        3. Bill management       |");
        System.out.println("               |        4. Payments              |");
        System.out.println("               |        5. History login         |");
        System.out.println("               |        0. Log Out               |");
        System.out.println("               ===================================");
    }
    private static void payPage() {
        menuPayment();
        choose = GetValue.getInt("Enter your choice :");
        switch (choose) {
            case 1:
                System.out.println("Danh sach cac don hang da thanh toan!");
                payments("PAID");
                break;
            case 2:
                payments("UNPAID");
                choose = GetValue.getInt("Nhap id muon thanh toan !");
                confirmPayments(choose);
                break;
            case 3:
                getRevenueAllYear();
            case 0:
                adminPage();
                break;
        }
        payPage();
    }

    private static void menuPayment() {
        System.out.println("               ===================================");
        System.out.println("               |            Pay Page             |");
        System.out.println("               ===================================");
        System.out.println("               | Options:                        |");
        System.out.println("               |        1. History payments      |");
        System.out.println("               |        2. Confirmed             |");
        System.out.println("               |        3. Revenue by year       |");
        System.out.println("               |        0. Back on program       |");
        System.out.println("               ===================================");
    }


}
