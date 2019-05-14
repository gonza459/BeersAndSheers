import dnl.utils.text.table.TextTable;
import java.io.*;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.text.*;

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

                String countSql = "SELECT count(*) From Clients";

                try (PreparedStatement query = conn.prepareStatement(displaySql)) {
                    ResultSet rs = query.executeQuery();


                    PreparedStatement countPS = conn.prepareStatement(countSql);
                    ResultSet countRS = countPS.executeQuery();
                    countRS.next();
                    int count = countRS.getInt(1);

                    displayClients(conn, rs, count);
                    rs.close();

                    break;
                }


            }case 2: {
                String displaySql = "SELECT * FROM Employees";

                String countSql = "SELECT count(*) From Employees";


                try (PreparedStatement query = conn.prepareStatement(displaySql)) {
                    ResultSet rs = query.executeQuery();


                    PreparedStatement countPS = conn.prepareStatement(countSql);
                    ResultSet countRS = countPS.executeQuery();
                    countRS.next();
                    int count = countRS.getInt(1);

                    displayEmployees(conn, rs, count);
                    rs.close();

                    break;
                }



            }case 3: {
                String displaySql = "SELECT * FROM Appointments";

                String countSql = "SELECT count(*) From Appointments";

                try (PreparedStatement query = conn.prepareStatement(displaySql)) {
                    ResultSet rs = query.executeQuery();


                    PreparedStatement countPS = conn.prepareStatement(countSql);
                    ResultSet countRS = countPS.executeQuery();
                    countRS.next();
                    int count = countRS.getInt(1);

                    displayAppointments(conn, rs, count);
                    rs.close();

                    break;
                }


            }case 4: {
                String displaySql = "SELECT * FROM Addresses";

                String countSql = "SELECT count(*) From Addresses";

                try (PreparedStatement query = conn.prepareStatement(displaySql)) {
                    ResultSet rs = query.executeQuery();


                    PreparedStatement countPS = conn.prepareStatement(countSql);
                    ResultSet countRS = countPS.executeQuery();
                    countRS.next();
                    int count = countRS.getInt(1);

                    displayAddresses(conn, rs, count);
                    rs.close();

                    break;
                }


            }case 5: {
                String displaySql = "SELECT * FROM Services";

                String countSql = "SELECT count(*) From Services";

                try (PreparedStatement query = conn.prepareStatement(displaySql)) {
                    ResultSet rs = query.executeQuery();


                    PreparedStatement countPS = conn.prepareStatement(countSql);
                    ResultSet countRS = countPS.executeQuery();
                    countRS.next();
                    int count = countRS.getInt(1);

                    displayServices(conn, rs, count);
                    rs.close();

                    break;
                }


            }

        }

    }


    //Querries to print data from each respective table
    private static void displayClients(Connection conn, ResultSet rs,  int count) throws SQLException {
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

        String[] data = {"Customer ID", "First Name", "Last Name", "Street Address", "City", "Zipcode", "Phone Number", "Email"};
        String[][] Clients = new String[count][8];
        int i = 0;
        assert rs != null;
        while (rs.next())
        {
            Clients[i][0] = rs.getString("FirstName");;
            Clients[i][1] = rs.getString("FirstName");
            Clients[i][2] = rs.getString("LastName");
            Clients[i][3] = rs.getString("Street");
            Clients[i][4] = rs.getString("City");
            Clients[i][5] = Integer.toString(rs.getInt("Zipcode"));
            Clients[i][6] = rs.getString("PhoneNum");
            Clients[i][7] = rs.getString("Email");
            i++;
        }
        TextTable ClientsTable = new TextTable(data, Clients);
        ClientsTable.printTable();

        rs.close();
        //query.executeUpdate();
    }
    private static void displayEmployees(Connection conn, ResultSet rs, int count) throws SQLException{
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

        String[] data = {"Employee ID", "First Name", "Last Name", "Street Address", "City", "Zipcode", "Phone Number"};
        String[][] Employees = new String[count][7];
        int i = 0;
        assert rs != null;
        while (rs.next())
        {
            Employees[i][0] = rs.getString("FirstName");;
            Employees[i][1] = rs.getString("FirstName");
            Employees[i][2] = rs.getString("LastName");
            Employees[i][3] = rs.getString("Street");
            Employees[i][4] = rs.getString("City");
            Employees[i][5] = Integer.toString(rs.getInt("Zipcode"));
            Employees[i][6] = rs.getString("PhoneNum");
            i++;
        }
        TextTable EmployeesTable = new TextTable(data, Employees);
        EmployeesTable.printTable();

        rs.close();
        //query.executeUpdate();
    }

    private static void displayAppointments(Connection conn, ResultSet rs,  int count) throws SQLException{
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

        String[] data = {"Appointment ID", "Service ID", "Appointment Month", "Appointment Day", "Customer ID"};
        String[][] Appointments = new String[count][5];
        int i = 0;
        assert rs != null;
        while (rs.next())
        {
            Appointments[i][0] = Integer.toString(rs.getInt("AppointmentID"));
            Appointments[i][1] = Integer.toString(rs.getInt("ServiceID"));
            Appointments[i][2] = Integer.toString(rs.getInt("AppointmentMonth"));
            Appointments[i][3] = Integer.toString(rs.getInt("AppointmentDay"));
            Appointments[i][4] = Integer.toString(rs.getInt("CustomerID"));
            i++;
        }
        TextTable AppointmentTable = new TextTable(data, Appointments);
        AppointmentTable.printTable();

        rs.close();
        //query.executeUpdate();
    }


    private static void displayAddresses(Connection conn, ResultSet rs,  int count) throws SQLException{
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

        String[] data = {"Street Address", "City", "Zipcode"};
        String[][] Addresses = new String[count][3];
        int i = 0;
        assert rs != null;
        while (rs.next())
        {
            Addresses[i][0] = rs.getString("Street");
            Addresses[i][1] = rs.getString("City");
            Addresses[i][2] = Integer.toString(rs.getInt("Zipcode"));
            i++;
        }
        TextTable AddressTable = new TextTable(data, Addresses);
        AddressTable.printTable();

        rs.close();
        //query.executeUpdate();
    }

    private static void displayServices(Connection conn, ResultSet rs,  int count) throws SQLException{
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

        String[] data = {"Service ID", "Service Name", "Duration", "Price", "Materials"};
        String[][] Services = new String[count][5];
        int i = 0;
        assert rs != null;
        while (rs.next())
        {
            Services[i][0] = Integer.toString(rs.getInt("ServiceID"));
            Services[i][1] = rs.getString("ServiceName");
            Services[i][2] = rs.getString("ServiceDuration");
            Services[i][3] = Float.toString(rs.getFloat("ServicePrice"));
            Services[i][4] = rs.getString("ServiceMaterials");
            i++;
        }
        TextTable ServiceTable = new TextTable(data, Services);
        ServiceTable.printTable();

        rs.close();
        //query.executeUpdate();
    }

    public static void printDB(Connection conn) throws SQLException, IOException {
        String data = ("Customer ID, " + " First Name, " + "Last Name, " + "Street Address, " + "City, "
                + "Zipcode," + "Phone Number," + "Email\n");

        String Date_Time = "dd-MM-yyy_HH:mm:ss";

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(Date_Time);
        LocalDateTime currentDate = LocalDateTime.now();
        String formatDateTime = currentDate.format(dtf);




        FileWriter fileWriter = new FileWriter("clients_" + formatDateTime + ".csv", false);
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

        fileWriter = new FileWriter("Employees_" + formatDateTime + ".csv", false);
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

        fileWriter = new FileWriter("Appointments_" + formatDateTime + ".csv", false);
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

        fileWriter = new FileWriter("Services_" + formatDateTime + ".csv", false);
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

