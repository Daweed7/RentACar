package com.lab.console;


import com.lab.domain.Car;
import com.lab.service.CarService;

public class CarConsoleOutput {
    CarService carService=new CarService();
    public void outputCar(int id){
        System.out.println(carService.get(id));
    }
    public void outputAllCars(){
        for (Car c:carService.getAll())
        System.out.println(c);
    }

    public void outputFreeCars(){
        for (Car c:carService.showFreeCars())
            System.out.println(c);
    }
}
