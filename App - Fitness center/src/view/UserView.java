package view;

import models.Admin;
import services.AdminService;
import utils.GetValue;
import utils.SerializationUtil;


public class UserView {
    static AdminService adminService = new AdminService();
    public static int choose;
    public static String address = "E:\\App - Fitness center\\Fitnesscenter\\App - Fitness center\\src\\database\\admin.txt";


    public static void main(String[] args) {
        do {
            switch (userMenuView()) {
                case 1:
                    adminView();
                    break;
                case 2:
                    //trainerService();
                    break;
                case 3:
                    //clientService();
                    break;
            }
        } while (choose != 0);
    }

    private static int userMenuView() {
        System.out.println("               ===================================");
        System.out.println("               |            UserVIew             |");
        System.out.println("               ===================================");
        System.out.println("               | Options:                        |");
        System.out.println("               |        1. Admin                 |");
        System.out.println("               |        2. Trainer               |");
        System.out.println("               |        3. Client                |");
        System.out.println("               |        5. Updating              |");
        System.out.println("               |        0. Exit to program       |");
        System.out.println("               ===================================");
        return GetValue.getInt("Enter your choice:");
    }

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
            }
        } while (choose != 0);
    }

    private static int adminService() {
        System.out.println("               ===================================");
        System.out.println("               |              Admin              |");
        System.out.println("               ===================================");
        System.out.println("               | Options:                        |");
        System.out.println("               |        1. Create admin          |");
        System.out.println("               |        2. Delete admin          |");
        System.out.println("               |        3. Update admin          |");
        System.out.println("               |        4. Print All             |");
        System.out.println("               |        0. Exit to program       |");
        System.out.println("               ===================================");
        return GetValue.getInt("Enter your choice:");
    }

    private static void addAdmin() {
        adminService.create(new Admin(GetValue.getString("Nhap ten"), GetValue.getString("Nhap userName"), GetValue.getString("Nhap passWord")
                , GetValue.getInt("Nhap so dien thoai"), GetValue.getInt("Nhap cccd"), GetValue.getString("Nhap dia chi"), GetValue.getString("Nhap gamil"), GetValue.getString("Nhap gioi tinh")));
        System.out.println();
        SerializationUtil.serialize(adminService, address);
    }
    private static void deleteAdmin() {
        adminService.delete(GetValue.getInt("Nhap id muon xoa"));
    }
    private static void updateAdmin() {
        adminService.delete(GetValue.getInt("Nhap id muon update"));
    }
    private static void printAdmin() {
        System.out.println("----------------------------------------------------------------------------------------------------------");
        System.out.println("|                                            Order Detail                                                |");
        System.out.println("----------------------------------------------------------------------------------------------------------");
        adminService.findAll();
    }
}

