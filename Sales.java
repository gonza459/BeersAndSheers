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
                + "	TotalAppointments text NOT NULL,\n"
                + "	TotalRevenue real\n"
                + "	TotalClients integer\n"
                + ");";

        try (PreparedStatement query = conn.prepareStatement(createTable)) {
            ResultSet rs = query.executeQuery();
            rs.close();

        }
    }

}
