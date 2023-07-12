package models;

import utils.CurrencyFormat;
import utils.GetValue;

import java.io.Serializable;

import static utils.CurrencyFormat.covertPriceToString;

public class Bill extends BIllDetail implements Serializable {
    private static final long serialVersionUID = 10L;
    private int id;

    private String status = "UNCONFIRMED";

    public Bill() {}

    public Bill(int id, Client clientMember,Trainer trainerPerson, Product product, double total, String status) {
        super(trainerPerson, product, total, clientMember);
        this.id = id;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return  String.format("| %-4d | %-20s | %-10s | %-10s | %-20s | %-14s | %-10s | %-8s | %-10s | %-14s | %-14s | %-10s |\n",
                id, clientMember.getName(),clientMember.getScheduleClient(), product.getNameCard(), getTrainerPerson().getName(),String.valueOf(CurrencyFormat.covertPriceToString(trainerPerson.getPriceCoachHire())),getTimeExp(),String.valueOf(product.getExpiryDate()), GetValue.getPlusTime(product.getExpiryDate()), CurrencyFormat.covertPriceToString(product.getPriceCardClass()),CurrencyFormat.covertPriceToString(getTotal()),status);
    }
}
