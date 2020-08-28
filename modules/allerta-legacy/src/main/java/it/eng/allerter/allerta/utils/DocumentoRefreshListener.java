package it.eng.allerter.allerta.utils;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;

import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

import it.eng.allerter.allerta.AllertaBean;
import it.eng.allerter.allerta.BollettinoBean;

@Component (
	    immediate = true,
	    property = {"destination.name=allerta/messaging"},
	    service = MessageListener.class
	)
public class DocumentoRefreshListener extends BaseMessageListener {

	@Override
	protected void doReceive(Message message) throws Exception {
		String servizio = (String)message.get("servizio");
		if ("refreshAllerta".equals(servizio)) {
			Long l = (Long)message.get("parametro");
			AllertaBean ab = new AllertaBean(l, (HttpServletRequest)null);
			ab.setThreadUserPermission();
			
			ab.creaReport();
			message.setResponse("ok");
			return;
		}
		
		if ("refreshMonitoraggio".equals(servizio)) {
			Long l = (Long)message.get("parametro");
			BollettinoBean ab = new BollettinoBean(l, (HttpServletRequest)null);
			ab.setThreadUserPermission();
			
			ab.creaReport(false);
			message.setResponse("ok");
			return;
		}
		
		
		
	}

	
}
