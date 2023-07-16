package services;
import models.Client;
import models.User;
import utils.AppUtils;
import utils.CRUD;
import utils.GetValue;
import utils.SerializationUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import static page.ClientPage.choose;
import static page.ClientPage.clientPage;
import static services.BillService.billList;
import static view.BillView.billView;
import static view.ClientView.clientView;
import static view.ClientView.printClient;


public class ClientService implements CRUD<Client>, Serializable {
    private static final long serialVersionUID = 3055276268292339966L;
    public static List<Client> clientList;
    public static int nextIdClient;
    public static String addressClient = "clients.txt";

    static {
        clientList = (List<Client>) SerializationUtil.deserialize(addressClient);
        if (clientList == null) {
            clientList = new ArrayList<>();
        }
        nextIdClient = AppUtils.findNext(clientList.stream().map(User::getId).collect(Collectors.toList()));
    }

    private static void save() {
        SerializationUtil.serialize(clientList, addressClient);
    }

    @Override
    public void create(Client client) {
        client.setId(nextIdClient);
        client.setName(GetValue.getString("Nhap ten khach hang"));
        client.setUsername(AppUtils.checkClient(GetValue.getString("Nhap userName"), clientList));
        client.setPassword(GetValue.getString("Nhap passWord"));
        client.setAge(GetValue.getInt("Nhap tuoi"));
        client.setPhone(GetValue.getPhone("Nhap so dien thoai"));
        client.setCccd(GetValue.getCccd("Nhap cccd"));
        client.setAddress(GetValue.getString("Nhap dia chi"));
        client.setEmail(GetValue.getString("Nhap email"));
        client.setGender(GetValue.getGender("Chon gioi tinh"));
        client.setHeight(GetValue.getDou("Nhap chieu cao"));
        client.setWeight(GetValue.getDou("Nhap can nang"));
        client.setStatusBmi(client.getStatusBmi());
        client.setRole(client.getRole());
        client.setTarget(GetValue.getTarget("Chon muc tieu huan luyen"));
        client.setScheduleClient(GetValue.getClientSchedule("Chon lich trinh huan luyen"));
        client.setStateOfStrength(GetValue.getString("Nhap tinh trang suc khoe"));
        System.out.println("Dang ky khach hang thanh cong!");
        clientList.add(client);
        save();
    }

    @Override
    public void delete(int idClient) {
        Client clientDelete = null;
        for (Client client : clientList) {
            if (idClient == client.getId()) {
                clientDelete = client;
                System.out.println("Xoa Client co id la " + idClient + " thanh cong.");
                break;
            }
        }
        clientList.remove(clientDelete);
        save();
    }

    @Override
    public void update(int idClient) {
        for (Client client : clientList) {
            if (idClient == client.getId()) {
                printMenuUpdate();
                choose = GetValue.getInt("Enter your choice :");
                switch (choose) {
                    case 1:
                        client.setName(GetValue.getString("Nhap ten moi :"));
                        client.setUsername(AppUtils.checkClient(GetValue.getString("Nhap userName"), clientList));
                        client.setPassword(GetValue.getString("Nhap passWord :"));
                        client.setAge(GetValue.getInt("Nhap tuoi"));
                        client.setPhone(GetValue.getPhone("Nhap so dien thoai"));
                        client.setCccd(GetValue.getCccd("Nhap cccd"));
                        client.setAddress(GetValue.getString("Nhap dia chi"));
                        client.setEmail(GetValue.getString("Nhap emali :"));
                        client.setGender(GetValue.getGender("Nhap gioi tinh :"));
                        System.out.println("Thay doi thong tin khach hang thanh cong!");
                    break;
                    case 2:  //  weight, height, String.format("%.6f", bmi), status, target, stateOfStrength);
                        client.setWeight(GetValue.getDou("Nhap trong luong "));
                        client.setHeight(GetValue.getDou("Nhap chieu cao "));
                        client.setTarget(GetValue.getTarget("Chon muc tieu"));
                        client.setStateOfStrength(GetValue.getString("Nhap tinh trang suc khoe"));
                        client.setBmi(client.getBmi());
                        client.setStatusBmi(client.getStatusBmi());
                        client.setScheduleClient(GetValue.getClientSchedule("Chon lich trinh huan luyen"));
                        System.out.println("Thay doi thong tin huan luyen cua khach hang thanh cong!");
                    break;
                    case 0:
                        clientView();
                        break;
                    default:
                        update(idClient);
                        break;
                }
                update(idClient);
            }
        }
            save();
    }

    @Override
    public List<Client> readFile() {
        return clientList;
    }

