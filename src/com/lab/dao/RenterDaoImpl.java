package com.lab.dao;

import com.lab.connection.MyConnection;
import com.lab.domain.Car;
import com.lab.domain.Renter;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RenterDaoImpl implements RenterDao {

    Connection connection;

    public RenterDaoImpl() {
        MyConnection myConnection = new MyConnection();
        connection = myConnection.connection;
    }

    private static final String SELECT_ALL = "SELECT * FROM renter;";
    private static final String SELECT_RENTER = "SELECT * FROM renter WHERE renter.car_id=?;";
    private static final String UPDATE_RENTER = "UPDATE renter SET renter_name=? WHERE renter_id=?;";
    private static final String UPDATE_RENTER_CITY = "UPDATE renter SET city=? WHERE renter_id=?;";
    private static final String UPDATE_RENTER_BIRTHDAY = "UPDATE renter SET birthday=? WHERE renter_id=?;";
    private static final String UPDATE_CAR_ID = "UPDATE renter SET car_id=? WHERE renter_id=?;";
    private static final String DELETE_RENTER = "DELETE FROM renter WHERE renter_id=?;";
    private static final String SELECT_RENTER_BY_ID = "SELECT * FROM renter WHERE renter_id=?;";
    private static final String CREATE_RENTER = "INSERT INTO renter (renter_name,city,car_id,birthday) VALUES(?,?,?,?)";


    @Override
    public List<Renter> getAll() {
        List list = new ArrayList();

        try {
            PreparedStatement statement = null;
            statement = connection.prepareStatement(SELECT_ALL);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Renter renter = new Renter();
                renter.setRenterName(rs.getString("renter_name"));
                renter.setCity(rs.getString("city"));
                renter.setCarId(rs.getInt("car_id"));
                renter.setBirthday(rs.getDate("birthday"));
                list.add(renter);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;

    }

    @Override
    public Renter getRenter(int id) {
        Renter renter = new Renter();

        try {
            PreparedStatement statement = null;
            statement = connection.prepareStatement(SELECT_RENTER);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            rs.next();
            renter.setRenterName(rs.getString("renter_name"));
            renter.setCity(rs.getString("city"));
            renter.setCarId(rs.getInt("car_id"));
            renter.setBirthday(rs.getDate("birthday"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return renter;
    }

    @Override
    public boolean create(Renter renter) {

        try {
            PreparedStatement statement = null;
            String renterName = renter.getRenterName();
            String renterCity = renter.getCity();
            int renterCarId = renter.getCarId();
            Date renterBirthday = renter.getBirthday();
            statement = connection.prepareStatement(CREATE_RENTER);
            statement.setString(1, renterName);
            statement.setString(2, renterCity);
            statement.setInt(3, renterCarId);
            statement.setDate(4, renterBirthday);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean deleteRenter(int id) {

        try {
            PreparedStatement statement = null;
            statement = connection.prepareStatement(SELECT_RENTER_BY_ID, ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            if (!resultSet.first()) {
                return false;
            } else {
                statement = connection.prepareStatement(DELETE_RENTER);
                statement.setInt(1, id);
                statement.executeUpdate();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean changeRenterName(String renterName, int id) {

        try {
            PreparedStatement statement = null;
            statement = connection.prepareStatement(UPDATE_RENTER);
            statement.setString(1, renterName);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean changeRenterCity(String city, int id) {

        try {
            PreparedStatement statement = null;
            statement = connection.prepareStatement(UPDATE_RENTER_CITY);
            statement.setString(1, city);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean changeRenterBirthday(Date birthday, int id) {

        try {
            PreparedStatement statement = null;
            statement = connection.prepareStatement(UPDATE_RENTER_BIRTHDAY);
            statement.setDate(1, birthday);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean changeCarId(int carId, int id) {

        try {
            PreparedStatement statement = null;
            statement = connection.prepareStatement(UPDATE_CAR_ID);
            statement.setInt(1, carId);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return true;
    }
}
