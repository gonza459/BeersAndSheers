import java.sql.*;
import java.util.Scanner;


//File for deleting records and tables from the DB
public class DeleteDB {

    public void DeleteRecord(Connection conn) throws Exception {
        Scanner dataTable = new Scanner(System.in);
        System.out.println("Enter the number of the table you would\n" +
                "like to delete a record from: " + "\n" +
                "\n" +
                "1.Clients" + "\n" +
                "2.Employees" + "\n" +
                "3.Appointments" + "\n" +
                "4.Services Being Offered" + "\n" +
                "5.Go back\n");

        int response = dataTable.nextInt();
        System.out.println("\n");

        switch (response) {
            case 1: {

                deleteClient(conn);

                break;

            }
            case 2: {

                deleteEmployee(conn);

                break;

            }
            case 3: {


                deleteAppointment(conn);

                break;

            }
            case 4: {
                deleteService(conn);

                break;


            }
            case 5: {
                UserInteraction UI = new UserInteraction();
                UI.Instructions(conn);
                break;

            }
        }

    }

    //This method deletes per record according to the EmployeeID as prompted from the user
    static void deleteEmployee(Connection conn) throws SQLException{
        Scanner dataTable = new Scanner(System.in);
        System.out.println("Enter the EmployeeID you would like to delete from: ");

        int response = dataTable.nextInt();
        try (PreparedStatement query = conn.prepareStatement("Delete From Employees where EmployeeID = ?" )) {
            System.out.println("Entries Deleted. \n");
            query.setInt(1, response);
            query.executeUpdate();

            System.out.println("The employee was successfully deleted.\n");
        }
        //query.executeUpdate();
    }

    //This method deletes per record according to the CustomerID as prompted from the user
    static void deleteClient(Connection conn) throws SQLException{
        Scanner dataTable = new Scanner(System.in);
        System.out.println("Enter the CustomerID you would like to delete from: ");

        int response = dataTable.nextInt();
        try (PreparedStatement query = conn.prepareStatement("Delete From Clients where CustomerID = ?" )) {
            System.out.println("Entries Deleted. \n");
            query.setInt(1, response);
            query.executeUpdate();

            System.out.println("The client was successfully deleted.\n");
        }
        //query.executeUpdate();
    }

    //This method deletes per record according to the AppointmentID as prompted from the user
    static void deleteAppointment(Connection conn) throws SQLException{
        Scanner dataTable = new Scanner(System.in);
        System.out.println("Enter the AppointmentID you would like to delete from: ");

        int response = dataTable.nextInt();
        try (PreparedStatement query = conn.prepareStatement("Delete From Appointments where AppointmentID = ?" )) {
            System.out.println("Entries Deleted. \n");
            query.setInt(1, response);
            query.executeUpdate();

            System.out.println("The appointment was successfully deleted.\n");
        }
        //query.executeUpdate();
    }

    //This method deletes per record according to the ServiceID as prompted from the user
    static void deleteService(Connection conn) throws SQLException{
        Scanner dataTable = new Scanner(System.in);
        System.out.println("Enter the ServiceID you would like to delete from: ");

        int response = dataTable.nextInt();
        try (PreparedStatement query = conn.prepareStatement("Delete From Services where ServiceID = ?" )) {
            System.out.println("Entries Deleted. \n");
            query.setInt(1, response);
            query.executeUpdate();

            System.out.println("The service was successfully deleted.\n");
        }
        //query.executeUpdate();
    }

    //Deletes all Records at once
    //Used for debugging purposes when inserting the faker file and avoiding errors of duplicates
    public static void deleteAllRecords(Connection conn) throws SQLException {
        Scanner dataTable = new Scanner(System.in);
        System.out.println("Enter the number of the data table you like to delete all current records from: " + "\n" +
                "1.Clients" + "\n" +
                "2.Employees" + "\n" +
                "3.Appointments" + "\n" +
                "4.Addresses" + "\n" +
                "5.Finances" + "\n" +
                "6.All tables" + "\n");

        int response = dataTable.nextInt();

        switch (response) {
            case 1: {
                try (Statement query = conn.createStatement()) {
                    query.executeUpdate("Truncate table Clients");

                    System.out.println("All records have successfully been deleted.");

                    break;
                }

            }
            case 2: {
                try (Statement query = conn.createStatement()) {
                    query.executeUpdate("Truncate table Employees");

                    System.out.println("All records have successfully been deleted.");

                    break;
                }

            }
            case 3: {
                try (Statement query = conn.createStatement()) {
                    query.executeUpdate("Truncate table Appointments");

                    System.out.println("All records have successfully been deleted.");

                    break;
                }

            }
            case 4: {
                try (Statement query = conn.createStatement()) {
                    query.executeUpdate("Truncate table Addresses");

                    System.out.println("All records have successfully been deleted.");

                    break;
                }

            }
            case 5: {
                try (Statement query = conn.createStatement()) {
                    query.executeUpdate("Truncate table Finances");

                    System.out.println("All records have successfully been deleted.\n");

                    break;
                }

            }
            case 6: {

                try (Statement query = conn.createStatement()) {
                    query.executeUpdate("Truncate table Clients");
                    query.executeUpdate("Truncate table Employees");
                    query.executeUpdate("Truncate table Addresses");
                    query.executeUpdate("Truncate table Appointments");

                    System.out.println("All records have successfully been deleted.\n");

                    break;
                }
            }
        }

    }

}
