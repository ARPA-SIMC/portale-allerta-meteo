<%@page import="com.liferay.site.navigation.service.SiteNavigationMenuItemLocalService"%>
<%@page import="it.eng.allerta.utils.AllertaTracker"%>
<%@page import="com.liferay.site.navigation.type.SiteNavigationMenuItemTypeRegistry"%>
<%@page import="com.liferay.site.navigation.type.SiteNavigationMenuItemType"%>
<%@page import="java.util.LinkedList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.site.navigation.service.SiteNavigationMenuItemLocalServiceUtil"%>
<%@page import="com.liferay.site.navigation.model.SiteNavigationMenuItem"%>
<%@page import="com.liferay.site.navigation.model.SiteNavigationMenu"%>
<%@page import="com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil"%>
<%@page import="com.liferay.asset.kernel.model.AssetEntry"%>
<%@page import="com.liferay.asset.kernel.service.AssetCategoryLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.Layout"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.model.Role"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.liferay.portal.kernel.service.RoleLocalServiceUtil"%>
<%@ include file="../init.jsp"%>

<%

SiteNavigationMenuItemTypeRegistry siteNavigationMenuItemTypeRegistry = 
	AllertaTracker.getService(SiteNavigationMenuItemTypeRegistry.class);

SiteNavigationMenu menu = (SiteNavigationMenu )renderRequest.getAttribute("menu");

if (menu == null)
	return;

SiteNavigationMenuItemLocalService siteNavigationMenuItemLocalService =
		AllertaTracker.getService(SiteNavigationMenuItemLocalService.class);

List<SiteNavigationMenuItem> menuItems = siteNavigationMenuItemLocalService
	.getSiteNavigationMenuItems(menu.getSiteNavigationMenuId(), 0);


if (menuItems.size() == 0)
	return;



%>

<style>
 .am .main-nav .nav-link .icon {
 background: none !important;
 }
 
 .am .main-nav .nav-item .nav .nav-item .nav-link:hover {
 	background: #DBF2FF !important;
 }
</style>

<div class="skipnav">
	<a href="#main-content" class="skip">Salta al contenuto della pagina</a>
</div>
       
