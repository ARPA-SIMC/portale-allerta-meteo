package it.eng.allerta.utils;

import com.liferay.portal.kernel.messaging.Destination;
import com.liferay.portal.kernel.messaging.DestinationConfiguration;
import com.liferay.portal.kernel.messaging.DestinationFactory;
import com.liferay.portal.kernel.messaging.DestinationFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.util.HashMapDictionary;

import java.util.Collection;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * Componente che registra una destinazione per i messaggi interni tra i componenti del portale.
 * Questi sono messaggi SINCRONI, che si bloccano fino alla ricezione
 * @author GFavini
 *
 */
@Component(
		  immediate = true, 			  
		  service = AllertaMessageBusDestination.class
		)
public class AllertaMessageBusDestination {
	
	public static final String ALLERTA_BUS_DESTINATION_NAME = "allerta/messaging";
	
	@Activate 
	protected void activate(BundleContext bundleContext, Map<String, Object> properties) {
		//if (MessageBusUtil.getDestination(ALLERTA_BUS_DESTINATION_NAME)==null) {
			DestinationConfiguration dc = DestinationConfiguration.createSynchronousDestinationConfiguration(ALLERTA_BUS_DESTINATION_NAME);
			//Destination d = DestinationFactoryUtil.createDestination(dc);
			Destination d = _destinationFactory.createDestination(dc); 
			
			Dictionary<String, Object> props = new HashMapDictionary<>();
	        props.put("destination.name", d.getName());
			
			bundleContext.registerService(Destination.class,d,props);
		//}
	}
	
	@Reference
	DestinationFactory _destinationFactory;
	
}
