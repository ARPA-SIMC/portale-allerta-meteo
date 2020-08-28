package it.eng.allertaer.allertebollettini.portlet;

import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.IOException;

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
