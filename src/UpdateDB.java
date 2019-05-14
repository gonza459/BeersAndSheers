import javax.xml.ws.Service;
import java.lang.*;
import java.io.*;
import java.sql.*;
import java.sql.Date;
import java.util.*;


public class UpdateDB {

    UpdateDB(){

    }
    public void UpdateEmployee(Connection conn) throws SQLException{
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the EmployeeID you would like to update: ");
        int E_ID = s.nextInt();

        System.out.println("What would you like to update?");
        System.out.println("1. First Name\n" +
                "2. Last Name\n" +
                "3. Street Address\n" +
                "4. City\n" +
                "5. Zipcode\n" +
                "6. Phone Number\n");

        int response = s.nextInt();

        switch (response) {
            case 1: {
                System.out.println("Enter the new First Name: ");
                s.nextLine();
                String name = s.nextLine();

                PreparedStatement query = conn.prepareStatement("UPDATE Employees SET FirstName = ? where EmployeeID = ?" );
                query.setString(1, name);
                query.setInt(2,E_ID);
                query.executeUpdate();

                System.out.println("The employee was successfully updated.");

                break;


            }
            case 2: {
                System.out.println("Enter the new Last Name: ");
                s.nextLine();
                String name = s.nextLine();

                PreparedStatement query = conn.prepareStatement("UPDATE Employees SET LastName = ? where EmployeeID = ?" );
                query.setString(1, name);
                query.setInt(2,E_ID);
                query.executeUpdate();

                System.out.println("The employee was successfully updated.");

                break;


            }
            case 3: {
                System.out.println("Enter the new street address: ");
                s.nextLine();
                String address = s.nextLine();

                PreparedStatement query = conn.prepareStatement("UPDATE Employees SET Street = ? where EmployeeID = ?" );
                query.setString(1, address);
                query.setInt(2,E_ID);
                query.executeUpdate();

                System.out.println("The employee was successfully updated.");

                break;


            }
            case 4: {
                System.out.println("Enter the new City: ");
                s.nextLine();
                String city = s.nextLine();

                PreparedStatement query = conn.prepareStatement("UPDATE Employees SET City = ? where EmployeeID = ?" );
                query.setString(1, city);
                query.setInt(2,E_ID);
                query.executeUpdate();

                System.out.println("The employee was successfully updated.");

                break;


            }
            case 5: {
                System.out.println("Enter the new Zipcode: ");
                s.nextInt();
                Integer zip = s.nextInt();

                PreparedStatement query = conn.prepareStatement("UPDATE Employees SET Zipcode = ? where EmployeeID = ?" );
                query.setInt(1, zip);
                query.setInt(2,E_ID);
                query.executeUpdate();

                System.out.println("The employee was successfully updated.");

                break;



            }case 6: {
                System.out.println("Enter the new phone number: ");
                s.nextLine();
                String phone = s.nextLine();

                PreparedStatement query = conn.prepareStatement("UPDATE Employees SET PhoneNum = ? where EmployeeID = ?" );
                query.setString(1, phone);
                query.setInt(2,E_ID);
                query.executeUpdate();

                System.out.println("The employee was successfully updated.");

                break;

            }
        }

    }public void UpdateClient(Connection conn) throws SQLException{
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the ClientID you would like to update: ");
        int C_ID = s.nextInt();

        System.out.println("What would you like to update?");
        System.out.println("1. First Name\n" +
                "2. Last Name\n" +
                "3. Street Address\n" +
                "4. City\n" +
                "5. Zipcode\n" +
                "6. Phone Number\n" +
                "7. Email\n");

        int response = s.nextInt();

        switch (response) {
            case 1: {
                System.out.println("Enter the new First Name: ");
                s.nextLine();
                String name = s.nextLine();

                PreparedStatement query = conn.prepareStatement("UPDATE Clients SET FirstName = ? where CustomerID = ?" );
                query.setString(1, name);
                query.setInt(2,C_ID);
                query.executeUpdate();

                System.out.println("The employee was successfully updated.");

                break;


            }
            case 2: {
                System.out.println("Enter the new Last Name: ");
                s.nextLine();
                String name = s.nextLine();

                PreparedStatement query = conn.prepareStatement("UPDATE Clients SET LastName = ? where CustomerID = ?" );
                query.setString(1, name);
                query.setInt(2,C_ID);
                query.executeUpdate();

                System.out.println("The employee was successfully updated.");

                break;


            }
            case 3: {
                System.out.println("Enter the new street address: ");
                s.nextLine();
                String address = s.nextLine();

                PreparedStatement query = conn.prepareStatement("UPDATE Clients SET Street = ? where CustomerID = ?" );
                query.setString(1, address);
                query.setInt(2,C_ID);
                query.executeUpdate();

                // PreparedStatement addressQuery = conn.prepareStatement("UPDATE Addresses SET Street = ? Where Zipcode = ?");
                //query.setString(1, address);

                System.out.println("The employee was successfully updated.");

                break;


            }
            case 4: {
                System.out.println("Enter the new City: ");
                s.nextLine();
                String city = s.nextLine();

                PreparedStatement query = conn.prepareStatement("UPDATE Clients SET City = ? where CustomerID = ?" );
                query.setString(1, city);
                query.setInt(2,C_ID);
                query.executeUpdate();

                System.out.println("The employee was successfully updated.");

                break;


            }
            case 5: {
                System.out.println("Enter the new Zipcode: ");
                s.nextInt();
                Integer zip = s.nextInt();

                PreparedStatement query = conn.prepareStatement("UPDATE Clients SET Zipcode = ? where CustomerID = ?" );
                query.setInt(1, zip);
                query.setInt(2,C_ID);
                query.executeUpdate();

                System.out.println("The employee was successfully updated.");

                break;



            }case 6: {
                System.out.println("Enter the new phone number: ");
                s.nextLine();
                String phone = s.nextLine();

                PreparedStatement query = conn.prepareStatement("UPDATE Clients SET PhoneNum = ? where CustomerID = ?" );
                query.setString(1, phone);
                query.setInt(2,C_ID);
                query.executeUpdate();

                System.out.println("The employee was successfully updated.");

                break;

            }case 7: {
                System.out.println("Enter the new email: ");
                s.nextLine();
                String email = s.nextLine();

                PreparedStatement query = conn.prepareStatement("UPDATE Clients SET Email = ? where CustomerID = ?" );
                query.setString(1, email);
                query.setInt(2,C_ID);
                query.executeUpdate();

                System.out.println("The employee was successfully updated.");

                break;

            }
        }

    }
    public void UpdateAppointments(Connection conn) throws SQLException{
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the AppointmentID you would like to update: ");
        int A_ID = s.nextInt();

        System.out.println("What would you like to update?");
        System.out.println("1. ServiceID\n" +
                "2. Appointment Month and Day\n" +
                "3. Just Appointment Day\n" +
                "4. Customer ID\n");

        int response = s.nextInt();

        switch (response) {
            case 1: {
                System.out.println("Enter the new ServiceID: ");
                s.nextLine();
                String name = s.nextLine();

                PreparedStatement query = conn.prepareStatement("UPDATE Employees SET FirstName = ? where EmployeeID = ?" );
                query.setString(1, name);
                query.setInt(2,A_ID);
                query.executeUpdate();

                System.out.println("The employee was successfully updated.");

                break;


            }
            case 2: {
                System.out.println("Enter the new Appointment Month: ");
                s.nextLine();
                String month = s.nextLine();

                System.out.println("Enter the new Appointment Day: ");
                s.nextLine();
                String day = s.nextLine();

                PreparedStatement query = conn.prepareStatement("UPDATE Appointments SET AppointmentMonth = ? where AppointmentID = ?" );
                query.setString(1, month);
                query.setInt(2,A_ID);
                query.executeUpdate();

                System.out.println("The employee was successfully updated.");

                break;


            }
            case 3: {
                System.out.println("Enter the new street address: ");
                s.nextLine();
                String address = s.nextLine();

                PreparedStatement query = conn.prepareStatement("UPDATE Employees SET Street = ? where EmployeeID = ?" );
                query.setString(1, address);
                query.setInt(2,A_ID);
                query.executeUpdate();

                System.out.println("The employee was successfully updated.");

                break;


            }
            case 4: {
                System.out.println("Enter the new City: ");
                s.nextLine();
                String city = s.nextLine();

                PreparedStatement query = conn.prepareStatement("UPDATE Employees SET City = ? where EmployeeID = ?" );
                query.setString(1, city);
                query.setInt(2,A_ID);
                query.executeUpdate();

                System.out.println("The employee was successfully updated.");

                break;


            }
            case 5: {
                System.out.println("Enter the new Zipcode: ");
                s.nextInt();
                Integer zip = s.nextInt();

                PreparedStatement query = conn.prepareStatement("UPDATE Employees SET Zipcode = ? where EmployeeID = ?" );
                query.setInt(1, zip);
                query.setInt(2,A_ID);
                query.executeUpdate();

                System.out.println("The employee was successfully updated.");

                break;



            }case 6: {
                System.out.println("Enter the new phone number: ");
                s.nextLine();
                String phone = s.nextLine();

                PreparedStatement query = conn.prepareStatement("UPDATE Employees SET PhoneNum = ? where EmployeeID = ?" );
                query.setString(1, phone);
                query.setInt(2,A_ID);
                query.executeUpdate();

                System.out.println("The employee was successfully updated.");

                break;

            }
        }

    }



}
