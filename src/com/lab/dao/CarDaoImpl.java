package com.lab.dao;

import java.sql.*;

import com.lab.connection.MyConnection;
import com.lab.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class CarDaoImpl implements CarDao {
    Connection connection;

    public CarDaoImpl() {
        MyConnection myConnection = new MyConnection();
        connection = myConnection.connection;
    }

    private static final String SELECT_ALL = "SELECT * FROM car;";
    private static final String SELECT_CAR = "SELECT * FROM car WHERE car.car_id=?;";
    private static final String UPDATE_CAR_NAME = "UPDATE car SET car_name=? " +
            "WHERE car_id=?";
    private static final String UPDATE_CAR_COLOR = "UPDATE car SET car_color=? " +
            "WHERE car_id=?";
    private static final String UPDATE_CAR_PRICE = "UPDATE car SET car_price=? " +
            "WHERE car_id=?";
    private static final String DELETE_CAR = "DELETE FROM car WHERE car.car_id=?;";
    private static final String LOOK_FOR_CAR = "SELECT * FROM car WHERE car.car_id=?;";
    private static final String CREATE_CAR = "INSERT INTO car (car_name,car_color,car_price) VALUES(?,?,?)";
    private static final String SELECT_FREE_CARS = "SELECT car_name,car_color,car_price FROM car LEFT JOIN renter" +
            " ON car.car_id=renter.car_id WHERE renter.car_id IS NULL;";

    public List<Car> getFreeCars() {
        List list = new ArrayList();
        try {
            PreparedStatement statement = null;
            statement = connection.prepareStatement(SELECT_FREE_CARS);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Car car = new Car();
                car.setCarName(rs.getString("car_name"));
                car.setCarColor(rs.getString("car_color"));
                car.setCarPrice(rs.getInt("car_price"));
                list.add(car);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Car> getAll() {
        List list = new ArrayList();
        try {
            PreparedStatement statement = null;
            statement = connection.prepareStatement(SELECT_ALL);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Car car = new Car();
                car.setCarName(rs.getString("car_name"));
                car.setCarColor(rs.getString("car_color"));
                car.setCarPrice(rs.getInt("car_price"));
                list.add(car);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;

    }

    @Override
    public Car getName(int id) {
        Car car = new Car();

        try {
            PreparedStatement statement = null;
            statement = connection.prepareStatement(SELECT_CAR);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            rs.next();
            car.setCarName(rs.getString("car_name"));
            car.setCarColor(rs.getString("car_color"));
            car.setCarPrice(rs.getInt("car_price"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return car;
    }

    @Override
    public boolean changeCarName(String carName, int id) {

        try {
            PreparedStatement statement = null;
            statement = connection.prepareStatement(UPDATE_CAR_NAME);
            statement.setString(1, carName);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean changeCarColor(String carColor, int id) {

        try {
            PreparedStatement statement = null;
            statement = connection.prepareStatement(UPDATE_CAR_COLOR);
            statement.setString(1, carColor);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean changeCarPrice(int price, int id) {

        try {
            PreparedStatement statement = null;
            statement = connection.prepareStatement(UPDATE_CAR_PRICE);
            statement.setInt(1, price);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean deleteCar(int id) {

        try {
            PreparedStatement statement = null;
            statement = connection.prepareStatement(LOOK_FOR_CAR, ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            if (!resultSet.first()) {
                return false;
            } else {
                statement = connection.prepareStatement(DELETE_CAR);
                statement.setInt(1, id);
                statement.executeUpdate();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean createCar(Car car) {

        try {
            PreparedStatement statement = null;
            String carName = car.getCarName();
            String carColor = car.getCarColor();
            int carPrice = car.getCarPrice();
            statement = connection.prepareStatement(CREATE_CAR);
            statement.setString(1, carName);
            statement.setString(2, carColor);
            statement.setInt(3, carPrice);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return true;
    }
}
