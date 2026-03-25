package KT.until;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtility {
    private static final String URL="jdbc:mysql://localhost:3306/ktss14";
    private static final String NAME="root";
    private static final String PASSWORD="123456$";

    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(URL,NAME,PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
