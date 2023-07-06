package models;

import eNum.eRole;

import java.io.Serializable;

public class Client extends User implements Serializable {
    private String role = String.valueOf(eRole.CLIENT);
    private double height;
    private double weight;
    private double bmi = weight / (height*2);
    private String status;
    private String target;
    private String stateOfStrength;

    public Client(String name, String userName, String passWord, int phone, int cccd, String address, String email, String gender) {
        super(name, userName, passWord, phone, cccd, address, email, gender);
    }

    public Client(String name, String userName, String passWord, int phone, int cccd, String address, String email, String gender, String role, double height, double weight, double bmi, String status, String target, String stateOfStrength) {
        super(name, userName, passWord, phone, cccd, address, email, gender);
        this.role = role;
        this.height = height;
        this.weight = weight;
        this.bmi = bmi;
        this.status = getStatus();
        this.target = target;
        this.stateOfStrength = stateOfStrength;
    }

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
        return bmi = bmi;
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

    public String getStatus() {
        if (bmi >= 30) {
            return status = "BEO PHI DO II";
        } else if (bmi >=25 &&  bmi < 30) {
            return status = "BEO PHI DO I";
        } else if (bmi >=23 &&  bmi < 25) {
            return status = "TIEN BEO PHI";
        } else if (bmi >=23) {
            return status = "THUA CAN";
        } else if (bmi >=19 &&  bmi < 23) {
            return status = "BINH THUONG";
        }
        return status = "BINH THUONG";
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
