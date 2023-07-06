package models;

public abstract class User {
    public int idCurrent =0 ;
    public int id;
    public String name;
    public String userName;
    public String passWord;
    public int phone;
    public int cccd;
    public String address;
    public String email;
    public String gender;

    public User( String name, String userName, String passWord, int phone, int cccd, String address, String email, String gender) {
        this.id = ++idCurrent;
        this.name = name;
        this.userName = userName;
        this.passWord = passWord;
        this.phone = phone;
        this.cccd = cccd;
        this.address = address;
        this.email = email;
        this.gender = gender;
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
}
