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

        List<List<String>> salonArray;

        PopulateDB pop = new PopulateDB();
        DeleteDB no = new DeleteDB();
        Sales s = new Sales();
        DisplayDB dis = new DisplayDB();
        UpdateDB u = new UpdateDB();
        SearchDB sD = new SearchDB();

        UserInteraction UI = new UserInteraction();

        boolean go = true;

        while(go) {
            UI.Instructions(conn);
        }

    }

}
