package edu.cit.lims.Controller;

import edu.cit.lims.Bean.User;
import edu.cit.lims.DAO.UserAccountDao;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

public class UserSignUp extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        User user=new User();
        ServletContext servletContext=getServletContext();
        String accout=request.getParameter("account");
        try{
            user.setAccount(Integer.parseInt(accout));
        }catch (Exception e){
            response.sendRedirect("/index.jsp");
        }
        user.setName(request.getParameter("nickname"));
        user.setRealname(request.getParameter("realname"));
        user.setAge(Integer.parseInt(request.getParameter("age")));
        user.setPosition(Integer.parseInt(request.getParameter("position")));
        user.setPassword(request.getParameter("password"));
        boolean isUserUp=UserAccountDao.userSignUp(user,(Connection)servletContext.getAttribute("conn"));
        if (isUserUp)servletContext.getRequestDispatcher("/WEB-INF/jsp/view/Ok.jsp");
        else servletContext.getRequestDispatcher("/WEB-INF/jsp/errorpage/ErrorPage.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        this.doPost(request,response);
    }
}
