package it.eng.parer.cron;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.DestinationNames;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.scheduler.SchedulerEngineHelper;
import com.liferay.portal.kernel.scheduler.SchedulerEntry;
import com.liferay.portal.kernel.scheduler.SchedulerEntryImpl;
import com.liferay.portal.kernel.scheduler.Trigger;
import com.liferay.portal.kernel.scheduler.TriggerFactory;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.Portal;

import it.eng.parer.bean.DatiSpecificiBean;
import it.eng.parer.custom.service.ParerService;
import it.eng.parer.model.ComponentiInvio;
import it.eng.parer.model.DatiSpecificiInvio;
import it.eng.parer.model.DocumentiCollegati;
import it.eng.parer.xmlGen.util.IJavaToXMLParerConstants;
import it.eng.parer.xmlGen.util.TipoDatoDaInviare;


@Component(
	immediate = true,
	service = MessageListener.class
)
public class ParerScheduler extends BaseMessageListener implements IJavaToXMLParerConstants {

	private Log _log = LogFactoryUtil.getLog(ParerScheduler.class);
	
	@Override
	protected void doReceive(Message message) throws Exception {
		
		_log.info("Parer Scheduler - START");
		
		inviaDocumentiParer();
		
		_log.info("Parer Scheduler - END");
		
	}

	//----Questo metodo carica i dati da reinviare dalla tabella parer_datiSpecifici
	// ---Costruisce l'oggetto di input e chiama il metodo specifico per l'invio ---//
	public void inviaDocumentiParer(){
		
		try {
			
			long companyId = portal.getDefaultCompanyId();
			
			User user = userLocalService.getDefaultUser(companyId);
			
			ParerService parerService = new ParerService(companyId, user.getGroupId(), user.getUserId());
			
			String tipoInvio="";
			//carico la lista dei dati non inviati (per esito KO)
			List<DatiSpecificiInvio> listaDatiSpecifici = new ArrayList<>();
			listaDatiSpecifici = parerService.listaDatiSpecificiByEsitoInvio(ESITO_INVIO_KO);
			
			for(DatiSpecificiInvio datiSpecifici : listaDatiSpecifici) {
				
				tipoInvio = datiSpecifici.getCODICE_TIPO_INVIO();				
				//Carica eventuali doc collegati e componenti
				List<DocumentiCollegati> listaDocCollegati = null;
				listaDocCollegati = parerService.listaDocumentiCollegatiByIdInvio(datiSpecifici.getID_INVIO());
				List<ComponentiInvio> listaComponenti = new ArrayList<>();
				listaComponenti = parerService.listaComponentiByIdInvio(datiSpecifici.getID_INVIO());
				//Inizio a costruire gli oggetti di input
				DatiSpecificiBean datiSpecificiBean = new DatiSpecificiBean();
				datiSpecificiBean.setDatiSpecifici(datiSpecifici);
				datiSpecificiBean.setComponenti(listaComponenti);
				datiSpecificiBean.setDocumentiCollegati(listaDocCollegati);
				//Richiamo il metodo specifico per l'invio
				if(TipoDatoDaInviare.ALLERTA.getTipoDatoDaInviare().equals(tipoInvio)){
					parerService.comunicaDatiSpecificiInvioAllerta(datiSpecificiBean);
				}else if(TipoDatoDaInviare.ALLERTA_BOLLETTINO.getTipoDatoDaInviare().equals(tipoInvio)) {
					parerService.comunicaDatiSpecificiInvioAllertaBollettino(datiSpecificiBean);
				}else if(TipoDatoDaInviare.ALLERTA_MAIL.getTipoDatoDaInviare().equals(tipoInvio)) {
					parerService.comunicaDatiSpecificiInvioAllertaMail(datiSpecificiBean);
				}else if (TipoDatoDaInviare.ALLERTA_SMS.getTipoDatoDaInviare().equals(tipoInvio)) {
					parerService.comunicaDatiSpecificiInvioAllertaSms(datiSpecificiBean);
				}else if (TipoDatoDaInviare.MONITORAGGIO.getTipoDatoDaInviare().equals(tipoInvio)) {
					parerService.comunicaDatiSpecificiInvioMonitoraggio(datiSpecificiBean);
				}else if (TipoDatoDaInviare.MONITORAGGIO_MAIL.getTipoDatoDaInviare().equals(tipoInvio)) {
					parerService.comunicaDatiSpecificiInvioMonitoraggioMail(datiSpecificiBean);
				}else if (TipoDatoDaInviare.MONITORAGGIO_SMS.getTipoDatoDaInviare().equals(tipoInvio)) {
					parerService.comunicaDatiSpecificiInvioMonitoraggioSms(datiSpecificiBean);
				}else if (TipoDatoDaInviare.SUPERAMENTO_MAIL.getTipoDatoDaInviare().equals(tipoInvio)) {
					parerService.comunicaDatiSpecificiInvioSuperamentoMail(datiSpecificiBean);
				}else if (TipoDatoDaInviare.SUPERAMENTO_SMS.getTipoDatoDaInviare().equals(tipoInvio)) {
					parerService.comunicaDatiSpecificiInvioSuperamentoSms(datiSpecificiBean);
				}else if(TipoDatoDaInviare.VALANGHE.getTipoDatoDaInviare().equals(tipoInvio)){
					parerService.comunicaDatiSpecificiInvioValanghe(datiSpecificiBean);
				}else if(TipoDatoDaInviare.VALANGHE_MAIL.getTipoDatoDaInviare().equals(tipoInvio)) {
					parerService.comunicaDatiSpecificiInvioValangheMail(datiSpecificiBean);
				}else if (TipoDatoDaInviare.VALANGHE_SMS.getTipoDatoDaInviare().equals(tipoInvio)) {
					parerService.comunicaDatiSpecificiInvioValangheSms(datiSpecificiBean);
				}		
			}			
		} 
		catch (Exception e) {
			_log.error("Parer [ERROR] exception : Something went wrong: "+e);
		}
	}


	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		
		Class<?> clazz = getClass();

		String className = clazz.getName();
		
		_log.info("Parer Scheduler scheduling at: 0 0 20 ? * * *" );

		Trigger trigger = _triggerFactory.createTrigger(className, className, null, null, "0 0 20 ? * * *");

		SchedulerEntry schedulerEntry = new SchedulerEntryImpl(className, trigger);

		baseScheduler.register(this, schedulerEntry, DestinationNames.SCHEDULER_DISPATCH);
		
	}

	@Deactivate
	protected void deactivate() {
		baseScheduler.unregister(this);
	}
	
	@Reference
	private SchedulerEngineHelper baseScheduler;
	
	@Reference
	private TriggerFactory _triggerFactory;

	@Reference
	private UserLocalService userLocalService;
	
	@Reference
	private Portal portal;

}

