package it.eng.allerta.compila.portlet.command;

import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.HashMap;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletMode;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.WindowState;

import org.osgi.service.component.annotations.Component;

import it.eng.allerta.utils.AllertaKeys;
import it.eng.allerter.allerta.AllertaValangheBean;


@Component(
		immediate = true,
		property = {
				"javax.portlet.name=" + AllertaKeys.AllertaValangheCompilaSbPortlet,
				"mvc.command.name=/allertaer/allerta_valanghe/webservice"
		},
		service = MVCActionCommand.class
	)
public class MeteomontServiceActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		AllertaValangheBean avb = new AllertaValangheBean(PortalUtil.getHttpServletRequest( actionRequest));
		String output = avb.creaDaWebService();
		if ("".equals(output)) {
			//successo
			
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			
			Long plid = PortalUtil.getPlidFromPortletId( themeDisplay.getScopeGroupId(), AllertaKeys.AllertaValangheCompilaSbPortlet);
			
			
			PortletURL compilaURL = 
					PortletURLFactoryUtil.create(
								actionRequest, 
								AllertaKeys.AllertaValangheCompilaSbPortlet, 
								plid, 
								PortletRequest.RENDER_PHASE);

			Map<String, String[]> compilaParameters = new HashMap<String, String[]>(0);
			compilaParameters.put("mvcRenderCommandName", new String[]{"/allertaer/allerta_valanghe/compila"});
			compilaParameters.put("allertaValangheId", new String[]{String.valueOf(avb.getAllertaValangheCorrente().getAllertaValangheId())});

			compilaURL.setParameters(compilaParameters);

			compilaURL.setPortletMode(PortletMode.VIEW);
			//compilaURL.setWindowState(WindowState.MAXIMIZED);

			actionResponse.sendRedirect( compilaURL.toString());
			
		} else {
			SessionErrors.add(actionRequest, output);
		}
		
	}

}
