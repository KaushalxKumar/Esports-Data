package Model.Database;

import Model.Data.League;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.sql.*;
import java.util.List;

public class Database {
    /**
     * Updates database with recent API data.<br><br>
     * <b>Preconditions:</b><br>
     * Database must be initialised<br>
     * <b>Postconditions:</b><br>
     * Database is updated with fresh data.<br>
     *
     * @param body The data to be pushed onto the database.
     */
    public void update(String body) {
        String url = "jdbc:sqlite:src/main/resources/Database/leagues.db";

        Connection c = null;
        PreparedStatement stmt = null;
        String sql = "UPDATE leagues set response = ? where id = 1;";

        try {
            c = DriverManager.getConnection(url);
            stmt = c.prepareStatement(sql);
            stmt.setString(1, body);
            stmt.executeUpdate();

            stmt.close();
            c.close();
            System.out.println("**DATA CACHED SUCCESSFULLY**\n");
        } catch ( Exception e ) {
            e.printStackTrace();
            System.out.println("Error Caching Data");
        }
    }

    /**
     * Retrieves recent API data from the database.<br><br>
     * <b>Preconditions:</b><br>
     * Database must be initialised<br>
     * <b>Postconditions:</b><br>
     * Data from database is retrieved<br>
     *
     * @return List of leagues from the database.
     */
    public List<League> select() {
        String url = "jdbc:sqlite:src/main/resources/Database/leagues.db";
        Connection c = null;

        Statement stmt = null;
        ResultSet res = null;
        String sql = "SELECT response FROM leagues WHERE id = 1;";
        String result = null;
        try {
            c = DriverManager.getConnection(url);
            stmt = c.createStatement();
            res = stmt.executeQuery(sql);

            result = res.getString("response");
            System.out.println("**MAKING CALL TO DATABASE**\n");
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            e.printStackTrace();
            System.out.println("Error Retrieving Cached Data");
        }

        List<League> leagues = null;
        try {
            ObjectMapper leagueMapper = new ObjectMapper();
            leagues = leagueMapper.readValue(result, new TypeReference<List<League>>() {});
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error Parsing Cached Data");
        }

        return leagues;
    }
    /**
     * Checks database to see if any information has been cached previously.<br><br>
     * <b>Preconditions:</b><br>
     * Database must be initialised<br>
     * <b>Postconditions:</b><br>
     * Notifies model if data has been cached previously.<br>
     *
     * @return The number of rows of previous data that exits.
     */
    public int check() {
        String url = "jdbc:sqlite:src/main/resources/Database/leagues.db";
        Connection c = null;

        Statement stmt = null;
        ResultSet res = null;
        String sql = "SELECT * FROM leagues;";

        int result = 0;

        try {
            c = DriverManager.getConnection(url);
            stmt = c.createStatement();
            res = stmt.executeQuery(sql);

            result = res.getInt("id");
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            e.printStackTrace();
            System.out.println("Error Checking Database");
        }

        return result;
    }

}
