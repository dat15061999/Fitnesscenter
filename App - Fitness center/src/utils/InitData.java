package utils;

import eNum.eCoachingStyle;
import eNum.eGender;
import eNum.eRole;
import eNum.eTrainerSchedule;
import models.Admin;
import models.Client;
import models.Trainer;

import java.util.ArrayList;
import java.util.List;

public class InitData {

    public static void main(String[] args) {
        //initAdmin();
        //initClient();
        initTrainer();

    }
    public static void initAdmin() {
        List<Admin> admin = new ArrayList<>();
        admin.add(new Admin(1,"DAT","admin1","123456",22,345666,1900071,"28 Nguyen Tri Phuong","datphamvan@gmail.com",eGender.MALE.getName(),String.valueOf(eRole.ADMIN)));
        admin.add(new Admin(2,"TUAN","admin2","123456",22,123456,1900072,"28 Nguyen Tri Phuong","tuanphamvan@gmail.com",eGender.MALE.getName(),String.valueOf(eRole.ADMIN)));
        admin.add(new Admin(3,"TON THI TU TON","admin3","123456",22,345666,1900071,"28 Nguyen Tri Phuong","datphamvan@gmail.com", eGender.MALE.getName(),String.valueOf(eRole.ADMIN)));
        SerializationUtil.serialize(admin,"admin.txt");

    }
    public static void initClient() {
        List<Client> clients = new ArrayList<>();
        clients.add(new Client(1,"Tuan Em","tuanem123","123456",22,123456,1900031,"28 Nguyen Tri Phuong","tuanem@ga,il.com",String.valueOf(eGender.MALE),String.valueOf(eRole.CLIENT),59,1.65,18,"Binh thuong","Tang can","Tot"));
        clients.add(new Client(2,"Tuan Anh","tuananh123","123456",22,123456,1900031,"28 Nguyen Tri Phuong","tuanem@ga,il.com",String.valueOf(eGender.MALE),String.valueOf(eRole.CLIENT),60,1.67,19,"Binh thuong","Tang can","Tot"));
        SerializationUtil.serialize(clients,"clients.txt");

    //int id,String name, String userName, String passWord,int age, int phone, int cccd, String address, String email, String gender, String role, int salary, double revenueBonus, double totalPrice, double exp, int level, String skill, String degree, String coachingStyle, String schedule
    }
    public static void initTrainer() {
        String schedule1 = eTrainerSchedule.CHIEU1.getName() + "," + eTrainerSchedule.SANG1.getName();
        String schedule2 = eTrainerSchedule.CHIEU2.getName() + "," + eTrainerSchedule.SANG2.getName();
        List<Trainer> trainer = new ArrayList<>();
        trainer.add(new Trainer(1,"Pham Van Thanh","thanhpt","123456",30,19922,1900333,"28 Nguyen Tri Phuong","tuanpt@ga,il.com",eGender.FEMALE.getName(),eRole.PT.getName(),7000000,1000000,8000000,10,10,"NANG TA BANG 1 TAY","BANG PHI CONG", eCoachingStyle.STRONG.getName(), new String[]{schedule1}));
        trainer.add(new Trainer(2,"Nguyen Anh Tuan","tuananhpt","123456",29,199222,1900333,"28 Nguyen Tri Phuong","tuanpt@ga,il.com",eGender.MALE.getName(),eRole.PT.getName(),7000000,1000000,8000000,10,3,"NANG TA BANG 1 TAY","BANG PHI CONG", eCoachingStyle.STRONG.getName(), new String[]{schedule2}));
        trainer.add(new Trainer(3,"Le Em Tuan","tuanempt","123456",24,199222,1900333,"28 Nguyen Tri Phuong","tuanpt@ga,il.com",eGender.MALE.getName(),eRole.PT.getName(),7000000,1000000,8000000,10,3,"NANG TA BANG 1 TAY","BANG PHI CONG", eCoachingStyle.STRONG.getName(), new String[]{schedule1}));
        trainer.add(new Trainer(4,"Tran Dinh Duy","duypt","123456",27,199222,1900333,"28 Nguyen Tri Phuong","tuanpt@ga,il.com",eGender.MALE.getName(),eRole.PT.getName(),7000000,1000000,8000000,10,3,"NANG TA BANG 1 TAY","BANG PHI CONG", eCoachingStyle.STRONG.getName(), new String[]{schedule1}));
        trainer.add(new Trainer(5,"Nguyen Xuan Phuc","phucpt","123456",25,199222,1900333,"28 Nguyen Tri Phuong","tuanpt@ga,il.com",eGender.MALE.getName(),eRole.PT.getName(),7000000,1000000,8000000,10,3,"NANG TA BANG 1 TAY","BANG PHI CONG", eCoachingStyle.STRONG.getName(), new String[]{schedule2}));

        for (Trainer trainer1: trainer) {
            System.out.println(trainer1);
        }

        SerializationUtil.serialize(trainer, "trainer.txt");
    }
}
