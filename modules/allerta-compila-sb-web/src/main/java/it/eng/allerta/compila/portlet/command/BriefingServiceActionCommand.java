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
import it.eng.allerter.allerta.AllertaBean;


@Component(
		immediate = true,
		property = {
				"javax.portlet.name=" + AllertaKeys.AllertaCompilaSbPortlet,
				"mvc.command.name=/allertaer/allerta/webservice"
		},
		service = MVCActionCommand.class
	)
public class BriefingServiceActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		AllertaBean avb = new AllertaBean(PortalUtil.getHttpServletRequest( actionRequest));
		String output = avb.creaDaWebService();
		if ("".equals(output)) {
			//successo
			
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			
			Long plid = PortalUtil.getPlidFromPortletId( themeDisplay.getScopeGroupId(), AllertaKeys.AllertaCompilaSbPortlet);
			
			
			PortletURL compilaURL = 
					PortletURLFactoryUtil.create(
								actionRequest, 
								AllertaKeys.AllertaCompilaSbPortlet, 
								plid, 
								PortletRequest.RENDER_PHASE);

			Map<String, String[]> compilaParameters = new HashMap<String, String[]>(0);
			compilaParameters.put("mvcRenderCommandName", new String[]{"/allertaer/allerta/compila"});
			compilaParameters.put("allertaId", new String[]{String.valueOf(avb.getallertaCorrente().getAllertaId())});

			compilaURL.setParameters(compilaParameters);

			compilaURL.setPortletMode(PortletMode.VIEW);
			//compilaURL.setWindowState(WindowState.MAXIMIZED);

			actionResponse.sendRedirect( compilaURL.toString());
			
		} else {
			SessionErrors.add(actionRequest, output);
		}
		
	}

}
