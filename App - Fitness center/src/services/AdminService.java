package services;

import models.Admin;
import utils.CRUD;
import utils.GetValue;
import utils.SerializationUtil;

import java.util.ArrayList;
import java.util.List;


public class AdminService implements CRUD<Admin> {
    public static List<Admin> adminList = new ArrayList<>();
    public static String address = "E:\\App - Fitness center\\Fitnesscenter\\App - Fitness center\\src\\database\\admin.txt";


    @Override
    public void create(Admin admin) {
        admin.setId(admin.getId());
        this.adminList.add(admin);
    }

    @Override
    public void delete(int idAdmin) {
        for (Admin admin: adminList) {
            if (idAdmin == admin.getId()) {
                adminList.remove(admin);
                System.out.println("Xoa admin co id la " + idAdmin + " thanh cong.");
                break;
            }
        }
    }
    @Override
    public void update(int idAdmin) {
        for (Admin admin: adminList) {
            if (idAdmin == admin.getId()) {
                admin.setName(GetValue.getString("Nhap ten moi :"));
                admin.setUserName(GetValue.getString("Nhap userName :"));
                admin.setPassWord(GetValue.getString("Nhap passWord :"));
                admin.setAge(GetValue.getInt("Nhap tuoi"));
                admin.setPhone(GetValue.getInt("Nhap so dien thoai"));
                admin.setCccd(GetValue.getInt("Nhap cccd"));
                admin.setAddress(GetValue.getString("Nhap dia chi"));
                admin.setEmail(GetValue.getString("Nhap emali :"));
                admin.setGender(GetValue.getString("Nhap gioi tinh :"));
                System.out.println("Thay doi thong tin Admin thanh cong");
                break;
            }
        }
    }

    @Override
    public void find() {

    }

    @Override
    public List<Admin> readFile() {
        this.adminList = (List<Admin>) SerializationUtil.deserialize(address);
        return this.adminList;
    }

    @Override
    public List<Admin> getAll() {
        return this.adminList;
    }


}
