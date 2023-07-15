package view;
import utils.GetValue;
import static page.AdminPage.adminPage;
import static view.AdminView.adminView;
import static view.ClientView.clientView;
import static view.TrainerView.trainerView;

public class UserView {
    public static int choose;

    public static void main(String[] args) {
        clientView();
    }


    public static void userView() {
        printMenuView();
        choose = GetValue.getInt("Enter your choice:");
        switch (choose) {
            case 1:
                adminView();
                break;
            case 2:
                trainerView();
                break;
            case 3:
                clientView();
                break;
            case 0:
                adminPage();
                break;
            default:
                userView();
                break;
        }
        userView();
    }

    private static void printMenuView() {
        System.out.println("               ===================================");
        System.out.println("               |            UserVIew             |");
        System.out.println("               ===================================");
        System.out.println("               | Options:                        |");
        System.out.println("               |        1. Admin                 |");
        System.out.println("               |        2. Trainer               |");
        System.out.println("               |        3. Client                |");
        System.out.println("               |        4. Updating              |");
        System.out.println("               |        0. Back to program       |");
        System.out.println("               ===================================");
    }


}

