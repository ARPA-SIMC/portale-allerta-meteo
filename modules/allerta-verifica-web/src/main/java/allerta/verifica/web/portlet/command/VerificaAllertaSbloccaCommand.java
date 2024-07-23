package allerta.verifica.web.portlet.command;

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

import java.util.HashMap;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

import allerta.verifica.model.Verifica;
import allerta.verifica.service.VerificaLocalServiceUtil;
import allerta.verifica.web.bean.VerificaAllertaBean;
import allerta.verifica.web.constants.AllertaVerificaWebPortletKeys;
import it.eng.allerter.service.LogInternoLocalServiceUtil;



@Component(
		immediate = true,
		property = {
				"javax.portlet.name=" + AllertaVerificaWebPortletKeys.ALLERTAVERIFICAWEB,
				"mvc.command.name=/allertaer/verifica/sblocca"
		},
		service = MVCActionCommand.class
		)
public class VerificaAllertaSbloccaCommand extends BaseMVCActionCommand{

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		VerificaAllertaBean allertaBean = null;
		
		boolean err = false;
		
		
		LogInternoLocalServiceUtil.log("sbloccaVerifica","sbloccaVerifica","0","");
		
		long allertaId = ParamUtil.getLong(actionRequest, "id");

		try {
			
			Verifica v = VerificaLocalServiceUtil.fetchVerifica(allertaId);
			if (v!=null) {
				v.setStato(0);
				VerificaLocalServiceUtil.updateVerifica(v);
			}

		} catch (Exception e) {
			
			log.error(e);
			
			err = true;
			
			//LogInternoLocalServiceUtil.log("allertaBean", "salvaAllerta", e, "");

			SessionErrors.add(actionRequest, e.getClass(), e.getMessage());
		}
		
		
		if(!err)
			SessionMessages.add(actionRequest, "saved");
		
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		Long plid = PortalUtil.getPlidFromPortletId( themeDisplay.getScopeGroupId(), AllertaVerificaWebPortletKeys.ALLERTAVERIFICAWEB);
		
		PortletURL compilaURL = 
							PortletURLFactoryUtil.create(
										actionRequest, 
										AllertaVerificaWebPortletKeys.ALLERTAVERIFICAWEB, 
										plid, 
										PortletRequest.RENDER_PHASE);
		
		Map<String, String[]> compilaParameters = new HashMap<String, String[]>(0);
		compilaParameters.put("mvcRenderCommandName", new String[]{"/allertaer/verifica/compila"});
		compilaParameters.put("id", new String[]{String.valueOf(allertaId)});
		
		compilaURL.setParameters(compilaParameters);
		
		actionResponse.sendRedirect( compilaURL.toString());
		
	}


	
	private Log log = LogFactoryUtil.getLog(VerificaAllertaConsolidaCommand.class);
	
	
}

