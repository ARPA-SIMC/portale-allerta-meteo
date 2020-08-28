package it.eng.allerta.configuration;

import org.osgi.service.component.annotations.Component;

import com.liferay.configuration.admin.category.ConfigurationCategory;

@Component
public class AllertaCategory implements ConfigurationCategory {

	@Override
	public String getCategoryKey() {
		// TODO Auto-generated method stub
		return _CATEGORY_KEY;
	}

	@Override
	public String getCategorySection() {
		// TODO Auto-generated method stub
		return _CATEGORY_SECTION;
	}
	
	
	private static final String _CATEGORY_KEY = "allerta-meteo";

	private static final String _CATEGORY_SECTION = "allerta-meteo";


}
