package it.eng.allerta.gestione.portlet.command;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import it.eng.allerta.utils.AllertaKeys;
import it.eng.allerter.allerta.ListaStazioniAttiveBean;
import it.eng.allerter.allerta.ListaStazioniAttiveBean.StazioneManager;
import it.eng.bollettino.service.StazioneLocalServiceUtil;

@Component(
		immediate = true,
		property = {
				"javax.portlet.name=" + AllertaKeys.AllertaPreferenzeMonitoraggioPortlet,
				"mvc.command.name=/allertaer/preferenze-monitoraggio/salva"
		},
		service = MVCActionCommand.class
	)
public class SalvaPreferenzeMonitoraggioAction extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		ListaStazioniAttiveBean stazioni = new ListaStazioniAttiveBean();
		
		for (StazioneManager stazione : stazioni.getStazioni()) {
			
			String s = ParamUtil.getString(actionRequest, "stazionesel_" + stazione.getStazione().getId(), null);
			
			if( Validator.isNotNull(s))
				stazione.getStazione().setIncluso(true);
			else 
				stazione.getStazione().setIncluso(false);
			
			try {
				StazioneLocalServiceUtil.updateStazione(stazione.getStazione());
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			
		}
		
	}

}
