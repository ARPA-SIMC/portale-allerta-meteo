package it.eng.allerta.animazione.portlet;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.WindowState;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import it.eng.allerta.animazione.bean.RadarBean;
import it.eng.allerta.utils.AllertaKeys;

@Component(
		immediate = true,
		property = {
				"com.liferay.portlet.display-category=" +  AllertaKeys.AllertaCategory,
				"com.liferay.portlet.use-default-template=true",
				"com.liferay.portlet.instanceable=false",
				"com.liferay.portlet.footer-portlet-javascript=/js/am.init.map-with-data.js?v=0.3",
				"javax.portlet.expiration-cache=0",
				"javax.portlet.display-name=Animazione Pressione", 
				"javax.portlet.init-param.template-path=/",
				"javax.portlet.init-param.view-template=/animpressione.jsp",
				"javax.portlet.name=" + AllertaKeys.AllertaAnimazionePressionePortlet,
				"javax.portlet.resource-bundle=content.Language",
				"javax.portlet.security-role-ref=power-user,user"
		},
		service = Portlet.class
	)
public class AllertaAnimazionePressionePortlet extends AllertaAnimazioneBasePorlet {
	

}
