package it.eng.allerta.user.registration.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.exception.ContactBirthdayException;
import com.liferay.portal.kernel.exception.PhoneNumberException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Contact;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.ListType;
import com.liferay.portal.kernel.model.ListTypeConstants;
import com.liferay.portal.kernel.model.Phone;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.RoleConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.security.auth.PrincipalThreadLocal;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionCheckerFactoryUtil;
import com.liferay.portal.kernel.security.permission.PermissionThreadLocal;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.ListTypeLocalServiceUtil;
import com.liferay.portal.kernel.service.ListTypeServiceUtil;
import com.liferay.portal.kernel.service.PhoneLocalServiceUtil;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.webcache.WebCachePoolUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.users.admin.kernel.util.UsersAdminUtil;

import it.eng.allerta.utils.AllertaKeys;
import it.eng.allerter.allerta.utils.MailUtils;
import it.eng.allerter.allerta.utils.StringUtils;
import it.eng.allerter.allerta.utils.UserExpando;
import it.eng.allerter.allerta.utils.WebAllerteConstants;

@Component(immediate = true, service = AllertaUserRegistrationService.class)
public class AllertaUserRegistrationService {

	public User registerUser(long creatorUserId, long companyId, long groupId, 
			String emailAddress, String firstName, String lastName,
			String screenName, Date dataNascita, String telefono, 
			ServiceContext serviceContext) throws SystemException, PortalException {

		validateUser(telefono, dataNascita);
		
		boolean autoScreenName = true;
		boolean autoPassword = true;
		String password1 = "";
		String password2 = "";

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dataNascita);
		int year = calendar.get(Calendar.YEAR);
		// Add one to month {0 - 11}
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DAY_OF_MONTH);

		long facebookId = 0;
		String openId = "";
		String middleName = "";// registrant.getMiddleName();
		int prefixId = 0;
		int suffixId = 0;
		boolean male = true;
		int birthdayMonth = month;
		int birthdayDay = day;
		int birthdayYear = year;
		String jobTitle = "";

		// Caratterizziamo l'utente
		User user = null;
		long[] groupIds = null;
		long[] organizationIds = null;
		long[] roleIds = null;
		// long[] siteroleIds = null;
		long[] userGroupIds = null;

		// GESTIAMO LA LISTA DEI SITI E RUOLI ASSOCIATI AGLI UTENTI
		List<String> sites = new ArrayList<>();
		List<String> roles = new ArrayList<>();
		// List<String> site_roles = new ArrayList<>();

		String userType = WebAllerteConstants.REGISTRATION_TYPE_CITTADINO.toString();

		if (userType.equals(WebAllerteConstants.REGISTRATION_TYPE_CITTADINO.toString())) {

			// sites.add(WeballerteConstants.SITE_NAME.toString());
			roles.add(WebAllerteConstants.ROLE_REGULAR_CITTADINO.toString());

			logger.info("START ADD USER PER " + WebAllerteConstants.REGISTRATION_TYPE_CITTADINO);
			// CARATTERIZZAZIONE UTENTE
			groupIds = defineUserSite(companyId, sites);
			roleIds = defineUserRoleInContext(companyId, roles);
			userGroupIds = new long[] {};
			organizationIds = new long[] {};
			jobTitle = WebAllerteConstants.CITTADINO_JOB_TITLE.toString();

			serviceContext.setAttribute(WebAllerteConstants.WF_PARAM_MAIL_USER.toString(), emailAddress);

			user = userLocalService.addUser(creatorUserId, companyId, autoPassword, password1, password2,
					autoScreenName, screenName, emailAddress, facebookId, openId, Locale.ITALY, firstName, middleName,
					lastName, prefixId, suffixId, male, birthdayMonth, birthdayDay, birthdayYear, jobTitle, groupIds,
					organizationIds, roleIds, userGroupIds, true, serviceContext);

			
			
			long plid = PortalUtil.getPlidFromPortletId(groupId, false, 
					AllertaKeys.AllertaUserRegistration);
			
			PortletURL portletURL = PortletURLFactoryUtil.create(serviceContext.getRequest(), 
					AllertaKeys.AllertaUserRegistration, plid, PortletRequest.RENDER_PHASE);
			
			// INVIO MAIL AD UTENTE CITTADINO PER ATTIVAZIONE
			//MailUtils.sendActivationMailToUser(user, portletURL.toString());
			
			MailUtils.informeAdminStartWf("Nuovo cittadino registrato <br/>. Utente Nome: " + user.getFirstName()
					+ " Cognome: " + user.getLastName() + "  screenName :" + screenName + " mail" + emailAddress);
		}

		userLocalService.updateStatus(user.getUserId(), WorkflowConstants.STATUS_APPROVED, 
				serviceContext);
		
		CacheRegistryUtil.clear();

		WebCachePoolUtil.clear();
		
		updateMobilePhone(user, companyId, telefono);
		
		if (userType.equals(WebAllerteConstants.REGISTRATION_TYPE_CITTADINO.toString())) {
			// Update Expandos Legato a Qualsiasi utente
			updateExpandos(companyId, user, "cittadino", "cittadino", "");
		} 

		return user;

	}

	private void validateUser(String telefono, Date dataNascita) 
			throws PhoneNumberException, ContactBirthdayException {
		
		if (!Validator.isPhoneNumber(telefono)) {
			throw new PhoneNumberException();
		}
		
		long diff = new Date().getTime() - dataNascita.getTime();
		
		long years = (((((diff / 1000) / 60) / 60) / 24) / 365);
		
		if (years < 18) {
			throw new ContactBirthdayException();
		}
		
		
	}

	/*
	 * CARATERIZZIAMO L UTENTE CON I RUOLI NECESSARI
	 */
	private long[] defineUserRoleInContext(long companyId, List<String> roles) {
		logger.info("@ Utente verra caratterizzato con " + roles.size());
		Iterator<String> it = roles.iterator();
		String roleName = null;
		Long roleId = (long) 0;
		long[] roleIds = new long[roles.size()];
		int i = 0;
		while (it.hasNext()) {
			roleName = it.next();
			roleId = getLiferayRoleByName(companyId, roleName);
			roleIds[i] = roleId;
			logger.info("CARATTERIZZAZIONE DEL UTENTE, cerco id ruolo per " + roleName);
			logger.info("IL RUOLO TROVATO HA ID" + roleId);
			i++;
		}

		logger.info("@ NUMERO DI RUOLI TROVATI " + roleIds.length);
		return roleIds;
	}

	/*
	 * DEFINIZIAMO IL SITO DA AGGIUNGERE ALL UTENTE
	 */
	private long[] defineUserSite(long companyId, List<String> sites) throws PortalException, SystemException {
		logger.info("IN defineUserSite");

		long[] organizationIds = null;
		if (sites != null && sites.size() > 0) {
			Iterator<String> it = sites.iterator();
			String actualSiteName = null;

			organizationIds = new long[sites.size()];
			long actualOrgId = 0;

			int i = 0;
			while (it.hasNext()) {
				actualSiteName = it.next();
				logger.info("@ RECUERSITO ATTUALE " + actualSiteName);

				actualOrgId = getSiteByName(companyId, actualSiteName);

				organizationIds[i] = actualOrgId;
				i++;

			}

		}

		return organizationIds;
	}

	/*
	 * RICERCO UN SITO PER NOME, CON DIVERSI TEST SUL NOME STESSO
	 */
	private long getSiteByName(long companyId, String siteName) {
		long case_normal = 0, case_proper = 0, case_camel = 0, actualOrgId = 0;
		case_normal = getLiferaySiteByName(companyId, siteName);
		case_proper = getLiferaySiteByName(companyId, StringUtils.toProperCase(siteName));
		case_camel = getLiferaySiteByName(companyId, StringUtils.toCamelCase(siteName));
		if (case_normal > 0) {
			logger.info("@ SITO ATTUALE RITROVATO CON STRINGA NORMAL");
			actualOrgId = case_normal;
		}
		if (case_proper > 0) {
			logger.info("@ SITO ATTUALE RITROVATO CON STRINGA  PROPER");
			actualOrgId = case_proper;
		}
		if (case_camel > 0) {
			logger.info("@ SITO ATTUALE RITROVATO CON STRINGA  CAMEL");
			actualOrgId = case_camel;
		}
		if (actualOrgId != 0) {
			logger.info("SITO ATTUALE ID" + actualOrgId);
		} else {
			logger.info("impossibile recuperare sito ");
		}
		return actualOrgId;
	}

	/*
	 * GET LIFERAY SITE NAME
	 */
	private Long getLiferaySiteByName(Long companyId, String siteName) {

		Long siteId = 0L;

		logger.info("DATI PERVENUTI PER IL RECUPERO DEL SITO WEB : COMANY ID" + companyId + " NOME SITO" + siteName);

		Group site = null;
		try {
			site = GroupLocalServiceUtil.getGroup(companyId, siteName);
		} catch (PortalException e) {
			logger.info("IMPOSSIBILE RECUPERARE SITO PER " + siteName);
			e.printStackTrace();
		} catch (SystemException e) {
			logger.info("IMPOSSIBILE RECUPERARE SITO PER " + siteName);
			e.printStackTrace();
		}

		if (site != null && site.getLiveGroupId() != 0) {
			siteId = site.getLiveGroupId();
		} else if (site != null) {
			siteId = site.getGroupId();
		}

		return siteId;
	}

	/*
	 * GET LIFERAY ROLE BY NAME
	 */
	private Long getLiferayRoleByName(Long companyId, String roleName) {
		Long roleId = 0L;

		try {
			Role role = RoleLocalServiceUtil.getRole(companyId, roleName);
			roleId = role.getRoleId();
		} catch (PortalException e) {
			logger.error("Impossibile recuperare il nome dal ruolo");
			e.printStackTrace();
		} catch (SystemException e) {
			logger.error("Impossibile recuperare il nome dal ruolo");
			e.printStackTrace();
		}
		return roleId;
	}

	private void updateExpandos(long companyId, User user,String role, 
			String service,String date) throws PortalException, SystemException {

		PermissionChecker permissionCheckerBackup = PermissionThreadLocal.getPermissionChecker();
		PermissionThreadLocal.setPermissionChecker(getAdministratorPermissionChecker(companyId));
		ExpandoBridge expandoBridge = user.getExpandoBridge();
		//expandoBridge.setAttribute(UserExpando.CODICE_FICALE.getName(), user.getCodiceFiscale());
		expandoBridge.setAttribute(UserExpando.ROLE.getName(), role);
		expandoBridge.setAttribute(UserExpando.SERVICE.getName(), service);
		expandoBridge.setAttribute(UserExpando.ENDOFTERMS.getName(), date);
		PermissionThreadLocal.setPermissionChecker(permissionCheckerBackup);
	}

	
	private void updateMobilePhone(User user, long companyId, String telefono)
			throws SystemException, PortalException {
		//List<Phone> phones = new ArrayList<Phone>();
		
		if (Validator.isNotNull(telefono)) {

			if (Validator.isPhoneNumber(telefono)) {
				long phoneId = CounterLocalServiceUtil.increment();
				Phone phone = PhoneLocalServiceUtil.createPhone(phoneId);
				phone.setUserId(user.getUserId());
				phone.setCompanyId(companyId);
				phone.setNumber(telefono);
				phone.setPrimary(true);
				phone.setTypeId(getMobilePhoneTypeId("mobile-phone"));
				PhoneLocalServiceUtil.updatePhone(phone);
				//phones.add(phone);

//				PermissionChecker permissionCheckerBackup = 
//						PermissionThreadLocal.getPermissionChecker();
//				PermissionThreadLocal.setPermissionChecker(
//						getAdministratorPermissionChecker(companyId));

				// Note: Exception will be thrown if we don't set the
				// PrinicpalThreadLocal name.
//				String principalNameBackup = PrincipalThreadLocal.getName();
//				PrincipalThreadLocal.setName(user.getUserId());
//				UsersAdminUtil.crea(Contact.class.getName(), user.getContactId(), phones);
//				PrincipalThreadLocal.setName(principalNameBackup);
//				PermissionThreadLocal.setPermissionChecker(permissionCheckerBackup);
			} else {

				if (!"N/A".equalsIgnoreCase(telefono)) {
					logger.error(
							String.format("Invalid mobilePhone=[%s] for registrant=[%s]", telefono,
							user.getFullName()));
				}
			}
		}
	}
	
	private long getMobilePhoneTypeId(String type) throws SystemException {
		
		List<ListType> phoneTypes = ListTypeServiceUtil
				.getListTypes(ListTypeConstants.CONTACT_PHONE);

		for (ListType phoneType : phoneTypes) {

			if (phoneType.getName().equals(type)) {
				return phoneType.getListTypeId();

			}
		}
		
		return 0;
	}
	
	private PermissionChecker getAdministratorPermissionChecker(long companyId)
			throws PortalException, SystemException {
		PermissionChecker administratorPermissionChecker = null;
		Role administratorRole = RoleLocalServiceUtil.getRole(companyId, RoleConstants.ADMINISTRATOR);
		List<User> administratorUsers = UserLocalServiceUtil.getRoleUsers(administratorRole.getRoleId());

		if ((administratorUsers != null) && (administratorUsers.size() > 0)) {

			User administratorUser = administratorUsers.get(0);
			
			
			try {
				administratorPermissionChecker = PermissionCheckerFactoryUtil
						.getPermissionCheckerFactory()
						.create(administratorUser);
			} catch (Exception e) {
				throw new SystemException(e.getMessage(), e);
			}
		} else {
			throw new SystemException("Unable to find a user with the Administrator role! Impossible!");
		}

		return administratorPermissionChecker;
	}

	
	@Reference
	private UserLocalService userLocalService;

	private Log logger = LogFactoryUtil.getLog(AllertaUserRegistrationService.class);

}
