package com.lab.dao;

import com.lab.domain.Car;

import java.util.List;

public interface CarDao extends IDao {
    @Override
    List<Car> getAll();

    Car getName(int id);

    public List<Car> getFreeCars();

    boolean changeCarName(String carName,int id);

    boolean changeCarColor(String carColor,int id);

    boolean changeCarPrice(int price,int id);


    boolean deleteCar(int id);

    boolean createCar(Car car);
}
