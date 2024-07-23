package it.eng.allerta.gestione.portlet.command;

import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.HashMap;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import org.osgi.service.component.annotations.Component;

import it.eng.allerta.utils.AllertaKeys;

@Component(
		immediate = true,
		property = {
				"javax.portlet.name=" + AllertaKeys.AllertaConfigurazioneSensoriPortlet,
				"mvc.command.name=/allertaer/sensori/tuoi-comuni"
		},
		service = MVCActionCommand.class
	)
public class ToggleTuoiComuniAction extends BaseMVCActionCommand {
	
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
	
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		Long plid = PortalUtil.getPlidFromPortletId( themeDisplay.getScopeGroupId(), AllertaKeys.AllertaConfigurazioneSensoriPortlet);
		
		PortletURL compilaURL = 
				PortletURLFactoryUtil.create(
					actionRequest, 
				AllertaKeys.AllertaConfigurazioneSensoriPortlet, 
				plid, 
				PortletRequest.RENDER_PHASE);

		Map<String, String[]> compilaParameters = new HashMap<String, String[]>(0);
		compilaParameters.put("solotuoicomuni", new String[]{""+ParamUtil.getBoolean(actionRequest, "solotuoicomuni")});

		compilaURL.setParameters(compilaParameters);

		actionResponse.sendRedirect( compilaURL.toString());
	}

}
