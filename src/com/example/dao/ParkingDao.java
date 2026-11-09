package com.example.dao;

import com.example.entity.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ParkingDao {

    private Connection conn;


    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }



    public void insertParking(Parking parking) {
    Statement stmt = null;
    try {
        String sql = "INSERT INTO parkings(name,address,capacity) VALUES ('"
                + parking.getName() + "','"
                + parking.getAddress() + "',"
                + parking.getCapacity() + ")";
        stmt = conn.createStatement();
        stmt.executeUpdate(sql);

    } catch (SQLException se) {
        se.printStackTrace();
    } finally {
        try {
            if (stmt != null) stmt.close();
        } catch (SQLException se2) {
            se2.printStackTrace();
        }
    }
}


}
