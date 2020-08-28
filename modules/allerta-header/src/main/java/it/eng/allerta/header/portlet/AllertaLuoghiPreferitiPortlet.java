package it.eng.allerta.header.portlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import it.eng.allerta.utils.AllertaKeys;

@Component(
	immediate = true, 
	property = { 
			"com.liferay.portlet.display-category=" + AllertaKeys.AllertaCategory,
			"com.liferay.portlet.instanceable=false", 
			"com.liferay.portlet.header-portlet-css=/css/dataTables.bootstrap4.css",
			"com.liferay.portlet.header-portlet-javascript=/js/jquery.dataTables.min.js",
			"com.liferay.portlet.footer-portlet-javascript=/js/luoghi.js",
			"javax.portlet.display-name=Luoghi Preferiti", 
			"javax.portlet.init-param.template-path=/luoghi/",
			"javax.portlet.init-param.view-template=/luoghi/view.jsp",
			"javax.portlet.name=" + AllertaKeys.AllertaLuoghiPreferitiPortlet, 
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user" 
	}, 
	service = Portlet.class
)
public class AllertaLuoghiPreferitiPortlet extends MVCPortlet {

}
