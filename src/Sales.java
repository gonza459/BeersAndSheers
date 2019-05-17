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


    static void UpdateSales(Connection conn) throws SQLException {
        int[] totals = new int[28];
        String insertSales = "Update MonthlySales Set TotalAppointments = ? where Month = ?";

        //Retrieves the total Number of appointments as grouped by month to then insert into the MonthlySales Table

        String totalAppts = "Select AppointmentMonth, count(distinct AppointmentID) from finalDB.Appointments group by AppointmentMonth";

        PreparedStatement ps = conn.prepareStatement(totalAppts);
        ResultSet rs = ps.executeQuery();
        System.out.println("\n");

        int i = 0;
        assert rs != null;
        while(rs.next()){
            totals[i] = rs.getInt(2);

            PreparedStatement query = conn.prepareStatement(insertSales);
            query.setInt(1,totals[i]);
            query.setInt(2, i+1);
            query.executeUpdate();
            i++;

            }
        rs.close();

        /*
        -Retrieves total number of distinct clients per month
        -Distinct client information is important for this column in case a particular client may
        have more than one appointment within a given month, the data will demonstrate the
        accurate number of clients compared to the number of appointments per month
        */
            int[] total_C = new int[28];
            String insertClients = "Update MonthlySales Set TotalClients = ? where Month = ?";

            String totalClients = "\n" +
                    "Select AppointmentMonth, count(distinct CustomerID) as TotalClients\n" +
                    "From finalDB.Appointments\n" +
                    "GROUP BY AppointmentMonth;";

            ps = conn.prepareStatement(totalClients);
            ResultSet clients_rs = ps.executeQuery();
            System.out.println("\n");

            i = 0;
            assert clients_rs != null;
            while(clients_rs.next()){
                total_C[i] = clients_rs.getInt(2);

                PreparedStatement query = conn.prepareStatement(insertClients);
                query.setInt(1,total_C[i]);
                query.setInt(2, i+1);
                query.executeUpdate();
                i++;

            }
            rs.close();

            /*
            -Retrieves all service price according to each service ID as found in each appointment
            -The SQL code then calculated the sum of the sale made from each appointment according to the
            service done.
            -The sums are then organized per month as the appointments are organized
            */
            int[] total_R = new int[28];
            String insertRevenue = "Update MonthlySales Set TotalRevenue= ? where Month = ?";

            String totalRevenue = "\n" +
                    "Select AppointmentMonth, sum(S.ServicePrice) as TotalRevenue\n"+
                    "From Services S RIGHT JOIN finalDB.Appointments A on S.ServiceID = A.ServiceID\n" +
                    "GROUP BY AppointmentMonth;";

            ps = conn.prepareStatement(totalRevenue);
            ResultSet rev_rs = ps.executeQuery();
            System.out.println("\n");

            i = 0;
            assert rev_rs != null;
            while(rev_rs.next()){
                total_R[i] = rev_rs.getInt(2);

                PreparedStatement query = conn.prepareStatement(insertRevenue);
                query.setInt(1,total_R[i]);
                query.setInt(2, i+1);
                query.executeUpdate();
                i++;

            }
        rs.close();
        }


    }

