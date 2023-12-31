package services;

import eNum.eRole;
import models.Client;
import models.Product;
import models.Trainer;
import models.User;
import utils.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static page.TrainerPage.choose;
import static page.TrainerPage.trainerPage;
import static utils.CurrencyFormat.covertPriceToString;
import static view.BillView.billView;


public class TrainerService implements CRUD<Trainer>, Serializable {

    private static final long serialVersionUID = 1L;
    public static List<Trainer> trainerList;
    private static int nextId;
    public static String addressTrainer = "trainer.txt";

    static {
        trainerList = (List<Trainer>) SerializationUtil.deserialize(addressTrainer);
        if (trainerList == null) {
            trainerList = new ArrayList<>();
        }
        nextId = AppUtils.findNext(trainerList.stream().map(User::getId).collect(Collectors.toList()));
    }

    private static void save() {
        SerializationUtil.serialize(trainerList, addressTrainer);
    }

    @Override
    public void create(Trainer trainer) {
        trainer.setId(nextId++);
        trainer.setName(GetValue.getString("Nhap ten huan luyen vien"));
        trainer.setUsername(AppUtils.checkTrainer(GetValue.getString("Nhap userName"), trainerList));
        trainer.setPassword(GetValue.getString("Nhap passWord"));
        trainer.setAge(GetValue.getInt("Nhap tuoi"));
        trainer.setPhone(GetValue.getPhone("Nhap so dien thoai"));
        trainer.setCccd(GetValue.getCccd("Nhap cccd"));
        trainer.setAddress(GetValue.getString("Nhap email"));
        trainer.setGender(GetValue.getGender("Chon gioi tinh"));
        trainer.setRole(eRole.PT.getName());
        trainer.setSalary(GetValue.getInt("Nhap luong co ban"));
        trainer.setTotalPrice(trainer.getTotalPrice());
        trainer.setExp(GetValue.getDou("Nhap kinh nghiem lam viec"));
        trainer.setLevel(trainer.getLevel());
        trainer.setSkill(GetValue.getString("Nhap ky nang"));
        trainer.setDegree(GetValue.getString("Nhap bang cap"));
        trainer.setCoachingStyle(GetValue.getStyle("Chon phong cach huan luyen"));
        trainer.setSchedule(GetValue.getSchedule("Chon lich trinh lam viec"));
        trainerList.add(trainer);
        System.out.println("THEM HUAN LUYEN VIEN THANH CONG");
        save();
    }

    @Override
    public void delete(int idTrainer) {
        Trainer trainerDelete = null;
        if (trainerList.stream().anyMatch(e->e.getId()==idTrainer && e.getSchedule().size()==2)) {
            for (Trainer trainer : trainerList) {
                if (idTrainer == trainer.getId() && trainer.getSchedule().size()==2) {
                    trainerDelete = trainer;
                    System.out.println("Xoa COACH co ID la " + idTrainer + " thanh cong.");
                    break;
                }
            }
            trainerList.remove(trainerDelete);
            save();
        } else {
            System.out.println("XOA ID COACH KHONG THANH CONG -");
        }

    }

    @Override
    public void update(int idTrainer) {
        if (!trainerList.isEmpty()) {
            for (Trainer trainer : trainerList) {
                if (idTrainer == trainer.getId()) {
                    System.out.println("1. Sua thong tin trainer");
                    System.out.println("2. Sua lich trinh va ky nang trainer");
                    switch (GetValue.getInt("Enter your choice :")) {
                        case 1:
                            trainer.setName(GetValue.getString("Nhap ten moi :"));
                            trainer.setUsername(GetValue.getString("Nhap userName :"));
                            trainer.setPassword(GetValue.getString("Nhap passWord :"));
                            trainer.setAge(GetValue.getInt("Nhap tuoi"));
                            trainer.setPhone(GetValue.getPhone("Nhap so dien thoai"));
                            trainer.setCccd(GetValue.getCccd("Nhap cccd"));
                            trainer.setAddress(GetValue.getString("Nhap dia chi"));
                            trainer.setEmail(GetValue.getString("Nhap emali :"));
                            trainer.setGender(GetValue.getGender("Nhap gioi tinh :"));
                            System.out.println("Thay doi thong tin COACH thanh cong");
                            break;
                        case 2:
                            trainer.setSkill(GetValue.getString("Nhap ky nang"));
                            trainer.setDegree(GetValue.getString("Nhap bang cap"));
                            trainer.setCoachingStyle(GetValue.getStyle("Chon phong cach"));
                            trainer.setExp(GetValue.getDou("Nhap kinh nghiem"));
                            trainer.setSchedule(GetValue.getSchedule("Chon lich trinh"));
                            System.out.println("Thay doi lich trinh COACH thanh cong");
                            break;
                    }
                }
            }
            save();
        }
    }

