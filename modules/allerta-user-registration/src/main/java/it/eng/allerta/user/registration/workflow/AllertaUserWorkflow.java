package it.eng.allerta.user.registration.workflow;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.mail.internet.InternetAddress;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.webcache.WebCachePoolUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowStatusManagerUtil;

import it.eng.allerta.configuration.AllertaBaseConfiguration;
import it.eng.allerta.utils.AllertaTracker;

@Component(
		immediate = true,
		service = AllertaUserWorkflow.class
		)
public class AllertaUserWorkflow {
	
	public List<Role> getRoles(Map<String, Serializable> workflowContext){

		List<Role> roles = new  ArrayList<>();
		 
		try {
			
			long   companyId            =  
					GetterUtil.getLong((String)workflowContext.get(WorkflowConstants.CONTEXT_COMPANY_ID));
			  
			Role adminRole = RoleLocalServiceUtil.getRole(companyId, "Administrator");
			roles = new ArrayList<Role>();
			roles.add(adminRole);
			
		} catch (Exception e) {
			log.error(e);
		}
		
		return roles;
	}
	
	public void disableUser(Map<String, Serializable> workflowContext) {
		
		try {
			
			ServiceContext  serviceUtil =	(ServiceContext) workflowContext.get(WorkflowConstants.CONTEXT_SERVICE_CONTEXT);	
			long   companyId            =   GetterUtil.getLong((String)workflowContext.get(WorkflowConstants.CONTEXT_COMPANY_ID));
		    String emailUser	        =   (String) serviceUtil.getAttribute("weballerteUserMail");
		
		    AllertaBaseConfiguration allertaBaseConfiguration = 
					AllertaTracker.getAllertaBaseConfiguration(companyId);
			
			String emailNotification = allertaBaseConfiguration.emailNotificationUserEnable();
			
			User usr =null;							
			try{
				usr = userLocalService.getUserByEmailAddress(companyId,emailUser);
				if(usr!=null ){
					System.out.println("--->> Ho recuperato utente con id "+usr.getUserId());	
					System.out.println("--->> companyId"+companyId);
			        System.out.println("--->> emailUser"+emailUser);	
					
					// EFFETTUO AGGIORNAMENTO DELLO STATO ATTIVANDO UTENTE
			        userLocalService.deleteUser(usr.getUserId());
				
					
				    // CANCELLO LA CACHE PER PERMETTERE UN ACCESSO ISTANTANEO
					
					CacheRegistryUtil.clear();
					WebCachePoolUtil.clear();
				
				
				    // INVIO MAIL									
					try {
						System.out.println( "--->> INVIO MAIL DI NOTIFICA");
						InternetAddress fromAddress = new InternetAddress(emailNotification);
						InternetAddress toAddress = new InternetAddress(emailUser);
						MailMessage mailMessage = new MailMessage();
						mailMessage.setTo(toAddress);
						mailMessage.setFrom(fromAddress);
						mailMessage.setSubject("diniego attivazione utente al portale");								
						mailMessage.setBody("Gentile utente la tua richiesta di attivazione è stata negata");
						mailMessage.setHTMLFormat(true);
						MailServiceUtil.sendEmail(mailMessage);
					} catch (Exception e) {
						System.out.println( "--->> ERRORE INVIO MAIL"+e.getMessage());
					}
				  }else{
					  System.out.println( "--->>>>>>>>>>>>Impossibile recuperare utente con email indicata"+emailUser);	
				}
			} catch (Exception exc) {						
				System.out.println( "utente non trovato per mail  ");	
				usr=null;
			}
			if(usr!=null){
				System.out.println( "UTENTE RECUPERATO");	
				WorkflowStatusManagerUtil.updateStatus(WorkflowConstants.getLabelStatus("approved"), workflowContext);
			}else{
			    WorkflowStatusManagerUtil.updateStatus(WorkflowConstants.getLabelStatus("approved"), workflowContext);
			    System.out.println( "UTENTE NON TROVATO ");	
				
				try {
					System.out.println(  "--->> INVIO MAIL DI NOTIFICA ERRORE DI APPROVAZIONE");
						InternetAddress fromAddress = new InternetAddress(emailNotification);
						InternetAddress toAddress = new InternetAddress(emailNotification);
						MailMessage mailMessage = new MailMessage();
						mailMessage.setTo(toAddress);
						mailMessage.setFrom(fromAddress);
						mailMessage.setSubject("errore nell cancellazione di un  utente al portale");								
						mailMessage.setBody("impossibile cancellare utente  con mail"+emailUser);
						mailMessage.setHTMLFormat(true);
						MailServiceUtil.sendEmail(mailMessage);
					} catch (Exception e) {
						System.out.println(  "--->> ERRORE INVIO MAIL"+e.getMessage());
					}
		
			}
			System.out.println( "------------------------- END  STEP cancellazione   SCRIPT ----------------------------------------------");
		    
		} catch (Exception e) {
			log.error(e);
		}
	}
	
