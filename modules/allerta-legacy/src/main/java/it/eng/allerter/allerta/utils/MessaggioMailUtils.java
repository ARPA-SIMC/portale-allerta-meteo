package it.eng.allerter.allerta.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.EmailAddress;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserGroupRole;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.service.UserGroupRoleLocalService;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.StreamUtil;
import com.liferay.portal.kernel.util.StringUtil;

@Component(
		immediate = true,
		service = MessaggioMailUtils.class
		)
public class MessaggioMailUtils {
	
	private final Log logger = LogFactoryUtil.getLog(MessaggioMailUtils.class);

	//	private static final long SINDACO_SITE_ROLEID	=	29574;
	//	private static final long DELEGATO_SINDACO_SITE_ROLEID	=	29574;

	public String prepareMessageBodyMail(Boolean sindaco,
			User user,Group group, String messaggio_pc,String paginaPieneFiumi,
			String paginaFrane,String paginaTemporali,String paginaVento,
			String paginaNeve,String paginaMareggiate,String paginaGhiaccio,
			String paginaOndateCalore,String paginaIncendio,String paginaTerremoto,
			String paginaAllerta, String baseUrl) throws IOException{
		
		String body ="";
		String html = "";
		int minlenght=5;
		if(showUtilsLink(sindaco,paginaPieneFiumi, paginaFrane, paginaTemporali, paginaVento, paginaNeve, paginaMareggiate, paginaGhiaccio, paginaOndateCalore, paginaIncendio, paginaTerremoto)){
			html ="<h5 style=\"color:#2A768D\">Informazioni utili : </h5>";
			if(paginaPieneFiumi!=null &&paginaPieneFiumi.length()>minlenght){
				html =html+"<p><a href=\""+paginaPieneFiumi+"\">Cosa fare in caso di piene</a></p>";
			}
			if(paginaFrane!=null &&paginaFrane.length()>minlenght){
				html =html+"<p><a href=\""+paginaFrane+"\">Cosa fare in caso di frane</a></p>";
			}		
			if(paginaTemporali!=null &&paginaTemporali.length()>minlenght){
				html =html+"<p><a href=\""+paginaTemporali+"\">Cosa fare in caso di temporali</a></p>";
			}
			if(paginaVento!=null &&paginaVento.length()>minlenght){
				html =html+"<p><a href=\""+paginaVento+"\">Cosa fare in caso di vento</a></p>";
			}
			if(paginaMareggiate!=null &&paginaMareggiate.length()>minlenght){
				html =html+"<p><a href=\""+paginaMareggiate+"\">Cosa fare in caso di mareggiate</a></p>";
			}
			if(paginaNeve!=null &&paginaNeve.length()>minlenght){
				html =html+"<p><a href=\""+paginaNeve+"\">Cosa fare in caso di neve</a></p>";
			}
			if(paginaGhiaccio!=null &&paginaGhiaccio.length()>minlenght){
				html =html+"<p><a href=\""+paginaGhiaccio+"\">Cosa fare in caso di ghiaccio e pioggia che gela</a></p>";
			}
			if(paginaOndateCalore!=null &&paginaOndateCalore.length()>minlenght){
				html =html+"<p><a href=\""+paginaOndateCalore+"\">Cosa fare in caso di ondate di calore</a></p>";
			}
			if(paginaIncendio!=null &&paginaIncendio.length()>minlenght){
				html =html+"<p><a href=\""+paginaIncendio+"\">Cosa fare in caso di incendio</a></p>";
			}
			if(paginaTerremoto!=null &&paginaTerremoto.length()>minlenght){
				html =html+"<p><a href=\""+paginaTerremoto+"\">Cosa fare in caso di terremoto</a></p>";
			}
		}
		String mess_allerta="";
		if( ( paginaAllerta!=null)  && (paginaAllerta.length()>minlenght) && (!paginaAllerta.contains("/Allerta-Bollettino/id/no"))){
			logger.info("DEBUG DELLA PAGINA DI ALLERTA"+paginaAllerta);
			mess_allerta="<a href=\""+paginaAllerta+"\">Vedi documento di allerta.</a><br/>";
		}
		String[] old_value = new String[]{"[$COMUNE_NAME$]","[$MESSAGGIO$]","[$SITE_URL$]","[$ALLERTA_SITE$]","[$EXTRA_HTML$]","[$ALLERTA$]"};
		
		
		String[] new_value = new String[] {group.getName(),messaggio_pc, baseUrl + "/web"+group.getFriendlyURL()+"/",
				baseUrl,html,mess_allerta};
		if(sindaco){
			InputStream is = this.getClass().getResourceAsStream("/tmpl/emailComune.tmpl");
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			
			StreamUtil.transfer(is, baos);
			
			body = new String(baos.toByteArray(), "UTF-8");
					//ContentUtil.get(TabViewWizardBean.class.getClassLoader(), "/tmpl/emailComune.tmpl");
			body = StringUtil.replace(body, old_value, new_value);

			//			body ="<h4 color =#2A768D>Gentile Utente Del Portale Weballerte  </h4>";
			//			body =body+"<h5 >Il sindaco "+user.getFirstName() +" "+user.getLastName() +" ha inviato la seguente comunicazione</h5>";
		}else{
			body =body+"il portale weballerte invia la  seguente comunicazione</h5>";

			body =body+"<table >";
			body =body+"<tr><td>"+messaggio_pc+"</td></tr>";
			body =body+"</table>";
		}
		return body;
	}

