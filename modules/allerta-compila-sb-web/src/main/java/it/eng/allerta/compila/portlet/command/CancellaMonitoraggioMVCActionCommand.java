package it.eng.allerta.compila.portlet.command;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import it.eng.allerta.utils.AllertaKeys;
import it.eng.allerter.service.AllertaLocalService;
import it.eng.bollettino.service.BollettinoLocalService;

@Component(
		immediate = true,
		property = {
				"javax.portlet.name=" + AllertaKeys.AllertaCompilaMonitoraggioPortlet,
				"mvc.command.name=/allertaer/monitoraggio/delete"
		},
		service = MVCActionCommand.class
	)
public class CancellaMonitoraggioMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		long bollettinoId = ParamUtil.getLong(actionRequest, "bollettinoId");
		
		monitoraggioLocalService.deleteBollettino(bollettinoId);
	}
	
	@Reference
	private BollettinoLocalService monitoraggioLocalService;

}
