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
import it.eng.bollettino.service.BollettinoLocalServiceUtil;



@Component(
		immediate = true,
		property = {
				"javax.portlet.name=" + AllertaVerificaWebPortletKeys.ALLERTAVERIFICAWEB,
				"mvc.command.name=/allertaer/verifica/salva"
		},
		service = MVCActionCommand.class
		)
public class VerificaAllertaSalvaCommand extends BaseMVCActionCommand{

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
	
		
		boolean err = false;
		
		long allertaId = -1;
		
		HttpServletRequest r = PortalUtil.getHttpServletRequest(actionRequest);
		allertaId  =   Long.parseLong(PortalUtil.getOriginalServletRequest(r).getParameter("id"));
		long allertaId2 = allertaId;
		
		String direzione = ParamUtil.getString(actionRequest, "direzione");
		
		if ("indietro".equals(direzione)) {
			Object ooo = BollettinoLocalServiceUtil.eseguiQueryGenerica("select id_ from verifica_verifica where createdate<(select createdate from verifica_verifica where id_="
		+allertaId+") order by createdate desc limit 1");
			if (ooo!=null) allertaId2 = Long.parseLong(ooo.toString());
		}
		
		if ("avanti".equals(direzione)) {
			Object ooo = BollettinoLocalServiceUtil.eseguiQueryGenerica("select id_ from verifica_verifica where createdate>(select createdate from verifica_verifica where id_="
		+allertaId+") order by createdate asc limit 1");
			if (ooo!=null) allertaId2 = Long.parseLong(ooo.toString());
		}
		
		try {
			VerificaAllertaBean bean = new VerificaAllertaBean(allertaId, r);
			bean.salva();

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
		compilaParameters.put("id", new String[]{String.valueOf(allertaId2)});
		
		compilaURL.setParameters(compilaParameters);
		
		actionResponse.sendRedirect( compilaURL.toString());
		
	}


	
	private Log log = LogFactoryUtil.getLog(VerificaAllertaConsolidaCommand.class);
	
	
}
