package services;

import models.Admin;
import models.Trainer;
import utils.CRUD;
import utils.GetValue;
import utils.SerializationUtil;

import java.util.ArrayList;
import java.util.List;

public class TrainerService implements CRUD <Trainer> {
    static List<Trainer> trainerList = new ArrayList<>();
    static String addressTrainer = "trainer.txt";

    @Override
    public void create(Trainer trainer) {
        trainer.setId(trainer.getId());
        trainerList.add(trainer);
    }

    @Override
    public void delete(int idTrainer) {
        for (Trainer trainer :trainerList) {
            if(idTrainer == trainer.getId()) {
                trainerList.remove(trainer);
                break;
            }
        }
    }

    @Override
    public void update(int idTrainer) {
        for (Trainer trainer: trainerList) {
            if (idTrainer == trainer.getId()) {
                trainer.setName(GetValue.getString("Nhap ten moi :"));
                trainer.setUserName(GetValue.getString("Nhap userName :"));
                trainer.setPassWord(GetValue.getString("Nhap passWord :"));
                trainer.setAge(GetValue.getInt("Nhap tuoi"));
                trainer.setPhone(GetValue.getInt("Nhap so dien thoai"));
                trainer.setCccd(GetValue.getInt("Nhap cccd"));
                trainer.setAddress(GetValue.getString("Nhap dia chi"));
                trainer.setEmail(GetValue.getString("Nhap emali :"));
                trainer.setGender(GetValue.getString("Nhap gioi tinh :"));
                System.out.println("Thay doi thong tin Trainer thanh cong");
                break;
            }
        }
    }

    @Override
    public void find() {

    }

    @Override
    public List<Trainer> readFile() {
        this.trainerList = (List<Trainer>) SerializationUtil.deserialize(addressTrainer);
        return this.trainerList;
    }

    @Override
    public List<Trainer> getAll() {
        return this.trainerList;
    }


}
