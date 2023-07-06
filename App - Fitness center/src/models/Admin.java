package models;

import eNum.eRole;

import java.io.Serializable;

public class Admin extends User implements Serializable {
    private String role = String.valueOf(eRole.ADMIN);
    public Admin(String name, String userName, String passWord, int phone, int cccd, String address, String email, String gender) {
        super(name, userName, passWord, phone, cccd, address, email, gender);
    }

    public Admin(String name, String userName, String passWord, int phone, int cccd, String address, String email, String gender, String role) {
        super(name, userName, passWord, phone, cccd, address, email, gender);
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
        return "Admin{" +
                "role='" + role + '\'' +
                ", idCurrent=" + idCurrent +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", phone=" + phone +
                ", cccd=" + cccd +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
