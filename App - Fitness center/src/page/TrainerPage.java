package page;
import utils.GetValue;
import static services.TrainerService.*;
import static view.LoginView.loginView;
public class TrainerPage {

    public static int choose;
    public static void main(String[] args) {
        trainerPage("thanhpt");
    }

    public static void trainerPage(String userName) {
        trainerMenu();
        choose = GetValue.getInt("Enter your choice: ");
        switch (choose) {
            case 1:
                trainerPersonal(userName);
                break;
            case 2:
                changeTrainerInf(userName);
                break;
            case 3:
                //trainerCard();
                break;
            case 4:
                //scheduleConfirm();
                break;
            case 0:
                loginView();
                break;
            default:
                trainerPage(userName);
                break;
        }
        trainerPage(userName);
    }

    private static void trainerMenu() {
        System.out.println("               ===================================");
        System.out.println("               |           Trainer Page          |");
        System.out.println("               ===================================");
        System.out.println("               | Options:                        |");
        System.out.println("               |        1. Personal information  |");
        System.out.println("               |        2. Change information    |");
        System.out.println("               |        3. Trainer Card          |");
        System.out.println("               |        4. Schedule Confirmation |");
        System.out.println("               |        0. Log Out               |");
        System.out.println("               ===================================");
    }


}
