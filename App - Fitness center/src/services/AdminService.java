package services;

import models.Admin;
import utils.CRUD;
import utils.GetValue;
import utils.SerializationUtil;

import java.util.ArrayList;
import java.util.List;

import static utils.GetValue.choose;

public class AdminService implements CRUD<Admin> {
    public static List<Admin> adminList = new ArrayList<>();
    public static AdminService adminService;
    public static Admin admin;

    @Override
    public void create(Admin admin) {
        admin.setId(admin.getId());
        adminList.add(admin);
    }

    @Override
    public void delete(int idAdmin) {
        for (Admin admin: adminList) {
            if (idAdmin == admin.getId()) {
                adminList.remove(admin);
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
    public List<Admin> findAll() {
        return adminList;
    }


}
