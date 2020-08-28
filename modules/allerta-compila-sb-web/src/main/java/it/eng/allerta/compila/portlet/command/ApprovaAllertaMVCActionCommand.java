package it.eng.allerta.compila.portlet.command;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import it.eng.allerta.utils.AllertaKeys;
import it.eng.allerter.allerta.AllertaBean;
import it.eng.allerter.service.AllertaLocalService;


@Component(
	immediate = true,
	property = {
			"javax.portlet.name=" + AllertaKeys.AllertaCompilaSbPortlet,
			"mvc.command.name=/allertaer/allerta/approva"
	},
	service = MVCActionCommand.class
)
public class ApprovaAllertaMVCActionCommand extends BaseMVCActionCommand{

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		long allertaId = ParamUtil.getLong(actionRequest, "allertaId");
		
		AllertaBean bean = new AllertaBean(allertaId, actionRequest);
		
		//bean.approve();
		
	}
	
	@Reference
	private AllertaLocalService allertaLocalService;

}
