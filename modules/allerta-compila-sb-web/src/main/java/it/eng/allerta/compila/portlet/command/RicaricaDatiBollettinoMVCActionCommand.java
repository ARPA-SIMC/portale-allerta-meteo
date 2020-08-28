package it.eng.allerta.compila.portlet.command;

import java.util.HashMap;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletMode;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.WindowState;

import org.osgi.service.component.annotations.Component;

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

import it.eng.allerta.utils.AllertaKeys;
import it.eng.allerter.allerta.BollettinoBean;
import it.eng.allerter.service.LogInternoLocalServiceUtil;

@Component(
	immediate = true,
	property = {
			"javax.portlet.name=" + AllertaKeys.AllertaCompilaMonitoraggioPortlet,
			"mvc.command.name=/allertaer/monitoraggio/ricarica"
	},
	service = MVCActionCommand.class
)
public class RicaricaDatiBollettinoMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		BollettinoBean bollettinoBean = null;
		
		boolean err = false;
		
		try {
			
			long bollettinoId = ParamUtil.getLong(actionRequest, "bollettinoId");
			
			bollettinoBean = new BollettinoBean(bollettinoId, PortalUtil.getHttpServletRequest( actionRequest) );
			//bollettinoBean = (BollettinoBean) actionRequest.getPortletSession().getAttribute(AllertaKeys.RequestBollettinoBean);
			//bollettinoBean.setRequest(PortalUtil.getHttpServletRequest(actionRequest));
			//bollettinoBean.initFromRequest();
			bollettinoBean.creaRep = false;
			bollettinoBean.salvaBollettino(true);
			bollettinoBean.creaRep = true;
			bollettinoBean.ricaricaLivelliOsservati(bollettinoId);
			
		}catch (Exception e) {
			
			log.error(e);
			//LogInternoLocalServiceUtil.log("bollettinoBean", "salvaBollettino", e, "");

			SessionErrors.add(actionRequest, e.getClass(), e.getMessage());
			
			err = true;
		}
		
		actionRequest.getPortletSession().setAttribute(AllertaKeys.RequestBollettinoBean, bollettinoBean);
		
		if(!err)
			SessionMessages.add(actionRequest, "saved");
		
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		Long plid = PortalUtil.getPlidFromPortletId( themeDisplay.getScopeGroupId(), AllertaKeys.AllertaCompilaMonitoraggioPortlet);
		
		PortletURL compilaURL = 
							PortletURLFactoryUtil.create(
										actionRequest, 
										AllertaKeys.AllertaCompilaMonitoraggioPortlet, 
										plid, 
										PortletRequest.RENDER_PHASE);
		
		Map<String, String[]> compilaParameters = new HashMap<String, String[]>(0);
		compilaParameters.put("mvcRenderCommandName", new String[]{"/allertaer/monitoraggio/compila"});
		compilaParameters.put("bollettinoId", new String[]{String.valueOf(bollettinoBean.getBollettinoId())});
		compilaParameters.put("ignoreSensors", new String[]{"true"});

		compilaURL.setParameters(compilaParameters);
		
		compilaURL.setPortletMode(PortletMode.VIEW);
		compilaURL.setWindowState(WindowState.MAXIMIZED);
		
		actionResponse.sendRedirect( compilaURL.toString());
		
		
		/*
		PortletURL redirect = PortletURLFactoryUtil.create(
					PortalUtil.getHttpServletRequest(actionRequest), AllertaKeys.AllertaCompilaMonitoraggioPortlet,
					themeDisplay.getLayout().getPlid(), PortletRequest.RENDER_PHASE
				);

		redirect.setPortletMode(PortletMode.VIEW);
		redirect.setWindowState(WindowState.NORMAL);
		
		
		actionResponse.sendRedirect(redirect.toString());
		*/

	}
	
	private Log log = LogFactoryUtil.getLog(SalvaBollettinoMVCActionCommand.class);

}
