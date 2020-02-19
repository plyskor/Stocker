/**
 * 
 */
package com.preciapps.stocker.web.context;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.preciapps.stocker.spring.config.StockerSpringConfigurator;


/**
 * @author joseantoniogarciadelsaz
 *
 */
public class StockerServletContextListener implements ServletContextListener{
	private Logger logger = LoggerFactory.getLogger(StockerServletContextListener.class);
	public StockerServletContextListener(){
		super();
	}
	  @Override
	  public void contextDestroyed(ServletContextEvent arg0) {
		  logger.info("Shutting down Stocker Server Instance...");
		  ServletContext context = arg0.getServletContext();
		  
	  }

	  @Override
	  public void contextInitialized(ServletContextEvent arg0) {
		  logger.info("Starting Stocker Server Instance...");
		  AnnotationConfigApplicationContext StockerServerSpringContext = 
	                new AnnotationConfigApplicationContext(StockerSpringConfigurator.class);
		  ServletContext context = arg0.getServletContext();
		  
		  
	  }
}
