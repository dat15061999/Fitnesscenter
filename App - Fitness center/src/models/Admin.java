package models;

import eNum.eRole;

import java.io.Serializable;
import java.util.Date;

public class Admin extends User implements Serializable {
    private static final long serialVersionUID = 3055276268292339966L;
    static boolean headerAdded = false;
    private  String role = String.valueOf(eRole.ADMIN);
    private  String date;
    public Admin() {}
    public Admin(int id,String name, String userName, String passWord,int age, int phone, int cccd, String address, String email, String gender) {
        super(id,name, userName, passWord,age, phone, cccd, address, email, gender);
    }

    public Admin(int id,String name, String userName, String passWord,int age, int phone, int cccd, String address, String email, String gender, String role,String date) {
        super(id,name, userName, passWord,age, phone, cccd, address, email, gender);
        this.role = role;
        this.date = date;
    }

    public String getRole() {
        return role;
    }

    public String getDate() {
        return this.date;
    }

    public  void setDate(String date) {
        this.date = date;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return  String.format("| %-4d | %-15s | %-20s | %-20s | %-10s |  %-8s  | %-30s | %-15s | %-8s | %-20s |",
                id, name, userName, passWord,String.valueOf(age),gender, email, role, phone, address);
    }
}
