package view;

import services.AdminService;
import services.TrainerService;
import utils.GetValue;


import static services.UserService.adminView;
import static view.TrainerView.trainerView;


public class UserView {
    private static AdminService adminService = new AdminService();
    private static TrainerService trainerService = new TrainerService();
    public static int choose = -1;

    public static void main(String[] args) {
        userView();
    }

    public static void userView() {
         while (choose != 0) {
             switch (userMenuView()) {
                 case 1:
                     adminService.readFile();
                     adminView();
                     break;
                 case 2:
                     trainerService.readFile();
                     trainerView();
                     break;
                 case 3:
                     //clientService();
                     break;
             }
         }
    }

    private static int userMenuView() {
        System.out.println("               ===================================");
        System.out.println("               |            UserVIew             |");
        System.out.println("               ===================================");
        System.out.println("               | Options:                        |");
        System.out.println("               |        1. Admin                 |");
        System.out.println("               |        2. Trainer               |");
        System.out.println("               |        3. Client                |");
        System.out.println("               |        4. Updating              |");
        System.out.println("               |        0. Back to program       |");
        System.out.println("               ===================================");
        return choose = GetValue.getInt("Enter your choice:");
    }





}

