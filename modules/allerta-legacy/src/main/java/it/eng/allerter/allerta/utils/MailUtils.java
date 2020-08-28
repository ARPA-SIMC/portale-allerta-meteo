package it.eng.allerter.allerta.utils;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;

public class MailUtils {

	private static final Log logger = LogFactoryUtil.getLog(MailUtils.class);
	private static String MAIL_SENDER="valeriano.fabris@iquadro.net";
	
	private static String prepareActivationBodyMail(User user, String loginUrl){
	      
		String body ="<div style=\"border:1px solid  #dedede; padding:10px\">";
		body =body+"<h4 color =#2A768D>Gentile Cittadino, abbiamo ricevuto la tua richiesta di registrazione al portale </h4>";
		body =body+"<h5 >Di seguito i tuoi dati di accesso</h5>";
		body =body+"<table >";
		body =body+"<tr><td>Username : </td><td><strong>"+user.getScreenName()+"</strong></td></tr>";
		body =body+"<tr><td>Password : </td><td><strong>"+user.getPasswordUnencrypted()+"</strong></td></tr>";
		body =body+"</table>";
		body =body+"<p>";
		body =body+"<a href=\""+loginUrl+"\">";
		body =body+"Vai al sito</a>";
		body =body+"</p>";
		body =body+"</div>";
		logger.info("MAIL BODY DI ATTIVAZIONE ");
		logger.info(body);
		
		return body;
	}
	
private static String prepareWfBodyMail(User user, String loginUrl){
    
	String body ="<div style=\"border:1px solid  ##2A768D\">";

	body =body+"<h4 color =#2A768D>Gentile "+user.getFirstName()+" "+user.getLastName()+"abbiamo ricevuto la tua richiesta di registrazione al portale Web Allerte </h4>";
	body =body+"<h5 >Il tuo account &egrave; al momento disabilitato, ti verr&agrave; inviata una mail con l'acettazione o il diniego della tua richiesta</h5>";
	body =body+"<h6> I tuoi dati di acesso, sono di seguito indicati e saranno attivi nel caso di acettazione </h6>";
	body =body+"<table>";
	body =body+"<tr><td>Username : </td><td><strong>"+user.getScreenName()+"</strong></td></tr>";
	body =body+"<tr><td>Password : </td><td><strong>"+user.getPasswordUnencrypted()+"</strong></td></tr>";
	body =body+"</table>";
	body =body+"<p>";
	
	body =body+"</p>";
	body =body+"<p>";
	body =body+"<a href=\""+loginUrl+"\">";
	body =body+"Vai al sito</a>";
	body =body+"</p>";
	body =body+"</div>";
	
	logger.info("MAIL BODY DI ATTIVAZIONE ");
	logger.info(body);
	
	return body;
}

	
//	private static String prepareBodyMail(User user){
//        
//		Iterator<Phone> itPhone =null;
//		Phone actualPhone=null;
//		try {
//			List<Phone> phones = user.getPhones();
//			itPhone = phones.iterator();
//		} catch (SystemException e) {
//			logger.error("Impossibile recuperare contatti telefonici dell utente  "+user.getLastName()+" "+user.getFirstName()+" con mail"+user.getEmailAddress() );
//			e.printStackTrace();
//		}
//		String body ="<div style=\"border:1px solid  grey\">";
//		body =body+"<h3 color =#2A768D> Nuova richiesta di registrazione al portale <strong>Web Allerte da parte di </strong>";
//		body =body+"<table>";
//		body =body+"<tr><td>Nome</td><td>"+user.getFirstName()+"</td></tr>";
//		body =body+"<tr><td>Cognome</td><td>"+user.getLastName()+"</td></tr>";
//		body =body+"<tr><td>Email</td><td>"+user.getEmailAddress()+"</td></tr>";
//		
//		if(itPhone!=null){
//			while(itPhone.hasNext()){
//				actualPhone= itPhone.next();
//				body =body+"<tr><td>Riferimento Telefonico</td><td>"+actualPhone.getNumber()+"</td></tr>";
//			}
//		
//		}
//		
//		body =body+"</table>";
//		body =body+"</div>";
//		
//		logger.info("MAIL BODY");
//		logger.info(body);
//		
//		return body;
//	}
	

