<%@page import="it.eng.allerter.model.AllertaValanghe"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.liferay.document.library.kernel.model.DLFileEntry"%>
<%@page import="it.eng.bollettino.model.Bollettino"%>
<%@page import="com.liferay.portal.kernel.util.DateFormatFactoryUtil"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="it.eng.allerter.model.Allerta"%>
<%@page import="com.liferay.portal.kernel.workflow.WorkflowTaskManagerUtil"%>
<%@page import="com.liferay.portal.kernel.workflow.WorkflowTask"%>
<%@page import="it.eng.allerta.utils.AllertaKeys"%>
<%@page import="com.liferay.portal.kernel.service.UserGroupRoleLocalServiceUtil"%>
<%@page import="java.io.Serializable"%>
<%@page import="java.util.Map"%>
<%@page import="com.liferay.portal.kernel.model.Group"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.model.Role"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="javax.portlet.PortletRequest"%>
<%@page import="com.liferay.portal.kernel.portlet.PortletURLFactoryUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.PortletKeys"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.util.PropsKeys"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@page import="com.liferay.portal.kernel.model.UserNotificationEvent"%>
<%@page import="java.util.List"%>
<%@page
	import="com.liferay.portal.kernel.notifications.UserNotificationDeliveryType"%>
<%@page
	import="com.liferay.portal.kernel.model.UserNotificationDeliveryConstants"%>
<%@page
	import="com.liferay.portal.kernel.service.UserNotificationEventLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@ include file="./init.jsp"%>

<%
	String fullName = themeDisplay.getUser().getFullName();

	/* int notificationCount = UserNotificationEventLocalServiceUtil.getUserNotificationEventsCount(
			user.getUserId(), PortletKeys.MY_WORKFLOW_TASK, UserNotificationDeliveryConstants.TYPE_WEBSITE, false);
	
	List<UserNotificationEvent> notifications = UserNotificationEventLocalServiceUtil
			.getUserNotificationEvents(user.getUserId(), UserNotificationDeliveryConstants.TYPE_WEBSITE, 
					0, 10);
 */
 
 	long notificationCount = (long) request.getAttribute("notificationCount");
 	List<UserNotificationEvent> notifications = (List<UserNotificationEvent> ) 	request.getAttribute("notifications");
 	
	DateFormat dateFormat = DateFormatFactoryUtil.getSimpleDateFormat("dd/MM/yyyy - HH:mm");
	
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<li class="nav-item dropdown"><a
	class="nav-link dropdown-toggle header__notifications__toggle" href="#"
	role="button" data-toggle="dropdown" data-container="body" id="notifications__toggle__label"
	aria-haspopup="true" aria-expanded="false"> <span
		class="icon i-bell-o" title="Icona delle notifiche"></span> <span
		class="header__notifications__toggle__label"> <span
			class="badge badge-pill badge-danger"><%=notificationCount%></span>
	</span>
