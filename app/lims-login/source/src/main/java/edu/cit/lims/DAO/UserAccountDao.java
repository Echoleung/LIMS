package edu.cit.lims.DAO;

import edu.cit.lims.Bean.User;
import edu.cit.lims.Util.JDBCUtil;

import java.sql.*;

public class UserAccountDao {

    public static User getStatus(int account, String password, Connection connection){
        User user=null;
        PreparedStatement pStmt=null;
        ResultSet resultSet=null;
        try{
            pStmt=connection.prepareStatement("SELECT * from user_tb where user_id=? and user_password=?");
            pStmt.setInt(1,account);
            pStmt.setString(2,password);
            resultSet=pStmt.executeQuery();
            if (resultSet.next()) {
                user=new User();
                user.setAccount(account);
                user.setPassword(password);
                user.setName(resultSet.getString(3));
                user.setAge(resultSet.getInt(4));
                user.setPosition(resultSet.getInt(5));
                user.setRealname(resultSet.getString(6));
            }
        }catch (SQLException ex){
            JDBCUtil.outSQLError(ex);
        }finally {
            JDBCUtil.close(pStmt,resultSet);
        }
        return user;
    }

    public static boolean userSignUp(User user,Connection connection){
        int rst=0;
        PreparedStatement pStmt=null;
        try{
            pStmt=connection.prepareStatement("UPDATE user_tb set user_password=?,user_name=?,user_age=?,user_position=?,user_realname=? where user_id=?");
            pStmt.setInt(6,user.getAccount());
            pStmt.setString(1,user.getPassword());
            pStmt.setString(2,user.getName());
            pStmt.setInt(3,user.getAge());
            pStmt.setInt(4,user.getPosition());
            pStmt.setString(5,user.getRealname());
            rst=pStmt.executeUpdate();
        }catch (SQLException ex){
            JDBCUtil.outSQLError(ex);
        }finally {
            JDBCUtil.close(pStmt);
        }
        return rst==1;
    }
}
