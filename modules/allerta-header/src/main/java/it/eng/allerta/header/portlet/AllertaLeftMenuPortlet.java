package it.eng.allerta.header.portlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.GroupConstants;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.site.navigation.constants.SiteNavigationConstants;
import com.liferay.site.navigation.model.SiteNavigationMenu;
import com.liferay.site.navigation.model.SiteNavigationMenuItem;
import com.liferay.site.navigation.service.SiteNavigationMenuItemLocalService;
import com.liferay.site.navigation.service.SiteNavigationMenuLocalService;
import com.liferay.site.navigation.type.SiteNavigationMenuItemType;
import com.liferay.site.navigation.type.SiteNavigationMenuItemTypeRegistry;

import it.eng.allerta.utils.AllertaKeys;
import it.eng.allerta.utils.AllertaTracker;

@Component(
		immediate = true, 
		property = { 
				"com.liferay.portlet.display-category=" + AllertaKeys.AllertaCategory,
				"com.liferay.portlet.instanceable=false", 
				"com.liferay.portlet.footer-portlet-javascript=/js/search.js",
				"com.liferay.portlet.css-class-wrapper=main-nav",
				"javax.portlet.display-name=Header", 
				"javax.portlet.init-param.template-path=/left-nav/",
				"javax.portlet.init-param.view-template=/left-nav/view.jsp",
				"javax.portlet.name=" + AllertaKeys.AllertaLeftMenuPortlet, 
				"javax.portlet.resource-bundle=content.Language",
				"javax.portlet.security-role-ref=power-user,user" 
		}, 
		service = Portlet.class
)
public class AllertaLeftMenuPortlet extends MVCPortlet {

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		try {

			HttpServletRequest request = portal.getHttpServletRequest(renderRequest);

			renderRequest.setAttribute("homeUrl", portal.getHomeURL(request));

			SiteNavigationMenu menu = 
						siteNavigationMenuLocalService
								.fetchSiteNavigationMenu(
										GroupLocalServiceUtil.getGroup(
													PortalUtil.getDefaultCompanyId(), GroupConstants.GUEST).getGroupId(), 
										SiteNavigationConstants.TYPE_PRIMARY
						);

			/*
			SiteNavigationMenuItemLocalService siteNavigationMenuItemLocalService =
					AllertaTracker.getService(SiteNavigationMenuItemLocalService.class);
			List<SiteNavigationMenuItem> menuItems = siteNavigationMenuItemLocalService
					.getSiteNavigationMenuItems(menu.getSiteNavigationMenuId());
			

			List<Layout> pageLayouts = new LinkedList<>();

			SiteNavigationMenuItemTypeRegistry siteNavigationMenuItemTypeRegistry =
					AllertaTracker.getService(SiteNavigationMenuItemTypeRegistry.class);
			
			for (SiteNavigationMenuItem menuItem : menuItems) {

				SiteNavigationMenuItemType menuType = siteNavigationMenuItemTypeRegistry
						.getSiteNavigationMenuItemType(menuItem);

				pageLayouts.add(menuType.getLayout(menuItem));

			}
*/
			renderRequest.setAttribute("menu", menu);

		} catch (Exception e) {
			_log.error(e);
		}

		super.render(renderRequest, renderResponse);
	}

	@Reference
	private Portal portal;

	@Reference
	private SiteNavigationMenuLocalService siteNavigationMenuLocalService;

	private Log _log = LogFactoryUtil.getLog(AllertaLeftMenuPortlet.class);
}
