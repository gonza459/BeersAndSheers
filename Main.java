import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.*;
import java.sql.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws Exception{

        Connection conn;
        DBConnection database = new DBConnection();
        conn = database.getMySqlConnection();

        //Process process;
        //process= Runtime.getRuntime().exec("python /Users/Sam_comp/IdeaProjects/FinalProject/venv/EmployeeFaker.py");


        List<List<String>> salonArray;

        PopulateDB pop = new PopulateDB();
        DeleteDB no = new DeleteDB();
        Sales s = new Sales();

        s.CreateTable(conn);

        //no.deleteAppointment(conn);
        //pop.GenerateService(conn);

        //Creates an array to store the data from the csv file
        //Enter the csvfile path for the reader to locate the file
        salonArray= pop.CSVReader("/Users/Sam_comp/PycharmProjects/Assignment3/Salon.csv");

        //no.deleteAllRecords(conn);
        //pop.InsertToDatabase(conn); //insert data into the database
        //pop.DisplayDatabase(conn); //Prompts for displaying data tables

    }

}