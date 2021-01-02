package lk.ijse.thogakade.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    //1st Step
    private static DBConnection dbConnection=null;
    private Connection connection;
    //2nd Step
    private DBConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ThogaKade","root","1234");
    }
    //3rd Step
    public static DBConnection getInstance() throws SQLException, ClassNotFoundException {
        //4th Step
        return (dbConnection==null)?
                (dbConnection=new DBConnection()):
                (dbConnection);
    }
    public Connection getConnection(){
        return connection;
    }
}