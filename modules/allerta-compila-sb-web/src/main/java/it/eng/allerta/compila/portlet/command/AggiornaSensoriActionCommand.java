package it.eng.allerta.compila.portlet.command;

import java.util.HashMap;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletMode;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.WindowState;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
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
import it.eng.allerter.allerta.SensoreBean;

@Component(
	immediate = true,
	property = {
			"javax.portlet.name=" + AllertaKeys.AllertaConfigurazioneSensoriPortlet,
			"mvc.command.name=/allertaer/sensori/carica"
	},
	service = MVCActionCommand.class
)
public class AggiornaSensoriActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		SensoreBean bollettinoBean = null;
		
		boolean err = false;
		
		try {
			
			HttpServletRequest h = PortalUtil.getOriginalServletRequest( 
					PortalUtil.getHttpServletRequest(actionRequest));
			bollettinoBean = new SensoreBean(h,false);
			//bollettinoBean = (BollettinoBean) actionRequest.getPortletSession().getAttribute(AllertaKeys.RequestBollettinoBean);
			//bollettinoBean.setRequest(PortalUtil.getHttpServletRequest(actionRequest));
			//bollettinoBean.initFromRequest();
			User utente = PortalUtil.getUser(h);
			String aggiorna = bollettinoBean.aggiornaSensori(utente);
			
		}catch (Exception e) {
			
			log.error(e);
			//LogInternoLocalServiceUtil.log("bollettinoBean", "salvaBollettino", e, "");

			SessionErrors.add(actionRequest, e.getClass(), e.getMessage());
			
			err = true;
		}
		
		
		
		
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
	
	private Log log = LogFactoryUtil.getLog(AggiornaSensoriActionCommand.class);

}
