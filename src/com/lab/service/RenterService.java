package com.lab.service;

import com.lab.dao.IDao;
import com.lab.dao.RenterDaoImpl;
import com.lab.domain.Renter;

import java.sql.Date;
import java.util.List;

public class RenterService {

    RenterDaoImpl renterDao = new RenterDaoImpl();

    public Renter get(int id) {
        return renterDao.getRenter(id);
    }

    public List<Renter> getAll() {
        return renterDao.getAll();
    }

    public boolean createRenter(Renter renter){
        renterDao.create(renter);
        return true;
    }

    public boolean deleteRenter(int id){
        renterDao.deleteRenter(id);
        return true;
    }

    public boolean changeRenterName(String name,int id){
    renterDao.changeRenterName(name,id);
        return true;
    }
    public boolean changeRenterCity(String city,int id){
        renterDao.changeRenterCity(city,id);
        return true;
    }
    public boolean changeRenterCar_id(int carId,int id){
    renterDao.changeCarId(carId,id);
        return true;
    }
    public boolean changeRenterBirthday(Date birthday,int id){
        renterDao.changeRenterBirthday(birthday,id);
        return true;
    }

}
