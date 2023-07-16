package models;
import utils.CurrencyFormat;
import utils.GetValue;

import java.io.PipedReader;
import java.io.Serializable;
import java.time.LocalDate;

public class Bill extends BIllDetail implements Serializable {
    private static final long serialVersionUID = 10L;
    private int id;
    private String statusCoach ="NONE";
    private String status = "UNPAID";


    public Bill() {}

    public Bill(int id, Client clientMember, Trainer trainerPerson, Product product, LocalDate timeExp, double total, String statusCoach, String status) {
        super(trainerPerson, product, total, clientMember, timeExp);
        this.id = id;
        this.status = status;
        this.statusCoach=statusCoach;
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

    public String getStatusCoach() {
        return statusCoach;
    }

    public void setStatusCoach(String statusCoach) {
        this.statusCoach = statusCoach;
    }

    @Override
    public String toString() {
        return  String.format("| %-4d | %-20s | %-10s | %-10s | %-20s | %-14s | %-10s | %-8s | %-10s | %-14s | %-14s | %-12s | %-15s | %-12s |\n",
                id,
                clientMember.getName(),
                clientMember.getScheduleClient(),
                product.getNameCard(),
                ( trainerPerson!=null? trainerPerson.getName() : "NONE-COACH"),
               (trainerPerson!=null && getStatusCoach().equals("CONFIRMED")? String.valueOf(CurrencyFormat.
                      covertPriceToString(
                              getTrainerPerson()
                                      .getPriceCoachHire())):0)
                ,GetValue.backFormatLocalDate(timeExp),
                String.valueOf(product.getExpiryDate()), GetValue.getPlusTime(product.getExpiryDate(),timeExp),
                CurrencyFormat.covertPriceToString(product.getPriceCardClass()),
                CurrencyFormat.covertPriceToString(getTotal()),
                product.getStatus(),
                statusCoach,status);
    }
}
