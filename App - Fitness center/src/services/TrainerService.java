package services;

import models.Trainer;
import utils.CRUD;

import java.util.ArrayList;
import java.util.List;

public class TrainerService implements CRUD <Trainer> {
    public List<Trainer> trainerList = new ArrayList<>();
    public TrainerService trainerService;

    @Override
    public void create(Trainer trainer) {
        trainerList.add(trainer);
    }

    @Override
    public void delete(int idTrainer) {

    }

    @Override
    public void update(int idTrainer) {

    }

    @Override
    public void find() {

    }

    @Override
    public List<Trainer> findAll() {
        return trainerList;
    }


}
