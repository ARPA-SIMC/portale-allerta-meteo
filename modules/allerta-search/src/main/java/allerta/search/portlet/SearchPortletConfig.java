package allerta.search.portlet;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

import aQute.bnd.annotation.metatype.Meta;


@ExtendedObjectClassDefinition(
		category = "category.sample",
		scope = ExtendedObjectClassDefinition.Scope.PORTLET_INSTANCE
	)
@Meta.OCD(id = "allerta.search.portlet.SearchPortletConfig",
name="AllertaSearchPortlet")
public interface SearchPortletConfig {
	
	@Meta.AD(required = false)
	String oggetto();

}
