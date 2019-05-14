import java.sql.*;
import java.util.Scanner;


//File for deleting records and tables from the DB
public class DeleteDB {

    //This method deletes per record according to the EmployeeID as prompted from the user
    static void deleteEmployee(Connection conn) throws SQLException{
        Scanner dataTable = new Scanner(System.in);
        System.out.println("Enter the EmployeeID you would like to delete from: ");

        int response = dataTable.nextInt();
        try (PreparedStatement query = conn.prepareStatement("Delete From Employees where EmployeeID = ?" )) {
            System.out.println("Entries Deleted. \n");
            query.setInt(1, response);
            query.executeUpdate();

            System.out.println("The employee was successfully deleted.");
        }
        //query.executeUpdate();
    }
    static void deleteClient(Connection conn) throws SQLException{
        Scanner dataTable = new Scanner(System.in);
        System.out.println("Enter the CustomerID you would like to delete from: ");

        int response = dataTable.nextInt();
        try (PreparedStatement query = conn.prepareStatement("Delete From Clients where CustomerID = ?" )) {
            System.out.println("Entries Deleted. \n");
            query.setInt(1, response);
            query.executeUpdate();

            System.out.println("The client was successfully deleted.");
        }
        //query.executeUpdate();
    }
    static void deleteAppointment(Connection conn) throws SQLException{
        Scanner dataTable = new Scanner(System.in);
        System.out.println("Enter the AppointmentID you would like to delete from: ");

        int response = dataTable.nextInt();
        try (PreparedStatement query = conn.prepareStatement("Delete From Appointments where AppointmentID = ?" )) {
            System.out.println("Entries Deleted. \n");
            query.setInt(1, response);
            query.executeUpdate();

            System.out.println("The appointment was successfully deleted.");
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

                    System.out.println("All records have successfully been deleted.");

                    break;
                }

            }
            case 6: {

                try (Statement query = conn.createStatement()) {
                    query.executeUpdate("Truncate table Clients");
                    query.executeUpdate("Truncate table Employees");
                    query.executeUpdate("Truncate table Addresses");
                    query.executeUpdate("Truncate table Appointments");
                    query.executeUpdate("Truncate table CreditCardInformation");

                    System.out.println("All records have successfully been deleted.");

                    break;
                }
            }
        }

    }

}
