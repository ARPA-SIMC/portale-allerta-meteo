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
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import it.eng.allerta.utils.AllertaKeys;
import it.eng.allerter.allerta.AllertaValangheBean;
import it.eng.allerter.service.AllertaValangheLocalService;

@Component(
	immediate = true,
	property = {
			"javax.portlet.name=" + AllertaKeys.AllertaValangheCompilaSbPortlet,
			"mvc.command.name=/allertaer/allerta_valanghe/salva"
	},
	service = MVCActionCommand.class
)
public class SalvaAllertaValangheMVCActionCommand extends BaseMVCActionCommand{

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {		
		AllertaValangheBean allertaValangheBean = null;		
		boolean err = false;		
		long allertaValangheId = -1;		
		HttpServletRequest r = PortalUtil.getHttpServletRequest(actionRequest);
		allertaValangheId = Long.parseLong(PortalUtil.getOriginalServletRequest(r).getParameter("allertaValangheId"));
		
		try {			
			allertaValangheBean = new AllertaValangheBean(allertaValangheId, actionRequest);			
			allertaValangheBean.salvaAllertaValanghe();
		} catch (Exception e) {			
			log.error(e);			
			err = true;
			
			//LogInternoLocalServiceUtil.log("allertaBean", "salvaAllerta", e, "");
			SessionErrors.add(actionRequest, e.getClass(), e.getMessage());
		}
		
		actionRequest.setAttribute(AllertaKeys.RequestAllertaValangheBean, allertaValangheBean);
		
		if(!err)
			SessionMessages.add(actionRequest, "saved");
		
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
		compilaParameters.put("allertaValangheId", new String[]{String.valueOf(allertaValangheBean.getAllertaValangheId())});		
		compilaURL.setParameters(compilaParameters);
		
		actionResponse.sendRedirect( compilaURL.toString());		
		//actionResponse.sendRedirect( ParamUtil.getString(actionRequest, "redirect"));
	}

	@Reference
	private AllertaValangheLocalService allertaValangheLocalService;
	
	private Log log = LogFactoryUtil.getLog(SalvaAllertaValangheMVCActionCommand.class);	
}
