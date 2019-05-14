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


    static void InsertSales(Connection conn) throws SQLException {
     /*   String insertSales = "Insert into MonthlySales(TotalAppointments) Values(?)";

        CallableStatement cs = conn.prepareCall("{call TotalAppointments}");
        ResultSet rs = cs.executeQuery();
        System.out.println("\n");

        while(rs.next()){
            Integer total = rs.getInt("totals");
            try (PreparedStatement query = conn.prepareStatement(insertSales)){
                query.setInt(1,total);
                query.executeUpdate();
                query.clearParameters();
                System.out.println("Inserted!");
            }
        }

    }
    */
    }

}
