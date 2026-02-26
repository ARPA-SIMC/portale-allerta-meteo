package it.eng.allerta.controlpanel.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

import it.eng.allerta.controlpanel.constants.AllertaControlPanelPortletKeys;
import it.eng.allerter.service.LogInternoLocalServiceUtil;
import it.eng.bollettino.model.BollettinoParametro;
import it.eng.bollettino.service.BollettinoParametroLocalServiceUtil;

@Component(
		immediate = true,
		property = {
				"javax.portlet.name=" + AllertaControlPanelPortletKeys.ALLERTACONTROLPANEL,
				"mvc.command.name=/controlpanel/bp/update"
		},
		service = MVCActionCommand.class
		)
public class ControlPanelUpdateBPAction extends BaseMVCActionCommand{

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
	
		
		boolean err = false;
		
		String id = "";
		
		HttpServletRequest r = PortalUtil.getHttpServletRequest(actionRequest);
		id  =   PortalUtil.getOriginalServletRequest(r).getParameter("id");
		try {
			HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest( 
					r); 
			String valore = ParamUtil.getString(httpRequest, "bp_" + id);
			if (valore==null) {
				SessionErrors.add(actionRequest, "Errore", "Parametro "+id+" non trovato.");
				return;
			}
			BollettinoParametro ap = BollettinoParametroLocalServiceUtil.fetchBollettinoParametro(id);
			if (ap==null) {
				SessionErrors.add(actionRequest, "Errore", "Parametro "+id+" non esiste.");
				return;
			}
			ap.setValore(valore);
			BollettinoParametroLocalServiceUtil.updateBollettinoParametro(ap);

		} catch (Exception e) {
			
			
			err = true;
			
			LogInternoLocalServiceUtil.log("control panel", "ControlPanelUpdateBPAction", e, "");

		}
		
		
		if(!err)
			SessionMessages.add(actionRequest, "saved");
		
		/*ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		Long plid = PortalUtil.getPlidFromPortletId( themeDisplay.getScopeGroupId(), AllertaControlPanelPortletKeys.ALLERTACONTROLPANEL);
		
		PortletURL compilaURL = 
							PortletURLFactoryUtil.create(
										actionRequest, 
										AllertaControlPanelPortletKeys.ALLERTACONTROLPANEL, 
										plid, 
										PortletRequest.RENDER_PHASE);
		
		Map<String, String[]> compilaParameters = new HashMap<String, String[]>(0);
		compilaParameters.put("mvcRenderCommandName", new String[]{"/allertaer/catasto/compila"});
		compilaParameters.put("id", new String[]{String.valueOf(bean.getId())});
		
		compilaURL.setParameters(compilaParameters);
		
		actionResponse.sendRedirect( compilaURL.toString());
		*/
	}


	
	
	
}