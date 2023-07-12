package view;
import services.LoginService;
import utils.GetValue;
public class LoginView {
    private static int choose;
    private static LoginService loginService = new LoginService();

    public static void main(String[] args) {
        loginView();
    }

    public static void loginView() {
        printMenu();
        choose = GetValue.getInt("Enter your choice: ");
        switch (choose) {
            case 1:
                loginUser();
                break;
            case 2:
                register();
                break;
            case 0:
                System.exit(0);
                break;
            default:
                loginView();
                break;
        }
        loginView();
    }

    public static void printMenu() {
        System.out.println("               ===================================");
        System.out.println("               |            Fitness - App        |");
        System.out.println("               ===================================");
        System.out.println("               | Options:                        |");
        System.out.println("               |        1. Account login         |");
        System.out.println("               |        2. Register              |");
        System.out.println("               |        0. Back to program       |");
        System.out.println("               ===================================");
    }
    public static void loginUser() {
        System.out.println("               ===================================");
        System.out.println("               |               Login             |");
        System.out.println("               ===================================");
        System.out.println("               | Options:                        |");
        System.out.println("               |        1. Login                 |");
        System.out.println("               |        0. Back to program       |");
        System.out.println("               ===================================");
        choose = GetValue.getInt("Enter your choice: ");
        switch (choose) {
            case 1:
                login();
                break;
            case 0:
                loginView();
                break;
            default:
                loginUser();
                break;
        }
        loginUser();
    }
    private static void login() {
        String userName = GetValue.getString("Nhap userName: ");
        String passWord = GetValue.getString("Nhap passWord: ");
        loginService.checkLogin(userName,passWord);
    }
    private static void register() {
        loginService.createUser();
    }
}

