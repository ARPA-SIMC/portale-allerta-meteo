package it.eng.allerta.gestione.portlet.command;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import it.eng.allerta.utils.AllertaKeys;
import it.eng.bollettino.model.BollettinoParametro;
import it.eng.bollettino.service.BollettinoLocalServiceUtil;
import it.eng.bollettino.service.BollettinoParametroLocalServiceUtil;

@Component(
		immediate = true,
		property = {
				"javax.portlet.name=" + AllertaKeys.AllertaGestioneMonitoraggioPortlet,
				"mvc.command.name=/allertaer/gestione-monitoraggio/salva"
		},
		service = MVCActionCommand.class
	)
public class SalvaGestioneMonitoraggioAction extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		String status = ParamUtil.getString(actionRequest, "monitoraggioAttivo", null);
		
		if( Validator.isNotNull(status)) {
			
			if( status.equals("true")) {
				
				BollettinoParametro bollpar = BollettinoParametroLocalServiceUtil.fetchBollettinoParametro("GESTIONE_MONITORAGGIO");
				bollpar.setValore("true");
				BollettinoParametroLocalServiceUtil.updateBollettinoParametro(bollpar);
			} else {
				BollettinoLocalServiceUtil.terminaMonitoraggio();
			}
		}
		
	}

}