</a>

	<div class="dropdown-menu dropdown-menu-right notifications"
		aria-labelledby="notifications__toggle__label" role="menu">
		<h2 class="col-12 notifications__heading">Notifiche</h2>

		<div class="notifications__list">
			
			<%
				
			for(UserNotificationEvent n : notifications) {
				JSONObject payload = JSONFactoryUtil.createJSONObject(n.getPayload());
				
			%>
			
				<portlet:resourceURL var="viewTaskURL" >
					<portlet:param name="cmd" value="read"/>
					<portlet:param name="userNotificationEventId" value="<%=String.valueOf(n.getUserNotificationEventId()) %>"/>
				</portlet:resourceURL>
			
				<div class="p-3">
				
				<%
				String entryClassName = payload.getString("entryClassName");
				Date date = new Date(n.getTimestamp());
				if (entryClassName.equals(Allerta.class.getName()) || 
					entryClassName.equals(Bollettino.class.getName()) ||
					entryClassName.equals(AllertaValanghe.class.getName()) ||
					entryClassName.equals(DLFileEntry.class.getName()) ) {
					
					long workflowTaskId = payload.getLong("workflowTaskId");
					
					PortletURL workflowUrl = 
							PortalUtil.getControlPanelPortletURL(request, 
									PortletKeys.MY_WORKFLOW_TASK, PortletRequest.RENDER_PHASE);
					
					workflowUrl.setParameter("mvcPath", "/edit_workflow_task.jsp");
					workflowUrl.setParameter("workflowTaskId", String.valueOf(workflowTaskId));
					workflowUrl.setParameter("redirect", themeDisplay.getURLCurrent());
					//workflowUrl.setWindowState(WindowState.MAXIMIZED);
					
				%>
				<a href="#" onclick="<portlet:namespace/>readNotification('<%=workflowUrl %>', '<%=viewTaskURL%>')">
						<%=payload.getString("notificationMessage") %> - <%= dateFormat.format(date) %>
					</a>
				<%
				} else {
					
				%>
					
					<a href="#" onclick="<portlet:namespace/>readNotification('', '<%=viewTaskURL%>')">
						<%=payload.getString("notificationMessage") %> - <%= dateFormat.format(date) %>
					</a>
				
				
			<%
				}
				%>
				</div>
				<%
			}
			%>
						
		</div>
	</div></li>
	
	<%
	String lat_k = "latitudine";
	String long_k = "longitudine";
	String area_k = "Area";
	String show = "no";
	String guest_site_k = "guest";
	String sitePath = "/web";

	// VARIABILI IDENTIFICAZIONE RUOLO
	//boolean isAdvancedAdmin = false;
	boolean isSindaco = false;
	boolean isAdministrator = false;
	boolean isTecnico = false;
	boolean isCittadino = false;
	boolean isApprovatore_arpae = false;
	boolean isApprovatore_pc = false;
	boolean isCompilatore_allerta = false;
	boolean isCompilatore_monitoraggio = false;
	boolean isOperatore_comunicazione = false;
	boolean isAmministratore_arpae_rubrica = false;
	boolean userNotification = false;
	boolean isAdminPortale = false;
	boolean isDelegatoTotale = false;
	boolean isDelegatoParziale = false;
	boolean isVerificaAllerte = false;
	
	boolean isCompilatorePC = false;
	boolean isCompilatoreARPAE = false;
	boolean isTecnicoPC = false;

	long idSito = 0;
	int numberSite = 0;
	String siteName = "";

	// GESTIONE DEI RUOLI 
	List<Role> roles = new ArrayList<Role>();
	roles.addAll(user.getRoles());
	Iterator<Role> it = roles.iterator();
	Role actual = null;
	String name;
	// ULTERIORI DATI LEGATI ALL UTENTE
	String urlSite = "";

	// CHIAVI DEI RUOLI 
	String sindaco_k = "SINDACO";
	String administrator_k = "Administrator";
	String tecnico_k = "TECNICO";
	String cittadino_k = "CITTADINO";
	String approvatore_arpae_k = "Approvatore_Arpae";
	String approvatore_pc_k = "Approvatore_Pc";
	String compilatore_allerta_k = "COMPILATORE_ALLERTA";
	String compilatore_monitoraggio_k = "COMPILATORE_MONITORAGGIO";
	String operatore_comunicazione_k = "COMUNICAZIONE";
	String amministratore_rubrica_k = "Amministratore arpae rubrica";
	String admin_portale = "Amministratore portale";
	String delegato_totale = "DELEGATO SINDACO";
	String delegato_parziale_k = "DELEGATO POTERI PARZIALI";
	
	String compilatore_pc_k = "Compilatore PC";
	String compilatore_arpae_k = "Compilatore ARPAE";
	String tecnico_pc_k = "Tecnico PC";
	String verifica_k = "Compilatore Verifica Allerte";
	//String webmaster_k = "webmaster";
	Map<String,String> sindacoLinks = new HashMap<String,String>();

	
	// COSTANTI DEI SITI
	String guest_k = "guest";

	long site_sindaco_role_id = 29574;
	long site_delegato_role_id = 75902;
	long site_delegatoPar_role_id = 75920;

	while (it.hasNext()) {
		actual = it.next();
		name = actual.getName();
		if (name.equalsIgnoreCase(sindaco_k) || name.equalsIgnoreCase(delegato_totale)
				|| name.equalsIgnoreCase(delegato_parziale_k)) {
			//isAdvancedAdmin = true;
			if (name.equalsIgnoreCase(sindaco_k) || name.equalsIgnoreCase(delegato_totale))
				isSindaco = true;

			List<Group> sitiSindaco = user.getMySiteGroups();

			numberSite = sitiSindaco.size();

			Iterator<Group> itSite = sitiSindaco.iterator();
			boolean findSiteSindaco = false;
			Map<String, Serializable> expandoAttribs = null;
			Group sitoAttuale;
			String sname = "";
			while (itSite.hasNext()) {
				sitoAttuale = (Group) itSite.next();
				sname = sitoAttuale.getName();
				if (!sname.equalsIgnoreCase(guest_k)) {

					// controllo se per il sito attuale l utente è il sindaco
					boolean isSindacoInThisSite = (UserGroupRoleLocalServiceUtil
							.hasUserGroupRole(user.getUserId(), sitoAttuale.getGroupId(),
									site_sindaco_role_id)
							|| UserGroupRoleLocalServiceUtil.hasUserGroupRole(user.getUserId(),
									sitoAttuale.getGroupId(), site_delegato_role_id)
							|| UserGroupRoleLocalServiceUtil.hasUserGroupRole(user.getUserId(),
									sitoAttuale.getGroupId(), site_delegatoPar_role_id));

					if (isSindacoInThisSite) {
						siteName = sitoAttuale.getName();
						urlSite = "";
						expandoAttribs = sitoAttuale.getExpandoBridge().getAttributes();
						String lat_ = (String) expandoAttribs.get(lat_k);
						String long_ = (String) expandoAttribs.get(long_k);
						String area = (String) expandoAttribs.get(area_k);
						String geoName = siteName.replaceAll("\\s", "").toUpperCase();
						String url_parameter = "/home";
						//String url_parameter = "/home#geoLoc=" + lat_ + "|" + long_+ "&geoName=" + geoName + "&geoArea=" + area;
						urlSite = sitePath.concat(sitoAttuale.getFriendlyURL());
						urlSite = urlSite.concat(url_parameter);
						findSiteSindaco = true;
						sindacoLinks.put(siteName,urlSite);
					}
				}

			}
		}
		if (name.equalsIgnoreCase(administrator_k))
			isAdministrator = true;
		if (name.equalsIgnoreCase(tecnico_k))
			isTecnico = true;
		if (name.equalsIgnoreCase(cittadino_k))
			isCittadino = true;
		else
			userNotification = true;
		if (name.equalsIgnoreCase(approvatore_arpae_k))
			isApprovatore_arpae = true;
		if (name.equalsIgnoreCase(approvatore_pc_k))
			isApprovatore_pc = true;
		if (name.equalsIgnoreCase(compilatore_allerta_k))
			isCompilatore_allerta = true;
		if (name.equalsIgnoreCase(compilatore_monitoraggio_k))
			isCompilatore_monitoraggio = true;
		if (name.equalsIgnoreCase(operatore_comunicazione_k))
			isOperatore_comunicazione = true;
		if (name.equalsIgnoreCase(compilatore_pc_k))
			isCompilatorePC = true;
		if (name.equalsIgnoreCase(compilatore_arpae_k))
			isCompilatoreARPAE = true;
		if (name.equalsIgnoreCase(tecnico_pc_k))
			isTecnicoPC = true;
		if (name.equalsIgnoreCase(verifica_k))
			isVerificaAllerte = true;
		//if (name.equalsIgnoreCase(webmaster_k)) {
		//	isWebmaster = true;
		//}
		if (name.equalsIgnoreCase(amministratore_rubrica_k))
			isAmministratore_arpae_rubrica = true;

		if (name.equalsIgnoreCase(admin_portale))
			isAdminPortale = true;
		if (name.equalsIgnoreCase(delegato_parziale_k)) {
			isDelegatoParziale = true;
		}

	}
	%>


