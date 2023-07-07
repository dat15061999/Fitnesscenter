package view;

import models.Admin;
import models.Trainer;
import services.TrainerService;
import utils.GetValue;

import java.util.List;

public class TrainerView {
    private static int choose = -1;
    static TrainerService trainerService = new TrainerService();

    public static void trainerView() {
        do {
            switch (trainerMenu()) {
                case 1:
                    //addTrainer();
                    break;
                case 2:
                    //deleteTrainer();
                    break;
                case 3:
                    //updateTrainer();
                    break;
                case 4:
                    printTrainer();
                    break;
                case 5:
                    System.exit(5);
                    break;
            }
        } while (choose != 0);
    }
    private static int trainerMenu() {
        System.out.println("               ===================================");
        System.out.println("               |           Trainer List          |");
        System.out.println("               ===================================");
        System.out.println("               | Options:                        |");
        System.out.println("               |        1. Create Trainer        |");
        System.out.println("               |        2. Delete Trainer        |");
        System.out.println("               |        3. Update Trainer        |");
        System.out.println("               |        4. Print Trainer         |");
        System.out.println("               |        5. Exit All              |");
        System.out.println("               |        0. Back to program       |");
        System.out.println("               ===================================");
        return choose = GetValue.getInt("Enter your choice:");
    }
    private static void addTrainer() {

    }
    private static void deleteTrainer() {

    }
    private static void updateTrainer() {

    }
    private static void printTrainer() {
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("|                                                                          Trainer List                                                                                                                                                                                                |");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-4s | %-17s | %-10s | %-10s | %-8s | %-20s | %-10s | %-8s | %-20s | %-10s | %-20s | %-15s | %-15s | %-20s | %-8s | %-10s | %-10s | %-10s | \n",
                "ID", "Name", "Username", "Password","Age", "Email", "Role", "Phone", "Address","Gender","Skill","Degree","CoachingStyle","Schedule","Level","Experience","Bonus","TotalPrice");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        List<Trainer> trainerList = trainerService.getAll();
        if (trainerList != null) {
            for (Trainer trainer : trainerList) {
                System.out.println(trainer);
            }
        } else {
            System.out.println("Trainer list is empty.");
        }
    }
 }
