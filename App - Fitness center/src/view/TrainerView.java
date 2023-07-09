package view;

import eNum.eRole;
import models.Admin;
import models.Trainer;
import services.TrainerService;
import utils.GetValue;
import utils.SerializationUtil;

import java.util.List;

public class TrainerView {
    private static int choose = -1;
    static TrainerService trainerService = new TrainerService();

    public static void trainerView() {
        do {
            switch (trainerMenu()) {
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
        List<Trainer> trainers = trainerService.readFile();
        int max=0;
        for (Trainer trainer: trainers) {
            if(trainer.getId() > max) {
                max = trainer.getId();
            }
        }
        ++max;
        trainerService.create(new Trainer(max,GetValue.getString("Nhap ten huan luyen vien"),GetValue.getString("Nhap userName"),GetValue.getString("Nhap passWord"),GetValue.getInt("Nhap tuoi"),GetValue.getPhone("Nhap so dien thoai"),GetValue.getCccd("Nhap cccd"),GetValue.getString("Nhap dia chi"),GetValue.getString("Nhap email"),GetValue.getGender("Chon gioi tinh"), eRole.PT.getName()
                ,GetValue.getInt("Nhap luong co ban"),GetValue.getDou("Hoa hong"),GetValue.getDou("Tong luong"),GetValue.getDou("Nhap kinh nghiem lam viec"),GetValue.getString("Nhap ky nang"),GetValue.getString("Nhap bang cap"),GetValue.getStyle("Chon phong cach huan luyen"),GetValue.getSchedule("Chon lich trinh lam viec")));
        System.out.println("Them huan luyen vien thanh cong");
        SerializationUtil.serialize(trainerService.getAll(),"trainer.txt");
    }

    private static void deleteTrainer() {
        trainerService.delete(GetValue.getInt("Nhap id muon xoa"));
        SerializationUtil.serialize(trainerService.getAll(),"trainer.txt");

    }

    private static void updateTrainer() {
        trainerService.update(GetValue.getInt("Nhap id trainer muon chinh sua"));
        SerializationUtil.serialize(trainerService.getAll(), "trainer.txt");
    }

    private static void printTrainer() {
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("|                                                                          Trainer List                                                                                                                                                                                                                 |");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-4s | %-17s | %-10s | %-10s | %-8s | %-20s | %-10s | %-8s | %-20s | %-10s | %-20s | %-15s | %-15s | %-24s | %-10s | %-8s | %-10s | %-10s | %-10s | \n",
                "ID", "Name", "Username", "Password","Age", "Email", "Role", "Phone", "Address","Gender","Skill","Degree","CoachingStyle","Schedule","Status","Level","Experience","Bonus","TotalPrice");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
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
