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
    Services service = new Services();


    public PopulateDB() {

    }

    //Takes the csvfile as a parameter and extrats the information into an array
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
    public void InsertToDatabase(Connection conn) throws Exception{

        String addressInsert = "Insert into Addresses(Street, City, Zipcode)" +
                "VALUES (?, ?, ?)";
        String appointmentInsert = "Insert into Appointments(AppointmentID, ServiceID, AppointmentMonth, AppointmentDay, CustomerID)" +
                "VALUES (?, ?, ?, ?, ?)";
        String ClientsInsert = "Insert into Clients(CustomerID,FirstName, LastName, Street, City, Zipcode, PhoneNum, email, CreditNum, CardExpiration, CardCode)" +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        String EmployeeInsert = "Insert into Employees(EmployeeID, FirstName, LastName, Street, City, Zipcode, PhoneNum)" +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        for(int i = 1; i < attributes.size(); i++) { // start from 1 to exclude headers
            List<String> row = attributes.get(i);
            Integer ClientID = i;
            Integer EmployeeID = i;
            Integer AppointmentID = i;

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
            int ServiceID = service.getServiceID();

            try (PreparedStatement query = conn.prepareStatement(ClientsInsert)){
                query.setInt(1, ClientID);
                query.setString(2, Client_fName);
                query.setString(3, Client_lName);
                query.setString(4, C_street_address);
                query.setString(5, C_city);
                query.setInt(6, C_zipcode);
                query.setString(8, email);
                query.setString(7, C_phoneNum);
                query.executeUpdate();
                query.clearParameters();
                System.out.println("Inserted!");
            }
            try (PreparedStatement query = conn.prepareStatement(addressInsert)){
                query.setString(1, C_street_address);
                query.setString(2, C_city);
                query.setInt(3, C_zipcode);
                query.setString(1, E_street_address);
                query.setString(2, E_city);
                query.setInt(3, E_zipcode);
                query.executeUpdate();
                query.clearParameters();
                System.out.println("Inserted!");
            }
            try (PreparedStatement query = conn.prepareStatement(appointmentInsert)){
                query.setInt(1, AppointmentID);
                query.setInt(2, ServiceID);
                query.setString(4, NextAppointmentDay);
                query.setString(3, NextAppointmentMonth);
                query.setInt(5, ClientID);
                query.executeUpdate();
                query.clearParameters();
                System.out.println("Inserted!");
            }
            try (PreparedStatement query = conn.prepareStatement(EmployeeInsert)){
                query.setInt(1, EmployeeID);
                query.setString(2, Employee_fName);
                query.setString(3, Employee_lName);
                query.setString(4, E_street_address);
                query.setString(5, E_city);
                query.setInt(6, E_zipcode);
                query.setString(7, E_phoneNum);
                query.executeUpdate();
                query.clearParameters();
                System.out.println("Inserted!");
            }

        }
    }

    public void InsertClient(Connection conn)throws SQLException{
        String createProcedure = "CREATE PROCEDURE insertClient(IN FirstName varchar(20), IN LastName varchar(20), " +
                "IN Street varchar(50), IN  City varchar(45), IN Zipcode int(11), IN PhoneNum varchar(25), IN Email varchar(25)) if NOT Exists "+
                "BEGIN\n"+
                "INSERT Into Clients (FirstName, LastName, Street, City, Zipcode, PhoneNum, Email)\n" +
                "Values (FirstName, LastName, Street, City, Zipcode, PhoneNum, Email);\n" +
                "END;\n";

        //Statement stmt = conn.createStatement();
        //stmt.executeUpdate(createProcedure);

        Scanner s = new Scanner(System.in);
        System.out.println("Enter the following information for the new client: " + "\n");
        System.out.println( "First Name: " + "\n");
        String fName = s.nextLine();

        System.out.println( "Last Name: " + "\n");
        String lName = s.nextLine();

        System.out.println( "Phone Number: " + "\n");
        String phoneNum = s.nextLine();

        System.out.println( "Email: " + "\n");
        String  email = s.nextLine();

        System.out.println( "Street: " + "\n");
        String street = s.nextLine();

        System.out.println( "City: " + "\n");
        String city = s.nextLine();

        System.out.println( "Zip: " + "\n");
        Integer zip = s.nextInt();
        System.out.println("\n");


        CallableStatement cs = conn.prepareCall("{call InsertClient(?, ?, ?, ?, ?, ?, ?)}");

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
}