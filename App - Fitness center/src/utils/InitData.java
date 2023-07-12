package utils;

import eNum.*;
import models.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static services.ClientService.clientList;
import static services.ProductService.productList;
import static services.TrainerService.trainerList;

public class InitData {
    private static List<String> schedule1 = new ArrayList<>();
    private static List<String> schedule2 = new ArrayList<>();
    private static List<String> schedule3 = new ArrayList<>();
    private static List<String> schedule4 = new ArrayList<>();

    static {
        //    SANG1("6H 2-4-6"),SANG2("6H 3-5-7"),CHIEU1("15H 2-4-6"),CHIEU2("15H 3-5-7");
        schedule1.add(eTrainerSchedule.SANG1.getName());
        schedule1.add(eTrainerSchedule.CHIEU1.getName());

        schedule2.add(eTrainerSchedule.SANG1.getName());
        schedule2.add(eTrainerSchedule.CHIEU2.getName());

        schedule3.add(eTrainerSchedule.SANG2.getName());
        schedule3.add(eTrainerSchedule.CHIEU1.getName());

        schedule4.add(eTrainerSchedule.SANG2.getName());
        schedule4.add(eTrainerSchedule.CHIEU2.getName());
    }

    public static void main(String[] args) {
        initBill();

    }

    public static void initAdmin() {
        List<Admin> admin = new ArrayList<>();
        admin.add(new Admin(1, "DAT", "admin1", "123456", 22, 345666, 1900071, "28 Nguyen Tri Phuong", "datphamvan@gmail.com", eGender.MALE.getName(), String.valueOf(eRole.ADMIN), ""));
        admin.add(new Admin(2, "TUAN", "admin2", "123456", 22, 123456, 1900072, "28 Nguyen Tri Phuong", "tuanphamvan@gmail.com", eGender.MALE.getName(), String.valueOf(eRole.ADMIN), ""));
        admin.add(new Admin(3, "TON THI TU TON", "admin3", "123456", 22, 345666, 1900071, "28 Nguyen Tri Phuong", "datphamvan@gmail.com", eGender.MALE.getName(), String.valueOf(eRole.ADMIN), ""));
        SerializationUtil.serialize(admin, "admin.txt");

    }

    public static void initClient() {
        //    SANG1("6H 2-4-6"),SANG2("6H 3-5-7"),CHIEU1("15H 2-4-6"),CHIEU2("15H 3-5-7");
        List<Client> clients = new ArrayList<>();
        clients.add(new Client(1, "Tuan Phu Bai", "tuanem123", "123456", 22, 123456, 1900031, "28 Nguyen Tri Phuong", "tuanem@gamil.com", eGender.MALE.getName(), eRole.CLIENT.getName(), 1.65, 70, "Tang can", eTrainerSchedule.SANG1.getName(), "Tot"));
        clients.add(new Client(2, "Tuan Hue", "tuananh123", "123456", 22, 223456, 1900031, "28 Nguyen Tri Phuong", "tuanem@gamil.com", eGender.MALE.getName(), eRole.CLIENT.getName(), 1.65, 65, "Tang can", eTrainerSchedule.SANG2.getName(), "Tot"));
        clients.add(new Client(3, "Anh Linh", "anhlinh123", "123456", 18, 323456, 1900032, "28 Nguyen Tri Phuong", "tuanem@gamil.com", eGender.FEMALE.getName(), eRole.CLIENT.getName(), 1.65, 65, "Tang can", eTrainerSchedule.CHIEU1.getName(), "Tot"));
        SerializationUtil.serialize(clients, "clients.txt");

    }

