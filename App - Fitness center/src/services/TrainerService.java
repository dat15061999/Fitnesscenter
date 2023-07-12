package services;

import eNum.eRole;
import models.Trainer;
import models.User;
import utils.AppUtils;
import utils.CRUD;
import utils.GetValue;
import utils.SerializationUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static page.TrainerPage.choose;
import static page.TrainerPage.trainerPage;


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
        trainer.setUserName(AppUtils.checkTrainer(GetValue.getString("Nhap userName"), trainerList));
        trainer.setPassWord(GetValue.getString("Nhap passWord"));
        trainer.setAge(GetValue.getInt("Nhap tuoi"));
        trainer.setPhone(GetValue.getPhone("Nhap so dien thoai"));
        trainer.setCccd(GetValue.getCccd("Nhap cccd"));
        trainer.setAddress(GetValue.getString("Nhap email"));
        trainer.setGender(GetValue.getGender("Chon gioi tinh"));
        trainer.setRole(eRole.PT.getName());
        trainer.setSalary(GetValue.getInt("Nhap luong co ban"));
        trainer.setRevenueBonus(GetValue.getDou("Hoa hong"));
        trainer.setTotalPrice(trainer.getTotalPrice());
        trainer.setExp(GetValue.getDou("Nhap kinh nghiem lam viec"));
        trainer.setLevel(trainer.getLevel());
        trainer.setSkill(GetValue.getString("Nhap ky nang"));
        trainer.setDegree(GetValue.getString("Nhap bang cap"));
        trainer.setCoachingStyle(GetValue.getStyle("Chon phong cach huan luyen"));
        trainer.setSchedule(GetValue.getSchedule("Chon lich trinh lam viec"));
        trainerList.add(trainer);
        save();
    }

    @Override
    public void delete(int idTrainer) {
        Trainer trainerDelete = null;
        for (Trainer trainer : trainerList) {
            if (idTrainer == trainer.getId()) {
                trainerDelete = trainer;
                System.out.println("Xoa trainer co id la " + idTrainer + " thanh cong.");
                break;
            }
        }
        trainerList.remove(trainerDelete);
        save();
    }

    @Override
    public void update(int idTrainer) {
        if (!trainerList.isEmpty()) {
            for (Trainer trainer : trainerList) {
                if (idTrainer == trainer.getId()) {
                    System.out.println("1. Sua thong tin trainer");
                    System.out.println("2. Sua ky nang trainer");
                    switch (GetValue.getInt("Enter your choice :")) {
                        case 1:
                            trainer.setName(GetValue.getString("Nhap ten moi :"));
                            trainer.setUserName(GetValue.getString("Nhap userName :"));
                            trainer.setPassWord(GetValue.getString("Nhap passWord :"));
                            trainer.setAge(GetValue.getInt("Nhap tuoi"));
                            trainer.setPhone(GetValue.getPhone("Nhap so dien thoai"));
                            trainer.setCccd(GetValue.getCccd("Nhap cccd"));
                            trainer.setAddress(GetValue.getString("Nhap dia chi"));
                            trainer.setEmail(GetValue.getString("Nhap emali :"));
                            trainer.setGender(GetValue.getGender("Nhap gioi tinh :"));
                            System.out.println("Thay doi thong tin Trainer thanh cong");
                            break;
                        case 2:
                            trainer.setSkill(GetValue.getString("Nhap ky nang"));
                            trainer.setDegree(GetValue.getString("Nhap bang cap"));
                            trainer.setCoachingStyle(GetValue.getStyle("Chon phong cach"));
                            trainer.setSchedule(GetValue.getSchedule("Chon lich trinh"));
                            trainer.setExp(GetValue.getDou("Nhap kinh nghiem"));
                            trainer.setRevenueBonus(GetValue.getInt("Nhap hoa hong"));
                            System.out.println("Thay doi ky nang Trainer thanh cong");
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
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("|                                                                          Trainer List                                                                                                                                                                                                                                          |");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-4s | %-17s | %-10s | %-10s | %-8s | %-20s | %-10s | %-8s | %-20s | %-10s | %-20s | %-15s | %-15s | %-24s | %-10s | %-8s | %-10s | %-14s | %-14s | %-14s | %-14s | %-14s | \n",
                "ID", "Name", "Username", "Password", "Age", "Email", "Role", "Phone", "Address", "Gender", "Skill", "Degree", "Coaching Style", "Schedule", "Status", "Level", "Experience", "Price Coach", "Price Hire", "Salary", "Bonus", "Total Salary");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        if (trainerList != null) {
            for (Trainer trainer : trainerList) {
                System.out.println(trainer);
            }
        } else {
            System.out.println("Trainer list is empty.");
        }

    }

    public static void trainerPersonal(String userName) {
        if (trainerList != null) {
            for (Trainer trainer : trainerList) {
                if (trainer.getUserName().equals(userName)) {
                    System.out.printf("| %-17s | %-10s | %-10s | %-8s | %-20s | %-8s | %-20s | %-10s | %-20s | %-15s | %-15s | %-30s | %-10s | %-8s | %-10s | %-10s | %-10s | %-10s | \n",
                            "Name", "Username", "Password", "Age", "Email", "Phone", "Address", "Gender", "Skill", "Degree", "CoachingStyle", "Schedule", "Status", "Level", "Experience", "Bonus", "Salary", "TotalPrice");
                    String formattedString = String.format("| %-17s | %-10s | %-10s | %-8s | %-20s | %-8s | %-20s | %-10s | %-20s | %-15s | %-15s | %-30s | %-10s | %-8s | %-10s | %-10s | %-10s | %-10s | \n",
                            trainer.getName(), trainer.getUserName(), trainer.getHiddenPassWord(), String.valueOf(trainer.getAge()), trainer.getEmail(), trainer.getPhone()
                            , trainer.getAddress(), trainer.getGender(), trainer.getSkill(), trainer.getDegree(), trainer.getCoachingStyle(), trainer.getSchedule(), trainer.getStatus(), trainer.getLevel()
                            , trainer.getExp(), trainer.getRevenueBonus(), trainer.getSalary(), trainer.getTotalPrice());
                    System.out.println(formattedString);
                }
            }
        } else {
            System.out.println("NUll");
        }
    }

    public static void changeTrainerInf(String userName) {
        if (!trainerList.isEmpty()) {
            for (Trainer trainer : trainerList) {
                if (trainer.getUserName().equals(userName)) {
                    System.out.println("1. Cap nhat thong tin");
                    System.out.println("2. Thay doi lich lam viec");
                    choose = GetValue.getInt("Enter your choice :");
                    switch (choose) {
                        case 1:
                            trainer.setName(GetValue.getString("Nhap ten moi :"));
                            trainer.setUserName(GetValue.getString("Nhap userName :"));
                            trainer.setPassWord(GetValue.getString("Nhap passWord :"));
                            trainer.setAge(GetValue.getInt("Nhap tuoi"));
                            trainer.setPhone(GetValue.getPhone("Nhap so dien thoai"));
                            trainer.setCccd(GetValue.getCccd("Nhap cccd"));
                            trainer.setAddress(GetValue.getString("Nhap dia chi"));
                            trainer.setEmail(GetValue.getString("Nhap emali :"));
                            trainer.setGender(GetValue.getGender("Nhap gioi tinh :"));
                            System.out.println("Thay doi thong tin thanh cong");
                            break;
                        case 2:
                            trainer.setSchedule(GetValue.getSchedule("Chon lich trinh"));
                            System.out.println("Thay doi lich trinh lam viec thanh cong");
                            break;
                        default:
                            changeTrainerInf(userName);
                            break;
                    }
                }

            }
            save();
        }
    }

    public static void remoteSchedule(int idTrainer, String schedule1) {
        if (!trainerList.isEmpty()) {
            Trainer trainer = trainerList.stream().filter(e -> e.getId() == idTrainer).findFirst().orElse(null);
            if(trainer == null || trainer.getSchedule() == null) return;
            trainer.setSchedule(trainer
                            .getSchedule()
                            .stream()
                            .filter(e -> Objects.equals(e, schedule1))
                            .collect(Collectors.toList()));
            save();
        }
    }
}
