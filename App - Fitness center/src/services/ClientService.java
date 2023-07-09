package services;

import models.Client;
import models.Trainer;
import utils.CRUD;
import utils.GetValue;
import utils.SerializationUtil;

import java.util.ArrayList;
import java.util.List;

public class ClientService implements CRUD<Client> {
    static List<Client> clientList = new ArrayList<>();
    @Override
    public void create(Client client) {
        client.setId(client.getId());
        clientList.add(client);
    }

    @Override
    public void delete(int idClient) {
        for (Client client: clientList) {
            if (idClient == client.getId()) {
                clientList.remove(client);
                System.out.println("Xoa Client co id la " + idClient + " thanh cong.");
                break;
            }
        }
    }

    @Override
    public void update(int idClient) {
        for (Client client: clientList) {
            if (idClient == client.getId()) {
                System.out.println("1. Sua thong tin khach hang");
                System.out.println("2. Sua thong tin huan luyen khach hang");
                switch (GetValue.getInt("Enter your choice :")) {
                    case 1:
                        client.setName(GetValue.getString("Nhap ten moi :"));
                        client.setUserName(GetValue.getString("Nhap userName :"));
                        client.setPassWord(GetValue.getString("Nhap passWord :"));
                        client.setAge(GetValue.getInt("Nhap tuoi"));
                        client.setPhone(GetValue.getPhone("Nhap so dien thoai"));
                        client.setCccd(GetValue.getCccd("Nhap cccd"));
                        client.setAddress(GetValue.getString("Nhap dia chi"));
                        client.setEmail(GetValue.getString("Nhap emali :"));
                        client.setGender(GetValue.getGender("Nhap gioi tinh :"));
                        System.out.println("Thay doi thong tin khach hang thanh cong!");
                        break;
                    case 2: //  weight, height, String.format("%.6f", bmi), status, target, stateOfStrength);
                        client.setWeight(GetValue.getDou("Nhap trong luong "));
                        client.setHeight(GetValue.getDou("Nhap chieu cao "));
                        client.setTarget(GetValue.getTarget("Chon muc tieu"));
                        client.setStateOfStrength(GetValue.getString("Nhap tinh trang suc khoe"));
                        System.out.println("Thay doi thong tin huan luyen cua khach hang thanh cong!");
                        break;
                }
            }
        }
    }

    @Override
    public void find() {

    }

    @Override
    public List<Client> readFile() {
        this.clientList = (List<Client>) SerializationUtil.deserialize("clients.txt");
        return this.clientList;
    }

    @Override
    public List<Client> getAll() {
        return this.clientList;
    }
}
