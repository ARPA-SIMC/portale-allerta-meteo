package it.eng.allerta.compila.portlet.command;

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
				"mvc.command.name=/allertaer/monitoraggio/salva-invia"
		},
		service = MVCActionCommand.class
	)
public class SalvaInviaBollettinoMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		BollettinoBean bollettinoBean = null;
		
		try {
			
			long bollettinoId = ParamUtil.getLong(actionRequest, "bollettinoId");
			
			bollettinoBean = new BollettinoBean(bollettinoId, PortalUtil.getHttpServletRequest( actionRequest) );
			bollettinoBean.inviaApprovazione();
			
		}catch (Exception e) {
			
			log.error(e);
			
			//LogInternoLocalServiceUtil.log("bollettinoBean", "salvaInviaBollettino", e, "");

			SessionErrors.add(actionRequest, e.getClass(), e.getMessage());
		}
		
		actionRequest.getPortletSession().setAttribute(AllertaKeys.RequestBollettinoBean, bollettinoBean);
		
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		PortletURL redirect = PortletURLFactoryUtil.create(
					PortalUtil.getHttpServletRequest(actionRequest), AllertaKeys.AllertaCompilaMonitoraggioPortlet,
					themeDisplay.getLayout().getPlid(), PortletRequest.RENDER_PHASE
				);

		redirect.setPortletMode(PortletMode.VIEW);
		redirect.setWindowState(WindowState.NORMAL);
		actionResponse.sendRedirect(redirect.toString());
	}
	
	private Log log = LogFactoryUtil.getLog(SalvaInviaBollettinoMVCActionCommand.class);

}
