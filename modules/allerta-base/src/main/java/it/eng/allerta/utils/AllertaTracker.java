package it.eng.allerta.utils;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

import com.liferay.osgi.util.ServiceTrackerFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.module.configuration.ConfigurationException;
import com.liferay.portal.kernel.module.configuration.ConfigurationProvider;
import com.liferay.portal.kernel.util.PortalUtil;

import it.eng.allerta.configuration.AllertaBaseConfiguration;
import it.eng.allerta.configuration.AllertaEmailConfiguration;
import it.eng.allerta.configuration.AllertaSMSConfiguration;
import it.eng.allerta.configuration.DocumentazioneConfiguration;
import it.eng.allerta.configuration.schedulers.AllertaBaseSchedulersConfiguration;

public class AllertaTracker {
	
	@SuppressWarnings("deprecation")
	public static <T> T getService(Class<T> clazz) {
		
		Bundle bundle = FrameworkUtil.getBundle(clazz);
		ServiceTracker<T, T> serviceTracker = null;
		
		if (bundle != null) {
			serviceTracker = ServiceTrackerFactory.open(bundle, clazz);
		} else {
			serviceTracker = ServiceTrackerFactory.open(clazz);
		}
		
		T service = serviceTracker.getService();
		
		serviceTracker.close();
		
		serviceTracker = null;
		
		return service;
		
	}
	
	public static AllertaBaseSchedulersConfiguration getAllertaSchedulersConfiguration() {
		
		long companyId = PortalUtil.getDefaultCompanyId();
		
		return getAllertaSchedulerConfiguration(companyId);
	}
	
	private static AllertaBaseSchedulersConfiguration getAllertaSchedulerConfiguration( long companyId){
		
		ConfigurationProvider configurationProvider = getService(ConfigurationProvider.class);
		
		try {
			
			return configurationProvider.getCompanyConfiguration(AllertaBaseSchedulersConfiguration.class, companyId);
			
		} catch (Exception e) {
			_log.error(e);
		}
		
		return null;
	}
	
	public static <T> T getConfiguration(long companyId, Class<T> clazz) {
	
		ConfigurationProvider configurationProvider = getService(ConfigurationProvider.class);
		
		try {
			
			return configurationProvider.getCompanyConfiguration(clazz, companyId);
			
		} catch (Exception e) {
			_log.error(e);
		}
		
		return null;
	
	}
	
	public static AllertaBaseConfiguration getAllertaBaseConfiguration() 
	{
		long companyId = PortalUtil.getDefaultCompanyId();
		
		return getAllertaBaseConfiguration(companyId);
		
	}
	
	public static AllertaBaseConfiguration getAllertaBaseConfiguration(long companyId)  {
		
		ConfigurationProvider configurationProvider = getService(ConfigurationProvider.class);
		
		try {
			
			return configurationProvider.getCompanyConfiguration(AllertaBaseConfiguration.class, 
					companyId);
			
		} catch (Exception e) {
			_log.error(e);
		}
		
		return null;
		
	}
	
	
	public static AllertaEmailConfiguration getAllertaEmailConfiguration() 
	{
		long companyId = PortalUtil.getDefaultCompanyId();
		
		return getAllertaEmailConfiguration(companyId);
		
	}
	
	public static AllertaEmailConfiguration getAllertaEmailConfiguration(long companyId)  {
		
		ConfigurationProvider configurationProvider = getService(ConfigurationProvider.class);
		
		try {
			
			return configurationProvider.getCompanyConfiguration(AllertaEmailConfiguration.class, 
					companyId);
			
		} catch (Exception e) {
			_log.error(e);
		}
		
		return null;
		
	}
	
	public static AllertaSMSConfiguration getAllertaSMSConfiguration() 
	{
		long companyId = PortalUtil.getDefaultCompanyId();
		
		return getAllertaSMSConfiguration(companyId);
		
	}
	
	public static AllertaSMSConfiguration getAllertaSMSConfiguration(long companyId)  {
		
		ConfigurationProvider configurationProvider = getService(ConfigurationProvider.class);
		
		try {
			
			return configurationProvider.getCompanyConfiguration(AllertaSMSConfiguration.class, 
					companyId);
			
		} catch (Exception e) {
			_log.error(e);
		}
		
		return null;
		
	}
	
	public static DocumentazioneConfiguration getDocumentazioneConfiguration() 
	{
		long companyId = PortalUtil.getDefaultCompanyId();
		
		return getDocumentazioneConfiguration(companyId);
		
	}
	
	public static DocumentazioneConfiguration getDocumentazioneConfiguration(long companyId)  {
		
		ConfigurationProvider configurationProvider = getService(ConfigurationProvider.class);
		
		try {
			
			return configurationProvider.getCompanyConfiguration(DocumentazioneConfiguration.class, 
					companyId);
			
		} catch (Exception e) {
			_log.error(e);
		}
		
		return null;
		
	}

	private static Log _log = LogFactoryUtil.getLog(AllertaTracker.class);
}
