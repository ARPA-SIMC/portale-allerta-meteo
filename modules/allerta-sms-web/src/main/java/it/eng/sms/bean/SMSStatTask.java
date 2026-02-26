package it.eng.sms.bean;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.DestinationNames;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.scheduler.SchedulerEngineHelper;
import com.liferay.portal.kernel.scheduler.SchedulerEntry;
import com.liferay.portal.kernel.scheduler.SchedulerEntryImpl;
import com.liferay.portal.kernel.scheduler.TimeUnit;
import com.liferay.portal.kernel.scheduler.Trigger;
import com.liferay.portal.kernel.scheduler.TriggerFactory;
import com.liferay.dispatch.executor.BaseDispatchTaskExecutor;
import com.liferay.dispatch.executor.DispatchTaskExecutor;
import com.liferay.dispatch.executor.DispatchTaskExecutorOutput;
import com.liferay.dispatch.model.DispatchTrigger;

import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;


import it.eng.bollettino.service.BollettinoLocalServiceUtil;

@Component(
		  property = {
			"dispatch.task.executor.name=Aggiornamento stat SMS",
			"dispatch.task.executor.type=task-aggiornamento-sms"
		  },
		  service = DispatchTaskExecutor.class
		)
public class SMSStatTask extends BaseDispatchTaskExecutor {
	
	
	private Log logger = LogFactoryUtil.getLog(SMSStatTask.class);
	@Reference
	private TriggerFactory _triggerFactory;
	@Reference
	private SchedulerEngineHelper baseScheduler;
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void doExecute(DispatchTrigger dispatchTrigger, DispatchTaskExecutorOutput output)
			throws Exception {
		String queryElencoInvii = "insert into allerter_invii (id,evento,tipo_evento) " + 
				"(select id,evento,tipo_evento from sms_invii_vw i where not exists (select * from allerter_invii a where a.id=i.id))";
		
		String queryStat = "update allerter_invii i set generati=a.generati, " + 
				"    spediti=a.spediti, " + 
				"    consegnati=a.consegnati, " + 
				"    successo=a.successo, " + 
				"    ultimo_aggiornamento=a.ultimo_aggiornamento, " + 
				"    creazione=a.creazione " + 
				"from (select * from sms_invii_vw) a where i.id=a.id";
		
		String queryDestinatari1 = "insert into allerter_sms_destinatari (select distinct tipo,sottotipo,param,destinatario,false as raggiunto, concat(tipo,(case when tipo='superamento' then '' else concat('_',sottotipo) end) " + 
				",'_',param) as nome_invio from allerter_sms where " + 
				"datainvio>now()-cast('1 day' as interval) group by tipo, sottotipo, param, destinatario) ON CONFLICT DO NOTHING";
		
		String queryDestinatari2 = "update allerter_sms_destinatari asd set raggiunto=true from (select tipo, sottotipo, param, destinatario from allerter_sms where datainvio>now()-cast('1 day' as interval) and stato=4 group by tipo, sottotipo, param, destinatario) as subquery " + 
				"WHERE asd.tipo=subquery.tipo and (asd.sottotipo='superamento' or asd.sottotipo=subquery.sottotipo) and " + 
				"asd.param=subquery.param and asd.destinatario=cast(subquery.destinatario as character varying)";
		
		String queryDestinatari3 = "update allerter_sms_destinatari asd set raggiunto=true from (select tipo, sottotipo, param, destinatario from allerter_sms ss where datainvio>now()-cast('1 day' as interval) and stato=-1000 and exists(select * from allerter_sms ss2 where ss2.tipo=ss.tipo and ss2.sottotipo=ss.sottotipo and ss2.param=ss.param and ss2.numero=ss.numero and ss2.stato=4) group by tipo, sottotipo, param, destinatario) as subquery " + 
				"WHERE asd.tipo=subquery.tipo and (asd.sottotipo='superamento' or asd.sottotipo=subquery.sottotipo) and " + 
				"asd.param=subquery.param and asd.destinatario=cast(subquery.destinatario as character varying)";
		
		String queryTotali1 = "update allerter_invii i set gruppi_raggiunti=(select count(*) from allerter_sms_destinatari d where i.id=concat(d.tipo,(case when d.tipo='superamento' then concat('_',d.param) else concat('_',d.sottotipo) end) " + 
				") and raggiunto)  where creazione>now()-cast('2 day' as interval)";
		String queryTotali2 = "update allerter_invii i set gruppi_totali=(select count(*) from allerter_sms_destinatari d where i.id=concat(d.tipo,(case when d.tipo='superamento' then concat('_',d.param) else concat('_',d.sottotipo) end) " + 
				"))  where creazione>now()-cast('2 day' as interval)";
		String queryTotali3 = "update allerter_invii i set tutti_raggiunti=(gruppi_raggiunti=gruppi_totali)";
		
		BollettinoLocalServiceUtil.eseguiQueryGenerica(queryElencoInvii);
		BollettinoLocalServiceUtil.eseguiQueryGenerica(queryStat);
		
		BollettinoLocalServiceUtil.eseguiQueryGenerica(queryDestinatari1);
		BollettinoLocalServiceUtil.eseguiQueryGenerica(queryDestinatari2);
		BollettinoLocalServiceUtil.eseguiQueryGenerica(queryDestinatari3);

		BollettinoLocalServiceUtil.eseguiQueryGenerica(queryTotali1);
		BollettinoLocalServiceUtil.eseguiQueryGenerica(queryTotali2);
		BollettinoLocalServiceUtil.eseguiQueryGenerica(queryTotali3);

		output.setOutput("Aggiornamento SMS terminato");
		
	}
	
}
