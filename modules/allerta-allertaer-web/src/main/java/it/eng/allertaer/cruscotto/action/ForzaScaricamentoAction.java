package it.eng.allertaer.cruscotto.action;

import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.File;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.eng.allerta.utils.AllertaKeys;
import it.eng.allerter.service.SMSLocalServiceUtil;
import it.eng.bollettino.cron.CaricaDBTask;

@Component(
		immediate = true,
		property= {
				"javax.portlet.name=" + AllertaKeys.AllertaCruscottoPortlet,
				"mvc.command.name=/cruscotto/rt_data/forza"
		},
		service = MVCActionCommand.class
	)
public class ForzaScaricamentoAction extends BaseMVCActionCommand {
	
	//@Reference
	//CaricaDBTask caricaTask;


	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		/*User u = PortalUtil.getUser(actionRequest);
		String s = "";
		if (u!=null) s = u.getFullName();
		
		
		caricaTask.forza(s);
		
		File f = DLFileEntryLocalServiceUtil.getFile(1516510, "3.0", false, 0);
		if (f!=null)
		SMSLocalServiceUtil.inviaEmail("allerta","075/2020",76101,"ALLERTAER - Emessa Allerta 075/2020",
				"<html>\r\n" + 
				"<head></head>\r\n" + 
				"<body>\r\n" + 
				"Si invia in allegato l'Allerta 075/2020 valida dalle 00:00 del 02-10-2020 alle 00:00 del 03-10-2020:\r\n" + 
				"<br/>\r\n" + 
				"CODICE COLORE ROSSO: per vento, nelle sottozone G1,E1,C1,A1; <br/>CODICE COLORE ARANCIONE: per criticita' idrogeologica, nelle zone H,G; per criticita' per temporali, nella zona G; per vento, nelle sottozone G2,E2,B1,A2; <br/>CODICE COLORE GIALLO: per criticita' idraulica, nelle zone H,G; per criticita' idrogeologica, nelle zone E,C; per criticita' per temporali, nelle zone H,E,C; per vento, nelle sottozone H1,C2,B2; per criticita' costiera, nella sottozona D2; <br/>\r\n" + 
				"Si consiglia di consultare l'Allerta e gli scenari di riferimento e di seguire l'evolversi degli eventi sul sito: <a href=\"https://allertameteo.regione.emilia-romagna.it\">https://allertameteo.regione.emilia-romagna.it</a>\r\n" + 
				"<hr/>\r\n" + 
				"Questo messaggio e' stato inviato da un sistema automatico, si chiede cortesemente di non rispondere poiche' non verra' dato seguito alle comunicazioni ricevute. \r\n" + 
				"</body>\r\n" + 
				"</html>","no-reply@regione.emilia-romagna.it",f,"allerta075_2020.pdf");

		;*/
	}

}
