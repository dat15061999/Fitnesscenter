package models;

import eNum.eRole;

import java.io.Serializable;

public class Admin extends User implements Serializable {
    private static final long serialVersionUID = 3055276268292339966L;
    static boolean headerAdded = false;
    private static String role = String.valueOf(eRole.ADMIN);
    public Admin() {}
    public Admin(int id,String name, String userName, String passWord,int age, int phone, int cccd, String address, String email, String gender) {
        super(id,name, userName, passWord,age, phone, cccd, address, email, gender);
    }

    public Admin(int id,String name, String userName, String passWord,int age, int phone, int cccd, String address, String email, String gender, String role) {
        super(id,name, userName, passWord,age, phone, cccd, address, email, gender);
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return  String.format("| %-4d | %-15s | %-20s | %-20s |  %-8s  | %-30s | %-15s | %-8s | %-20s |",
                id, name, userName, passWord,String.valueOf(age), email, role, phone, address);
    }
}
