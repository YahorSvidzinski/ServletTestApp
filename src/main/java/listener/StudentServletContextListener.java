package listener;


import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.File;
import org.apache.log4j.PropertyConfigurator;


public class StudentServletContextListener implements ServletContextListener {

	private static final String LOG_4_J_CONFIG_LOCATION = "log4j-config-location";

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		ServletContext context = servletContextEvent.getServletContext();
		String log4jConfigFile = context.getInitParameter(LOG_4_J_CONFIG_LOCATION);
		String fullPath = context.getRealPath("") + File.separator + log4jConfigFile;
		PropertyConfigurator.configure(fullPath);
	}

	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		//no actions
	}
}
