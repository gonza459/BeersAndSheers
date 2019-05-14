
//import dnl.utils.text.table.TextTable;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DisplayDB {
    List<List<String>> attributes = new ArrayList<List<String>>();
    Connection conn;
    Services service = new Services();

    DisplayDB(){

    }

    //Prints out Information from the Database Tables
    public void DisplayDatabase(Connection conn) throws Exception{
        Scanner dataTable = new Scanner(System.in);
        System.out.println("Enter the number of the information you would like to display: " + "\n" +
                "1.Clients" + "\n" +
                "2.Employees" + "\n" +
                "3.Appointments" + "\n" +
                "4.Addresses List" + "\n" +
                "5.Services Being Offered" + "\n" +
                "6.Sales per Month" + "\n");

        int response = dataTable.nextInt();

        switch (response) {
            case 1: {
                String displaySql = "SELECT * FROM Clients";

                try (PreparedStatement query = conn.prepareStatement(displaySql)) {
                    ResultSet rs = query.executeQuery();
                    displayClients(conn, rs);
                    rs.close();

                    break;
                }

            }case 2: {
                String displaySql = "SELECT * FROM Employees";

                try (PreparedStatement query = conn.prepareStatement(displaySql)) {
                    ResultSet rs = query.executeQuery();
                    displayEmployees(conn, rs);
                    rs.close();

                    break;
                }

            }case 3: {
                String displaySql = "SELECT * FROM Appointments";

                try (PreparedStatement query = conn.prepareStatement(displaySql)) {
                    ResultSet rs = query.executeQuery();
                    displayAppointments(conn, rs);
                    rs.close();

                    break;
                }

            }case 4: {
                String displaySql = "SELECT * FROM Addresses";

                try (PreparedStatement query = conn.prepareStatement(displaySql)) {
                    ResultSet rs = query.executeQuery();
                    displayAddresses(conn, rs);
                    rs.close();

                    break;
                }

            }case 5: {
                String displaySql = "SELECT * FROM Services";

                try (PreparedStatement query = conn.prepareStatement(displaySql)) {
                    ResultSet rs = query.executeQuery();
                    displayServices(conn, rs);
                    rs.close();

                    break;
                }

            }
        }

    }


    //Querries to print data from each respective table
    private static void displayClients(Connection conn, ResultSet rs) throws SQLException {
    /*    String createProcedure = "Create Procedure displayClients()\n" +
                " BEGIN\n" +
                "   SELECT * From Clients;\n" +
                "  END;";

        Statement stmt = conn.createStatement();
        stmt.executeUpdate(createProcedure);
    */
        CallableStatement cs = conn.prepareCall("{call displayClients}");
        rs = cs.executeQuery();
        System.out.println("\n");
        while (rs.next()) {
            Integer C_ID = rs.getInt("CustomerID");
            String C_fName = rs.getString("FirstName");
            String C_lName = rs.getString("LastName");
            String C_streetAdd = rs.getString("Street");
            String C_city = rs.getString("City");
            Integer C_zip = rs.getInt("Zipcode");
            String email = rs.getString("Email");
            String phone = rs.getString("PhoneNum");


            System.out.print(
                    "ClientID: " + C_ID + "\t\t" +
                            " First Name: " + C_fName + "\t\t" +
                            " Last Name: " + C_lName + "\t\t" +
                            " Street Address: " + C_streetAdd + "\t\t" +
                            " City:  " + C_city + "\t\t" +
                            " Zipcode: " + C_zip + "\t\t" +
                            " Email: " + email + "\t\t" +
                            " Phone Number:" + phone + "\n"
            );

        }

    }
    private static void displayEmployees(Connection conn, ResultSet rs) throws SQLException{
      /*  String createProcedure = "Create Procedure displayEmployees()\n" +
                " BEGIN\n" +
                "   SELECT * From Employees;\n" +
                "  END;";

        Statement stmt = conn.createStatement();
        stmt.executeUpdate(createProcedure);
*/
        CallableStatement cs = conn.prepareCall("{call displayEmployees}");
        rs = cs.executeQuery();
        System.out.println("\n");
        while (rs.next()) {
            Integer E_ID = rs.getInt("EmployeeID");
            String E_fName = rs.getString("FirstName");
            String E_lName = rs.getString("LastName");
            String E_streetAdd = rs.getString("Street");
            String E_city = rs.getString("City");
            Integer E_zip = rs.getInt("Zipcode");
            String phone = rs.getString("PhoneNum");



            System.out.print(
                    "EmployeeID: " + E_ID + "\t\t" +
                            " First Name: " + E_fName + "\t\t" +
                            " Last Name: " + E_lName + "\t\t" +
                            " Street Address: " + E_streetAdd + "\t\t" +
                            " City:  " + E_city + "\t\t" +
                            " Zipcode: " + E_zip + "\t\t" +
                            " Phone Number:" + phone + "\n"

            );

        }
        rs.close();
        //query.executeUpdate();
    }

    private static void displayAppointments(Connection conn, ResultSet rs) throws SQLException{
    /*    String createProcedure = "Create Procedure displayAppointments()\n" +
                " BEGIN\n" +
                "   SELECT * From Appointments;\n" +
                "  END;";

        Statement stmt = conn.createStatement();
        stmt.executeUpdate(createProcedure);
    */
        CallableStatement cs = conn.prepareCall("{call displayAppointments}");
        rs = cs.executeQuery();
        System.out.println("\n");
        while (rs.next()) {
            Integer A_ID = rs.getInt("AppointmentID");
            String AppointmentMonth = rs.getString("AppointmentMonth");
            String AppointmentDay = rs.getString("AppointmentDay");
            String ServiceID = rs.getString("ServiceID");
            Integer C_ID = rs.getInt("CustomerID");

            System.out.print(
                    " Appointment ID " + A_ID + "\t\t" +
                            " Client's Next Appointment Date: " + AppointmentMonth + "/" + AppointmentDay + "\t\t" +
                            " Service: " + ServiceID + "\t\t" +
                            " CustomerID:  " + C_ID + "\n"

            );

        }
        rs.close();
        //query.executeUpdate();
    }



    private static void displayAddresses(Connection conn, ResultSet rs) throws SQLException{
    /*   String createProcedure = "Create Procedure displayAddresses()\n" +
                " BEGIN\n" +
                "   SELECT * From Addresses;\n" +
                "  END;";

        Statement stmt = conn.createStatement();
        stmt.executeUpdate(createProcedure);
    */
        CallableStatement cs = conn.prepareCall("{call displayAddresses}");
        rs = cs.executeQuery();
        System.out.println("\n");
        while (rs.next()) {
            String E_streetAdd = rs.getString("Street");
            String E_city = rs.getString("City");
            Integer E_zip = rs.getInt("Zipcode");


            System.out.print(
                    " Street Address: " + E_streetAdd + "\t\t" +
                            " City:  " + E_city + "\t\t" +
                            " Zipcode: " + E_zip + "\n"
            );

        }
        rs.close();
        //query.executeUpdate();
    }
    private static void displayServices(Connection conn, ResultSet rs) throws SQLException{
       /* String createProcedure = "Create Procedure displayServices()\n" +
                " BEGIN\n" +
                "   SELECT * From Services;\n" +
                "  END;";

        Statement stmt = conn.createStatement();
        stmt.executeUpdate(createProcedure);
*/
        CallableStatement cs = conn.prepareCall("{call displayServices}");
        rs = cs.executeQuery();
        System.out.println("\n");
        while (rs.next()) {
            Integer ServiceID = rs.getInt("ServiceID");
            String ServiceName = rs.getString("ServiceName");
            String ServiceDuration = rs.getString("ServiceDuration");
            Float ServicePrice = rs.getFloat("ServicePrice");
            String ServiceMaterials = rs.getString("ServiceMaterials");


            System.out.print(
                    " Service ID: " + ServiceID + "\t\t" +
                            " Service: " + ServiceName + "\t\t" +
                            " Service Duration: " + ServiceDuration + "\t\t" +
                            " Price of Service:  " + ServicePrice + "\t\t" +
                            " Materials: " + ServiceMaterials + "\n"
            );

        }
        rs.close();
        //query.executeUpdate();
    }

    public static void printDB(Connection conn) throws SQLException, IOException {
        String data = ("Customer ID, " + " First Name, " + "Last Name, " + "Street Address, " + "City, "
                + "Zipcode," + "Phone Number," + "Email\n");

        FileWriter fileWriter = new FileWriter("clients.csv", false);
        PrintWriter writer = new PrintWriter(fileWriter);

        writer.print(data);

        PreparedStatement getPS = conn.prepareStatement("SELECT * FROM Clients");
        ResultSet getRS = getPS.executeQuery();

        while (getRS.next())
        {
            writer.print(getRS.getInt(1) + ", "
                    + getRS.getString(2) + ", "
                    + getRS.getString(3) + ", "
                    + getRS.getString(4) + ", "
                    + getRS.getString(5) + ", "
                    + getRS.getInt(6) + ", "
                    + getRS.getString(7) + ", "
                    + getRS.getString(8) + "\n");
        }
        writer.close();

        data = ("Employee ID, " + " First Name, " + "Last Name, " + "Street Address, " + "City, "
                + "Zipcode," + "Phone Number\n");

        fileWriter = new FileWriter("Employees.csv", false);
        writer = new PrintWriter(fileWriter);

        writer.print(data);

        getPS = conn.prepareStatement("SELECT * FROM Employees");
        getRS = getPS.executeQuery();

        while (getRS.next())
        {
            writer.print(getRS.getInt(1) + ", "
                    + getRS.getString(2) + ", "
                    + getRS.getString(3) + ", "
                    + getRS.getString(4) + ", "
                    + getRS.getString(5) + ", "
                    + getRS.getInt(6) + ", "
                    + getRS.getString(7) + "\n");
        }
        writer.close();

        data = ("Appointment ID, " + "ServiceID, " + "AppointmentMonth, " + "AppointmentDay, " + "CustomerID,\n");

        fileWriter = new FileWriter("Appointments.csv", false);
        writer = new PrintWriter(fileWriter);

        writer.print(data);

        getPS = conn.prepareStatement("SELECT * FROM Appointments");
        getRS = getPS.executeQuery();

        while (getRS.next())
        {
            writer.print(getRS.getInt(1) + ", "
                    + getRS.getInt(2) + ", "
                    + getRS.getInt(3) + ", "
                    + getRS.getInt(4) + ", "
                    + getRS.getInt(5) + "\n");
        }
        writer.close();

        data = ("Service ID, " + "ServiceName, " + "ServiceDuration, " + "ServicePrice, " + "ServiceMaterials,\n");

        fileWriter = new FileWriter("Services.csv", false);
        writer = new PrintWriter(fileWriter);

        writer.print(data);

        getPS = conn.prepareStatement("SELECT * FROM Services");
        getRS = getPS.executeQuery();

        while (getRS.next())
        {
            writer.print(getRS.getInt(1) + ", "
                    + getRS.getString(2) + ", "
                    + getRS.getString(3) + ", "
                    + getRS.getFloat(4) + ", "
                    + getRS.getString(5) + "\n");
        }
        writer.close();

        System.out.println("Exported all tables to CSVs");
    }
}

