package com.lab.domain;

import java.sql.Date;

public class Renter {
String renterName;
String city;
int carId;
Date birthday;

public Renter(){}

    public Renter(String renterName,String city,int carId,Date birthday){
    this.renterName=renterName;
    this.city=city;
    this.carId=carId;
    this.birthday=birthday;
    }



    public String getRenterName() {
        return renterName;
    }

    public void setRenterName(String renterName) {
        this.renterName = renterName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String toString(){
        return renterName + " " + city + " " + carId + " " + birthday;
    }
}
