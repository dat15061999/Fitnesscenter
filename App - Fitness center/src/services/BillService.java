package services;
import models.Bill;
import models.Client;
import utils.AppUtils;
import utils.CRUD;
import utils.SerializationUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static services.ClientService.createClientOfBill;
import static view.ClientView.addClient;

public class BillService implements CRUD<Bill> {
    private static int nextIdBill;
    private static String addressBill = "bill.txt";
    private static List<Bill> billList;
    static {
        billList = (List<Bill>) SerializationUtil.deserialize(addressBill);
        if (billList.isEmpty()) {
            billList = new ArrayList<>();
        }
        nextIdBill = AppUtils.findNext(billList.stream().map(e->e.getId()).collect(Collectors.toList()));
    }
    private static void save() {
        SerializationUtil.serialize(billList,addressBill);
    }
    @Override
    public void create(Bill bill) {
        bill.setId(nextIdBill);
        bill.setClientMember(createClientOfBill(new Client()));
//        bill.setProduct();
//        bill.setTrainerPerson();
//        bill.setPriceTrainer();
        billList.add(bill);
        save();
    }

    @Override
    public void delete(int idBill) {
        Bill billDelete = null;
        for (Bill bill : billList) {
            if (idBill == bill.getId()) {
                billDelete = bill;
                System.out.println("Xoa bill co id la " + idBill +" thanh cong!");
            }
        }
        billList.remove(billDelete);
        save();
    }

    @Override
    public void update(int id) {

    }

    @Override
    public List<Bill> readFile() {
        return billList;
    }

    @Override
    public Bill find(int id) {
        return null;
    }

    @Override
    public void getAll() {
        // String.format("| %-4d | %-10s | %-20s | %-30s | %-10s | %-10s | %-10s | %-10s | %-15s |\n",
        //                id, clientMember.getName(), timeExp, trainerPerson.getName(),priceTrainer,product.getNameCard(),product.getPriceCardClass(),product.getExpiryDate(),total);
        //
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("|                                                                          Bill List                                                                                                |");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-4s | %-20s | %-10s | %-10s | %-20s | %-14s | %-10s | %-8s | %-10s | %-14s | %-14s | %-10s |\n",
                "ID", "Name Client", "Schedule", "Card Class", "Coach", "Price Hire", "Time Star","Month","Time End","Price Card","Total","Status");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        if (billList != null) {
            for (Bill bill : billList) {
                System.out.println(bill);
            }
        } else {
            System.out.println("Bill list is empty.");
        }
    }

}
