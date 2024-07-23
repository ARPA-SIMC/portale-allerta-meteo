package it.eng.allerta.compila.portlet.command;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.PortalUtil;

import it.eng.allerta.utils.AllertaKeys;
import it.eng.allerter.allerta.AllertaValangheBean;
import it.eng.allerter.service.AllertaValangheLocalService;

@Component(
	immediate = true,
	property = {
			"javax.portlet.name=" + AllertaKeys.AllertaValangheCompilaSbPortlet,
			"mvc.command.name=/allertaer/allerta_valanghe/salva-invia"
	},
	service = MVCActionCommand.class
)
public class SalvaInviaAllertaValangheMVCActionCommand extends BaseMVCActionCommand{

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {		
		AllertaValangheBean allertaValangheBean = null;	
		HttpServletRequest request = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(actionRequest));

		try {			
			allertaValangheBean = new AllertaValangheBean(request);
			
			allertaValangheBean.inviaApprovazione();			
		} catch (Exception e) {
			log.error(e);
			
			//LogInternoLocalServiceUtil.log("allertaBean", "salvaAllerta", e, "");
			SessionErrors.add(request, e.getClass(), e.getMessage());
		}
		
		actionRequest.setAttribute(AllertaKeys.RequestAllertaValangheBean, allertaValangheBean);		
	}

	@Reference
	private AllertaValangheLocalService allertaValangheLocalService;
	
	private Log log = LogFactoryUtil.getLog(SalvaInviaAllertaValangheMVCActionCommand.class);	
}
