package models;

import eNum.eRole;

import java.io.Serializable;

public class Client extends User implements Serializable {
    private static final long serialVersionUID = 3055276268292339966L;
    private String role = String.valueOf(eRole.CLIENT);
    private double height;
    private double weight;
    private double bmi;
    private String status;
    private String target;

    private String scheduleClient;
    private String stateOfStrength;

    public Client(int id,String name, String userName, String passWord,int age, int phone, int cccd, String address, String email, String gender) {
        super(id,name, userName, passWord,age, phone, cccd, address, email, gender);
    }

    public Client(int id,String name, String userName, String passWord,int age, int phone, int cccd, String address, String email, String gender, String role, double height, double weight, String target,String scheduleClient, String stateOfStrength) {
        super(id,name, userName, passWord,age, phone, cccd, address, email, gender);
        this.role = role;
        this.height = height;
        this.weight = weight;
        this.bmi = getBmi();
        this.status = getStatus();
        this.target = target;
        this.scheduleClient = scheduleClient;
        this.stateOfStrength = stateOfStrength;
    }
    public Client(String name,String scheduleClient) {}
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

    public String getStatus() {
        if (getBmi() >= 30) {
            return status = "BEO PHI DO II";
        } else if (getBmi() >=25 &&  getBmi() < 30) {
            return status = "BEO PHI DO I";
        } else if (getBmi() >=23 &&  getBmi() < 25) {
            return status = "TIEN BEO PHI";
        } else if (getBmi() >=23) {
            return status = "THUA CAN";
        } else if (getBmi() >=19 &&  getBmi() < 23) {
            return status = "BINH THUONG";
        }
        return status = "GAY";
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getScheduleClient() {
        return scheduleClient;
    }

    public void setScheduleClient(String scheduleClient) {
        this.scheduleClient = scheduleClient;
    }

    @Override
    public String toString() {
        return String.format("| %-4d | %-10s | %-10s | %-10s |  %-4s  | %-20s | %-10s | %-10s | %-20s | %-8s | %-8s | %-10s | %-15s | %-15s | %-10s | %-10s | %-10s |\n",
                id, name, userName, passWord, String.valueOf(age), email, role, phone, address, gender, weight, height, String.format("%.6f", bmi), status, target,scheduleClient, stateOfStrength);
    }

    public static void main(String[] args) {
        double bmi = 70.0 / (1.65 * 1.65);
        System.out.println(bmi);
    }
}
