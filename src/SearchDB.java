import dnl.utils.text.table.TextTable;

import javax.xml.transform.Result;
import java.io.*;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.text.*;

public class SearchDB {
    List<List<String>> attributes = new ArrayList<List<String>>();
    Connection conn;
    Services service = new Services();

    SearchDB() {

    }

    //Prints out Information from the Database Tables
    public void SearchDatabase(Connection conn) throws Exception {
        Scanner dataTable = new Scanner(System.in);
        System.out.println("Enter the number of the information you would like to search for: " + "\n" +
                "\n" +
                "1.Clients" + "\n" +
                "2.Employees" + "\n" +
                "3.Appointments" + "\n" +
                "4.Addresses List" + "\n" +
                "5.Services Being Offered" + "\n" +
                "6.Sales per Month" + "\n" +
                "7.Go back to main menu" + "\n");

            int response = dataTable.nextInt();

        System.out.println("\n");

            switch (response) {
                case 1: {

                    searchClients(conn);

                    break;

                }
                case 2: {

                    searchEmployees(conn);

                    break;

                }
                case 3: {


                    searchAppointments(conn);

                    break;

                }
                case 4: {
                    searchAddresses(conn);

                    break;

                }
                case 5: {

                    searchServices(conn);

                    break;


                }
                case 6: {

                    searchSales(conn);

                    break;

                }
                case 7: {
                    UserInteraction UI = new UserInteraction();
                    UI.Instructions(conn);
                    break;

                }

            }

        }



    //Querries to print data from each respective table
    private static void searchClients(Connection conn) throws SQLException {
        Scanner input = new Scanner(System.in);
        int count;
        ResultSet rs;

        System.out.println("What would you like to search by?\n" +
                "1. Client ID\n" +
                "2. Fist Name\n" +
                "3. Last Name\n" +
                "4. Phone Number\n" +
                "5. Email");
        int response = input.nextInt();

        switch (response) {
            case 1: {
                System.out.println("Enter the Customer ID you would like to look up: ");
                input.nextLine();
                int id = input.nextInt();

                String countSql = "SELECT count(*) From Clients where CustomerID = ?";

                PreparedStatement countPS = conn.prepareStatement(countSql);
                countPS.setInt(1,id);
                ResultSet countRS = countPS.executeQuery();
                countRS.next();
                count = countRS.getInt(1);
                System.out.println(count);

                String searchSql = "SELECT * FROM Clients Where CustomerID = ?";

                PreparedStatement query = conn.prepareStatement(searchSql);
                query.setInt(1,id);
                rs = query.executeQuery();

                DisplayDB d = new DisplayDB();
                d.displayClients(conn, rs, count);
                rs.close();

                break;


            }
            case 2: {
                System.out.println("Enter the First Name you would like to look up: ");
                input.nextLine();
                String f_Name = input.nextLine();

                String countSql = "SELECT count(*) From Clients where FirstName = ?";

                PreparedStatement countPS = conn.prepareStatement(countSql);
                countPS.setString(1,f_Name);
                ResultSet countRS = countPS.executeQuery();
                countRS.next();
                count = countRS.getInt(1);

                String searchSql = "SELECT * FROM Clients Where FirstName = ?";

                PreparedStatement query = conn.prepareStatement(searchSql);
                query.setString(1,f_Name);
                rs = query.executeQuery();

                DisplayDB d = new DisplayDB();
                d.displayClients(conn, rs, count);
                rs.close();

                break;
            }

            case 3: {

                System.out.println("Enter the Last Name you would like to look up: ");
                input.nextLine();
                String l_Name = input.nextLine();

                String countSql = "SELECT count(*) From Clients where LastName = ?";

                PreparedStatement countPS = conn.prepareStatement(countSql);
                countPS.setString(1,l_Name);
                ResultSet countRS = countPS.executeQuery();
                countRS.next();
                count = countRS.getInt(1);

                String searchSql = "SELECT * FROM Clients Where LastName = ?";

                PreparedStatement query = conn.prepareStatement(searchSql);
                query.setString(1,l_Name);
                rs = query.executeQuery();

                DisplayDB d = new DisplayDB();
                d.displayClients(conn, rs, count);
                rs.close();

                break;

            }case 4: {
                System.out.println("Enter the Phone Number you would like to look up: ");
                input.nextLine();
                String phoneNum = input.nextLine();

                String countSql = "SELECT count(*) From Clients where PhoneNum = ?";

                PreparedStatement countPS = conn.prepareStatement(countSql);
                countPS.setString(1,phoneNum);
                ResultSet countRS = countPS.executeQuery();
                countRS.next();
                count = countRS.getInt(1);

                String searchSql = "SELECT * FROM Clients Where PhoneNum = ?";

                PreparedStatement query = conn.prepareStatement(searchSql);
                query.setString(1,phoneNum);
                rs = query.executeQuery();

                DisplayDB d = new DisplayDB();
                d.displayClients(conn, rs, count);
                rs.close();

                break;

            }case 5: {
                System.out.println("Enter the email you would like to look up: ");
                input.nextLine();
                String email = input.nextLine();

                String countSql = "SELECT count(*) From Clients where Email = ?";

                PreparedStatement countPS = conn.prepareStatement(countSql);
                countPS.setString(1,email);
                ResultSet countRS = countPS.executeQuery();
                countRS.next();
                count = countRS.getInt(1);

                String searchSql = "SELECT * FROM Clients Where Email = ?";

                PreparedStatement query = conn.prepareStatement(searchSql);
                query.setString(1,email);
                rs = query.executeQuery();

                DisplayDB d = new DisplayDB();
                d.displayClients(conn, rs, count);
                rs.close();

                break;
                }


            }

        }

