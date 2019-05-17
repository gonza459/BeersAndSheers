import com.mysql.fabric.xmlrpc.Client;

import javax.xml.ws.Service;
import java.lang.*;
import java.io.*;
import java.sql.*;
import java.sql.Date;
import java.util.*;

//Script for inserting records into the DB from the csv file or through user entry
public class PopulateDB {

    List<List<String>> attributes = new ArrayList<List<String>>();
    Connection conn;


    public PopulateDB() {

    }

    //Takes the csvfile as a parameter and extracts the information into an array
    public List<List<String>> CSVReader(String csvfile) throws FileNotFoundException{
        Scanner s = new Scanner(new File(csvfile));
        s.useDelimiter(",");

        //Reads through each line of text
        while(s.hasNext()) {
            String temp = s.nextLine();
            List<String> tuples = Arrays.asList(temp.split(","));

            attributes.add(tuples);
        }
        s.close();
        //System.out.println(attributes);
        return attributes;
    }

    //Inserts Data to the Database Tables
    public void InsertCSVtoDatabase(Connection conn) throws Exception{
        System.out.println("Please enter the path to the CSV file you would like to enter into the database: ");
        Scanner file = new Scanner(System.in);
        String csvfile;
        csvfile = file.nextLine();
        CSVReader(csvfile);


        //SQL commands
        String addressInsert = "Insert into Addresses(Street, City, Zipcode)" +
                "VALUES (?, ?, ?)";

        for(int i = 1; i < attributes.size(); i++) { // start from 1 to exclude headers
            List<String> row = attributes.get(i);
            Integer ClientID;
            PreparedStatement c_query = conn.prepareStatement("SELECT CustomerID FROM Clients ORDER BY RAND() LIMIT 1");
            ResultSet c_rs = c_query.executeQuery();
            c_rs.next();
            ClientID = c_rs.getInt(1);

            Integer EmployeeID;
            PreparedStatement e_query = conn.prepareStatement("SELECT EmployeeID FROM Employees ORDER BY RAND() LIMIT 1");
            ResultSet e_rs = c_query.executeQuery();
            e_rs.next();
            EmployeeID = e_rs.getInt(1);

            String Client_fName = row.get(0);
            String Client_lName = row.get(1);
            String C_phoneNum = row.get(2);
            String email = row.get(3);

            String C_street_address= row.get(4);
            String  C_city = row.get(5);
            Integer C_zipcode = Integer.valueOf(row.get(6));

            String Employee_fName = row.get(10);
            String Employee_lName = row.get(11);
            String E_phoneNum = row.get(12);
            String E_street_address= row.get(13);
            String  E_city = row.get(14);
            Integer E_zipcode = Integer.valueOf(row.get(15));

            String HairColor = row.get(16);
            String NextAppointmentMonth = row.get(17);
            String NextAppointmentDay = row.get(18);

            //Retrieves a random number from the set of services offered from the database
            int ServiceID;
            PreparedStatement s_query = conn.prepareStatement("SELECT ServiceID FROM Services ORDER BY RAND() LIMIT 1");
            ResultSet rs = s_query.executeQuery();
            rs.next();
            ServiceID = rs.getInt(1);

            CallableStatement cs = conn.prepareCall("{call insertEmployee(?, ?, ?, ?, ?, ?)}");

            cs.setString(1, Client_fName);
            cs.setString(2, Client_lName);
            cs.setString(3, C_street_address);
            cs.setString(4, C_city);
            cs.setInt(5, C_zipcode);
            cs.setString(6, C_phoneNum);

            cs.executeUpdate();

            try (PreparedStatement query = conn.prepareStatement(addressInsert)){
                query.setString(1, C_street_address);
                query.setString(2, C_city);
                query.setInt(3, C_zipcode);
                query.setString(1, E_street_address);
                query.setString(2, E_city);
                query.setInt(3, E_zipcode);
                query.executeUpdate();
                query.clearParameters();
               // System.out.println("Inserted!");
            }
            CallableStatement A_cs = conn.prepareCall("{call InsertAppointment(?, ?, ?, ?, ?)}");

            A_cs.setInt(1, ServiceID);
            A_cs.setString(2, NextAppointmentMonth);
            A_cs.setString(3, NextAppointmentDay);
            A_cs.setInt(4, ClientID);
            A_cs.setInt(5, EmployeeID);

            cs.executeUpdate();

            CallableStatement E_cs = conn.prepareCall("{call insertEmployee(?, ?, ?, ?, ?, ?)}");

            E_cs.setString(1, Employee_fName);
            E_cs.setString(2, Employee_lName);
            E_cs.setString(3, E_street_address);
            E_cs.setString(4, E_city);
            E_cs.setInt(5, E_zipcode);
            E_cs.setString(6, E_phoneNum);

            cs.executeUpdate();
            break;

        }

    }
    public void InsertIntoDatabase(Connection conn) throws Exception {
        Scanner dataTable = new Scanner(System.in);
        System.out.println("Enter the data table you would like to insert a new record into: " + "\n" +
                "1.Clients" + "\n" +
                "2.Employees" + "\n" +
                "3.Appointments" + "\n" +
                "4.Services Being Offered" + "\n" +
                "5.Go back to Main Menu\n");

        int response = dataTable.nextInt();

        System.out.println("\n");

        switch (response) {
            case 1: {

                InsertClient(conn);

                break;

            }case 2: {

                InsertEmployee(conn);

                break;

            }case 3: {


                InsertAppointment(conn);

                break;

            }case 4: {
                InsertService(conn);

                break;


            }case 5: {
                UserInteraction UI = new UserInteraction();
                UI.Instructions(conn);
                break;

            }
        }

    }

