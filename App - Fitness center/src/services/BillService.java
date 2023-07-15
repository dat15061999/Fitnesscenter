package services;

import models.Bill;
import utils.AppUtils;
import utils.CRUD;
import utils.GetValue;
import utils.SerializationUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static page.TrainerPage.trainerPage;
import static services.ClientService.createClientOfBill;
import static services.ClientService.setStatusClient;
import static services.ProductService.getProduct;
import static services.TrainerService.getTrainer;
import static view.ProductView.printProduct;

public class BillService implements CRUD<Bill> {
    private static int nextIdBill;
    private static String addressBill = "bill.txt";
    public static List<Bill> billList;

    static {
        billList = (List<Bill>) SerializationUtil.deserialize(addressBill);
        if (billList.isEmpty()) {
            billList = new ArrayList<>();
        }
        nextIdBill = AppUtils.findNext(billList.stream().map(Bill::getId).collect(Collectors.toList()));
    }

    private static void save() {
        SerializationUtil.serialize(billList, addressBill);
    }

    @Override
    public void create(Bill bill) {
        bill.setId(nextIdBill);
        bill.setClientMember(createClientOfBill());
        printProduct();
        bill.setProduct(getProduct(GetValue.getInt("Chon goi tap ")));
        if ((bill.getProduct().getStatus().contains("TRAINED"))) {
            bill.setTrainerPerson(getTrainer(bill.getClientMember().getScheduleClient(), bill.getProduct().getStatus()));
        } else {
            bill.setTrainerPerson(null);
        }
        bill.setTimeExp(bill.getTimeExp());
        billList.add(bill);
        save();
    }

    @Override
    public void delete(int idBill) {
        Bill billDelete = null;
        for (Bill bill : billList) {
            if (idBill == bill.getId()) {
                billDelete = bill;
                System.out.println("Xoa bill co id la " + idBill + " thanh cong!");
            }
        }
        billList.remove(billDelete);
        save();
    }

    @Override
    public void update(int id) {
        if (billList != null) {
            billList.stream().filter(e -> e.getId() == id).findFirst().map(e -> {
                e.setTrainerPerson(getTrainer(e.getClientMember().getScheduleClient(), e.getProduct().getStatus()));
                e.setStatusCoach("NONE");
                e.getClientMember().setStatusMember("REGISTERED");
                return e;
            }).orElse(null);
            save();
        }
    }

    public void updateProduct(int id) {
        if (billList != null) {
            billList.stream().filter(e -> e.getId() == id).findFirst().map(e -> {
                e.setProduct(getProduct(GetValue.getInt("Chon goi tap ")));
                return e;
            }).orElse(null);
            save();
        }
    }

    @Override
    public List<Bill> readFile() {
        return billList;
    }


    public static String findClient(int idClient) {
        if (billList.stream().anyMatch(e -> e.getClientMember().getId() == idClient)) {
            if (billList.stream().anyMatch(e -> e.getStatusCoach().contains("CONFIRMED"))) {
                return "REGISTERED";
            }
            return "REGISTERING";
        }
        return "NONE";
    }

    public static void printTrainerSchedule(String userName, String statusCoach) {
        if (billList != null) {
            if (billList.stream()
                    .filter(e -> e.getTrainerPerson() != null)
                    .anyMatch(e -> e.getTrainerPerson()
                            .getUsername().contains(userName))) {
                    System.out.printf("| %-20s | %-5s | %-15s | %-8s | %-8s | %-8s | %-20s | %-15s | %-10s | %-10s | %-10s | %-15s |\n",
                            "Name", "Age", "Phone", "Gender", "Weight", "Height", "BMI", "Status BMI", "Schedule", "Target", "Strength", "Status Member");
                    billList.stream().
                            filter(e -> e.getTrainerPerson() != null).
                            filter(e -> e.getTrainerPerson().getUsername().equals(userName) && e.getStatusCoach().equals(statusCoach)).
                            forEach(client -> {
                                System.out.printf("| %-20s | %-5s | %-15s | %-8s | %-8s | %-8s | %-20s | %-15s | %-10s | %-10s | %-10s | %-15s |\n",
                                        client.getClientMember().getName(), String.valueOf(client.getClientMember().getAge()), client.getClientMember().getPhone(),
                                        client.getClientMember().getGender(), client.getClientMember().getWeight(), client.getClientMember().getHeight(),
                                        client.getClientMember().getBmi(), client.getClientMember().getStatusBmi(), client.getClientMember().getScheduleClient(),
                                        client.getClientMember().getTarget(), client.getClientMember().getStateOfStrength(), client.getClientMember().getStatusMember());
                            });
            }
        } else
            System.out.println("CHUA CO KHACH HANG DANG KY MOI");
    }

    public static void scheduleConfirm(String userName, String statusClient, int choose) {
        if (billList != null) {
            switch (choose) {
                case 1:
                    billList.stream().filter(e -> e.getTrainerPerson() != null).filter(e -> e.getTrainerPerson().getUsername().contains(userName)).
                            filter(e -> e.getStatusCoach().contains(statusClient)).
                            forEach(e -> {
                                e.setStatusCoach("CONFIRMED");
                            });
                    System.out.println("Xac nhan lich tap thanh cong");
                    save();
                    break;
                case 2:
                    billList.stream().filter(e -> e.getTrainerPerson() != null).filter(e -> e.getTrainerPerson().getUsername().contains(userName)).
                            filter(e -> e.getStatusCoach().contains(statusClient)).
                            forEach(e -> {
                                e.setStatusCoach("UNCONFIRMED");
                                e.setTrainerPerson(null);
                            });
                    System.out.println("Huy lich tap voi khach hang thanh cong");
                    save();
                    return;
                case 0:
                    trainerPage(userName);
                    break;
            }
        } else
            scheduleConfirm(userName, statusClient, GetValue.getInt("Moi nhap lai"));
    }


    @Override
    public void getAll() {
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("|                                                                          Bill List                                                                                                                                            |");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-4s | %-20s | %-10s | %-10s | %-20s | %-14s | %-10s | %-8s | %-10s | %-14s | %-14s | %-12s | %-15s | %-12s |\n",
                "ID", "Name Client", "Schedule", "Card Class", "Coach", "Price Hire", "Time Star", "Month", "Time End", "Price Card", "Total", "Hire", "Status Coach", "Payment");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        if (billList != null) {
            for (Bill bill : billList) {
                System.out.println(bill);
            }
        } else {
            System.out.println("Bill list is empty.");
        }
    }

    public static void payments(String statusPay) {
        if (billList != null) {
            billList.stream().filter(e -> e.getStatus().equals(statusPay))
                    .forEach(System.out::println);
        }
    }

    public static void confirmPayments(int idBill) {
        if (billList != null) {
            billList.stream().filter(e -> e.getId() == idBill).findFirst().map(e -> {
                        e.setStatus("PAID");
                        return e;
                    })
                    .orElse(null);
            save();
            System.out.println("THANH TOAN THANH CONG");
        }
    }


}
