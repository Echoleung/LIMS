package edu.cit.lims.Controller;

import edu.cit.lims.Bean.User;
import edu.cit.lims.DAO.UserAccountDao;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;

import static java.lang.Integer.parseInt;

/*annotation
@WebServlet(
        name = "UserSignIn",
        urlPatterns = {"/Signin"},
        loadOnStartup=1
)
this annotation can replace the Servlet descriptor in web.xml
*/
public class UserSignIn extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        int status=-1;
        ServletContext servletContext=getServletContext();
        int account=Integer.parseInt(request.getParameter("account"));
        String password=request.getParameter("password");
        User user = UserAccountDao.getStatus(account,password,(Connection)getServletContext().getAttribute("conn"));
        request.setAttribute("user",user);
        if (user==null)status=-1;
        else if (user.getPosition()==-1)status=0;
        else status=1;
        switch (status){
            case -1:servletContext.getRequestDispatcher("/WEB-INF/jsp//errorpage/ErrorPage.jsp").forward(request,response);
                break;//query failed
            case 0:
                HttpSession session=request.getSession();
                if (session.getAttribute("account")==null)
                    session.setAttribute("cart",user);
                servletContext.getRequestDispatcher("/WEB-INF/jsp/view/SignUp.jsp").forward(request,response);
                break;//need sign up
            case 1:servletContext.getRequestDispatcher("/WEB-INF/jsp/view/Ok.jsp");
                break;//login successed
        }
    }
    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        this.doPost(request,response);
    }
}
