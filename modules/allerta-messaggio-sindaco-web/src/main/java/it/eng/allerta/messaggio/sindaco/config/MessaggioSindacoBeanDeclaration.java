package it.eng.allerta.messaggio.sindaco.config;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.settings.definition.ConfigurationBeanDeclaration;

@Component
public class MessaggioSindacoBeanDeclaration implements ConfigurationBeanDeclaration {

	@Override
	public Class<?> getConfigurationBeanClass() {
		return MessaggioSindacoConfiguration.class;
	}

}
