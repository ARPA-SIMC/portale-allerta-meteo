package it.eng.allerter.allerta.utils;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.mail.internet.AddressException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.util.FileUtil;

import it.eng.allerter.allerta.FileBean;
//import it.eng.allerter.service.logInternoLocalService;
import it.eng.allerter.service.SMSLocalService;

@Component(
		immediate = true,
		service = ChannelSendUtils.class
		)
public class ChannelSendUtils {

	private final Log logger = LogFactoryUtil.getLog(ChannelSendUtils.class);
	private String MAIL_SENDER="no-reply@regione.emilia-romagna.it";

	/*
	 *  METODO PER LA PUBBLICAZIONE SU FACEBOOK 
	 */

	public boolean shareOnFacebook(User user, FacebookAccount credenziali,String title, String message, String portalURL){
		//		String type="Messaggio";				
		//		String link = "http://www.arpae.it/";
		//		String pictureLink = "http://www.regione.emilia-romagna.it/logo_er.png";
		//	    String title="nuova comunicazione dal portale weballerte.it";Boolean shared =true;

		String link = "https://allertameteo.regione.emilia-romagna.it/";
		String pictureLink = portalURL+"/weballerte-theme/images/allerta/logo_allertameteo_er.png";
		Boolean shared =true;

		logger.info("RICHIESTO SHARE SU FACEBOOK ");
		logger.info("pictureLink = "+pictureLink+" , title = "+title +", message = "+message);

		if(user!=null){
			if(credenziali.getToken()!=null && credenziali.getToken().length()>0 ){
				logger.info("INIZIO LO SHARE  ");
				logger.info("@@@@@@@@@@@@ faceId "+credenziali.getFaceId());
				logger.info("@@@@@@@@@@@@ facePass "+credenziali.getFacePass());
				logger.info("@@@@@@@@@@@@ token "+credenziali.getToken());

				FacebookConnector arpaFacebook = new FacebookConnector(credenziali.getFaceId(),
						credenziali.getFacePass(),credenziali.getToken());

				if(arpaFacebook!=null){
					logger.info("Facebook è stato creato: "+arpaFacebook.toString());
				}
				//al momento non usato dal 14/09
				//arpaFacebook.postWithLinkAndText(title,message,link, pictureLink);
				arpaFacebook.postMessage(title, message);
				logger.info("FINITO LO SHARE  ");
			}
		}else{
			logger.info("@@@@@@@@@@@@ nessuna comunicazione inviata, trovata utente nullo ");
		}
		return shared;
	}


	/*
	 *  INVIO ALLERTA
	 *  
	 */

	public boolean sendAlert(User user){
		logger.info(" AVVIO GESTIONE CANALE SMS NON IMPLEMENTATO ");
		//boolean send=true;
		return true;
	}
	/*
	 *   INVIO DEL MESSAGGIO SMS 
	 */

	public boolean sendSms(User user){
		logger.info(" AVVIO GESTIONE CANALE SMS NON IMPLEMENTATO ");
		//smsLocalService.creaSMS
		Boolean send =true;		
		return send;
	}

	public boolean sendSms(Group group, String testo, String tipo, long sottotipo){
		boolean send=false;
		try {
			//			smsLocalService.creaOnlySMSOrganization("AllerteER", testo, tipo, sottotipo, 0L, organizationId);
			smsLocalService.creaOnlySMSGroup("AllerteER", testo, tipo, String.valueOf(sottotipo), 0L, group.getGroupId());
			smsLocalService.eliminaDuplicati(tipo, String.valueOf(sottotipo), 0);
			smsLocalService.inviaSMS(tipo, String.valueOf(sottotipo), 0);
			send=true;
		} catch (Exception e) {
			logger.error(e);
			//logInternoLocalService.log("ChannelSendUtil", "sendSMS", e, "");
		}
		return send;
	}