    public static void initTrainer() {
        List<Trainer> trainer = new ArrayList<>();
        trainer.add(new Trainer(1, "Pham Van Thanh", "thanhpt", "123456", 30, 19922, 1900331, "28 Nguyen Tri Phuong", "tuanpt@gmail.com", eGender.FEMALE.getName(), eRole.PT.getName(), 7000000, 8000000, 10, "NANG TA BANG 1 TAY", "BANG PHI CONG", eCoachingStyle.STRONG.getName(), schedule1));
        trainer.add(new Trainer(2, "Nguyen Anh Tuan", "tuanadtpt", "123456", 29, 199223, 1900332, "28 Nguyen Tri Phuong", "tuanadtpt@gmail.com", eGender.MALE.getName(), eRole.PT.getName(), 7000000, 8000000, 10, "NANG TA BANG 1 TAY", "BANG MAY BAY", eCoachingStyle.HEALTHY.getName(), schedule2));
        trainer.add(new Trainer(3, "Le Em Tuan", "tuanempt", "123456", 24, 199224, 1900333, "28 Nguyen Tri Phuong", "tuanpt@gmail.com", eGender.MALE.getName(), eRole.PT.getName(), 7000000, 8000000, 10, "NANG TA BANG 1 TAY", "BANG XE TANG", eCoachingStyle.STRONG.getName(), schedule3));
        trainer.add(new Trainer(4, "Le Anh Tuan", "tuananhpt", "123456", 24, 197222, 1900334, "28 Nguyen Tri Phuong", "tuananhpt@gmail.com", eGender.MALE.getName(), eRole.PT.getName(), 7000000, 8000000, 10, "NANG TA BANG 1 TAY", "BANG XE TANG", eCoachingStyle.STRONG.getName(), schedule3));
        trainer.add(new Trainer(5, "Tran Dinh Duy", "duypt", "123456", 27, 169222, 1900335, "28 Nguyen Tri Phuong", "duypt@gmail.com", eGender.MALE.getName(), eRole.PT.getName(), 7000000, 8000000, 10, "NANG TA BANG 1 TAY", "BANG XE MAY", eCoachingStyle.STRONG.getName(), schedule1));
        trainer.add(new Trainer(6, "Nguyen Ngoc Anh", "anhpt", "123456", 27, 159224, 1900336, "28 Nguyen Tri Phuong", "anhpt@gmail.com", eGender.FEMALE.getName(), eRole.PT.getName(), 7000000, 8000000, 10, "NANG TA BANG 1 TAY", "BANG XE MAY", eCoachingStyle.STRONG.getName(), schedule1));
        trainer.add(new Trainer(7, "Nguyen Xuan Phuc", "phucpt", "123456", 25, 195226, 1900337, "28 Nguyen Tri Phuong", "phucpt@ggmail.com", eGender.MALE.getName(), eRole.PT.getName(), 7000000, 8000000, 10, "NANG TA BANG 1 TAY", "BANG CU NHAN", eCoachingStyle.STRONG.getName(), schedule4));
        SerializationUtil.serialize(trainer, "trainer.txt");
    }

    public static void initProduct() {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "THUONG", 1000000, 3, "NO-TRAINER"));
        products.add(new Product(2, "THUONG", 2000000, 6, "NO-TRAINER"));
        products.add(new Product(3, "THUONG", 3000000, 9, "NO-TRAINER"));
        products.add(new Product(4, "BAC", 2000000, 3, "TRAINED"));
        products.add(new Product(5, "BAC", 4000000, 6, "TRAINED"));
        products.add(new Product(6, "BAC", 6000000, 9, "TRAINED"));
        SerializationUtil.serialize(products, "products.txt");
    }

    public static void initBill() {
        List<Bill> bills = new ArrayList<>();
        bills.add(new Bill(1, clientList.get(0), trainerList.get(0), productList.get(3), 6000000, "CONFIRMED"));
        bills.add(new Bill(2, clientList.get(1), trainerList.get(2), productList.get(3), 6000000, "CONFIRMED"));
        bills.add(new Bill(3, clientList.get(2), trainerList.get(3), productList.get(3), 6000000, "CONFIRMED"));
        for (Bill bill : bills) {
            System.out.println(bill);
        }
        SerializationUtil.serialize(bills, "bill.txt");
    }

}