	private boolean showUtilsLink(boolean isSindaco,String paginaPieneFiumi,String paginaFrane,String paginaTemporali,String paginaVento,String paginaNeve,String paginaMareggiate,String paginaGhiaccio,String paginaOndateCalore,String paginaIncendio,String paginaTerremoto){
		boolean show =false;
		int min=5;
		if(isSindaco && (
				(paginaPieneFiumi!=null && paginaPieneFiumi.length()>min) 
				||(paginaFrane!=null && paginaFrane.length()>min) 
				|| (paginaTemporali!=null && paginaTemporali.length()>min) 
				|| (paginaVento!=null && paginaVento.length()>min) 
				|| (paginaNeve!=null && paginaNeve.length()>min)  
				|| (paginaMareggiate!=null && paginaMareggiate.length()>min) 
				|| (paginaGhiaccio!=null && paginaGhiaccio.length()>min) 
				|| (paginaOndateCalore!=null && paginaOndateCalore.length()>min) 
				|| (paginaIncendio!=null && paginaIncendio.length()>min) 
				|| (paginaTerremoto!=null && paginaTerremoto.length()>min)  )){
			show=true;
		}
		return show;
	}
	

	public InternetAddress[] prepareListReceiver(int userGroupId, User user,boolean sindaco) throws SystemException{

		logger.info("PREPARAZIONE DELLE MAIL UTENTI per userGroup"+userGroupId);
		InternetAddress[] addresses =null;
		List<InternetAddress> addressesList = new ArrayList<>();
		List<User> user_list = new ArrayList<User>();
		final long ID_CITTADINO_ROLE = 36751;
		final String KEY_CITTADINO = "CITTADINO";

		String name = null;
		try {
			name = roleLocalService.getRole(ID_CITTADINO_ROLE).getName();
		} catch (PortalException e1) {
			// TODO Auto-generated catch block
			logger.error(e1);
		}

		if(sindaco && name == KEY_CITTADINO){
			List<UserGroupRole> userGroupRolesByGroupAndRole = userGroupRoleLocalService.getUserGroupRolesByGroupAndRole(userGroupId, ID_CITTADINO_ROLE);
			for(UserGroupRole userBy: userGroupRolesByGroupAndRole)
				try {
					user_list.add(userLocalService.getUserById(userBy.getUserId()));
					logger.info(userLocalService.getUserById(userBy.getUserId()).getEmailAddress());
				} catch (PortalException e1) {
					// TODO Auto-generated catch block
					logger.error(e1);
				}
			for(User users: user_list){
				logger.info(users.getFullName());
				if(userGroupRoleLocalService.hasUserGroupRole(users.getUserId(), userGroupId, ID_CITTADINO_ROLE)){
					try {
						for(EmailAddress email : user.getEmailAddresses())
							addressesList.add(new InternetAddress(email.getAddress()));
					} catch (AddressException e) {
						// TODO Auto-generated catch block
						logger.error(e);
					}
				}
			}
			addresses = new InternetAddress[addressesList.size()];
			addresses = addressesList.toArray(addresses);
		}
		else if(!sindaco && user_list!=null && user_list.size()>=1){
			user_list = userLocalService.getUserGroupUsers(userGroupId);
			addresses = new InternetAddress[user_list.size()];
			Iterator<User> itUser = user_list.iterator();
			User actualUser = null;
			int i=0;
			boolean stop=false;
			while(itUser.hasNext()&& !stop){
				actualUser = itUser.next();
				if(actualUser.getEmailAddress()!=null && actualUser.getEmailAddress().length()>5){
					boolean corretEmail = true;
					try {
						addresses[i]= new InternetAddress(actualUser.getEmailAddress(), actualUser.getEmailAddress());
					} catch (UnsupportedEncodingException e) {
						corretEmail=false;
						logger.error(e);
					} 
					if(corretEmail)
						i++;
				}
				logger.info("USER "+actualUser.getEmailAddress());
			}
		}
		return addresses;
	}
	
	@Reference
	private RoleLocalService roleLocalService;
	
	@Reference
	private UserLocalService userLocalService;
	
	@Reference
	private UserGroupRoleLocalService userGroupRoleLocalService;
}