    private static void searchEmployees(Connection conn) throws SQLException {
        Scanner input = new Scanner(System.in);
        int count;
        ResultSet rs;

        System.out.println("What would you like to search by?\n" +
                "1. Employee ID\n" +
                "2. Fist Name\n" +
                "3. Last Name\n" +
                "4. Phone Number");
        int response = input.nextInt();

        switch (response) {
            case 1: {
                System.out.println("Enter the Employee ID you would like to look up: ");
                input.nextLine();
                int id = input.nextInt();

                String countSql = "SELECT count(*) From Employees where EmployeeID = ?";

                PreparedStatement countPS = conn.prepareStatement(countSql);
                countPS.setInt(1,id);
                ResultSet countRS = countPS.executeQuery();
                countRS.next();
                count = countRS.getInt(1);
                System.out.println(count);

                String searchSql = "SELECT * FROM Employees Where EmployeeID = ?";

                PreparedStatement query = conn.prepareStatement(searchSql);
                query.setInt(1,id);
                rs = query.executeQuery();

                DisplayDB d = new DisplayDB();
                d.displayEmployees(conn, rs, count);
                rs.close();

                break;


            }
            case 2: {
                System.out.println("Enter the First Name you would like to look up: ");
                input.nextLine();
                String f_Name = input.nextLine();

                String countSql = "SELECT count(*) From Employees where FirstName = ?";

                PreparedStatement countPS = conn.prepareStatement(countSql);
                countPS.setString(1,f_Name);
                ResultSet countRS = countPS.executeQuery();
                countRS.next();
                count = countRS.getInt(1);

                String searchSql = "SELECT * FROM Employees Where FirstName = ?";

                PreparedStatement query = conn.prepareStatement(searchSql);
                query.setString(1,f_Name);
                rs = query.executeQuery();

                DisplayDB d = new DisplayDB();
                d.displayEmployees(conn, rs, count);
                rs.close();

                break;
            }

            case 3: {

                System.out.println("Enter the Last Name you would like to look up: ");
                input.nextLine();
                String l_Name = input.nextLine();

                String countSql = "SELECT count(*) From Employees where LastName = ?";

                PreparedStatement countPS = conn.prepareStatement(countSql);
                countPS.setString(1,l_Name);
                ResultSet countRS = countPS.executeQuery();
                countRS.next();
                count = countRS.getInt(1);

                String searchSql = "SELECT * FROM Employees Where LastName = ?";

                PreparedStatement query = conn.prepareStatement(searchSql);
                query.setString(1,l_Name);
                rs = query.executeQuery();

                DisplayDB d = new DisplayDB();
                d.displayEmployees(conn, rs, count);
                rs.close();

                break;

            }case 4: {
                System.out.println("Enter the Phone Number you would like to look up: ");
                input.nextLine();
                String phoneNum = input.nextLine();

                String countSql = "SELECT count(*) From Employees where PhoneNum = ?";

                PreparedStatement countPS = conn.prepareStatement(countSql);
                countPS.setString(1,phoneNum);
                ResultSet countRS = countPS.executeQuery();
                countRS.next();
                count = countRS.getInt(1);

                String searchSql = "SELECT * FROM Employees Where PhoneNum = ?";

                PreparedStatement query = conn.prepareStatement(searchSql);
                query.setString(1,phoneNum);
                rs = query.executeQuery();

                DisplayDB d = new DisplayDB();
                d.displayEmployees(conn, rs, count);
                rs.close();

                break;

            }

        }

    }

