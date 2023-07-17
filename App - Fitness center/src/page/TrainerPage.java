package page;
import utils.GetValue;
import static services.BillService.printTrainerSchedule;
import static services.BillService.scheduleConfirm;
import static services.TrainerService.*;
import static view.LoginView.loginUser;
import static view.LoginView.loginView;
public class TrainerPage {

    public static int choose;
    public static void main(String[] args) {
            trainerPage("thanhpt");
    }

    public static void trainerPage(String userName) {
        printMenu();
        choose = GetValue.getInt("Enter your choice: ");
        switch (choose) {
            case 1:
                System.out.println("THÔNG TIN COACH");
                printTrainerPersonal(userName);
                break;
            case 2:
                System.out.println("Thay doi thong tin tai khoan");
                changeTrainerInf(userName);
                break;
            case 3:
                System.out.println("Thong tin khach hang va lich huan luyen ");
                printTrainerSchedule(userName,"CONFIRMED");
                break;
            case 4:
                System.out.println("Xac nhan lich huan luyen");
                printTrainerSchedule(userName,"CONFIRMING");
                System.out.println();
                printConfirmMenu();
                choose = GetValue.getInt("Enter your choice: ");
                scheduleConfirm(userName,"CONFIRMING",choose);
                break;
            case 5:
                confirmWorkDay(userName);
                break;
            case 6:
                System.out.println("BANG TINH LUONG "+ GetValue.getMonthNow());
                printTotalSalary(userName);
                break;
            case 0:
                loginUser();
                break;
            default:
                trainerPage(userName);
                break;
        }
        trainerPage(userName);
    }

    private static void printMenu() {
        System.out.println("               ===================================");
        System.out.println("               |           Trainer page          |");
        System.out.println("               ===================================");
        System.out.println("               | Options:                        |");
        System.out.println("               |        1. Account               |");
        System.out.println("               |        2. Change information    |");
        System.out.println("               |        3. Schedule Work         |");
        System.out.println("               |        4. Confirmation schedule |");
        System.out.println("               |        5. Timekeeping           |");
        System.out.println("               |        6. Salary                |");
        System.out.println("               |        0. Log Out               |");
        System.out.println("               ===================================");
    }
    private static void printConfirmMenu() {
        System.out.println("               ===================================");
        System.out.println("               |              CONFIRM            |");
        System.out.println("               ===================================");
        System.out.println("               | Options:                        |");
        System.out.println("               |        1. Confirmed             |");
        System.out.println("               |        2. Unconfirmed           |");
        System.out.println("               |        0. Back to program       |");
        System.out.println("               ===================================");
    }


}
