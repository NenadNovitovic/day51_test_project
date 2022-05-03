package engineering.it.web.webapp.listener;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import engineering.it.web.webapp.config.MyAppConfiguration;
import engineering.it.web.webapp.domain.Mesto;
import engineering.it.web.webapp.domain.Proizvodjac;
import engineering.it.web.webapp.domain.User;
import engineering.it.web.webapp.persistence.MyEntityManagerFactory;

/**
 * Application Lifecycle Listener implementation class MyInitContextListener
 *
 */
@Component
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
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyAppConfiguration.class);
        sce.getServletContext().setAttribute("app-context", applicationContext);
       // AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
        
        //sce.getServletContext().setAttribute("app-context",applicationContext);
        //System.out.println("Napravio i dodao app-context" + applicationContext.toString());
       // System.out.println(applicationContext.getBean("jdbcTemplate"));
        
        sce.getServletContext().setAttribute("loggedInUsers", new ArrayList<User>());
        
        
    }
	
}
