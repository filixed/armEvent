package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author sqlitetutorial.net
 */
public class createTable {

    public static void createNewTable(String nameTable) {
        // SQLite connection string
        String url = "jdbc:sqlite:armLubiana.db";

        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS "+nameTable+ "(\n"
                + "    ID integer PRIMARY KEY AUTOINCREMENT,\n"
                + "    name text NOT NULL,\n"
                + "    surname text NOT NULL \n,"
                + "    win integer NOT NULL DEFAULT 0,\n"
                + "    loss integer NOT NULL DEFAULT 0 \n"
                + ");";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


}
