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
        DisplayDB dis = new DisplayDB();

        s.CreateTable(conn);

        //no.deleteAppointment(conn);
        //pop.D(conn);

        //Creates an array to store the data from the csv file
        //Enter the csvfile path for the reader to locate the file
        salonArray= pop.CSVReader("/Users/Sam_comp/PycharmProjects/Assignment3/Beers&Sheers.csv");

        //no.deleteAllRecords(conn);
        //pop.InsertClient(conn); //insert data into the database
        dis.DisplayDatabase(conn); //Prompts for displaying data tables

    }

}