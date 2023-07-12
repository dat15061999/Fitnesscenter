package models;

import utils.GetValue;
import java.io.Serializable;

import static services.TrainerService.remoteSchedule;

public class BIllDetail implements Serializable {
    private static final long serialVersionUID = 15L;
    protected Trainer trainerPerson;

    protected Product product;
    protected Client clientMember;
    protected double total;
    protected String timeExp = GetValue.getTimeNow();

    public BIllDetail() {
    }

    public BIllDetail(Trainer trainerPerson, Product product, double total, Client clientMember) {
        this.trainerPerson = trainerPerson;
        this.product = product;
        this.total = total;
        this.timeExp = timeExp;
        this.clientMember = clientMember;
    }

    public Trainer getTrainerPerson() {
        remoteSchedule(trainerPerson.getId(), clientMember.getScheduleClient());
        return trainerPerson;
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
        return total = (trainerPerson.getPriceCoachHire() + product.getPriceCardClass());
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getTimeExp() {
        return timeExp;
    }

    public void setTimeExp(String timeExp) {
        this.timeExp = timeExp;
    }
}
