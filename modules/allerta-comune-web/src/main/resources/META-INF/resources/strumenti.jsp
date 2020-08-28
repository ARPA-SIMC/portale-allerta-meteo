<%@page import="com.liferay.portal.kernel.service.UserGroupRoleLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="com.liferay.portal.kernel.model.Group"%>
<%@page import="it.eng.allerter.allerta.UserBean"%>
<%@page import="it.eng.allerter.allerta.LoginBean"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="javax.portlet.PortletRequest"%>
<%@page import="com.liferay.portal.kernel.portlet.PortletURLFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="it.eng.allerta.utils.AllertaKeys"%>
<%@page import="com.liferay.portal.kernel.service.RoleLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.Role"%>

<%@ include file="./init.jsp"%>

<%

if ( themeDisplay.isSignedIn()) {
	
	long site_sindaco_role_id = 29574;
	long site_delegato_role_id = 75902;
	long site_delegatoPar_role_id = 75920;
	
	Group site = themeDisplay.getSiteGroup();
	
	if (UserGroupRoleLocalServiceUtil
			.hasUserGroupRole(user.getUserId(), site.getGroupId(), site_sindaco_role_id)
			|| 
		UserGroupRoleLocalServiceUtil
			.hasUserGroupRole(user.getUserId(),	site.getGroupId(), site_delegato_role_id)
			|| 
		UserGroupRoleLocalServiceUtil
			.hasUserGroupRole(user.getUserId(),	site.getGroupId(), site_delegatoPar_role_id)); {
		
		LoginBean lbean = new LoginBean(themeDisplay);
		UserBean ub = lbean.getComuneSindaco();
		
		String userSiteName = ub.getName();
		
		Iterator<Role> r= themeDisplay.getUser().getRoles().iterator();
		
		while(r.hasNext()) {
			Role rr = (Role)r.next();
			System.out.println( rr.getName());
		}
		
		String comune = site.getName();
		
		String siteUrl = themeDisplay.getPortalURL() + themeDisplay.getPathFriendlyURLPublic() + themeDisplay.getScopeGroup().getFriendlyURL();
%>

<liferay-portlet:renderURL portletName="<%= AllertaKeys.AllertaMessaggioSindacoPortlet%>" var="myPortletURL"
windowState="<%=LiferayWindowState.POP_UP.toString()%>" portletMode="VIEW">

</liferay-portlet:renderURL>


<div class="page--comune">
<div class="page--comune__reserved-tools">
   <div class="container">
       <div class="row">
           <div class="col-12">
               <div class="panel panel--foreground panel--reserved-tools">
                   <h2 class="panel__heading">Strumenti per gestire il tuo comune</h2>
                   <div class="row panel__body">
                       <div class="col-12">
                           <div class="panel--reserved-tools__actions pt-2">
                           <%if( 
                        		   UserLocalServiceUtil.hasRoleUser(20161, user.getUserId()) //Administrator
                        		   
                        		   ||
                        		   
									UserLocalServiceUtil.hasRoleUser(168321, user.getUserId()) //Amministratore portale
                        		   
                        		   ||
                        		UserGroupRoleLocalServiceUtil
                        					.hasUserGroupRole(user.getUserId(), site.getGroupId(), site_sindaco_role_id) 
                        			||
                        		UserGroupRoleLocalServiceUtil
                        					.hasUserGroupRole(user.getUserId(), site.getGroupId(), site_delegato_role_id) ) {
                            %>
                               <a class="btn btn-secondary" id="sendMessagge" data-toggle="modal" data-target="#modal-send-message">
                                   <span class="icon i-envelope" title="Icona messaggio"></span>
                                   <span class="nav-vertical__item-label">Invia un messaggio</span>
                               </a>    
                               <a class="btn btn-secondary" href="<%=siteUrl%>/aggiornamenti-del-comune">
                                   <span class="icon i-message" title="Icona notizia"></span>
                                   <span class="nav-vertical__item-label">Pubblica un aggiornamento dal tuo comune</span>
                               </a>    
                            <%} %>
                               <a class="btn btn-secondary" href="<%=siteUrl%>/piano-di-protezione-civile">
                                   <span class="icon i-map" title="Icona ingranaggio"></span>
                                   <span class="nav-vertical__item-label">Gestisci documenti</span>
                               </a> 
                           </div>
                       </div>
                   </div>
                   <div class="row panel__footer"></div> 
               </div>                            
			</div>
        </div>
        
		<div class="modal modal-send-message" tabindex="-1" role="dialog" id="modal-send-message">
             <div class="modal-dialog modal-xxl" role="document">
                 <div class="modal-content" style="min-height: 800px !important;">
                     <div class="modal-header">
                         <h5 class="modal-title"> Invia un messaggio </h5>
                         <button type="button" class="close" data-dismiss="modal" aria-label="Chiudi">
                              <span class="icon i-close" title="Icona del bottone che chiude la finestra modale"></span> 
                         </button>
                     </div>
                     <div class="modal-body">
	                     <iframe src="/messaggio-ai-cittadini" frameborder="0" allowtransparency="true" width="100%" style="min-height: 800px;">
	                     </iframe>
                     </div>
                 </div>
             </div>
         </div>  
    </div>
</div>
</div>


<%	
	}
 }%>