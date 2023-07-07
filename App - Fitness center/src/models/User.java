package models;

import java.io.Serializable;

public abstract class User implements Serializable {
    public static int idCurrent =0 ;
    public int id;
    public String name;
    public String userName;
    public String passWord;
    public int phone;
    public int cccd;
    public String address;
    public String email;
    public String gender;
    public int age;



    public User(int id, String name, String userName, String passWord, int age, int phone, int cccd, String address, String email, String gender) {
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.passWord = passWord;
        this.age = age;
        this.phone = phone;
        this.cccd = cccd;
        this.address = address;
        this.email = email;
        this.gender = gender;
    }

    protected User() {
    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public int getIdCurrent() {
        return idCurrent;
    }

    public void setIdCurrent(int idCurrent) {
        this.idCurrent = idCurrent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getCccd() {
        return cccd;
    }

    public void setCccd(int cccd) {
        this.cccd = cccd;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
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
