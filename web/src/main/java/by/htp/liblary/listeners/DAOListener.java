package by.htp.liblary.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

import by.htp.liblary.dao.HibernateSessionManager;
import by.htp.liblary.dao.connection_pool.ConnectionPool;
import by.htp.liblary.dao.connection_pool.ConnectionPoolException;
import org.hibernate.Session;

/**
 * Application Lifecycle Listener implementation class DAOListener
 *
 */
public class DAOListener implements ServletContextListener {
	//private static final Logger LOG=LogManager.getLogger("by.htp.liblary.listeners");


	/**
	 * Default constructor.
	 */
	public DAOListener() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent arg0) {

		HibernateSessionManager.shutdown();
		// TODO Auto-generated method stub
	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent arg0) {
		 HibernateSessionManager.getSessionFactory().openSession();
		// TODO Auto-generated method stub
		
	}

}
