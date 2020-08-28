package it.eng.allerta.compila.portlet.command;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import it.eng.allerta.utils.AllertaKeys;
import it.eng.allerter.allerta.AllertaBean;
import it.eng.allerter.service.AllertaLocalService;
import it.eng.allerter.service.LogInternoLocalServiceUtil;

@Component(
		immediate = true,
		property = {
				"javax.portlet.name=" + AllertaKeys.AllertaCompilaSbPortlet,
				"mvc.command.name=/allertaer/allerta/salva-invia"
		},
		service = MVCActionCommand.class
		)
public class SalvaInviaAllertaMVCActionCommand extends BaseMVCActionCommand{

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		AllertaBean allertaBean = null;
	
		HttpServletRequest request = PortalUtil.getOriginalServletRequest( 
				PortalUtil.getHttpServletRequest(actionRequest));

		try {
			
			allertaBean = new AllertaBean(request);
			
			allertaBean.inviaApprovazione();
			
			
		} catch (Exception e) {
			log.error(e);
			//LogInternoLocalServiceUtil.log("allertaBean", "salvaAllerta", e, "");

			SessionErrors.add(request, e.getClass(), e.getMessage());
		}
		
		actionRequest.setAttribute(AllertaKeys.RequestAllertaBean, allertaBean);
		
	}

	@Reference
	private AllertaLocalService allertaLocalService;
	
	private Log log = LogFactoryUtil.getLog(SalvaInviaAllertaMVCActionCommand.class);
	
	
}
