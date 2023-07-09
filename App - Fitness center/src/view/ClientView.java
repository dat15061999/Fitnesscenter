package view;

import eNum.eRole;
import models.Client;
import models.Trainer;
import services.ClientService;
import utils.GetValue;
import utils.SerializationUtil;

import java.util.List;

public class ClientView {
    private static int choose = -1;
    static ClientService clientService = new ClientService();

    public static void main(String[] args) {
        clientService.readFile();
        clientView();
    }

    public static void clientView() {
        do {
            switch (clientMenu()) {
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
            }
        } while (choose != 0);
    }

    private static int clientMenu() {
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
        return choose = GetValue.getInt("Enter your choice:");
    }
    private static void addClient() {
        List<Client> clients = clientService.readFile();
        int max=0;
        for (Client client: clients) {
            if(client.getId() > max) {
                max = client.getId();
            }
        }
        ++max;
        //, double height, double weight, String target, String stateOfStrength
        clientService.create(new Client(max,GetValue.getString("Nhap ten khach hang"),GetValue.getString("Nhap userName"),GetValue.getString("Nhap passWord"),GetValue.getInt("Nhap tuoi"),GetValue.getPhone("Nhap so dien thoai"),GetValue.getCccd("Nhap cccd"),GetValue.getString("Nhap dia chi"),GetValue.getString("Nhap email"),GetValue.getGender("Chon gioi tinh"), eRole.PT.getName()
                ,GetValue.getDou("Nhap chieu cao"),GetValue.getDou("Nhap can nang"),GetValue.getTarget("Chon muc tieu huan luyen"),GetValue.getString("Nhap tinh trang suc khoe")));
        SerializationUtil.serialize(clientService.getAll(),"clients.txt");
    }
    private static void deleteClient() {
        clientService.delete(GetValue.getInt("Nhap id khach hang can xoa"));
        SerializationUtil.serialize(clientService.getAll(),"clients.txt");
    }
    private static void updateClient() {
        clientService.update(GetValue.getInt("Nhap id khach hang can chinh sua"));
        SerializationUtil.serialize(clientService.getAll(),"clients.txt");
    }
    private static void printClient() {
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("|                                                                          Client List                                                                                                                                          |");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-4s | %-10s | %-10s | %-10s |  %-4s  | %-20s | %-10s | %-10s | %-20s | %-8s | %-8s | %-10s | %-15s | %-15s | %-10s | %-10s |\n",
                "ID", "Name", "Username", "Password","Age", "Email", "Role", "Phone", "Address","Gender","Weight","Height","BMI","Status","Target","Strength");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        List<Client> clientList = clientService.getAll();
        if (clientList != null) {
            for (Client client : clientList) {
                System.out.println(client);
            }
        } else {
            System.out.println("Client list is empty.");
        }
    }
}
