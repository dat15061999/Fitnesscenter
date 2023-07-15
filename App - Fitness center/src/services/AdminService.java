package services;
import models.Admin;
import models.User;
import utils.AppUtils;
import utils.CRUD;
import utils.GetValue;
import utils.SerializationUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AdminService implements CRUD<Admin> {
    private static final long serialVersionUID = 3055276268292339966L;
    private static int nextIdAdmin;
    public static String address = "admin.txt";
    public static List<Admin> adminList;
    public static List<Admin> loginHistory;

    static {
        adminList = (List<Admin>) SerializationUtil.deserialize(address);
        if (adminList.isEmpty()) {
            adminList = new ArrayList<>();
        }
        loginHistory = (List<Admin>) SerializationUtil.deserialize("loginAdmin.txt");
        if (loginHistory.isEmpty()) {
            loginHistory = new ArrayList<>();
        }
        nextIdAdmin = AppUtils.findNext(adminList.stream().map(User::getId).collect(Collectors.toList()));
    }
    private static void save() {
        SerializationUtil.serialize(adminList, address);
    }
    @Override
    public void create(Admin admin) {
        admin.setId(nextIdAdmin);
        admin.setName(GetValue.getString("Nhap ten moi :"));
        admin.setUsername(GetValue.getString("Nhap userName :"));
        admin.setPassword(GetValue.getString("Nhap passWord :"));
        admin.setAge(GetValue.getInt("Nhap tuoi"));
        admin.setPhone(GetValue.getInt("Nhap so dien thoai"));
        admin.setCccd(GetValue.getInt("Nhap cccd"));
        admin.setAddress(GetValue.getString("Nhap dia chi"));
        admin.setEmail(GetValue.getString("Nhap emali :"));
        admin.setGender(GetValue.getString("Nhap gioi tinh :"));
        System.out.println("Them Admin thanh cong");
        adminList.add(admin);
        save();
    }

    @Override
    public void delete(int idAdmin) {
        Admin adminDelete = null;
        for (Admin admin : adminList) {
            if (idAdmin == admin.getId()) {
                adminDelete = admin;
                System.out.println("Xoa admin co id la " + idAdmin + " thanh cong.");
                break;
            }
        }
        adminList.remove(adminDelete);
        save();
    }

    @Override
    public void update(int idAdmin) {
        for (Admin admin : adminList) {
            if (idAdmin == admin.getId()) {
                admin.setName(GetValue.getString("Nhap ten moi :"));
                admin.setUsername(GetValue.getString("Nhap userName :"));
                admin.setPassword(GetValue.getString("Nhap password"));
                admin.setAge(GetValue.getInt("Nhap tuoi"));
                admin.setPhone(GetValue.getInt("Nhap so dien thoai"));
                admin.setCccd(GetValue.getInt("Nhap cccd"));
                admin.setAddress(GetValue.getString("Nhap dia chi"));
                admin.setEmail(GetValue.getString("Nhap emali :"));
                admin.setGender(GetValue.getString("Nhap gioi tinh :"));
                System.out.println("Thay doi thong tin Admin thanh cong");
                break;
            }
        }
        save();
    }

    public static void historyLoginAdmin(Admin admin) {
        admin.setDate(GetValue.getTime());
        loginHistory.add(admin);
        SerializationUtil.serialize(loginHistory, "loginAdmin.txt");
    }
    public static void printHistoryLogin() {
        if (loginHistory != null) {
            System.out.printf("| %-20s | %-30s |\n",
                    "Name", "Time");
            for (Admin admin : loginHistory) {
                System.out.printf("| %-20s | %-30s |\n", admin.getName(), admin.getDate());
            }
        }

    }

    @Override
    public List<Admin> readFile() {
        return adminList;
    }



    @Override
    public void getAll() {
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("|                                                                          Admin List                                                                                                 |");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-4s | %-15s | %-20s | %-20s | %-10s |  %-8s  | %-30s | %-15s | %-8s | %-20s |\n",
                "ID", "Name", "Username", "Password", "Age", "Gender", "Email", "Role", "Phone", "Address");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        if (adminList != null) {
            for (Admin admin : adminList) {
                System.out.println(admin);
            }
        } else {
            System.out.println("Admin list is empty.");
        }
    }
    public static Admin getByUserName(String userName) {
        return adminList.stream()
                .filter(e -> e.getUsername().equals(userName))
                .findFirst()
                .orElse(null);
    }


}