    private static void searchAppointments(Connection conn) throws SQLException {
        Scanner input = new Scanner(System.in);
        int count;
        ResultSet rs;

        System.out.println("What would you like to search by?\n" +
                "1. Appointment ID\n" +
                "2. Service ID\n" +
                "3. Appointment Month\n" +
                "4. Appointment Month and Day\n" +
                "5. Appointment Day\n" +
                "6. CustomerID");
        int response = input.nextInt();

        switch (response) {
            case 1: {
                System.out.println("Enter the Appointment ID you would like to look up: ");
                input.nextLine();
                int A_id = input.nextInt();

                String countSql = "SELECT count(*) From Appointments where AppointmentID = ?";

                PreparedStatement countPS = conn.prepareStatement(countSql);
                countPS.setInt(1,A_id);
                ResultSet countRS = countPS.executeQuery();
                countRS.next();
                count = countRS.getInt(1);
                System.out.println(count);

                String searchSql = "SELECT * FROM Appointments Where AppointmentID = ?";

                PreparedStatement query = conn.prepareStatement(searchSql);
                query.setInt(1,A_id);
                rs = query.executeQuery();

                DisplayDB d = new DisplayDB();
                d.displayAppointments(conn, rs, count);
                rs.close();

                break;

            }
            case 2: {
                System.out.println("Enter the Service ID you would like to look up: ");
                input.nextLine();
                int S_id = input.nextInt();

                String countSql = "SELECT count(*) From Appointments where ServiceID = ?";

                PreparedStatement countPS = conn.prepareStatement(countSql);
                countPS.setInt(1,S_id);
                ResultSet countRS = countPS.executeQuery();
                countRS.next();
                count = countRS.getInt(1);
                System.out.println(count);

                String searchSql = "SELECT * FROM Appointments Where ServiceID = ?";

                PreparedStatement query = conn.prepareStatement(searchSql);
                query.setInt(1,S_id);
                rs = query.executeQuery();

                DisplayDB d = new DisplayDB();
                d.displayAppointments(conn, rs, count);
                rs.close();

                break;

            }
            case 3: {
                System.out.println("Enter the Appointment Month you would like to look up: ");
                input.nextLine();
                String month = input.nextLine();

                String countSql = "SELECT count(*) From Appointments where AppointmentMonth = ?";

                PreparedStatement countPS = conn.prepareStatement(countSql);
                countPS.setString(1, month);
                ResultSet countRS = countPS.executeQuery();
                countRS.next();
                count = countRS.getInt(1);
                System.out.println(count);

                String searchSql = "SELECT * FROM Appointments Where AppointmentMonth = ?";

                PreparedStatement query = conn.prepareStatement(searchSql);
                countPS.setString(1, month);
                rs = query.executeQuery();

                DisplayDB d = new DisplayDB();
                d.displayAppointments(conn, rs, count);
                rs.close();

                break;

            }
            case 4: {

                System.out.println("Enter the Appointment Month you would like to look up: ");
                input.nextLine();
                String month = input.nextLine();
                System.out.println("Enter the Appointment Day you would like to look up: ");
                input.nextLine();
                String day = input.nextLine();

                String countSql = "SELECT count(*) From Appointments where AppointmentMonth = ? AND AppointmentDay = ?";

                PreparedStatement countPS = conn.prepareStatement(countSql);
                countPS.setString(1,month);
                countPS.setString(2,day);
                ResultSet countRS = countPS.executeQuery();
                countRS.next();
                count = countRS.getInt(1);
                System.out.println(count);

                String searchSql = "SELECT * FROM Appointments Where AppointmentMonth = ? AND AppointmentDay = ?";

                PreparedStatement query = conn.prepareStatement(searchSql);
                countPS.setString(1,month);
                countPS.setString(2,day);
                rs = query.executeQuery();

                DisplayDB d = new DisplayDB();
                d.displayAppointments(conn, rs, count);
                rs.close();

                break;

            }
            case 5: {
                System.out.println("Enter the Appointment Day you would like to look up: ");
                input.nextLine();
                String day = input.nextLine();

                String countSql = "SELECT count(*) From Appointments where AppointmentDay = ?";

                PreparedStatement countPS = conn.prepareStatement(countSql);
                countPS.setString(1,day);
                ResultSet countRS = countPS.executeQuery();
                countRS.next();
                count = countRS.getInt(1);
                System.out.println(count);

                String searchSql = "SELECT * FROM Appointments Where AppointmentDay = ?";

                PreparedStatement query = conn.prepareStatement(searchSql);
                countPS.setString(1,day);
                rs = query.executeQuery();

                DisplayDB d = new DisplayDB();
                d.displayAppointments(conn, rs, count);
                rs.close();

                break;

            }
            case 6: {
                System.out.println("Enter the customer ID you would like to look up: ");
                input.nextLine();
                int C_id = input.nextInt();

                String countSql = "SELECT count(*) From Appointments where CustomerIDID = ?";

                PreparedStatement countPS = conn.prepareStatement(countSql);
                countPS.setInt(1,C_id);
                ResultSet countRS = countPS.executeQuery();
                countRS.next();
                count = countRS.getInt(1);
                System.out.println(count);

                String searchSql = "SELECT * FROM Appointments Where AppointmentID = ?";

                PreparedStatement query = conn.prepareStatement(searchSql);
                query.setInt(1,C_id);
                rs = query.executeQuery();

                DisplayDB d = new DisplayDB();
                d.displayAppointments(conn, rs, count);
                rs.close();

                break;

            }


        }

    }

