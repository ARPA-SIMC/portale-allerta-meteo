package it.eng.allerta.compila.portlet.command;

import java.util.HashMap;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.xmlrpc.Success;

import it.eng.allerta.utils.AllertaKeys;
import it.eng.allerter.allerta.AllertaBean;
import it.eng.allerter.service.AllertaLocalService;
import it.eng.allerter.service.LogInternoLocalServiceUtil;

@Component(
		immediate = true,
		property = {
				"javax.portlet.name=" + AllertaKeys.AllertaCompilaSbPortlet,
				"mvc.command.name=/allertaer/allerta/salva-sintesi"
		},
		service = MVCActionCommand.class
		)
public class SalvaAllertaSintesiMVCActionCommand extends BaseMVCActionCommand{

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		AllertaBean allertaBean = null;
		
		boolean err = false;
		
		long allertaId = -1;
		
		HttpServletRequest r = PortalUtil.getHttpServletRequest(actionRequest);
		allertaId  =   Long.parseLong(PortalUtil.getOriginalServletRequest(r).getParameter("allertaId"));
		
		try {
			
			allertaBean = new AllertaBean(allertaId, actionRequest);
			
			allertaBean.salvaSintesi();

		} catch (Exception e) {
			
			log.error(e);
			
			err = true;
			
			//LogInternoLocalServiceUtil.log("allertaBean", "salvaAllerta", e, "");

			SessionErrors.add(actionRequest, e.getClass(), e.getMessage());
		}
		
		actionRequest.setAttribute(AllertaKeys.RequestAllertaBean, allertaBean);
		
		if(!err)
			SessionMessages.add(actionRequest, "saved");
		
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
		compilaParameters.put("allertaId", new String[]{String.valueOf(allertaBean.getAllertaId())});
		compilaParameters.put("sintesi", new String[]{"true"});

		compilaURL.setParameters(compilaParameters);
		
		actionResponse.sendRedirect( compilaURL.toString());
		
		//actionResponse.sendRedirect( ParamUtil.getString(actionRequest, "redirect"));
	}

	@Reference
	private AllertaLocalService allertaLocalService;
	
	private Log log = LogFactoryUtil.getLog(SalvaAllertaMVCActionCommand.class);
	
	
}
