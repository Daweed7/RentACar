package com.lab.dao;

import com.lab.domain.Renter;

import java.sql.Date;
import java.util.List;

public interface RenterDao extends IDao{
    @Override
    List<Renter> getAll();

    Renter getRenter(int id);

    boolean create(Renter renter);

    boolean deleteRenter(int id);

    boolean changeRenterName(String renterName,int id);

    boolean changeRenterCity(String city,int id);

    boolean changeRenterBirthday(Date birthday, int id);

    boolean changeCarId(int carId,int id);


}