    private static void searchAddresses(Connection conn) throws SQLException {
        Scanner input = new Scanner(System.in);
        int count;
        ResultSet rs;

        System.out.println("What would you like to search by?\n" +
                "1. Zipcode\n" +
                "2. City\n" +
                "3. Street Address");

        int response = input.nextInt();

        switch (response) {
            case 1: {
                System.out.println("Enter the Zipcode you would like to look up: ");
                input.nextLine();
                int zip = input.nextInt();

                String countSql = "SELECT count(*) From Addresses where Zipcode = ?";

                PreparedStatement countPS = conn.prepareStatement(countSql);
                countPS.setInt(1,zip);
                ResultSet countRS = countPS.executeQuery();
                countRS.next();
                count = countRS.getInt(1);
                System.out.println(count);

                String searchSql = "SELECT * FROM Addresses Where Zipcode = ?";

                PreparedStatement query = conn.prepareStatement(searchSql);
                query.setInt(1,zip);
                rs = query.executeQuery();

                DisplayDB d = new DisplayDB();
                d.displayAddresses(conn, rs, count);
                rs.close();

                break;

            }
            case 2: {
                System.out.println("Enter the City you would like to look up: ");
                input.nextLine();
                String city = input.nextLine();

                String countSql = "SELECT count(*) From Addresses where City = ?";

                PreparedStatement countPS = conn.prepareStatement(countSql);
                countPS.setString(1,city);
                ResultSet countRS = countPS.executeQuery();
                countRS.next();
                count = countRS.getInt(1);
                System.out.println(count);

                String searchSql = "SELECT * FROM Addresses Where City = ?";

                PreparedStatement query = conn.prepareStatement(searchSql);
                query.setString(1,city);
                rs = query.executeQuery();

                DisplayDB d = new DisplayDB();
                d.displayAddresses(conn, rs, count);
                rs.close();

                break;

            }
            case 3: {
                System.out.println("Enter the City you would like to look up: ");
                input.nextLine();
                String street = input.nextLine();

                String countSql = "SELECT count(*) From Addresses where Street = ?";

                PreparedStatement countPS = conn.prepareStatement(countSql);
                countPS.setString(1,street);
                ResultSet countRS = countPS.executeQuery();
                countRS.next();
                count = countRS.getInt(1);
                System.out.println(count);

                String searchSql = "SELECT * FROM Addresses Where Street = ?";

                PreparedStatement query = conn.prepareStatement(searchSql);
                query.setString(1,street);
                rs = query.executeQuery();

                DisplayDB d = new DisplayDB();
                d.displayAddresses(conn, rs, count);
                rs.close();

                break;

            }
        }

    }

