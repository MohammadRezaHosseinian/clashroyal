package code.dbms;

/*
 **
 * in this class connect to data base
 **
 */

import java.sql.*;


public class Db {
    private Connection connection;
    private static Db instance = null;

    private Db() throws SQLException {
        String CONNECTION_STRING = "jdbc:sqlite:mydb.db";
        this.connection = DriverManager.getConnection(CONNECTION_STRING);
    }

    public Connection getConnection(){
        return this.connection;
    }

    public static Connection getSingleConnection(){
        if(instance == null){
            try {
                instance = new Db();
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        }
        return instance.getConnection();

    }
}
