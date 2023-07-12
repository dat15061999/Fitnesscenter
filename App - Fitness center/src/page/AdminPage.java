package page;
import utils.GetValue;
import static services.AdminService.historyLogin;
import static view.LoginView.loginView;
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
                //trainerView();
                break;
            case 4:
                //trainerView();
                break;
            case 5:
                //trainerView();
                break;
            case 6:
                historyLogin();
                break;
            case 0:
                loginView();
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
        System.out.println("               |        4. Updating              |");
        System.out.println("               |        5. History login         |");
        System.out.println("               |        0. Log Out               |");
        System.out.println("               ===================================");
    }


}
