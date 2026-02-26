package it.eng.allerta.gestione.portlet.command;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.ThemeDisplayModel;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.Date;

import it.eng.allerta.utils.AllertaKeys;
import it.eng.allerter.service.LogInternoLocalServiceUtil;
import it.eng.allerter.service.SMSLocalServiceUtil;
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
			
			User u = null;
			
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			if (themeDisplay!=null) {
				u = themeDisplay.getUser();
			}
			// now read your parameters, e.g. like this:
			// long someParameter = ParamUtil.getLong(request, "someParameter");
			

			String testo = "Spegnimento manuale mappa monitoraggio";
			String testoMail = "Si comunica lo spegnimento manuale della mappa di monitoraggio in quanto non ci sono allerte idro-geo-temporali in corso di validità presente o futura.";
				

			
			if( status.equals("true")) {
				
				testo = "Accensione manuale mappa monitoraggio";
				testoMail = "Si comunica l'accensione manuale della mappa di monitoraggio in quanto non ci sono allerte idro-geo-temporali in corso di validità presente o futura.";
				
				
				BollettinoParametro bollpar = BollettinoParametroLocalServiceUtil.fetchBollettinoParametro("GESTIONE_MONITORAGGIO");
				bollpar.setValore("true");
				BollettinoParametroLocalServiceUtil.updateBollettinoParametro(bollpar);
				
				BollettinoParametro bollpar2 = BollettinoParametroLocalServiceUtil.fetchBollettinoParametro("CONTROLLO_MONITORAGGIO");
				if (bollpar2!=null) {
					bollpar2.setValore("false");
					BollettinoParametroLocalServiceUtil.updateBollettinoParametro(bollpar2);

				}
			
				LogInternoLocalServiceUtil.log("mappaMonitoraggio", "Accensione manuale mappa", u!=null?u.getScreenName():"", "");
			} else {
				BollettinoLocalServiceUtil.terminaMonitoraggio();
				LogInternoLocalServiceUtil.log("mappaMonitoraggio", "Spegnimento manuale mappa", u!=null?u.getScreenName():"", "");
			}
			
			
			BollettinoParametro gruppo = BollettinoParametroLocalServiceUtil.fetchBollettinoParametro("GRUPPO_ACCENSIONE_MAPPA");
			if (gruppo!=null) {
				try {
					
					
					
					long ts = new Date().getTime();
					long canaleMail[] = new long[1];
					canaleMail[0] = 1;
					SMSLocalServiceUtil.creaNotificaGruppoRubrica(canaleMail, "AllerteER", testo, "automatismo", "monitoraggio", ts, 20181, gruppo.getValore(), true, null);
					SMSLocalServiceUtil.eliminaDuplicatiEmail("automatismo", "monitoraggio", ts);
					SMSLocalServiceUtil.inviaEmail("automatismo", "monitoraggio", ts,
							testo, testoMail, "no-reply@regione.emilia-romagna.it");
								} catch (Exception e) {}
					
				}
			}
		
	}

}
