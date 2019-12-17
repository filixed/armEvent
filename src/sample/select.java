package sample;


import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author sqlitetutorial.net
 */
public class select {

    /**
     * Connect to the test.db database
     * @return the Connection object
     */
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

    public int selectAll(){
        String sql = "SELECT COUNT(*) as ilosc from zawodnicy";
        int ile = 0;
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            ile = rs.getInt("ilosc");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ile;
    }

    public String playerName(int id){
        String sql = "SELECT name, surname from zawodnicy where id = " + id;
        String playerNamef = "";
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            playerNamef = rs.getString("name") + " " + rs.getString("surname") ;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return playerNamef;
    }

    public int playerID(String name, String surname){
        String sql = "SELECT id from zawodnicy where name = '"+name+"' AND surname = '"+surname+"' ";
        int id = 0;
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            id = rs.getInt("ID");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return id;
    }

}