import java.util.*;
import java.lang.*;
import java.io.*;
import java.sql.*;
import java.sql.Date;

public class Sales {

    private int Month, totalAppt, totalRevenue, totalClients;

    Sales(){

    }
    static void CreateTable(Connection conn) throws SQLException{
        String createTable = "CREATE TABLE IF NOT EXISTS MonthlySales (\n"
                + "	Month integer PRIMARY KEY,\n"
                + "	TotalAppointments INTEGER NOT NULL,\n"
                + "	TotalRevenue REAL,\n"
                + "	TotalClients INTEGER\n"
                + ");";

        try (PreparedStatement query = conn.prepareStatement(createTable)) {
            query.executeUpdate();

        }
    }

    /*
    static void InsertData(Connection conn) throws SQLException{
        String ServicesInsert = "Insert into MonthlySales(Month, TotalAppointments, TotalRevenue, TotalClients)" +
                "VALUES (?, ?, ?, ?)";
        String ServicesAppt = "Select count(CustomerID) From Appointments Group by Appointment";

        try (PreparedStatement query = conn.prepareStatement(ServicesInsert)){
            query.setInt(1,);
            query.setString(2, service.getName());
            query.setString(3, service.getDuration());
            query.setInt(4, service.getPrice());
            query.setString(5, service.getMaterials());
            query.executeUpdate();
            query.clearParameters();
            System.out.println("Inserted!");
        }



    }
*/

}
