package utils;

import eNum.eGender;
import eNum.eRole;
import models.Admin;
import models.Client;
import models.Trainer;

import java.util.ArrayList;
import java.util.List;

public class InitData {
    public static void main(String[] args) {
        initTrainer();
    }
    public static void initAdmin() {
        List<Admin> admin = new ArrayList<>();
        admin.add(new Admin("DAT","admin1","123456",0345666,1900071,"28 Nguyen Tri Phuong","datphamvan@gmail.com",String.valueOf(eGender.MALE),String.valueOf(eRole.ADMIN)));
        admin.add(new Admin("TUAN","admin2","123456",0123456,1900072,"28 Nguyen Tri Phuong","datphamvan@gmail.com",String.valueOf(eGender.FEMALE),String.valueOf(eRole.ADMIN)));
        SerializationUtil.serialize(admin,"E:\\App - Fitness center\\Fitnesscenter\\App - Fitness center\\src\\database\\admin.txt");
    }
    public static void initClient() {
        List<Client> clients = new ArrayList<>();
        clients.add(new Client("Tuan Em","tuanem123","123456",0123456,1900031,"28 Nguyen Tri Phuong","tuanem@ga,il.com",String.valueOf(eGender.MALE),String.valueOf(eRole.CLIENT),59,1.65,18,"Binh thuong","Tang can","Tot"));
        clients.add(new Client("Tuan Anh","tuananh123","123456",0123456,1900031,"28 Nguyen Tri Phuong","tuanem@ga,il.com",String.valueOf(eGender.MALE),String.valueOf(eRole.CLIENT),60,1.67,19,"Binh thuong","Tang can","Tot"));
        SerializationUtil.serialize(clients,"E:\\App - Fitness center\\Fitnesscenter\\App - Fitness center\\src\\database\\clients.txt");

    //String name, String userName, String passWord, int phone, int cccd, String address, String email, String gender, String role, int salary, int dayOff, double revenueBonus, double totalPrice, double exp, int level, String skill, String degree, String coachingStyle, String schedule
    }
    public static void initTrainer() {
        List<Trainer> trainer = new ArrayList<>();
        trainer.add(new Trainer("Tuan PT","tuanpt","123456",19922,1900333,"28 Nguyen Tri Phuong","tuanpt@ga,il.com",String.valueOf(eGender.FEMALE)));
        trainer.add(new Trainer("Tuan PT","tuanpt","123456",199222,1900333,"28 Nguyen Tri Phuong","tuanpt@ga,il.com",String.valueOf(eGender.MALE)));
        SerializationUtil.serialize(trainer,"E:\\App - Fitness center\\Fitnesscenter\\App - Fitness center\\src\\database\\trainer.txt");
    }
}
