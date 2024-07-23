package it.eng.allertaer.allertebollettini.portlet;

import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.eng.allerta.utils.AllertaKeys;
import it.eng.allertaer.cruscotto.action.ForzaScaricamentoAction;
import it.eng.allerter.service.LogInternoLocalService;
import it.eng.allerter.service.SMSLocalServiceUtil;
import it.eng.bollettino.cron.CaricaDBTask;
import it.eng.bollettino.cron.RisultatiAggiornamento;
import it.eng.bollettino.service.StazioneLocalService;
import it.eng.bollettino.service.StazioneVariabileLocalService;
import it.eng.bollettino.service.ValoreSensoreLocalService;
import it.eng.bollettino.service.VariabileLocalService;

@Component(
		immediate = true,
		
		property = {
			"com.liferay.portlet.display-category=" + AllertaKeys.AllertaCategory,
			"com.liferay.portlet.instanceable=false",
			"javax.portlet.init-param.add-process-action-success-action=false",
			"javax.portlet.init-param.add-process-action-error-action=false",
			"javax.portlet.display-name=Cruscotto di sistema", 
			"javax.portlet.init-param.view-template=/cruscotto.jsp",
			"javax.portlet.name=" + AllertaKeys.AllertaCruscottoPortlet,
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user"
		},
		service = Portlet.class
	)
public class CruscottoPortlet  extends MVCPortlet {

	
	@Override
	public void render(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {
		
		
		super.render(renderRequest, renderResponse);
	}
	
	public void forzaScaricamentoStazioni(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		User u = PortalUtil.getUser(actionRequest);
		String s = "";
		if (u!=null) s = u.getFullName();
		
		
		RisultatiAggiornamento ra1 = variabileLocalService.aggiornaVariabili();
		RisultatiAggiornamento ra2 = stazioneLocalService.aggiornaStazioni();
		RisultatiAggiornamento ra3 = stazioneVariabileLocalService.aggiornaSensori();
		
		String output = "Variabili: ";
		if (ra1.errore!=null) output+=ra1.errore;
		else {
			output+= "aggiunte "+ra1.aggiunti;
		}
		output+="; Stazioni: ";
		if (ra2.errore!=null) output+=ra2.errore;
		else {
			output+= "aggiunte "+ra2.aggiunti+", rimosse "+ra2.rimossi+", riattivate "+ra2.modificati;
		}
		output+="; Sensori: ";
		if (ra3.errore!=null) output+=ra3.errore;
		else {
			output+= "aggiunti "+ra3.aggiunti+", rimossi "+ra3.rimossi+", modificati "+ra3.modificati;
		}
		logInternoLocalService.log("dati osservati", "Aggiornamento manuale stazioni", output, s);
		
	}
	
	public void forzaScaricamentoDati(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		
		/*Folder folder = DLAppServiceUtil.getFolder(20181, 518352, "allerta-" + 76101);
		List<FileEntry> fileEntries = DLAppServiceUtil.getFileEntries(20181, folder.getFolderId());
		String nomeFile="";
		File fx = null;
		for (FileEntry f : fileEntries) {
			if (f.getTitle().startsWith("allerta") || f.getTitle().startsWith("bollettino")) {
				nomeFile = f.getTitle();
				File ff = FileUtil.createTempFile(f.getContentStream());
				fx = ff;
			}
		}
		

		
		//File f = DLFileEntryLocalServiceUtil.getFile(1516510, "3.0", false, 0);
		if (fx!=null) {

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
				"</html>","no-reply@regione.emilia-romagna.it",fx,"allerta075_2020.pdf");

		}
		

		if (1==1) return;*/
		
		User u = PortalUtil.getUser(actionRequest);
		String s = "";
		if (u!=null) s = u.getFullName();
		
		
		RisultatiAggiornamento ra1 = valoreSensoreLocalService.aggiornaTuttiDatiOsservati();
		
		String output = "Valori: ";
		if (ra1.errore!=null) output+=ra1.errore;
		else {
			output+= ""+ra1.aggiunti;
		}
		
		logInternoLocalService.log("dati osservati", "Aggiornamento manuale dati osservati", output, s);
		
	}
	
	@Reference
	LogInternoLocalService logInternoLocalService;
	
	@Reference
	VariabileLocalService variabileLocalService;
	
	@Reference
	StazioneVariabileLocalService stazioneVariabileLocalService;
	
	@Reference
	StazioneLocalService stazioneLocalService;
	
	@Reference
	ValoreSensoreLocalService valoreSensoreLocalService;

}
