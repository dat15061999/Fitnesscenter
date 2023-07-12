package services;

import models.Client;
import models.User;
import utils.AppUtils;
import utils.CRUD;
import utils.GetValue;
import utils.SerializationUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static page.AdminPage.adminPage;
import static page.ClientPage.choose;
import static page.ClientPage.clientPage;
import static view.ClientView.clientView;
import static view.ClientView.printClient;


public class ClientService implements CRUD<Client> {
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
        client.setUserName(AppUtils.checkClient(GetValue.getString("Nhap userName"), clientList));
        client.setPassWord(GetValue.getString("Nhap passWord"));
        client.setAge(GetValue.getInt("Nhap tuoi"));
        client.setPhone(GetValue.getPhone("Nhap so dien thoai"));
        client.setCccd(GetValue.getCccd("Nhap cccd"));
        client.setAddress(GetValue.getString("Nhap dia chi"));
        client.setEmail(GetValue.getString("Nhap email"));
        client.setGender(GetValue.getGender("Chon gioi tinh"));
        client.setHeight(GetValue.getDou("Nhap chieu cao"));
        client.setWeight(GetValue.getDou("Nhap can nang"));
        client.setStatus(client.getStatus());
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
                        client.setUserName(GetValue.getString("Nhap userName :"));
                        client.setPassWord(GetValue.getString("Nhap passWord :"));
                        client.setAge(GetValue.getInt("Nhap tuoi"));
                        client.setPhone(GetValue.getPhone("Nhap so dien thoai"));
                        client.setCccd(GetValue.getCccd("Nhap cccd"));
                        client.setAddress(GetValue.getString("Nhap dia chi"));
                        client.setEmail(GetValue.getString("Nhap emali :"));
                        client.setGender(GetValue.getGender("Nhap gioi tinh :"));
                        System.out.println("Thay doi thong tin khach hang thanh cong!");
                        break;
                    case 2: //  weight, height, String.format("%.6f", bmi), status, target, stateOfStrength);
                        client.setWeight(GetValue.getDou("Nhap trong luong "));
                        client.setHeight(GetValue.getDou("Nhap chieu cao "));
                        client.setTarget(GetValue.getTarget("Chon muc tieu"));
                        client.setStateOfStrength(GetValue.getString("Nhap tinh trang suc khoe"));
                        client.setBmi(client.getBmi());
                        client.setStatus(client.getStatus());
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
            }
            save();
        }
    }

    @Override
    public List<Client> readFile() {
        return clientList;
    }

    @Override
    public Client find(int id) {
        return null;
    }

    @Override
    public void getAll() {
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("|                                                                          Client List                                                                                                                                                       |");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-4s | %-10s | %-10s | %-10s |  %-4s  | %-20s | %-10s | %-10s | %-20s | %-8s | %-8s | %-10s | %-15s | %-15s | %-10s | %-10s | %-10s |\n",
                "ID", "Name", "Username", "Password", "Age", "Email", "Role", "Phone", "Address", "Gender", "Weight", "Height", "BMI", "Status", "Target", "Schedule", "Strength");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        for (Client client : clientList) {
            System.out.println(client);
        }
    }

    public static void clientPersonal(String userName) {
        if (clientList != null) {
            for (Client client : clientList) {
                if (client.getUserName().equals(userName)) {
                    System.out.printf("| %-10s | %-10s | %-10s |  %-4s  | %-20s | %-10s | %-20s | %-8s | %-8s | %-10s | %-15s | %-15s | %-10s | %-10s | %-10s |\n",
                             "Name", "Username", "Password", "Age", "Email", "Phone", "Address", "Gender", "Weight", "Height", "BMI", "Status", "Target", "Schedule", "Strength");
                    String formattedString = String.format("| %-10s | %-10s | %-10s |  %-4s  | %-20s | %-10s | %-20s | %-8s | %-8s | %-10s | %-15s | %-15s | %-10s | %-10s | %-10s |\n",
                            client.getName(), client.getUserName(), client.getHiddenPassWord(), String.valueOf(client.getAge()), client.getEmail(), client.getPhone()
                            , client.getAddress(), client.getGender(), client.getWeight(), client.getHeight(), String.format("%.6f", client.getBmi()), client.getStatus(), client.getTarget(), client.getScheduleClient(), client.getStateOfStrength());
                    System.out.println(formattedString);
                }
            }
        }
    }

    public static void changeInf(String userName) {
        for (Client client : clientList) {
            if (client.getUserName().equals(userName)) {
                printMenuUpdate();
                choose = GetValue.getInt("Enter your choice :");
                switch (choose) {
                    case 1:
                        client.setName(GetValue.getString("Nhap ten moi :"));
                        client.setUserName(GetValue.getString("Nhap userName :"));
                        client.setPassWord(GetValue.getString("Nhap passWord :"));
                        client.setAge(GetValue.getInt("Nhap tuoi"));
                        client.setPhone(GetValue.getPhone("Nhap so dien thoai"));
                        client.setCccd(GetValue.getCccd("Nhap cccd"));
                        client.setAddress(GetValue.getString("Nhap dia chi"));
                        client.setEmail(GetValue.getString("Nhap emali :"));
                        client.setGender(GetValue.getGender("Nhap gioi tinh :"));
                        System.out.println("Thay doi thong tin khach hang thanh cong!");
                        break;
                    case 2: //  weight, height, String.format("%.6f", bmi), status, target, stateOfStrength);
                        client.setWeight(GetValue.getDou("Nhap trong luong "));
                        client.setHeight(GetValue.getDou("Nhap chieu cao "));
                        client.setTarget(GetValue.getTarget("Chon muc tieu"));
                        client.setStateOfStrength(GetValue.getString("Nhap tinh trang suc khoe"));
                        client.setBmi(client.getBmi());
                        client.setStatus(client.getStatus());
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
            }

        }
        save();
    }

    public static void printMenuUpdate() {
        System.out.println("1. Sua thong tin khach hang");
        System.out.println("2. Sua thong tin huan luyen khach hang");
        System.out.println("0. Back to program");
    }

    public static Client createClientOfBill(Client client) {
        printCreateClientBill();
        choose = GetValue.getInt("Enter your choice :");
        switch (choose) {
            case 1:
                printClient();
                choose = GetValue.getInt("Chon id khach hang");
                break;
            case 2:
                client.setId(nextIdClient);
                client.setName(GetValue.getString("Nhap ten khach hang"));
                client.setUserName(AppUtils.checkClient(GetValue.getString("Nhap userName"), clientList));
                client.setPassWord(GetValue.getString("Nhap passWord"));
                client.setAge(GetValue.getInt("Nhap tuoi"));
                client.setPhone(GetValue.getPhone("Nhap so dien thoai"));
                client.setCccd(GetValue.getCccd("Nhap cccd"));
                client.setAddress(GetValue.getString("Nhap dia chi"));
                client.setEmail(GetValue.getString("Nhap email"));
                client.setGender(GetValue.getGender("Chon gioi tinh"));
                client.setHeight(GetValue.getDou("Nhap chieu cao"));
                client.setWeight(GetValue.getDou("Nhap can nang"));
                client.setStatus(client.getStatus());
                client.setRole(client.getRole());
                client.setTarget(GetValue.getTarget("Chon muc tieu huan luyen"));
                client.setScheduleClient(GetValue.getClientSchedule("Chon lich trinh huan luyen"));
                client.setStateOfStrength(GetValue.getString("Nhap tinh trang suc khoe"));
                System.out.println("Dang ky khach hang thanh cong!");
                clientList.add(client);
                save();
                return client;
            case 0:
                adminPage();
                break;
        }
        return createClientOfBill(client);
    }
    public static void printCreateClientBill() {
        System.out.println("1. Chon khach hang");
        System.out.println("2. Them khach hang moi");
        System.out.println("0. Back to program");
    }

}



