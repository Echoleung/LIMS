package edu.cit.lims.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;

public class JDBCUtil{
    private final static String DRIVER="com.mysql.cj.jdbc.Driver";
    private final static String URL="jdbc:mysql://localhost:3306/lims_db?useSSL=false&user=root&password=000000&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    public static Connection getConnection(){
        Connection conn=null;
        try{
            Class.forName(DRIVER);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        try{
            conn=DriverManager.getConnection(URL);
        }catch (SQLException ex){
            outSQLError(ex);
        }

        return conn;
    }

    public static void close(PreparedStatement pstmt){
        try {
            if (pstmt!=null)
                pstmt.close();
        }catch (SQLException ex){
            outSQLError(ex);
        }
    }

    public static void close(PreparedStatement pstmt,ResultSet rs){
        close(pstmt);
        try{
            if(rs!=null)rs.close();
        }catch (SQLException ex){
            outSQLError(ex);
        }
    }

    public static void outSQLError(SQLException ex){
        System.out.println("SQLException:"+ex.getMessage());
        System.out.println("SQLState:"+ex.getSQLState());
        System.out.println("VendorError:"+ex.getErrorCode());
    }

}
