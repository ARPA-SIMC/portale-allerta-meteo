package it.eng.allerta.previsioni.portlet;

import it.eng.allerta.previsioni.bean.MapModelBean;
import it.eng.allerta.utils.AllertaKeys;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author CPPNDR74H
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=" +  AllertaKeys.AllertaCategory,
		"com.liferay.portlet.use-default-template=true",
		"com.liferay.portlet.instanceable=false",
		"com.liferay.portlet.footer-portlet-javascript=/js/am.init.map-regional-and-local.js?v=1.0h",
		"com.liferay.fragment.entry.processor.portlet.alias=previsioni-home",
		"javax.portlet.display-name=Allerta Previsioni Home", 
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + AllertaKeys.AllertaPrevisioniPortlet,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class AllertaPrevisioniPortlet extends MVCPortlet {
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		MapModelBean mapModelBean = null;
		try {
			mapModelBean = new MapModelBean(themeDisplay);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Long plid = -1L;
		try {
			plid = PortalUtil.getPlidFromPortletId( themeDisplay.getScopeGroupId(), AllertaKeys.AllertaGraficoPortlet);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PortletURL pUrl =  PortletURLFactoryUtil.create(renderRequest, AllertaKeys.AllertaGraficoPortlet, plid, PortletRequest.RENDER_PHASE);
		pUrl.setParameter("mvcRenderCommandName", new String[]{"/allerta/animazione/grafico"});
		
		renderRequest.setAttribute("graficoUrl", pUrl.toString());
		
		renderRequest.setAttribute("MapModelBean", mapModelBean);
		
		super.render(renderRequest, renderResponse);

	}
	
	
}