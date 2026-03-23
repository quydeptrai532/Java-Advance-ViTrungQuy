package Ex06.util;

import java.sql.*;

public class DBUtility {
    private static final String URL="jdbc:mysql://localhost:3306/rikkei_hospital";
    private static final String USERNAME="root";
    private static final String PASSWORD="123456$";

    public static Connection getConnection(){
        try {
           return DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void closeAll(Connection conn, Statement stmt, ResultSet rs){
        try {
            if(rs!=null){
                rs.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            if(stmt!=null){
                stmt.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            if(conn!=null){
                conn.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
