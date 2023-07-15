package models;

import eNum.eRole;

import java.io.Serializable;

import static services.BillService.findClient;


public class Client extends User implements Serializable {
    private static final long serialVersionUID = 3055276268292339966L;
    private String role = String.valueOf(eRole.CLIENT);
    private double height;
    private double weight;
    private double bmi;
    private String statusBmi;

    private String target;

    private String scheduleClient;
    private String stateOfStrength;
    private String statusMember = "NONE";

    public Client(int id,String name, String userName, String passWord,int age, int phone, int cccd, String address, String email, String gender) {
        super(id,name, userName, passWord,age, phone, cccd, address, email, gender);
    }

    public Client(int id,String name, String userName, String passWord,int age, int phone, int cccd, String address, String email, String gender, String role, double height, double weight, String target,String scheduleClient, String stateOfStrength) {
        super(id,name, userName, passWord,age, phone, cccd, address, email, gender);
        this.role = role;
        this.height = height;
        this.weight = weight;
        this.bmi = getBmi();
        this.statusBmi = getStatusBmi();
        this.target = target;
        this.scheduleClient = scheduleClient;
        this.stateOfStrength = stateOfStrength;
        this.statusMember = statusMember;
    }

    public Client(){}

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getBmi() {
        return bmi = weight/(height*height);
    }
    public void setBmi(double bmi) {
        this.bmi = bmi;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getStateOfStrength() {
        return stateOfStrength;
    }

    public void setStateOfStrength(String stateOfStrength) {
        this.stateOfStrength = stateOfStrength;
    }

    public String getStatusMember() {
        return findClient(getId());
    }

    public void setStatusMember(String statusMember) {
        this.statusMember = statusMember;
    }

    public String getStatusBmi() {
        if (getBmi() >= 30) {
            return statusBmi = "BEO PHI DO II";
        } else if (getBmi() >=25 &&  getBmi() < 30) {
            return statusBmi = "BEO PHI DO I";
        } else if (getBmi() >=23 &&  getBmi() < 25) {
            return statusBmi = "TIEN BEO PHI";
        } else if (getBmi() >=23) {
            return statusBmi = "THUA CAN";
        } else if (getBmi() >=19 &&  getBmi() < 23) {
            return statusBmi = "BINH THUONG";
        }
        return statusBmi = "GAY";
    }

    public void setStatusBmi(String statusBmi) {
        this.statusBmi = statusBmi;
    }

    public String getScheduleClient() {
        return scheduleClient;
    }

    public void setScheduleClient(String scheduleClient) {
        this.scheduleClient = scheduleClient;
    }

    @Override
    public String toString() {
        return String.format("| %-4d | %-20s | %-10s | %-10s |  %-4s  | %-20s | %-10s | %-10s | %-20s | %-8s | %-8s | %-10s | %-15s | %-15s | %-10s | %-10s | %-10s | %-12s |\n",
                id, name, username, password.getPasscode(), String.valueOf(age), email, role, phone, address, gender, weight, height, String.format("%.6f", bmi), getStatusBmi(), target,scheduleClient, stateOfStrength,getStatusMember());
    }


}
