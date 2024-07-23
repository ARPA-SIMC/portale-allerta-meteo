package allerta.search.portlet;

import aQute.bnd.annotation.metatype.Meta;

@Meta.OCD(id = "allerta.search.portlet.AllertaSearchPortlet")
public interface SearchPortletConfig {
	
	@Meta.AD(required = false)
	String oggetto();

}
