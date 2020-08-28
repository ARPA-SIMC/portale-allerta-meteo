package it.eng.allerter.activator;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class AllertaBundleActivatorService implements BundleActivator {
	
	private static Log logger = LogFactoryUtil.getLog(AllertaBundleActivatorService.class);

	@Override
	public void start(BundleContext context) throws Exception {
		logger.info("start AllertaBundleActivatorService begin");
		logger.info("lo stato del bundle " + context.getBundle().getSymbolicName() + " è " + context.getBundle().getState());
		logger.info("start AllertaBundleActivatorService end");
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		logger.info("stop AllertaBundleActivatorService begin");
		logger.info("lo stato del bundle " + context.getBundle().getSymbolicName() + " è " + context.getBundle().getState());
		logger.info("stop AllertaBundleActivatorService end");
	}

}