	public void enableUser(Map<String, Serializable> workflowContext) {
		
		try {			
			
			ServiceContext  serviceUtil =	
					(ServiceContext) workflowContext.get(WorkflowConstants.CONTEXT_SERVICE_CONTEXT);	
			long   companyId            =   
					GetterUtil.getLong((String)workflowContext.get(WorkflowConstants.CONTEXT_COMPANY_ID));
		    String emailUser	        =   (String) serviceUtil.getAttribute("weballerteUserMail");
		
			User usr =null;
			
			AllertaBaseConfiguration allertaBaseConfiguration = 
					AllertaTracker.getAllertaBaseConfiguration(companyId);
			
			String emailNotification = allertaBaseConfiguration.emailNotificationUserEnable();
			
			try{
				usr = userLocalService.getUserByEmailAddress(companyId,emailUser);
				if(usr!=null ){
					System.out.println("--->> Ho recuperato utente con id "+usr.getUserId());	
					System.out.println( "--->> companyId"+companyId);
			        System.out.println("--->> emailUser"+emailUser);	
					
					// EFFETTUO AGGIORNAMENTO DELLO STATO ATTIVANDO UTENTE
			        userLocalService.updateStatus(usr.getUserId(),0,serviceUtil);
			        //userLocalService.updateUser(usr);
				
				
				    // CANCELLO LA CACHE PER PERMETTERE UN ACCESSO ISTANTANEO
					
					CacheRegistryUtil.clear();
					WebCachePoolUtil.clear();
									
				
				    // INVIO MAIL									
					try {
						System.out.println( "--->> INVIO MAIL DI NOTIFICA");
						InternetAddress fromAddress = 
								new InternetAddress(emailNotification);
						InternetAddress toAddress = new InternetAddress(emailUser);
						MailMessage mailMessage = new MailMessage();
						mailMessage.setTo(toAddress);
						mailMessage.setFrom(fromAddress);
						mailMessage.setSubject("attivazione utente al portale");								
						mailMessage.setBody("Gentile utente sei stato abilitato al portale ");
						mailMessage.setHTMLFormat(true);
						MailServiceUtil.sendEmail(mailMessage);
					} catch (Exception e) {
							System.out.println( "--->> ERRORE INVIO MAIL"+e.getMessage());
					}
				  }else{
					System.out.println("--->>>>>>>>>>>>Impossibile recuperare utente con email indicata"+emailUser);	
				}
			} catch (Exception exc) {						
				System.out.println("utente non trovato per mail  ");	
				usr=null;
			}
			if(usr!=null){
				System.out.println("UTENTE RECUPERATO");	
				WorkflowStatusManagerUtil
					.updateStatus(WorkflowConstants.STATUS_APPROVED, workflowContext);
				
			}else{
			    
				WorkflowStatusManagerUtil
					.updateStatus(WorkflowConstants.STATUS_APPROVED, workflowContext);
				System.out.println("UTENTE NON TROVATO ");								
											
				try {
						System.out.println("--->> INVIO MAIL DI NOTIFICA ERRORE DI APPROVAZIONE");
						InternetAddress fromAddress = new InternetAddress(emailUser);
						InternetAddress toAddress = new InternetAddress(emailUser);
						MailMessage mailMessage = new MailMessage();
						mailMessage.setTo(toAddress);
						mailMessage.setFrom(fromAddress);
						mailMessage.setSubject("errore nell attivazione utente al portale");								
						mailMessage.setBody("impossibile attivate utene con mail"+emailUser);
						mailMessage.setHTMLFormat(true);
						MailServiceUtil.sendEmail(mailMessage);
					} catch (Exception e) {
							System.out.println("--->> ERRORE INVIO MAIL"+e.getMessage());
					}
		
			}
		    System.out.println( "------------------------- END  STEP APPROVE  SCRIPT ----------------------------------------------");	
		
		    
		} catch (Exception e) {
			log.error(e);
		}
	}

	public User userAssignmentAction(Map<String, Serializable> workflowContext) {

		try {

			ServiceContext serviceUtil = (ServiceContext) workflowContext
					.get(WorkflowConstants.CONTEXT_SERVICE_CONTEXT);

			// RECUPER LA MAIL DELL UTENTE CHE E STATA SETTATA IN PRECEDENZA DAL CONTROLLER
			String emailUser = (String) serviceUtil.getAttribute("weballerteUserMail");
			System.out.println("--->> emailUser" + emailUser);

			// COME PRIMA OPERAZIONE ASSEGNO L APPROVAZIONE PER RUOLO
			long companyId = GetterUtil.getLong((String) workflowContext.get(WorkflowConstants.CONTEXT_COMPANY_ID));
			System.out.println("--->> companyId" + companyId);

			// ASSEGNO PER UTENTE SE SETTATO DAL CONTROLLER
			// NB L AZZEGANZIONE ALL UTENTE PUO ESSERE SOLO SINGOLA, ALTRIMENTI VUOL DIRE
			// CHE SI DEVE LAVORARE SUI RUOLI

			User usr = userLocalService.getUserByEmailAddress(companyId,emailUser);
			long userId = usr.getUserId();

				System.out.println("--->> UTENTE APPROVATORE SETTATO DAL CONTROLLER CON ID " + userId);
				try {
					
				} catch (Exception exc) {

					System.out.println("impossibile recuperare utente con id indicato " + userId);
					usr = null;
				}

				if (usr != null) {
					System.out.println("IL WF e stato assegnato al singolo utente con id  " + userId);
				}
			

			User user = usr;
			System.out.println(
					"------------------------- FINE  SCRIPT DI ASSEGNAZIONE DINAMICA----------------------------------------------");

			return user;
			
		} catch (Exception e) {
			log.error(e);
		}
		
		return null;
	}

	@Reference
	private UserLocalService userLocalService;
	
	private Log log = LogFactoryUtil.getLog(AllertaUserWorkflow.class);

}