    private static void searchServices(Connection conn) throws SQLException {
        Scanner input = new Scanner(System.in);
        int count;
        ResultSet rs;

        System.out.println("What would you like to search by?\n" +
                "1. Service ID\n" +
                "2. Service Name\n" +
                "3. Duration\n" +
                "4. Price\n" +
                "5. Materials");
        int response = input.nextInt();

        switch (response) {
            case 1: {
                System.out.println("Enter the Service ID you would like to look up: ");
                input.nextLine();
                int S_id = input.nextInt();

                String countSql = "SELECT count(*) From Services where ServiceID = ?";

                PreparedStatement countPS = conn.prepareStatement(countSql);
                countPS.setInt(1,S_id);
                ResultSet countRS = countPS.executeQuery();
                countRS.next();
                count = countRS.getInt(1);
                System.out.println(count);

                String searchSql = "SELECT * FROM Services Where ServiceID = ?";

                PreparedStatement query = conn.prepareStatement(searchSql);
                query.setInt(1,S_id);
                rs = query.executeQuery();

                DisplayDB d = new DisplayDB();
                d.displayServices(conn, rs, count);
                rs.close();

                break;

            }
            case 2: {
                System.out.println("Enter the Service name you would like to look up: ");
                input.nextLine();
                String name = input.nextLine();

                String countSql = "SELECT count(*) From Services where ServiceName = ?";

                PreparedStatement countPS = conn.prepareStatement(countSql);
                countPS.setString(1,name);
                ResultSet countRS = countPS.executeQuery();
                countRS.next();
                count = countRS.getInt(1);
                System.out.println(count);

                String searchSql = "SELECT * FROM Services Where ServiceName = ?";

                PreparedStatement query = conn.prepareStatement(searchSql);
                query.setString(1,name);
                rs = query.executeQuery();

                DisplayDB d = new DisplayDB();
                d.displayServices(conn, rs, count);
                rs.close();

                break;

            }
            case 3: {
                System.out.println("Enter the duration you would like to look up: ");
                input.nextLine();
                String duration = input.nextLine();

                String countSql = "SELECT count(*) From Services where ServiceDuration = ?";

                PreparedStatement countPS = conn.prepareStatement(countSql);
                countPS.setString(1,duration);
                ResultSet countRS = countPS.executeQuery();
                countRS.next();
                count = countRS.getInt(1);
                System.out.println(count);

                String searchSql = "SELECT * FROM Services Where ServiceDuration = ?";

                PreparedStatement query = conn.prepareStatement(searchSql);
                query.setString(1,duration);
                rs = query.executeQuery();

                DisplayDB d = new DisplayDB();
                d.displayServices(conn, rs, count);
                rs.close();

                break;

            }
            case 4: {
                System.out.println("Enter the Service ID you would like to look up: ");
                input.nextLine();
                float price = input.nextInt();

                String countSql = "SELECT count(*) From Services where ServicePrice = ?";

                PreparedStatement countPS = conn.prepareStatement(countSql);
                countPS.setFloat(1,price);
                ResultSet countRS = countPS.executeQuery();
                countRS.next();
                count = countRS.getInt(1);
                System.out.println(count);

                String searchSql = "SELECT * FROM Services Where ServicePrice = ?";

                PreparedStatement query = conn.prepareStatement(searchSql);
                query.setFloat(1,price);
                rs = query.executeQuery();

                DisplayDB d = new DisplayDB();
                d.displayServices(conn, rs, count);
                rs.close();

                break;

            }
            case 5: {
                System.out.println("Enter the materials you would like to look up: ");
                input.nextLine();
                String materials = input.nextLine();

                String countSql = "SELECT count(*) From Services where ServiceMaterials = ?";

                PreparedStatement countPS = conn.prepareStatement(countSql);
                countPS.setString(1,materials);
                ResultSet countRS = countPS.executeQuery();
                countRS.next();
                count = countRS.getInt(1);
                System.out.println(count);

                String searchSql = "SELECT * FROM Services Where ServiceMaterials = ?";

                PreparedStatement query = conn.prepareStatement(searchSql);
                query.setString(1,materials);
                rs = query.executeQuery();

                DisplayDB d = new DisplayDB();
                d.displayServices(conn, rs, count);
                rs.close();

                break;

            }
        }

    }

    private static void searchSales(Connection conn) throws SQLException {
        Scanner input = new Scanner(System.in);
        int count;
        ResultSet rs;

        System.out.println("What would you like to search by?\n" +
                "1. Month\n");
        int response = input.nextInt();

        switch (response) {
            case 1: {
                System.out.println("Enter the Appointment Month you would like to look up: ");
                input.nextLine();
                String month = input.nextLine();

                String countSql = "SELECT count(*) From MonthlySales where Month = ?";

                PreparedStatement countPS = conn.prepareStatement(countSql);
                countPS.setString(1, month);
                ResultSet countRS = countPS.executeQuery();
                countRS.next();
                count = countRS.getInt(1);
                System.out.println(count);

                String searchSql = "SELECT * FROM MonthlySales Where Month = ?";

                PreparedStatement query = conn.prepareStatement(searchSql);
                countPS.setString(1, month);
                rs = query.executeQuery();

                DisplayDB d = new DisplayDB();
                d.displaySales(conn, rs, count);
                rs.close();

                break;

            }

        }

    }
}
