import java.sql.*;
import java.lang.*;

public class DBConnection {

    //private Connection mySqlConnection = null;

    public static Connection getMySqlConnection() throws SQLException {
        Connection mysqlConnection = null;
        try{
            String driverLoc = "com.mysql.jdbc.Driver";
            String connectionUrl = "jdbc:mysql://35.185.209.10:3306/finalDB?useSSL=false";
            String uName = "root";
            String pass = "kDr3CHPes1mcBBbB";


            Class.forName(driverLoc);
            mysqlConnection = DriverManager.getConnection(connectionUrl, uName, pass);
            System.out.println("Welcome to your Beers & Sheers database!\n");

            if(mysqlConnection.isClosed())
                mysqlConnection = DBConnection.getMySqlConnection();

            mysqlConnection.setAutoCommit(true);

        }catch(Exception ex){
            ex.printStackTrace();
            //mysqlConnection.rollback();
        }
        return mysqlConnection;
    }

}