    public void InsertClient(Connection conn)throws SQLException{
        /*String createProcedure = "CREATE PROCEDURE insertClient(IN FirstName varchar(20), IN LastName varchar(20), " +
                "IN Street varchar(50), IN  City varchar(45), IN Zipcode int(11), IN PhoneNum varchar(25), IN Email varchar(25) "+
                "BEGIN\n"+
                "INSERT Into Clients (FirstName, LastName, Street, City, Zipcode, PhoneNum, Email)\n" +
                "Values (FirstName, LastName, Street, City, Zipcode, PhoneNum, Email);\n" +
                "END;\n";

        Statement stmt = conn.createStatement();
        stmt.executeUpdate(createProcedure);
*/
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the following information for the new client: " + "\n");
        System.out.println( "First Name: " + "\n");
        String fName = s.nextLine();

        System.out.println( "Last Name: " + "\n");
        String lName = s.nextLine();

        System.out.println( "Phone Number: " + "\n");
        String phoneNum = s.nextLine();

        System.out.println( "Email: " + "\n");
        String email = s.nextLine();

        System.out.println( "Street: " + "\n");
        String street = s.nextLine();

        System.out.println( "City: " + "\n");
        String city = s.nextLine();

        System.out.println( "Zip: " + "\n");
        int zip = s.nextInt();

        CallableStatement cs = conn.prepareCall("{call insertClient(?, ?, ?, ?, ?, ?, ?)}");

        cs.setString(1, fName);
        cs.setString(2, lName);
        cs.setString(3, street);
        cs.setString(4, city);
        cs.setInt(5, zip);
        cs.setString(6, phoneNum);
        cs.setString(7, email);

        cs.executeUpdate();
        //rs = cs.executeQuery();
        System.out.println("Client Added!\n");

    }
    public void InsertAppointment(Connection conn)throws SQLException{
    /*   String createProcedure = "CREATE PROCEDURE insertAppointment(IN ServiceID int(11), " +
                "IN AppointmentMonth int(2), IN AppointmentDay int(2), IN CustomerID int(11)) "+
                "BEGIN\n"+
                "INSERT Into Appointments (ServiceID, AppointmentMonth, AppointmentDay, CustomerID)\n" +
                "Values (ServiceID, AppointmentMonth, AppointmentDay, CustomerID);\n" +
                "END;\n";

        Statement stmt = conn.createStatement();
        stmt.executeUpdate(createProcedure);
*/
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the following information for the new Appointment: " + "\n");

        System.out.println( "Service ID: " + "\n");
        int S_ID = s.nextInt();

        System.out.println( "Appointment Month: " + "\n");
        int month = s.nextInt();

        System.out.println( "Appointment Day: " + "\n");
        int day = s.nextInt();

        System.out.println( "CustomerID of Client: " + "\n");
        int C_ID = s.nextInt();

        System.out.println( "Employee ID of assigned stylist: " + "\n");
        int E_ID = s.nextInt();

        CallableStatement cs = conn.prepareCall("{call InsertAppointment(?, ?, ?, ?, ?)}");

        cs.setInt(1, S_ID);
        cs.setInt(2, month);
        cs.setInt(3, day);
        cs.setInt(4, C_ID);
        cs.setInt(5, E_ID);

        cs.executeUpdate();
        //rs = cs.executeQuery();
        System.out.println("Apppointment Added!\n");

    }
    public void InsertEmployee(Connection conn)throws SQLException{

        Scanner s = new Scanner(System.in);
        System.out.println("Enter the following information for the new employee: " + "\n");
        System.out.println( "First Name: " + "\n");
        String fName = s.nextLine();

        System.out.println( "Last Name: " + "\n");
        String lName = s.nextLine();

        System.out.println( "Phone Number: " + "\n");
        String phoneNum = s.nextLine();

        System.out.println( "Street: " + "\n");
        String street = s.nextLine();

        System.out.println( "City: " + "\n");
        String city = s.nextLine();

        System.out.println( "Zip: " + "\n");
        Integer zip = s.nextInt();
        System.out.println("\n");


        CallableStatement cs = conn.prepareCall("{call insertEmployee(?, ?, ?, ?, ?, ?)}");

        cs.setString(1, fName);
        cs.setString(2, lName);
        cs.setString(3, street);
        cs.setString(4, city);
        cs.setInt(5, zip);
        cs.setString(6, phoneNum);

        cs.executeUpdate();
        //rs = cs.executeQuery();
        System.out.println("Employee Added!\n");

    }
    public void InsertService(Connection conn)throws SQLException{

        //Prompts for important information to fill in the table
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the following information for the new Service: " + "\n");

        System.out.println( "Service Name: " + "\n");
        String name = s.nextLine();

        System.out.println( "Estimated Service Duration, include unit of time: " + "\n");
        String duration = s.nextLine();

        System.out.println( "Materials necessary for service: " + "\n");
        String materials = s.nextLine();

        System.out.println( "Price of Service rounded to nearest whole dollar: " + "\n");
        int price = s.nextInt();

        CallableStatement cs = conn.prepareCall("{call InsertService(?, ?, ?, ?)}");

        cs.setString(1, name);
        cs.setString(2, duration);
        cs.setInt(3, price);
        cs.setString(4, materials);

        cs.executeUpdate();
        //rs = cs.executeQuery();
        System.out.println("Service Added!\n");

    }
}