<li class="nav-item dropdown"><a
	class="nav-link dropdown-toggle header__personal-nav__toggle" href="#"
	role="button" data-toggle="dropdown" data-container="body" window
	aria-haspopup="true" aria-expanded="false"> <span
		class="icon i-user-circle-o"
		title="Icona che rappresenta il tuo menu personale"></span> <span
		class="d-none d-md-inline-block d-print-inline-block header__personal-nav__toggle__label"
		id="personal-menu__label"><%=fullName%></span>
</a>

	<div class="dropdown-menu dropdown-menu-right personal-menu"
		aria-labelledby="personal-menu__label" role="menu">
		<h2 class="col-12 personal-menu__heading"><%=fullName%></h2>

		<nav role="navigation" class="nav-vertical">
			<ul class="nav flex-column">
			
				<% for (String sindacoLink : sindacoLinks.keySet()) {
					%><li class="nav-item">
						<a class="nav-link " href="<%=sindacoLinks.get(sindacoLink)%>"> <span
							class="icon i-tree" title="Vai a <%=sindacoLink%>"></span> <span
							class="nav-vertical__item-label">Vai a <%=sindacoLink%></span>
						</a>
					</li><%
				}
				%>
				<c:if test="<%=false && (isSindaco || isDelegatoParziale)%>">
					<li class="nav-item">
						<a class="nav-link " href="<%=urlSite%>"> <span
							class="icon i-tree" title="Il tuo comune"></span> <span
							class="nav-vertical__item-label">Il tuo comune</span>
						</a>
					</li>
				
				</c:if>
				
					
				<c:if
					test="<%=false && (isAdministrator || isApprovatore_arpae || isApprovatore_pc
										|| isCompilatore_allerta || isCompilatore_monitoraggio || isAdminPortale)%>">
					
					<%
					PortletURL workflowUrl = 
					PortalUtil.getControlPanelPortletURL(request, 
							PortletKeys.MY_WORKFLOW_TASK, PortletRequest.RENDER_PHASE);
			
						workflowUrl.setParameter("redirect", themeDisplay.getURLCurrent());
						workflowUrl.setWindowState(WindowState.MAXIMIZED);
		
					%>
					
					<li class="nav-item">
						<a class="nav-link " href="<%=workflowUrl%>"> <span
							class="icon i-tasks" title="Richieste per me"></span> <span
							class="nav-vertical__item-label">Richieste per me</span>
						</a>
					</li>
					
					<%
					 workflowUrl = 
						PortalUtil.getControlPanelPortletURL(request, 
								PortletKeys.MY_WORKFLOW_TASK, PortletRequest.RENDER_PHASE);
				
							workflowUrl.setParameter("tabs1", "assigned-to-my-roles");
							workflowUrl.setParameter("redirect", themeDisplay.getURLCurrent());
							workflowUrl.setWindowState(WindowState.MAXIMIZED);
					%>
					<li class="nav-item">
						<a class="nav-link " href="<%=workflowUrl%>"> <span
							class="icon i-tasks" title="Le richieste a me assegnate"></span> <span
							class="nav-vertical__item-label">Le richieste a me assegnate</span>
						</a>
					</li>
					
					
				</c:if>
				
				<c:if test="<%=isAdministrator || isAdminPortale %>">
					<li class="nav-item">
						<a class="nav-link " href="/cruscotto"> <span
							class="icon i-dashboard" title="Cruscotto eventi"></span> <span
							class="nav-vertical__item-label">Cruscotto eventi</span>
						</a>
					</li>
				</c:if>
				
				<c:if test="<%=isAdministrator || isOperatore_comunicazione%>">
			
					<li class="nav-item">
						<a class="nav-link " href="/comunicazioni"> <span
							class="icon i-bullhorn" title="Comunicazione"></span> <span
							class="nav-vertical__item-label">Comunicazione</span>
						</a>
					</li>
					
				</c:if>
				
				<c:if test="<%=isAdministrator || isAmministratore_arpae_rubrica || isAdminPortale || isSindaco || isDelegatoTotale %>">
				
					<li class="nav-item">
						<a class="nav-link " href="/gestione-utenza"> <span
							class="icon i-users" title="Gestione Utenza e Rubriche"></span> <span
							class="nav-vertical__item-label">Gestione Utenza e Rubriche</span>
						</a>
					</li>
					
				
				</c:if>
				
				<c:if
					test="<%=isAdministrator || isCompilatore_allerta || isTecnico || isCompilatore_monitoraggio || isSindaco || isDelegatoTotale || isDelegatoParziale || isCompilatorePC || isCompilatoreARPAE || isTecnicoPC %>">
					
					<li class="nav-item">
						<a class="nav-link " href="/sensori"> 
						  <span	class="icon i-bar-chart" title="Sensori per l'allertamento"></span> 
							<span class="nav-vertical__item-label">Sensori </span>
						</a>
					</li>
					
					
		
				</c:if>
				
				<c:if
					test="<%=isAdministrator || isCompilatore_allerta || isCompilatore_monitoraggio || isAdminPortale %>">
					
				<li class="nav-item">
						<a class="nav-link " href="/allarme"> 
						  <span	class="icon i-flag" title="Regole Allarmi"></span> 
							<span class="nav-vertical__item-label">Regole superamenti</span>
						</a>
					</li>
				</c:if>
				
				<c:if
					test="<%=isAdministrator || isCompilatore_allerta || isCompilatore_monitoraggio  || isCompilatoreARPAE %>">
					
					
					
					<%
					long allertaPlid = PortalUtil.getPlidFromPortletId(scopeGroupId, false, 
							AllertaKeys.AllertaCompilaSbPortlet); 
					
					PortletURL allertaUrl = PortletURLFactoryUtil.create(request, 
							AllertaKeys.AllertaCompilaSbPortlet, allertaPlid, 
							PortletRequest.RENDER_PHASE);
					allertaUrl.setParameter("mvcRenderCommandName", "/allertaer/allerta/compila");
					
					long valanghePlid = PortalUtil.getPlidFromPortletId(scopeGroupId, false, 
							AllertaKeys.AllertaValangheCompilaSbPortlet); 
					
					PortletURL valangheUrl = PortletURLFactoryUtil.create(request, 
							AllertaKeys.AllertaValangheCompilaSbPortlet, valanghePlid, 
							PortletRequest.RENDER_PHASE);
					allertaUrl.setParameter("mvcRenderCommandName", "/allertaer/allerta_valanghe/compila");
					
					%>
					<li class="nav-item">
						<a class="nav-link " href="<%=allertaUrl%>"> <span
							class="icon i-files-o" title="Crea
								allerte e bollettini"></span> <span
							class="nav-vertical__item-label">Crea allerte e bollettini</span>
						</a>
					</li>
					
					<li class="nav-item">
						<a class="nav-link " href="<%=valangheUrl%>"> <span
							class="icon i-files-o" title="Crea
								documenti valanghe"></span> <span
							class="nav-vertical__item-label">Crea documenti valanghe</span>
						</a>
					</li>
					
					<li class="nav-item">
						<a class="nav-link " href="/gestione-monitoraggio"> <span
							class="icon i-files-o" title="Mappa Monitoraggio"></span> 
							<span class="nav-vertical__item-label">Mappa Monitoraggio</span>
						</a>
					</li>
					
		
				</c:if>
				
				
				<c:if test="<%=isAdministrator || isCompilatore_monitoraggio || isCompilatoreARPAE %>">
				
					<li class="nav-item">
						<a class="nav-link " href="/monitoraggio-eventi"> <span
							class="icon i-files-o" title="Crea
								doc. di monitoraggio"></span> <span
							class="nav-vertical__item-label">Crea doc. di monitoraggio</span>
						</a>
					</li>
					
					<li class="nav-item">
						<a class="nav-link " href="/preferenze-monitoraggio"> <span
							class="icon i-files-o" title="Idrometri
								Monitoraggio"></span> <span
							class="nav-vertical__item-label">Idrometri Monitoraggio</span>
						</a>
					</li>
					
				</c:if>
				
				<c:if
					test="<%=isAdministrator || isCompilatore_allerta || isCompilatore_monitoraggio || isTecnico || isCompilatorePC || isCompilatoreARPAE || isTecnicoPC %>">
				<li class="nav-item">
						<a class="nav-link " href="/elenco-superamenti"> <span
							class="icon i-umbrella" title="Elenco superamenti"></span> <span
							class="nav-vertical__item-label">Elenco superamenti</span>
						</a>
					</li>
				</c:if>
				
				<c:if
					test="<%=isAdministrator || isCompilatorePC || isCompilatoreARPAE || isApprovatore_arpae || isApprovatore_pc  %>">
				<li class="nav-item">
						<a class="nav-link " href="/briefing"> <span
							class="icon i-file-o" title="Briefing allerta"></span> <span
							class="nav-vertical__item-label">Briefing allerta</span>
						</a>
					</li>
				</c:if>
				
				<c:if
					test="<%=isAdministrator || isCompilatore_allerta || isCompilatore_monitoraggio || isCompilatorePC || isCompilatoreARPAE %>">

					

					<li class="nav-item">
						<a class="nav-link " href="/sms2"> <span
							class="icon i-inbox" title="Report invii"></span> <span
							class="nav-vertical__item-label">Report invii</span>
						</a>
					</li>
					
				</c:if>
				
				<c:if
					test="<%=isAdministrator || isCompilatore_allerta || isCompilatore_monitoraggio  || isCompilatorePC %>">
					
					<li class="nav-item">
						<a class="nav-link " href="/sms"> <span
							class="icon i-inbox" title="Report invii analitico"></span> <span
							class="nav-vertical__item-label">Report invii analitico</span>
						</a>
					</li>
				</c:if>
				
				<c:if
					test="<%=isAdministrator || isAdminPortale || isVerificaAllerte %>">
					
					<li class="nav-item">
						<a class="nav-link " href="/verifica"> <span
							class="icon i-files-o" title="Verifica allerte"></span> <span
							class="nav-vertical__item-label">Verifica allerte</span>
						</a>
					</li>
					
					<li class="nav-item">
						<a class="nav-link " href="/catasto-segnalazioni"> <span
							class="icon i-files-o" title="Catasto segnalazioni"></span> <span
							class="nav-vertical__item-label">Catasto segnalazioni</span>
						</a>
					</li>
				</c:if>
				
				<c:if
					test="<%=isAdministrator || isCompilatore_allerta || isCompilatore_monitoraggio  || isCompilatoreARPAE %>">
							
					<li class="nav-item">
						<a class="nav-link " href="/archivio-report-post-evento"> <span
							class="icon i-files-o" title="Report post evento"></span> <span
							class="nav-vertical__item-label">Report post
								evento</span>
						</a>
					</li>
				
				</c:if>
				
				<c:if
					test="<%=isAdministrator || isCompilatore_allerta || isCompilatore_monitoraggio  %>">
					
						
					<li class="nav-item">
						<a class="nav-link " href="/meteomont"> <span
							class="icon i-files-o" title="Documento meteomont"></span> <span
							class="nav-vertical__item-label">Documento
								meteomont</span>
						</a>
					</li>
					
					
				</c:if>
				
				<c:if test="<%=isAdministrator || isAdminPortale || isTecnico || isSindaco || isDelegatoTotale || isDelegatoParziale || isOperatore_comunicazione || isCompilatorePC || isTecnicoPC %>">
			
					<li class="nav-item">
						<a class="nav-link " href="/documenti-allertameteoer"> <span
							class="icon i-comment" title="Documenti AllertaMeteoER"></span> <span
							class="nav-vertical__item-label">Documenti AllertaMeteoER</span>
						</a>
					</li>
					
				</c:if>
				
				
				<c:if
					test="<%=isAdministrator || isCompilatore_allerta
										|| isCompilatore_monitoraggio || isCompilatorePC %>">
						<%
						long comunicazionePlid = PortalUtil.getPlidFromPortletId(scopeGroupId, 
								AllertaKeys.AllertaMessaggioSindacoPortlet );
						%>
							<liferay-portlet:renderURL plid="<%=comunicazionePlid %>"
								portletName="<%= AllertaKeys.AllertaMessaggioSindacoPortlet%>"
								 var="comunicazioneURL">
								 <portlet:param name="new" value="1"/>
								</liferay-portlet:renderURL>
								
					<li class="nav-item">						
						<a class="nav-link" href="<%=comunicazioneURL%>"> <span
							class="icon i-bullhorn" title="Invia un Messaggio"></span> <span
							class="nav-vertical__item-label">Prepara e invia la comunicazione</span>
						</a>
					</li>
								
				</c:if>
				
				<c:if test="<%=isAdministrator || isAdminPortale %>">
					<li class="nav-item">
						<a class="nav-link " href="/elenco-cittadini"> <span
							class="icon i-user" title="Elenco cittadini"></span> <span
							class="nav-vertical__item-label">Elenco cittadini</span>
						</a>
					</li>
				</c:if>
				
				
				<li class="nav-item">
					<a class="nav-link " href="<%=themeDisplay.getURLMyAccount()%>"> <span
						class="icon i-cogs" title="Il mio account"></span> <span
						class="nav-vertical__item-label">Il mio account</span>
					</a>
				</li>
		
				<li class="nav-item"><a class="nav-link "
					href="<%=themeDisplay.getURLSignOut()%>"> <span class="icon i-sign-out"
						title=""></span> <span class="nav-vertical__item-label">Esci</span>
				</a></li>
			</ul>
		</nav>
	</div></li>
	
<%-- <aui:script>
	Liferay.delegateClick(
		'comunicazioneAnchor',
		function(event) {
			Liferay.Util.openInDialog(
				event,
				{
					dialogIframe: {
						bodyCssClass: 'dialog-with-footer',
						destroyOnClose:true
					}
				}
			);
		}
	);

</aui:script> --%>
	
<script type="text/javascript">

function <portlet:namespace/>openComunicazionePopup(renderUrl) {
	Liferay.Util.openWindow(
		{
			dialog: {
				width: 960,
				modal:false,
				centered: true,
				destroyOnClose: true,
				destroyOnHide: true,
			},
			uri: renderUrl,
			title: 'Comunicazioni',
			id: '<portlet:namespace/>openComunicazionePopup',
			
		}
	);
	
}

function <portlet:namespace/>readNotification(wflUrl, serviceUrl) {
	jQuery.ajax({
	      url: serviceUrl,
	      method: 'GET',
	      success: function(result) {
	    		
	    		location.href = wflUrl;
	    	}
	     
	    });
}

</script>