	public boolean sendSmsPrepare(Long organizationId, String testo, String tipo, long sottotipoL) {
		boolean send=false;
		try {
			String sottotipo = String.valueOf(sottotipoL);
			smsLocalService.creaOnlySMSOrganization("AllerteER", testo, tipo, sottotipo, 0L, organizationId);
			send=true;
		} catch (Exception e) {
			logger.error(e);
			//logInternoLocalService.log("ChannelSendUtil", "sendSMS", e, "");
		}
		return send;
	}

	public boolean sendSms(String tipo, long sottotipoL) {
		boolean send=false;
		try {
			String sottotipo = String.valueOf(sottotipoL);
			smsLocalService.eliminaDuplicati(tipo, sottotipo, 0);
			smsLocalService.inviaSMS(tipo, sottotipo, 0);
			send=true;
		} catch (Exception e) {
			logger.error(e);
			//logInternoLocalService.log("ChannelSendUtil", "sendSMS", e, "");
		}
		return send;
	}

	/*
	 *  GESTIONE DELLA TELEFONATA 
	 *  
	 */

	public  boolean sendCall(User user){
		logger.info("AVVIO GESTIONE CANALE TELEFONICO NON IMPLEMENTATO ");
		Boolean send =true;
		return send;
	}

	public  boolean sendMail(String tipo,String sottotipo,
			boolean sindaco,String subject,String body,
			List<FileBean> uploadedFiles) throws SystemException, 
				UnsupportedEncodingException, AddressException{
		logger.info("Send Email");
		List<File> file = new ArrayList<>();
		List<String> nomeFile = new ArrayList<String>();

		if(uploadedFiles!=null && uploadedFiles.size()>0){
			File files = null;
			Iterator<FileBean> it = uploadedFiles.iterator();
			while(it.hasNext()){
				FileBean actualFile = it.next();

				try {
					files = FileUtil.createTempFile(actualFile.getContent());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				file.add(files);
				nomeFile.add(actualFile.getTitle());
			}
		}
		try {
			smsLocalService.eliminaDuplicatiEmail(tipo, sottotipo, 0);
			smsLocalService.inviaEmail(tipo, sottotipo, 0, subject, body, "no-reply@regione.emilia-romagna.it", file, nomeFile);
		} catch (Exception e) {
			logger.error(e);
			//logInternoLocalService.log("ChannelSendUtil", "sendEmail", e, "");
		}

		logger.info("FINE DI Send Email");

		return true;
	}



	public void printMessageOnConsole(Boolean isSindaco,String messaggio_pc,
			String paginaPieneFiumi,String paginaFrane,String paginaTemporali,
			String paginaVento,String paginaNeve,String paginaMareggiate,
			String paginaGhiaccio,String paginaOndateCalore,String paginaIncendio,
			String paginaTerremoto,String paginaAllerta){

		if(isSindaco){
			logger.info("MESSAGGIO   DAL SINDACO");
		}else{
			logger.info("MESSAGGIO   DAL AMMINISTRATORE");
		}

		logger.info("MESSAGGIO   >> ******************");
		logger.info("MESSAGGIO :"+messaggio_pc);
		logger.info(">> ******************");
		logger.info("PAGINE>> ******************");
		logger.info("PaginaPiene :"+paginaPieneFiumi);
		logger.info("PaginaFrane :"+paginaFrane);
		logger.info("PaginaTemporali :"+paginaTemporali);
		logger.info("PaginaVento:"+paginaVento);
		logger.info("PaginaMareggiate:"+paginaMareggiate);
		logger.info("PaginaNeve :"+paginaNeve);
		logger.info("PaginaGiaggio :"+paginaGhiaccio);
		logger.info("PaginaOndateCalore :"+paginaOndateCalore);		
		logger.info("PaginaIncendi :"+paginaIncendio);	
		logger.info("PaginaTerremoto :"+paginaTerremoto);
		logger.info("PaginaAllerta:"+paginaAllerta);

		logger.info("******************");

	}

	@Reference
	private SMSLocalService smsLocalService;
	
	//@Reference
	//private //logInternoLocalService //logInternoLocalService;
}
