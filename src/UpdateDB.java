import javax.xml.ws.Service;
import java.lang.*;
import java.io.*;
import java.sql.*;
import java.sql.Date;
import java.util.*;


public class UpdateDB {

    UpdateDB(){

    }
    public void UpdateDatabase(Connection conn) throws Exception {
        Scanner dataTable = new Scanner(System.in);
        System.out.println("Enter the number of the information you would\n" +
                "like to update a record: " + "\n" +
                "1.Clients" + "\n" +
                "2.Employees" + "\n" +
                "3.Appointments" + "\n" +
                "5.Services Being Offered" + "\n" +
                "6.Sales per Month" + "\n");

        int response = dataTable.nextInt();

        switch (response) {
            case 1: {

                UpdateClient(conn);

                break;

            }case 2: {

                UpdateEmployee(conn);

                break;

            }case 3: {


                UpdateAppointment(conn);

                break;

            }case 4: {
                UpdateService(conn);

                break;


            }case 5:{
                Sales s = new Sales();
                s.UpdateSales(conn);

            }
        }

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



            }
            case 6: {
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

    }
    public void UpdateClient(Connection conn) throws SQLException{
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

                System.out.println("The Client was successfully updated.");

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

                System.out.println("The client was successfully updated.");

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

                System.out.println("The client was successfully updated.");

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

                System.out.println("The client was successfully updated.");

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

                System.out.println("The client was successfully updated.");

                break;



            }
            case 6: {
                System.out.println("Enter the new phone number: ");
                s.nextLine();
                String phone = s.nextLine();

                PreparedStatement query = conn.prepareStatement("UPDATE Clients SET PhoneNum = ? where CustomerID = ?" );
                query.setString(1, phone);
                query.setInt(2,C_ID);
                query.executeUpdate();

                System.out.println("The client was successfully updated.");

                break;

            }
            case 7: {
                System.out.println("Enter the new email: ");
                s.nextLine();
                String email = s.nextLine();

                PreparedStatement query = conn.prepareStatement("UPDATE Clients SET Email = ? where CustomerID = ?" );
                query.setString(1, email);
                query.setInt(2,C_ID);
                query.executeUpdate();

                System.out.println("The client was successfully updated.");

                break;

            }
        }

    }
    public void UpdateAppointment(Connection conn) throws SQLException{
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the AppointmentID you would like to update: ");
        int A_ID = s.nextInt();

        System.out.println("What would you like to update?\n");
        System.out.println("1. ServiceID\n" +
                "2. Appointment Month and Day\n" +
                "3. Just Appointment Day\n" +
                "4. Customer ID\n" +
                "5. Go back to main menu\n");

        int response = s.nextInt();

        System.out.println("\n");

        switch (response) {
            case 1: {
                System.out.println("Enter the new ServiceID: ");
                s.nextLine();
                int S_ID = s.nextInt();

                PreparedStatement query = conn.prepareStatement("UPDATE Appointments SET ServiceID = ? where AppointmentID = ?" );
                query.setInt(1, S_ID);
                query.setInt(2,A_ID);
                query.executeUpdate();

                System.out.println("The Appointment was successfully updated.");

                break;


            }
            case 2: {
                System.out.println("Enter the new Appointment Month: ");
                s.nextLine();
                int month = s.nextInt();

                System.out.println("Enter the new Appointment Day: ");
                s.nextLine();
                int day = s.nextInt();

                PreparedStatement query = conn.prepareStatement("UPDATE Appointments SET AppointmentMonth = ?, AppointmentDay =  ? where AppointmentID = ?" );
                query.setInt(1, month);
                query.setInt(2, day);
                query.setInt(3,A_ID);
                query.executeUpdate();

                System.out.println("The Appointment was successfully updated.");

                break;


            }
            case 3: {
                System.out.println("Enter the Appointment Day: ");
                s.nextLine();
                int day = s.nextInt();

                PreparedStatement query = conn.prepareStatement("UPDATE Appointments SET AppointmentDay = ? where AppointmentID = ?" );
                query.setInt(1, day);
                query.setInt(2,A_ID);
                query.executeUpdate();

                System.out.println("The Appointment was successfully updated.");

                break;


            }
            case 4: {
                System.out.println("Enter the Customer ID: ");
                s.nextLine();
                int C_ID = s.nextInt();

                PreparedStatement query = conn.prepareStatement("UPDATE Appointments SET CustomerID = ? where AppointmentID = ?" );
                query.setInt(1, C_ID);
                query.setInt(2,A_ID);
                query.executeUpdate();

                System.out.println("The Appointment was successfully updated.");

                break;


            }case 5: {
                UserInteraction UI = new UserInteraction();
                UI.Instructions(conn);
                break;

            }

        }

    }
    public void UpdateService(Connection conn) throws SQLException {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the ServiceID you would like to update: ");
        int S_ID = s.nextInt();

        System.out.println("What would you like to update?");
        System.out.println("1. Service Name\n" +
                "2. Service Duration\n" +
                "3. Service Price\n" +
                "4. Service Materials\n");

        int response = s.nextInt();

        switch (response) {
            case 1: {
                System.out.println("Enter the new name of the service: ");
                s.nextLine();
                String name = s.nextLine();

                PreparedStatement query = conn.prepareStatement("UPDATE Services SET ServiceName = ? where ServiceID = ?");
                query.setString(1, name);
                query.setInt(2, S_ID);
                query.executeUpdate();

                System.out.println("The Service was successfully updated.");

                break;


            }
            case 2: {
                System.out.println("Enter the new estimated duration of the service: ");
                s.nextLine();
                String duration = s.nextLine();

                PreparedStatement query = conn.prepareStatement("UPDATE Services SET ServiceDuration = ? where ServiceID = ?");
                query.setString(1, duration);
                query.setInt(2, S_ID);
                query.executeUpdate();

                System.out.println("The Service Duration was successfully updated.");

                break;


            }
            case 3: {
                System.out.println("Enter the new price of the service: ");
                s.nextLine();
                float price = s.nextFloat();

                PreparedStatement query = conn.prepareStatement("UPDATE Services SET ServicePrice = ? where ServiceID = ?");
                query.setFloat(1, price);
                query.setInt(2, S_ID);
                query.executeUpdate();

                System.out.println("The Service price was successfully updated.");

                break;


            }
            case 4: {
                System.out.println("Enter the new materials needed for the service: ");
                s.nextLine();
                String materials = s.nextLine();

                PreparedStatement query = conn.prepareStatement("UPDATE Services SET ServiceMaterials = ? where ServiceID = ?");
                query.setString(1, materials);
                query.setInt(2, S_ID);
                query.executeUpdate();

                System.out.println("The Service materials was successfully updated.");

                break;


            }case 5: {
                UserInteraction UI = new UserInteraction();
                UI.Instructions(conn);
                break;

            }

        }
    }

}