<!-- Menu principale -->
<nav role="navigation" class="main-nav">

    <ul class="nav flex-column ">
    
       
    
		<li class="nav-item">
            <a class="nav-link active" href="/" title="Home">
                <span class="icon i-home" aria-hidden="true"></span>
                <span class="main-nav__nav-item__label">
                    Home
                </span>
            </a>
        </li>
    	<%
    	
    	User u = null;
    	List<Role> roles = null;
    	try {
			u = PortalUtil.getUser(request);
			if (u!=null) roles = RoleLocalServiceUtil.getUserRoles(u.getUserId());
		} catch (Exception e) {}
    	
    	for (SiteNavigationMenuItem menuItem : menuItems) {
    		SiteNavigationMenuItemType menuType = 
    				siteNavigationMenuItemTypeRegistry.getSiteNavigationMenuItemType(menuItem);
    		
    		Layout l = menuType.getLayout(menuItem);
    		boolean seeLink = true;
    		
    		if (l!=null && l.getExpandoBridge().hasAttribute("Roles")  && 
    				l.getExpandoBridge().getAttribute("Roles")!=null &&
    				!"".equals(l.getExpandoBridge().getAttribute("Roles"))) {
    			
    	
    			
    			seeLink = false;
    			String abilitati = l.getExpandoBridge().getAttribute("Roles").toString();
    			String[] roleList = abilitati.split(",");
    			if (roleList.length==0) seeLink = true;
    			else {
    				for (String r : roleList) {
						try {
    						long idRuolo = Long.parseLong(r);
    						if (roles!=null) {
    							for (Role rr : roles) {
    								if (rr.getRoleId()==idRuolo || rr.getRoleId()==20161) seeLink = true;
    							}
    						}
						} catch (Exception exx) {}
    				}
    				
    			}
    		}
    		
    		if (!seeLink) continue;
    		
    	%>
    		         	
        	<li class="nav-item">
            	<a class="nav-link " href="<%= l != null ? l.getFriendlyURL(locale) : "#"%>" 
            		title="<%= l != null ? l.getName(locale) : menuType.getLabel(locale)%>">
            		
            	<%if( l != null && l.getExpandoBridge().hasAttribute("Icon")) {%>
                <span class='icon <%= l != null ? l.getExpandoBridge().getAttribute("Icon") : "" %>' aria-hidden="true"></span>
                <% } %>
                <span class="main-nav__nav-item__label">
                   <%= l != null ? l.getName(locale) : menuType.getTitle(menuItem, locale)%>
                    	<span class="main-nav__nav-item__label__lead">
                    		<%= l != null ? l.getDescription(locale) : "" %>
                    	</span>                
                	</span>
            	</a>
            	
            	<%
            	List<SiteNavigationMenuItem> subMenuItems = 
            				siteNavigationMenuItemLocalService
            						.getSiteNavigationMenuItems(
            									menu.getSiteNavigationMenuId(), 
            									menuItem.getSiteNavigationMenuItemId()
            							);
            	
            	%>
            	
            	<c:if test="<%=subMenuItems.size() > 0 %>">
            		<ul class="nav">
            	 	<%
            		for(SiteNavigationMenuItem subMenuItem : subMenuItems) {
            			
            			SiteNavigationMenuItemType subMenuType = 
                				siteNavigationMenuItemTypeRegistry.getSiteNavigationMenuItemType(subMenuItem);

            			l = null;
            			
            			if (subMenuItem.getType().equals("layout")) {
            				 l = subMenuType.getLayout(subMenuItem);
            			}
            			
            			if (l!=null && l.getExpandoBridge().hasAttribute("Roles")  && 
                				l.getExpandoBridge().getAttribute("Roles")!=null &&
                				!"".equals(l.getExpandoBridge().getAttribute("Roles"))) {
                			
                	
                			
                			seeLink = false;
                			String abilitati = l.getExpandoBridge().getAttribute("Roles").toString();
                			String[] roleList = abilitati.split(",");
                			if (roleList.length==0) seeLink = true;
                			else {
                				for (String r : roleList) {
            						try {
                						long idRuolo = Long.parseLong(r);
                						if (roles!=null) {
                							for (Role rr : roles) {
                								if (rr.getRoleId()==idRuolo || rr.getRoleId()==20161) seeLink = true;
                							}
                						}
            						} catch (Exception exx) {}
                				}
                				
                			}
                		}
                		
                		if (!seeLink) continue;
            			
            			List<SiteNavigationMenuItem> subSubMenuItems = 
            						siteNavigationMenuItemLocalService
            							.getSiteNavigationMenuItems(
            									menu.getSiteNavigationMenuId(), 
                        						subMenuItem.getSiteNavigationMenuItemId()
                        					);
            			
                		
            			%>
            				<li class="nav-item">
                    			<a 
                    				class="nav-link <%=subSubMenuItems.size() > 0 ? "nav-link--has-submenu" : ""%>" 
                    				style="<%=subSubMenuItems.size() == 0 ? "padding: 0.75rem 3.3rem 0.75rem;" : "" %>"
                    				href="<%=subSubMenuItems.size() == 0 ? (l != null ? l.getFriendlyURL(locale) : "#") : "" %>"
                    				title="<%=l != null ? l.getName(locale) : subMenuType.getTitle(subMenuItem, locale)%>">
                    				
                    				<c:choose>
	                    				<c:when test="<%=subSubMenuItems.size() > 0 %>">
	                            			<span class="icon i-plus-square-o icon-expand" title="Espandi" aria-hidden="false"></span>
	                            			<span class="icon i-minus-square-o icon-collapse" title="Richiudi" aria-hidden="true"></span>
	                        			</c:when>
	                        			<c:otherwise>
	                        				<span class="icon icon-collapse icon-expand"></span>
	                        			</c:otherwise>
                        			</c:choose>
                        			
                        			<span><%= l != null ? l.getName(locale) : subMenuType.getTitle(subMenuItem, locale)%></span>
                    			</a>
                    		

            		<c:if test="<%=subSubMenuItems.size() > 0 %>">
            			<ul class="nav">
                        	
            				<%
            		for(SiteNavigationMenuItem subSubMenuItem : subSubMenuItems) {
            			SiteNavigationMenuItemType subSubMenuType = 
                				siteNavigationMenuItemTypeRegistry.getSiteNavigationMenuItemType(subSubMenuItem);
            			
            			if(subSubMenuType.hasPermission(permissionChecker, subSubMenuItem) ) {

                		l = subSubMenuType.getLayout(subSubMenuItem);
                		
                		if (l!=null && l.getExpandoBridge().hasAttribute("Roles")  && 
                				l.getExpandoBridge().getAttribute("Roles")!=null &&
                				!"".equals(l.getExpandoBridge().getAttribute("Roles"))) {
                			
                	
                			
                			seeLink = false;
                			String abilitati = l.getExpandoBridge().getAttribute("Roles").toString();
                			String[] roleList = abilitati.split(",");
                			if (roleList.length==0) seeLink = true;
                			else {
                				for (String r : roleList) {
            						try {
                						long idRuolo = Long.parseLong(r);
                						if (roles!=null) {
                							for (Role rr : roles) {
                								if (rr.getRoleId()==idRuolo || rr.getRoleId()==20161) seeLink = true;
                							}
                						}
            						} catch (Exception exx) {}
                				}
                				
                			}
                		}
                		
                		if (!seeLink) continue;
                		
            			%>
            			 	<li class="nav-item">
                            <a class="nav-link" href="<%=l != null ? l.getFriendlyURL(locale) : "#" %>" 
                            	title="<%=l != null ?l.getName(locale) : subSubMenuType.getTitle(subSubMenuItem, locale)%>">
                                <span><%= l != null ?l.getName(locale) : subSubMenuType.getTitle(subSubMenuItem, locale)%></span>
                            </a>
                        </li>
                        <%
            				}
                        } 
                        %>
                        </ul>
            			
            			</c:if>
            			
            		
                    	</li>
                    <%
                    }
            		%>
            		
            		
                    </ul> 
				</c:if>
				
        	</li>
        	
        <%
        }
        %>

    </ul>
</nav>

