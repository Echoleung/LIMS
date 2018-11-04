package edu.cit.lims.Listener;

import edu.cit.lims.Util.JDBCUtil;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class JDBCListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent event){
        ServletContext servletContext=event.getServletContext();
        servletContext.setAttribute("conn", JDBCUtil.getConnection());
    }
    public void contextDetroyed(ServletContextEvent event){

    }
}
