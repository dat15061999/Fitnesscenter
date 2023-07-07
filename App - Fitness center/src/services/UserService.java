package services;

import models.Admin;
import utils.GetValue;
import utils.SerializationUtil;

import java.util.Collections;
import java.util.List;



public class UserService {
    static AdminService adminService = new AdminService();

    public static int choose = -1;

    public static String address = "admin.txt";

    public static void adminView() {
        do {
            switch (adminService()) {
                case 1:
                    addAdmin();
                    break;
                case 2:
                    deleteAdmin();
                    break;
                case 3:
                    updateAdmin();
                    break;
                case 4:
                    printAdmin();
                    break;
                case 5:
                    System.exit(5);
                    break;
            }
        } while (choose != 0);
    }

    private static int adminService() {
        System.out.println("               ===================================");
        System.out.println("               |             Admin List          |");
        System.out.println("               ===================================");
        System.out.println("               | Options:                        |");
        System.out.println("               |        1. Create admin          |");
        System.out.println("               |        2. Delete admin          |");
        System.out.println("               |        3. Update admin          |");
        System.out.println("               |        4. Print All             |");
        System.out.println("               |        5. Exit All              |");
        System.out.println("               |        0. Back to program       |");
        System.out.println("               ===================================");
        return choose = GetValue.getInt("Enter your choice:");
    }

    private static void addAdmin() {
        List<Admin> admins = adminService.readFile();
        int max = 0 ;
        for (Admin admin : admins) {
            if (admin.getId() > max) {
                max = admin.getId();
            }
        }
        int newid = ++max;
        adminService.create(new Admin(newid,GetValue.getString("Nhap ten"), GetValue.getString("Nhap userName"), GetValue.getString("Nhap passWord")
                ,GetValue.getInt("Nhap tuoi"), GetValue.getPhone("Nhap so dien thoai"), GetValue.getCccd("Nhap cccd"), GetValue.getString("Nhap dia chi"), GetValue.getString("Nhap gamil"), GetValue.getString("Nhap gioi tinh")));
        System.out.println();
        SerializationUtil.serialize(adminService.getAll(), address);
    }
    private static void deleteAdmin() {
        adminService.delete(GetValue.getInt("Nhap id muon xoa"));
        SerializationUtil.serialize(adminService.getAll(), address);
    }
    private static void updateAdmin() {
        adminService.update(GetValue.getInt("Nhap id muon update"));
        SerializationUtil.serialize(adminService.getAll(), address);
    }
    private static void printAdmin() {
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("|                                                                          Admin List                                                                                    |");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-4s | %-15s | %-20s | %-20s |  %-8s  | %-30s | %-15s | %-8s | %-20s |\n",
                "ID", "Name", "Username", "Password","Age", "Email", "Role", "Phone", "Address");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        List<Admin> adminList = adminService.getAll();
        if (adminList != null) {
            for (Admin admin : adminList) {
                System.out.println(admin);
            }
        } else {
            System.out.println("Admin list is empty.");
        }
    }
}
