package com.lab.domain;

public class Car {

   String carName;
   String carColor;
   int carPrice;

   public Car(){
   }

   public Car(String carName,String carColor,int carPrice){
       this.carName=carName;
       this.carColor=carColor;
       this.carPrice=carPrice;
   }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public int getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(int carPrice) {
        this.carPrice = carPrice;
    }
    public String toString(){
        return carName+" "+carColor+" "+carPrice;
    }
}
