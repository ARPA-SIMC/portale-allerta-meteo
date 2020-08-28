package it.eng.allerta.messages.services.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PortalLifecycle;
import com.liferay.portal.kernel.util.PortalLifecycleUtil;


/**
 * DELETE CLASS
 * @author EFabiani
 *
 */
public class AllerteListener /*implements ServletContextListener, PortalLifecycle*/ {
	/*
	private static Log logger = LogFactoryUtil.getLog(AllerteListener.class);	
	
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		logger.info("AllerteListener - contextInitialized start");
		// wait until the portal is ready
        PortalLifecycleUtil.register(this, PortalLifecycle.METHOD_ALL);
        
        logger.info("AllerteListener - contextInitialized end");
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		logger.info("AllerteListener - contextDestroyed start");
		
		PortalLifecycleUtil.register(this, PortalLifecycle.METHOD_DESTROY);
		 
		logger.info("AllerteListener - contextDestroyed end");
	}

	@Override
	public void portalInit() {
		logger.info("PortalInit start");
		
		try {
			//SmsSchedulerContextUtility.doPortalInitInExclusiveMode();
			logger.info("PortalInit terminato con successo");
			
		} catch (Throwable e) {						
			logger.error("PortalInit terminato con fallimento",  e);
		}
		
		logger.info("PortalInit end");
	}
	
	@Override
	public void portalDestroy() {
		logger.info("PortalDestroy start");
		
		try {			
			//SmsSchedulerContextUtility.doPortalDestroyInExclusiveMode();
			logger.info("PortalDestroy terminato con successo");						
		} catch (Throwable e) {			
			logger.error("PortalDestroy terminato con fallimento",  e);
		}		
		
		logger.info("PortalDestroy end");
	}
	*/
}

