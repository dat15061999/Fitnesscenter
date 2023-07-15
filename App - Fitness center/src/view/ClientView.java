package view;
import eNum.eRole;
import models.Client;
import services.ClientService;
import utils.GetValue;
import utils.SerializationUtil;
import java.util.List;

import static services.ClientService.clientList;
import static view.UserView.userView;

public class ClientView {
    private static int choose;
    public static ClientService clientService = new ClientService();

    static {
        clientService.readFile();
    }

    public static void clientView() {
        printMenu();
        choose = GetValue.getInt("Enter your choice:");
        switch (choose) {
            case 1:
                addClient();
                break;
            case 2:
                deleteClient();
                break;
            case 3:
                updateClient();
                break;
            case 4:
                printClient();
                break;
            case 5:
                System.exit(5);
                break;
            case 0:
                userView();
                break;
            default:
                clientView();
                break;
        }
        clientView();
    }

    private static void printMenu() {
        System.out.println("               ===================================");
        System.out.println("               |           Client List           |");
        System.out.println("               ===================================");
        System.out.println("               | Options:                        |");
        System.out.println("               |        1. Create Client         |");
        System.out.println("               |        2. Delete Client         |");
        System.out.println("               |        3. Update Client         |");
        System.out.println("               |        4. Print Client List     |");
        System.out.println("               |        5. Exit All              |");
        System.out.println("               |        0. Back to program       |");
        System.out.println("               ===================================");
    }


    public static void addClient() {
        System.out.println("Dang ky khach hang moi");
        clientService.create(new Client());
    }
    private static void deleteClient() {
        clientService.delete(GetValue.getInt("Nhap id khach hang can xoa"));
    }

    private static void updateClient() {
        clientService.update(GetValue.getInt("Nhap id khach hang can chinh sua"));
    }

    public static void printClient() {
       clientService.getAll();
    }
}
