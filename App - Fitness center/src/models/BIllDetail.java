package models;

import utils.GetValue;

import java.io.Serializable;
import java.time.LocalDate;


import static services.TrainerService.remoteSchedule;

public class BIllDetail implements Serializable {
    private static final long serialVersionUID = 15L;
    protected Trainer trainerPerson;

    protected Product product;
    protected Client clientMember;
    protected double total;
    protected LocalDate timeExp;

    public BIllDetail() {
    }

    public BIllDetail(Trainer trainerPerson, Product product, double total, Client clientMember, LocalDate timeExp) {
        this.trainerPerson = trainerPerson;
        this.product = product;
        this.total = total;
        this.timeExp = timeExp;
        this.clientMember = clientMember;
    }

    public Trainer getTrainerPerson() {
        if (trainerPerson != null) {
            if (clientMember != null && "REGISTERED".equals(clientMember.getStatusMember())) {
                remoteSchedule(trainerPerson.getId(), clientMember.getScheduleClient());
            }
            return trainerPerson;
        }
        return null;
    }


    public void setTrainerPerson(Trainer trainerPerson) {
        this.trainerPerson = trainerPerson;
    }

    public Client getClientMember() {
        return clientMember;
    }

    public void setClientMember(Client clientMember) {
        this.clientMember = clientMember;
    }


    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getTotal() {
        return total = (((trainerPerson != null && clientMember.getStatusMember().equals("REGISTERING")) ? product.getPriceCardClass():
                (clientMember.getStatusMember().equals("REGISTERED"))? trainerPerson.getPriceCoachHire() + product.getPriceCardClass() : 0));
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public LocalDate getTimeExp() {
        if (timeExp == null) {
            return GetValue.getTimeNow();
        }
        return timeExp;
    }

    public void setTimeExp(LocalDate timeExp) {
        this.timeExp = timeExp;
    }
}
