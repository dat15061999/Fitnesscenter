package page;
import models.Bill;
import utils.GetValue;
import static services.BillService.*;
import static services.ClientService.changeInf;
import static services.ClientService.clientPersonal;
import static view.LoginView.loginUser;

public class ClientPage {
    public static int choose;
    public static void main(String[] args) {
        clientPage("thi123");
    }
    public static void clientPage(String userName) {
            clientMenu();
            choose = GetValue.getInt("Enter your choice:");
            switch (choose) {
                case 1:
                    clientPersonal(userName);
                    break;
                case 2:
                    changeInf(userName);
                    break;
                case 3:
                    printMemberCard(userName);
                    break;
                case 4:
                    registerMember(userName);
                    break;
                case 5:
                    System.out.println("THONG TIN HUAN LUYEN");
                    //registerMember(userName);
                    break;
                case 0:
                    loginUser();
                    break;
                default:
                    clientPage(userName);
                    break;
            }
        clientPage(userName);
    }

    private static void clientMenu() {
        System.out.println("               =====================================");
        System.out.println("               |           Client Page             |");
        System.out.println("               =====================================");
        System.out.println("               | Options:                          |");
        System.out.println("               |        1. Personal information    |");
        System.out.println("               |        2. Change information      |");
        System.out.println("               |        3. Member card             |");
        System.out.println("               |        4. Membership registration |");
        System.out.println("               |        0. Log Out                 |");
        System.out.println("               =====================================");
    }
    private static void printRegisterMember() {
        System.out.println("               =====================================");
        System.out.println("               |           REGISTER MEMBER         |");
        System.out.println("               =====================================");
        System.out.println("               | Options:                          |");
        System.out.println("               |        1. Register member         |");
        System.out.println("               |        2. Change COACH            |");
        System.out.println("               |        2. Change product          |");
        System.out.println("               |        0. Back to program         |");
        System.out.println("               =====================================");
    }
    private static void registerMember(String userName) {
        printRegisterMember();
        choose= GetValue.getInt("Enter your choice :");
        switch (choose) {
            case 1:
                registerMemberCard(userName, new Bill());
                break;
            case 2:
                changeCoach(userName);
                break;
            case 3:
                changeProduct(userName);
                break;
            case 0:
                clientPage(userName);
                break;
        }
        registerMember(userName);
    }

}


