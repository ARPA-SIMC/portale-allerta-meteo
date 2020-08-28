package it.eng.rubrica.portlet;

import it.eng.rubrica.constants.RubricaPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author GFavini
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.rubrica",
		"com.liferay.portlet.header-portlet-css=/static/css/2.fdb9d380.chunk.css",
		"com.liferay.portlet.header-portlet-css=/static/css/main.1a2880f2.chunk.css",
		
		"com.liferay.portlet.header-portlet-javascript=/static/js/2.65940d50.chunk.js",
		"com.liferay.portlet.header-portlet-javascript=/static/js/main.cfd30776.chunk.js",
		"com.liferay.portlet.footer-portlet-javascript=/static/js/pre.js",
		
		
		
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Rubrica",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + RubricaPortletKeys.RUBRICA,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class RubricaPortlet extends MVCPortlet {
}