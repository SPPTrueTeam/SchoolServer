package DAO;

import Entities.User;
import com.mysql.jdbc.MySQLConnection;
import com.sun.media.jfxmediaimpl.MediaDisposer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Артем on 01.05.2016.
 */
public class MySqlConnection {
    private Connection connection;
    private Statement statement;
    private String USER = "root";
    private String PASSWORD = "root";
    private String HOST = "jdbc:mysql://localhost:3306/school_db";

    public Connection getConnection(){
        if (connection != null)
            return connection;
        else
            try {
                connection = DriverManager.getConnection(HOST, USER, PASSWORD);
                return connection;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        return null;
    }

    public void closeConnection(){
        if (connection!=null)
            try {
                connection.close();
                connection = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }
}