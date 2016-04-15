package planner.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

/**
 *
 * Created by mchemingway0031 on 3/1/2016.
 */
public class databaseConnection
{
    private static Connection connection;
    private static boolean connected = false;

    public static boolean isConnected() {
        return connected;
    }

    public static Connection getConnection() {
        return connection;
    }


    public static void connectToDatabase()
    {
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection("jdbc:h2:F:\\Documents\\Projects\\Databases\\planner",
                    "planneruser", "password");
            connected = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addToDatabase(String groom_fname, String groom_lname, String bride_fname,
                                     String bride_lname, String email, String phone_number)
    {
        Random random = new Random();
        Statement statement;
        try {
            statement = connection.createStatement();
            int id = random.nextInt(2000) + 1;
            statement.executeUpdate("INSERT INTO CLIENT (CLIENT_ID, GROOM_FNAME, GROOM_LNAME, " +
                    "BRIDE_FNAME, BRIDE_LNAME, EMAIL, PHONE_NUMBER) " +
                    "VALUES ('"+id +"','"+groom_fname+"','"+groom_lname+"','" +
                    ""+bride_fname+"','"+bride_lname+"','"+email+"','"+phone_number+"')");
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
