package planner.Util;

import javafx.scene.control.Label;

import java.sql.*;

/**
 * databaseConnection.java
 * Handling database operations
 * Created by mchemingway0031 on 3/1/2016.
 */
public class databaseConnection
{
    private static Connection connection;
    public static Boolean taskState;


    /**
     * Attempts to make a database connection after the login
     * proess has been successful, displays error dialog if fails.
     *
     * Uses the MySQL Connector Java Driver to connect to a MySQL database
     * on a custom made LAMP server hosted on Wordpress.
     *
     * @return the active and valid database connection.
     */
    public static Connection connectToDatabase()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage() + e.getCause());
        }

        try {
            connection = DriverManager.getConnection("jdbc:mysql://104.236.3.18:3306/wedding",
                    "root", "john1122");
        } catch (SQLException e) {
            System.out.println(e.getSQLState() + "\t"
                    + e.getMessage() + "\t" + e.getErrorCode());
            return null;
            //System.exit(-1);
        }
        return connection;
    }

    /**
     * Adds client information to the database using the JDBC library.
     * Uses PreparedStatement from the java.sql.* library to prevent
     * possible SQL injections when entering data.
     *
     * @param gfname -- groom's first name.
     * @param gmname -- groom's middle initial.
     * @param glname -- groom's last name.
     * @param bfname -- bride's first name.
     * @param bmname -- bride's middle initial.
     * @param blname -- bride's last name.
     * @param wedding_date -- the date of the wedding.
     * @param contact_num -- primry phone number.
     * @param alt_contact_num -- secondary phone number.
     * @param email -- email address
     */
    public static void addToDatabase(String gfname, String gmname, String glname, String bfname, String bmname,
                                     String blname, Date wedding_date, String contact_num, String alt_contact_num,
                                     String email)
    {
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement("INSERT INTO Client" +
                    "( gfname, gmname, glname, bfname, bmname, blname, " +
                    "wedding_date, contact_num, alt_contact_num, email) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            statement.setString(1, gfname);
            statement.setString(2, gmname);
            statement.setString(3, glname);
            statement.setString(4, bfname);
            statement.setString(5, bmname);
            statement.setString(6, blname);
            statement.setDate(7, wedding_date);
            statement.setString(8, contact_num);
            statement.setString(9, alt_contact_num);
            statement.setString(10, email);

            statement.executeUpdate();

            statement.close();
            taskState = Boolean.TRUE;
        } catch (SQLException e) {
            taskState = Boolean.FALSE;
            System.out.println(e.getSQLState() + "\t"
                    + e.getMessage() + "\t" + e.getErrorCode());
            //System.exit(-1);
        }
    }

    /**
     * Adds ceremony details to the datbase
     * @param ceremony_name
     * @param fname
     * @param lname
     * @param time_start
     * @param time_end
     * @param primary_address
     * @param secondary_address
     * @param contact_number
     * @param city
     * @param state
     * @param zip
     */
    public static void addToDatabase(String ceremony_name, String fname, String lname,
                                     String time_start, String time_end, String primary_address,
                                     String secondary_address, String contact_number, String city, String state,
                                     int zip)
    {
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement("INSERT INTO Ceremony(ceremony_name, fname, lname, " +
                    "time_start, time_end, primary_address, secondary_address, " +
                    "contact_number, city, state, zip) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            statement.setString(1, ceremony_name);
            statement.setString(2, fname);
            statement.setString(3, lname);
            statement.setString(4, time_start);
            statement.setString(5, time_end);
            statement.setString(6, primary_address);
            statement.setString(7, secondary_address);
            statement.setString(8, contact_number);
            statement.setString(9, city);
            statement.setString(10, state);
            statement.setInt(11, zip);

            statement.executeUpdate();

            statement.close();
            taskState = Boolean.TRUE;
        } catch (SQLException e) {
            taskState = Boolean.FALSE;
            System.out.println(e.getSQLState() + "\t"
                    + e.getMessage() + "\t" + e.getErrorCode());
            //System.exit(-1);
        }
    }

    public static void addToDB(String reception_name, String fname, String lname,
                                     String time_start, String time_end, String primary_address,
                                     String secondary_address, String contact_number, String city, String state,
                                     int zip)
    {
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement("");
            statement.setString(1, reception_name);
            statement.setString(2, fname);
            statement.setString(3, lname);
            statement.setString(4, time_start);
            statement.setString(5, time_end);
            statement.setString(6, primary_address);
            statement.setString(7, secondary_address);
            statement.setString(8, contact_number);
            statement.setString(9, city);
            statement.setString(10, state);
            statement.setInt(11, zip);

            statement.executeUpdate();

            statement.close();
            taskState = Boolean.TRUE;
        } catch (SQLException e) {
            taskState = Boolean.FALSE;
            System.out.println(e.getSQLState() + "\t"
                    + e.getMessage() + "\t" + e.getErrorCode());
            //System.exit(-1);
        }
    }

    public static void addToDatabase(String wedding_flower, String fcolor, String scolor, String acolor,
                                     String bfflower, String gfflower, String wedding_style, int num_maid_matrons,
                                     int num_bestmen, int num_bridesmaids, int num_groomsmen, int num_guests,
                                     int table_size, int num_guests_per_table)
    {
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement("INSERT INTO Wedding_Info(fcolor, scolor, acolor, bfflower, " +
                    "gfflower, wedding_flower, wedding_style, num_maid_matrons,num_bestmen, num_bridesmaids, " +
                    "num_groomsmen, num_guests, table_size, num_guests_per_table) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,)");
            statement.setString(1, fcolor);
            statement.setString(2, scolor);
            statement.setString(3, acolor);
            statement.setString(4, bfflower);
            statement.setString(5, gfflower);
            statement.setString(6, wedding_flower);
            statement.setString(7, wedding_style);
            statement.setInt(8, num_maid_matrons);
            statement.setInt(9, num_bestmen);
            statement.setInt(10, num_bridesmaids);
            statement.setInt(11, num_groomsmen);
            statement.setInt(12, num_guests);
            statement.setInt(13, table_size);
            statement.setInt(14, num_guests_per_table);

            statement.executeUpdate();

            statement.close();
            taskState = Boolean.TRUE;
        } catch (SQLException e) {
            taskState = Boolean.FALSE;
            System.out.println(e.getSQLState() + "\t"
                    + e.getMessage() + "\t" + e.getErrorCode());
            //System.exit(-1);
        }
    }

    public static void addToDatabase(String guest_title, String guest_first, String guest_last)
    {
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement("INSERT INTO Guest_List" +
                    "(guest_title, guest_fname, guest_lname) " +
                    "VALUES (?, ?, ?)");
            statement.setString(1, guest_first);
            statement.setString(2, guest_last);
            statement.setString(3, guest_title);

            statement.executeUpdate();

            statement.close();
            taskState = Boolean.TRUE;
        } catch (SQLException e) {
            taskState = Boolean.FALSE;
            System.out.println(e.getSQLState() + "\t"
                    + e.getMessage() + "\t" + e.getErrorCode());
            //System.exit(-1);
        }
    }
    public static Label ping(Connection connection)
    {
        Label pingLabel = new Label();
        Statement statement = null;
        try{
            statement = connection.createStatement();
            ResultSet re = statement.executeQuery("SELECT 1");
            while (re.next())
            {
                if(re.getInt("1") == 1)
                {
                    pingLabel.setText("Database Successfully Connected");
                }
            }

            //System.out.println("Ping Successful!");
        }catch (SQLException sqle){
            //System.out.println("ping failed");
            pingLabel.setText("Connection Failed with Error Code:" +
                    sqle.getErrorCode());
        }finally {
            try {
                if(statement != null)
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return pingLabel;
    }
}
