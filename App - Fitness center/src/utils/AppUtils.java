package utils;

import models.Bill;
import models.Client;
import models.Trainer;

import java.util.List;
import java.util.stream.Collectors;

public class AppUtils {
    public static int findNext(List<Integer> integers) {
        int max = 0;
        for (Integer integer : integers) {
            if (integer > max) {
                max = integer;
            }
        }
        return ++max;
    }

    public static String checkTrainer(String userName, List<Trainer> trainers) {
        boolean check = true;
        for (Trainer trainer : trainers) {
            if (trainer.getUserName().equals(userName)) {
                System.err.println("Tai khoan da ton tai!");
                check = false;
                break;
            }
        }
        if (check) {
            return userName;
        }
        return checkTrainer(GetValue.getString("Nhap userName"), trainers);
    }

    public static String checkClient(String userName, List<Client> clientList) {
        boolean check = true;
        for (Client client : clientList) {
            if (client.getUserName().equals(userName)) {
                System.err.println("Tai khoan da ton tai!");
                check = false;
                break;
            }
        }
        if (check) {
            return userName;
        }
        return checkClient(GetValue.getString("Nhap userName"), clientList);
    }

    public static Client checkBill(int idClient, List<Bill> billList, List<Client> clientList) {
        if (!billList.isEmpty() && !clientList.isEmpty()) {
            if ( billList.stream().anyMatch(bill -> bill.getId() == idClient)) {
                return (Client) clientList.stream().map(e -> e.getId() == idClient).collect(Collectors.toList());
            }
        }
        System.err.println("Tai khoan da dang ky!");
        return checkBill(idClient, billList, clientList);
    }
}
