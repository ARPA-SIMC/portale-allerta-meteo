package it.eng.allerta.animazione.portlet;

import java.io.IOException;

import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import it.eng.allerta.utils.AllertaKeys;

public class AllertaAnimazioneBasePorlet extends MVCPortlet {

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		
		ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
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
	
		super.render(renderRequest, renderResponse);
	}
}
