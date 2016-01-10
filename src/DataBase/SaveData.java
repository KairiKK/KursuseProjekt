package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Kairi on 31.12.2015.
 *
 *
 *  https://github.com/KristerV/javaHarjutused/
 */

public class SaveData {

    Connection conn;

    public SaveData() {
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:login2.db");
            System.out.println("Andmebaas on ühendatud");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLClientInfoException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void closeSQL() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
    }

    public static void saveChoice(String FeedTitle, ArrayList buffer) {
    }

}