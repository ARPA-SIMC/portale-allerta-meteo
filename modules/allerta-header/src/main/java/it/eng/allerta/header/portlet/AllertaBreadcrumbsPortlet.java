package it.eng.allerta.header.portlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.LayoutLocalServiceUtil;
import com.liferay.portal.kernel.theme.NavItem;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import it.eng.allerta.utils.AllertaKeys;

@Component(
		immediate = true, 
		property = { 
		"com.liferay.portlet.display-category=" + AllertaKeys.AllertaCategory,
		"com.liferay.portlet.instanceable=false", 
		"javax.portlet.display-name=Breadcrumbs", 
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/breadcrumbs.jsp", 
		"javax.portlet.name=" + AllertaKeys.AllertaBreadcrumbsPortlet,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" 
		}, 
		service = Portlet.class
		)
public class AllertaBreadcrumbsPortlet extends MVCPortlet {
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		
		List<NavItem> navItems = new ArrayList<NavItem>();
	
		 try {
			 navItems = getBranchNavItems(PortalUtil.getHttpServletRequest(renderRequest));
		 } catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 }
		 
		 renderRequest.setAttribute("navItems", navItems);
		 
		 
		 ThemeDisplay themeDisplay = (ThemeDisplay)PortalUtil.getHttpServletRequest(renderRequest).getAttribute(
					WebKeys.THEME_DISPLAY);

				Layout layout = themeDisplay.getLayout();
		 long scope = PortalUtil.getScopeGroupId(layout);
		 
		 try {
		 if (scope>0 && scope!=20194 && scope!=20181) {
				Group g = GroupLocalServiceUtil.getGroup(scope);
				if (g.getSite()) {
					renderRequest.setAttribute("siteUrl", "/web"+g.getFriendlyURL());
					renderRequest.setAttribute("siteName", g.getName());
				}
			}
		 } catch (PortalException e) {}
		
		 super.render(renderRequest, renderResponse);
	}
	
	protected List<NavItem> getBranchNavItems(HttpServletRequest request)
			throws PortalException {

			ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
				WebKeys.THEME_DISPLAY);

			Layout layout = themeDisplay.getLayout();
			
			long scope = PortalUtil.getScopeGroupId(layout);
			List<NavItem> navItems = new ArrayList<>();
			
			

			if (layout.isRootLayout()) {
				navItems.add(new NavItem(request, themeDisplay, layout, null));
				return navItems;
			}

			List<Layout> ancestorLayouts = layout.getAncestors();

			

			ListIterator<Layout> listIterator = ancestorLayouts.listIterator(
				ancestorLayouts.size());

			while (listIterator.hasPrevious()) {
				Layout ancestorLayout = listIterator.previous();

				navItems.add(
					new NavItem(request, themeDisplay, ancestorLayout, null));
			}	
			
			//navItems.add(new NavItem(request, themeDisplay, layout, null));
			layout.setName(layout.getName(Locale.ITALIAN));
			navItems.add(new NavItem(request, themeDisplay, layout, null));

			return navItems;
		}

	

}