	public static void informeAdminStartWf(String info) {
		logger.info("RICHIESTA DI INVIO EMAIL AD UTENTE SEMPLICE");
		InternetAddress fromAddress = null;
		InternetAddress toAddress =null;
		try {
			fromAddress = new InternetAddress(MAIL_SENDER);
			toAddress = new InternetAddress(MAIL_SENDER);
			MailMessage mailMessage = new MailMessage();
			mailMessage.setTo(toAddress);
			mailMessage.setFrom(fromAddress);
			mailMessage.setSubject(WebAllerteConstants.MAIL_REGISTRATION_SUBJECT.toString());
			//mailMessage.setBody(prepareBodyMail(user));
			mailMessage.setBody(info);
			
			mailMessage.setHTMLFormat(true);
			MailServiceUtil.sendEmail(mailMessage);
			System.out.println("FINE Send mail with HTML Format");
		} catch (Exception e) {
			logger.error(e);
		}
	}
	

	
	
	public static void sendActivationMailToUser(User user, String loginUrl) {
		logger.info("RICHIESTA DI INVIO EMAIL AD UTENTE SEMPLICE");
		InternetAddress fromAddress = null;
		InternetAddress toAddress =null;
		try {
			fromAddress = new InternetAddress(MAIL_SENDER);
			toAddress = new InternetAddress(user.getEmailAddress());
			MailMessage mailMessage = new MailMessage();
			mailMessage.setTo(toAddress);
			mailMessage.setFrom(fromAddress);
			mailMessage.setSubject(WebAllerteConstants.MAIL_REGISTRATION_SUBJECT.toString());
			//mailMessage.setBody(prepareBodyMail(user));
			mailMessage.setBody(prepareActivationBodyMail(user, loginUrl));
			
			mailMessage.setHTMLFormat(true);
			MailServiceUtil.sendEmail(mailMessage);
			System.out.println("FINE Send mail with HTML Format");
		} catch (AddressException e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
	}
	
	public static void sendWfStartToUser(User user, String loginUrl) {
		logger.info("RICHIESTA DI INVIO EMAIL");
		InternetAddress fromAddress = null;
		InternetAddress toAddress =null;
		try {
			fromAddress = new InternetAddress(MAIL_SENDER);
			toAddress = new InternetAddress(user.getEmailAddress());
			MailMessage mailMessage = new MailMessage();
			mailMessage.setTo(toAddress);
			mailMessage.setFrom(fromAddress);
			mailMessage.setSubject(WebAllerteConstants.MAIL_REGISTRATION_SUBJECT.toString());
			mailMessage.setBody(prepareWfBodyMail(user, loginUrl));
			mailMessage.setHTMLFormat(true);
			MailServiceUtil.sendEmail(mailMessage);
			System.out.println("FINE Send mail with HTML Format");
		} catch (AddressException e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
	}
	
	
	public static InternetAddress[] defineDemoApprover() throws AddressException{
		
		InternetAddress[] approverMail = new InternetAddress[4];
		// DEMO MAIL 
		InternetAddress addr1 = new InternetAddress("valeriano.fabris@iquadro.net");
		InternetAddress addr2 = new InternetAddress("valeriano.fabris@mailinator.com");
		InternetAddress addr3 = new InternetAddress("valeriano@mailinator.com");
		InternetAddress addr4 = new InternetAddress("fabris@mailinator.com");
		
		approverMail[0]= addr1;
		approverMail[1]= addr2;
		approverMail[2]= addr3;
		approverMail[3]= addr4;		
		
		return approverMail;
	}
	
	

	
}
