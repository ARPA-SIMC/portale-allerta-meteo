package it.eng.allerta.animazione.portlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import it.eng.allerta.utils.AllertaKeys;

@Component(
	immediate = true,
	property = {
			"com.liferay.portlet.display-category=" +  AllertaKeys.AllertaCategory,
			"com.liferay.portlet.use-default-template=true",
			"com.liferay.portlet.instanceable=false",
			"com.liferay.portlet.footer-portlet-javascript=/js/am.init.map-with-data.js?v=0.3",
			"javax.portlet.expiration-cache=0",
			"javax.portlet.display-name=Animazione Vento", 
			"javax.portlet.init-param.template-path=/",
			"javax.portlet.init-param.view-template=/animvento.jsp",
			"javax.portlet.name=" + AllertaKeys.AllertaAnimazioneVentoPortlet,
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class AllertaAnimazioneVentoPortlet extends AllertaAnimazioneBasePorlet {

}