    @Override
    public List<Trainer> readFile() {
        return trainerList;
    }


    @Override
    public void getAll() {
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("|                                                                          Trainer List                                                                                                                                                                                                                                                                                           |");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-4s | %-17s | %-10s | %-10s | %-8s | %-20s | %-10s | %-8s | %-20s | %-10s | %-20s | %-15s | %-15s | %-24s | %-10s | %-8s | %-10s | %-14s | %-14s | %-14s | %-14s | %-12s | %-14s | \n",
                "ID", "Name", "Username", "Password", "Age", "Email", "Role", "Phone", "Address", "Gender", "Skill", "Degree", "Coaching Style", "Schedule", "Status", "Level", "Experience", "Price Coach", "Price Hire", "Salary", "Bonus", "Work Day", "Total Salary");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        if (trainerList != null) {
            for (Trainer trainer : trainerList) {
                System.out.println(trainer);
            }
        } else {
            System.out.println("Trainer list is empty.");
        }
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

    }

    public static void printTrainerPersonal(String userName) {
        if (trainerList != null) {
            if (trainerList.stream().anyMatch(e -> e.getUsername().equals(userName))) {
                Trainer trainer = getByUserName(userName);
                System.out.printf("%-20s: %s\n", "Họ và tên", trainer.getName());
                System.out.printf("%-20s: %s\n", "Số điện thoại", trainer.getPhone());
                System.out.printf("%-20s: %s\n", "Email", trainer.getEmail());
                System.out.printf("%-20s: %s\n", "Giới tính", trainer.getGender());
                System.out.printf("%-20s: %s\n", "Địa chỉ", trainer.getAddress());
                System.out.printf("%-20s: %s\n", "Kỹ năng", trainer.getSkill());
                System.out.printf("%-20s: %s\n", "Bằng cấp", trainer.getDegree());
                System.out.printf("%-20s: %s\n", "Phong cách", trainer.getCoachingStyle());
                System.out.printf("%-20s: %s\n", "Lịch trình", trainer.getSchedule());
                System.out.printf("%-20s: %s\n", "Kinh nghiem", trainer.getExp());
                System.out.printf("%-20s: %s\n", "Trạng thái", trainer.getStatus());
            }
        } else {
            System.out.println("NUll");
        }
    }

    public static void changeTrainerInf(String userName) {
        if (!trainerList.isEmpty()) {
            for (Trainer trainer : trainerList) {
                if (trainer.getUsername().equals(userName)) {
                    System.out.println("1. Update information");
                    System.out.println("2. Change Schedule Work");
                    System.out.println("0. Back to program");
                    choose = GetValue.getInt("Enter your choice :");
                    switch (choose) {
                        case 1:
                            trainer.setName(GetValue.getString("Nhap ten moi :"));
                            trainer.setUsername(GetValue.getString("Nhap userName :"));
                            trainer.setPassword(GetValue.getString("Nhap passWord :"));
                            trainer.setAge(GetValue.getInt("Nhap tuoi"));
                            trainer.setPhone(GetValue.getPhone("Nhap so dien thoai"));
                            trainer.setCccd(GetValue.getCccd("Nhap cccd"));
                            trainer.setAddress(GetValue.getString("Nhap dia chi"));
                            trainer.setEmail(GetValue.getString("Nhap emali :"));
                            trainer.setGender(GetValue.getGender("Nhap gioi tinh :"));
                            System.out.println("Thay doi thong tin thanh cong");
                            save();
                            break;
                        case 2:
                            trainer.setSchedule(GetValue.getSchedule("Chon lich trinh"));
                            System.out.println("Thay doi lich trinh lam viec thanh cong");
                            save();
                            break;
                        case 0:
                            trainerPage(userName);
                            break;
                        default:
                            changeTrainerInf(userName);
                            break;
                    }
                    changeTrainerInf(userName);
                }

            }
        }
    }

    public static Trainer remoteSchedule(int idTrainer, String schedule1) {
        if (!trainerList.isEmpty()) {
            Trainer trainer = getById(idTrainer);
            trainer.setSchedule(trainer
                    .getSchedule()
                    .stream()
                    .filter(e -> Objects.equals(e, schedule1))
                    .collect(Collectors.toList()));
            save();
            return trainer;
        }
        return null;
    }

    public static Trainer getTrainer(String schedule, String statusProduct) {
        if (!trainerList.isEmpty()) {
            if (statusProduct.equals("TRAINED")) {
                findCoachList(schedule);
                return getById(GetValue.getInt("Chon id Coach"));
            } else if (statusProduct.equals("NO-TRAINER")) {
                return null;
            }
        }
        return null;
    }

    public static void findCoachList(String schedule) {
        if (!trainerList.isEmpty()) {
            System.out.printf("| %-5s | %-20s | %-5s | %-15s | %-7s | %-10s | %-10s | %-20s | %-15s | %-20s | %-30s | %-10s | %-10s\n",
                    "ID", "Name", "Age", "Phone", "Gender", "Experience", "Level", "Skill", "Degree", "CoachingStyle", "Schedule", "Status", "Price Hire");
            trainerList.stream().filter(e -> e.getSchedule().
                            contains(schedule)).filter(trainer -> trainer.getSchedule().contains(schedule))
                    .forEach(trainer -> {
                        System.out.printf("| %-5d | %-20s | %-5s | %-15s | %-7s | %-10s | %-10s | %-20s | %-15s | %-20s | %-30s | %-10s | %-10s\n",
                                trainer.getId(), trainer.getName(), String.valueOf(trainer.getAge()), trainer.getPhone(),
                                trainer.getGender(), trainer.getExp(), trainer.getLevel(), trainer.getSkill(),
                                trainer.getDegree(), trainer.getCoachingStyle(), trainer.getSchedule(),
                                trainer.getStatus(), CurrencyFormat.covertPriceToString(trainer.getPriceCoachHire()));
                    });

        }
    }

    public static Trainer getByUserName(String userName) {
        return trainerList.stream()
                .filter(e -> e.getUsername().equals(userName))
                .findFirst()
                .orElse(null);
    }

    public static Trainer getById(int idCoach) {
        if (!trainerList.isEmpty()) {
            for (Trainer trainer : trainerList) {
                if (trainer.getId() == idCoach) {
                    return trainer;
                }
            }
        }
        return getById(GetValue.getInt("Nhap id Coach"));
    }

    public static void printTotalSalary(String userName) {
        if (trainerList != null) {
            if (trainerList.stream().anyMatch(e -> e.getUsername().contains(userName))) {
                trainerList.stream().filter(e -> e.getUsername().contains(userName)).
                        forEach(e -> {
                            System.out.println("Luong co ban la :" + covertPriceToString(e.getSalary()));
                            System.out.println("So ngay lam viec la :" + ((e.getWorkDay() != null) ? e.getWorkDay().size() : 0));
                            System.out.println("Tien thuong la :" + covertPriceToString(e.getRevenueBonus()));
                            System.out.println("Tong luong la :" + covertPriceToString(e.getTotalPrice()));
                        });
            }
        }
    }

    public static void confirmWorkDay(String userName) {
        if (trainerList != null) {
            for (Trainer trainer : trainerList) {
                if (trainer.getUsername().equals(userName)) {
                    List<Integer> workDay = trainer.getWorkDay();
                    int dayNow = GetValue.getDayNow();
                    if (!workDay.contains(dayNow)) {
                        List<Integer> newWorkDay = new ArrayList<>(workDay);
                        newWorkDay.add(dayNow);
                        trainer.setWorkDay(newWorkDay);
                        System.out.println("CHAM CONG THANH CONG");
                        save();
                    }  else {
                        System.out.println("ĐÃ CHẤM CÔNG TRONG NGÀY HÔM NAY");
                    }
                    break;
                }
            }
        } else {
            System.out.println("KHÔNG TÌM THẤY NHÂN VIÊN TRONG HỆ THỐNG");
        }

    }

    private static void printMenuTrainer() {
        System.out.println("               ===================================");
        System.out.println("               | Options:                        |");
        System.out.println("               |        1. Co huan luyen vien    |");
        System.out.println("               |        2. Khong huan luyen vien |");
        System.out.println("               |        0. Log Out               |");
        System.out.println("               ===================================");
    }

}
