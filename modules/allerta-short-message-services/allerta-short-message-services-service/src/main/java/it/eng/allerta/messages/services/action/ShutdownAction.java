package it.eng.allerta.messages.services.action;

import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.events.LifecycleAction;
import com.liferay.portal.kernel.events.SimpleAction;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import org.osgi.service.component.annotations.Component;

@Component(
	immediate = true,
	property = {"key=application.shutdown.events"},
	service = LifecycleAction.class
)
public class ShutdownAction extends SimpleAction {
	
	private static Log logger = LogFactoryUtil.getLog(ShutdownAction.class);
	private static boolean shutdown = false;
	
	//@Reference(cardinality = ReferenceCardinality.MANDATORY)
	//private SmsSchedulerContextUtility smsSchedulerContextUtility;

	@Override
	public void run(String[] ids) throws ActionException {
		logger.info("begin Shutdown");
		
		shutdown = true;
		
		logger.info("end Shutdown");
	}
	
	public static synchronized boolean isServerShutdown() {
		return shutdown;
	}
}
