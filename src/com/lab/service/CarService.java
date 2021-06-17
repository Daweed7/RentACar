package com.lab.service;

import com.lab.dao.CarDao;
import com.lab.dao.CarDaoImpl;
import com.lab.dao.IDao;
import com.lab.domain.Car;

import java.util.List;

public class CarService {

    CarDao newCarDao = new CarDaoImpl();

    public Car get(int id) {
        return newCarDao.getName(id);

    }

    public List<Car> getAll() {
        return newCarDao.getAll();
    }

    public boolean createCar(Car car) {
        newCarDao.createCar(car);
        return true;
    }

    public boolean deleteCar(int id){
        newCarDao.deleteCar(id);
        return true;
    }

    public boolean changCarName(String name,int id){
        newCarDao.changeCarName(name,id);
        return true;
    }

    public boolean changCarColor(String color,int id){
        newCarDao.changeCarColor(color,id);
        return true;
    }

    public boolean changCarPrice(int price,int id){
        newCarDao.changeCarPrice(price,id);
        return true;
    }

    public List<Car> showFreeCars(){
       return newCarDao.getFreeCars();
    }
}
