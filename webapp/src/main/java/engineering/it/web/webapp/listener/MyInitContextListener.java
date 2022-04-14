package engineering.it.web.webapp.listener;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import engineering.it.web.webapp.domain.User;

/**
 * Application Lifecycle Listener implementation class MyInitContextListener
 *
 */
public class MyInitContextListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public MyInitContextListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
        System.out.println("Usao u contextInit");
        sce.getServletContext().setAttribute("loggedInUsers", new ArrayList<User>());
    }
	
}
