/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.junit.runners.model.Statement;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * @author Jon
 */
public class Database {

    private String dbName;
    private final String url;

    public Database() {
        this.dbName = "/Users/Jon/Desktop/test.db";
        url = "jdbc:sqlite:" + dbName; //dbName name of the .db file
    }

    public Connection connectToDatabase() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to db " + dbName + " is established");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return conn;
    }

    private Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return conn;
    }

    /**
     * @param name
     * @param street
     * @param state
     * @param zip
     * @param country
     */
    public void addAddress(String name, String street, String state, String zip, String country) {

        String sql = "INSERT INTO IST411Lab (id, username, password, name, major, year, bio, interests, url)"
                + "VALUES (?,?,?,?,?,?,?,?,?)";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, "");
            pstmt.setString(2, "test");
            pstmt.setString(3, "test");
            pstmt.setString(4, "test");
            pstmt.setString(5, "test");
            pstmt.setString(6, "test");
            pstmt.setString(7, "test");
            pstmt.setString(8, "test");
            pstmt.setString(9, "test");
            

            pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public ArrayList<String> getAddressList() {
        ArrayList<String> addressInfo = new ArrayList<String>();;
        String name = "";
        String street = "";
        String state = "";
        String zip = "";

        String sql = "SELECT Name, Street, "
                + "State, Zip FROM IST411Lab";//\n ID = " + 1;
        //Database stores task info in 2D arrayList - arraylist used because dynamicly sized
        try (Connection conn = this.connect();
                java.sql.Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                name = rs.getString("Name");
                street = rs.getString("Street");
                state = rs.getString("State");
                zip = rs.getString("Zip");

                addressInfo.add(name);
                addressInfo.add(street);
                addressInfo.add(state);
                addressInfo.add(zip);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return addressInfo;
    }

}
