package page;
import utils.GetValue;

import static services.ClientService.changeInf;
import static services.ClientService.clientPersonal;
import static view.ClientView.clientService;
import static view.LoginView.loginView;
public class ClientPage {
    public static int choose;
    public static void main(String[] args) {
        clientPage("nam123");
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
                    //trainerView();
                    break;
                case 0:
                    loginView();
                    break;
                default:
                    clientPage(userName);
                    break;
            }
        clientPage(userName);
    }

    private static void clientMenu() {
        System.out.println("               ===================================");
        System.out.println("               |           Client Page           |");
        System.out.println("               ===================================");
        System.out.println("               | Options:                        |");
        System.out.println("               |        1. Personal information  |");
        System.out.println("               |        2. Change information    |");
        System.out.println("               |        3. Member card           |");
        System.out.println("               |        4. Product shop          |");
        System.out.println("               |        5. Your schedule         |");
        System.out.println("               |        0. Log Out               |");
        System.out.println("               ===================================");

    }

}