    @Override
    public void getAll() {
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("|                                                                          Client List                                                                                                                                                                                |");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-4s | %-20s | %-10s | %-10s |  %-4s  | %-20s | %-10s | %-10s | %-20s | %-8s | %-8s | %-10s | %-15s | %-15s | %-10s | %-10s | %-10s | %-12s |\n",
                "ID", "Name", "Username", "Password", "Age", "Email", "Role", "Phone", "Address", "Gender", "Weight", "Height", "BMI", "Status BMI", "Target", "Schedule", "Strength","Member Card");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        for (Client client : clientList) {
            System.out.println(client);
        }
    }

    public static void clientPersonal(String userName) {
        if (clientList.stream().anyMatch(e -> e.getUsername().equals(userName))) {
            Client client = getByUserNameCLient(userName);
            System.out.printf("| %-20s | %-10s | %-10s |  %-4s  | %-20s | %-10s | %-20s | %-8s | %-8s | %-10s | %-15s | %-15s | %-10s | %-10s | %-10s | %-12s |\n",
                    "Name", "Username", "Password", "Age", "Email", "Phone", "Address", "Gender", "Weight", "Height", "BMI", "Status", "Target", "Schedule", "Strength","Member Card");
            String formattedString = String.format("| %-20s | %-10s | %-10s |  %-4s  | %-20s | %-10s | %-20s | %-8s | %-8s | %-10s | %-15s | %-15s | %-10s | %-10s | %-10s | %-12s |\n",
                    client.getName(), client.getUsername(), client.getPassword().getPasscode(),
                    String.valueOf(client.getAge()), client.getEmail(), client.getPhone(),
                    client.getAddress(), client.getGender(), client.getWeight(), client.getHeight(),
                    String.format("%.6f", client.getBmi()), client.getStatusBmi(), client.getTarget(),
                    client.getScheduleClient(), client.getStateOfStrength(),client.getStatusMember());
            System.out.println(formattedString);
        }
    }


    public static void changeInf(String userName) {
        for (Client client : clientList) {
            if (client.getUsername().equals(userName)) {
                printMenuUpdate();
                choose = GetValue.getInt("Enter your choice :");
                switch (choose) {
                    case 1:
                        client.setName(GetValue.getString("Nhap ten moi :"));
                        client.setUsername(AppUtils.checkClient(GetValue.getString("Nhap userName"), clientList));
                        client.setPassword(GetValue.getString("Nhap passWord :"));
                        client.setAge(GetValue.getInt("Nhap tuoi"));
                        client.setPhone(GetValue.getPhone("Nhap so dien thoai"));
                        client.setCccd(GetValue.getCccd("Nhap cccd"));
                        client.setAddress(GetValue.getString("Nhap dia chi"));
                        client.setEmail(GetValue.getString("Nhap emali :"));
                        client.setGender(GetValue.getGender("Nhap gioi tinh :"));
                        System.out.println("Thay doi thong tin khach hang thanh cong!");
                        break;
                    case 2:
                        client.setWeight(GetValue.getDou("Nhap trong luong "));
                        client.setHeight(GetValue.getDou("Nhap chieu cao "));
                        client.setTarget(GetValue.getTarget("Chon muc tieu"));
                        client.setStateOfStrength(GetValue.getString("Nhap tinh trang suc khoe"));
                        client.setBmi(client.getBmi());
                        client.setStatusBmi(client.getStatusBmi());
                        client.setScheduleClient(GetValue.getClientSchedule("Chon lich trinh huan luyen"));
                        System.out.println("Thay doi thong tin huan luyen cua khach hang thanh cong!");
                        break;
                    case 0:
                        clientPage(userName);
                        break;
                    default:
                        changeInf(userName);
                        break;
                }
                changeInf(userName);
            }

        }
        save();
    }

    public static void printMenuUpdate() {
        System.out.println("1. Sua thong tin khach hang");
        System.out.println("2. Sua thong tin huan luyen khach hang");
        System.out.println("0. Back to program");
    }

    public static Client createClientOfBill() {
        printCreateClientBill();
        choose = GetValue.getInt("Enter your choice :");
        switch (choose) {
            case 1:
                printClient();
                return AppUtils.checkBill(GetValue.getInt("Chon id khach hang"), billList, clientList);
            case 2:
                Client client = new Client();
                client.setId(nextIdClient);
                client.setName(GetValue.getString("Nhap ten khach hang"));
                client.setUsername(AppUtils.checkClient(GetValue.getString("Nhap userName"), clientList));
                client.setPassword(GetValue.getString("Nhap passWord"));
                client.setAge(GetValue.getInt("Nhap tuoi"));
                client.setPhone(GetValue.getPhone("Nhap so dien thoai"));
                client.setCccd(GetValue.getCccd("Nhap cccd"));
                client.setAddress(GetValue.getString("Nhap dia chi"));
                client.setEmail(GetValue.getString("Nhap email"));
                client.setGender(GetValue.getGender("Chon gioi tinh"));
                client.setHeight(GetValue.getDou("Nhap chieu cao"));
                client.setWeight(GetValue.getDou("Nhap can nang"));
                client.setStatusBmi(client.getStatusBmi());
                client.setRole(client.getRole());
                client.setTarget(GetValue.getTarget("Chon muc tieu huan luyen"));
                client.setScheduleClient(GetValue.getClientSchedule("Chon lich trinh huan luyen"));
                client.setStateOfStrength(GetValue.getString("Nhap tinh trang suc khoe"));
                System.out.println("Dang ky khach hang thanh cong!");
                clientList.add(client);
                save();
                return client;
            case 0:
                billView();
                break;
        }
        return createClientOfBill();
    }

    public static void printCreateClientBill() {
        System.out.println("               ===================================");
        System.out.println("               |           Crate Bill            |");
        System.out.println("               ===================================");
        System.out.println("               | Options:                        |");
        System.out.println("               |        1. Chon khach hang       |");
        System.out.println("               |        2. Them khach hang moi   |");
        System.out.println("               |        0. Back to program       |");
        System.out.println("               ===================================");
    }

    public static Client getByUserNameCLient(String userName) {
        return clientList.stream()
                .filter(e -> e.getUsername().equals(userName))
                .findFirst()
                .orElse(null);
    }

    public static String setStatusClient(int idClient,String statusMember) {
         clientList.stream().
                filter(e -> e.getId() == (idClient)).
                forEach(e->e.setStatusMember(statusMember));
         save();
         return clientList.stream().filter(e->e.getId() == (idClient)).
                 map(Client::getStatusMember)
                .findFirst()
                .orElse(null);
    }

}



