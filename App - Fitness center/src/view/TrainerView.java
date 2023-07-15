package view;
import models.Trainer;
import services.TrainerService;
import utils.GetValue;
import static view.UserView.userView;

public class TrainerView {
    private static int choose;
    public static TrainerService trainerService = new TrainerService();

    static {
        trainerService.readFile();
    }

    public static void main(String[] args) {
        trainerView();
    }
    public static void trainerView() {
            trainerMenu();
            choose =  GetValue.getInt("Enter your choice:");
            switch (choose) {
                case 1:
                    addTrainer();
                    break;
                case 2:
                    deleteTrainer();
                    break;
                case 3:
                    updateTrainer();
                    break;
                case 4:
                    printTrainer();
                    break;
                case 5:
                    System.exit(5);
                    break;
                case 0:
                    userView();
                    break;
                default:
                    trainerView();
                    break;
            }
        trainerView();
    }

    private static void trainerMenu() {
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
    }

    private static void addTrainer() {
        trainerService.create(new Trainer());
    }


    private static void deleteTrainer() {
        trainerService.delete(GetValue.getInt("Nhap id muon xoa"));
    }

    private static void updateTrainer() {
        trainerService.update(GetValue.getInt("Nhap id trainer muon chinh sua"));
    }

    private static void printTrainer() {
        trainerService.getAll();
    }
 }
