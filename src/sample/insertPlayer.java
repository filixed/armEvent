package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class insertPlayer {

    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:armLubiana.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void insert(String name, String surname) {
        String sql = "INSERT INTO zawodnicy(name,surname) VALUES(?,?)";



        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, surname);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateWin(int id){
        String sql = "UPDATE zawodnicy SET win = " + 1 +" "+
                "where ID = "+id ;
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param


            // update
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
