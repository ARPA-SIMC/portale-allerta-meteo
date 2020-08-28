package it.eng.allerta.header.portlet;

import it.eng.allerta.utils.AllertaKeys;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.UserNotificationDeliveryConstants;
import com.liferay.portal.kernel.model.UserNotificationEvent;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.UserNotificationEventLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortletKeys;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author VLPMRC80B
 */
@Component(
		immediate = true, 
		property = {   
		"com.liferay.portlet.display-category=" + AllertaKeys.AllertaCategory,
		"com.liferay.portlet.instanceable=false", 
		"com.liferay.portlet.footer-portlet-javascript=/js/search.js",
		"javax.portlet.display-name=Header", 
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp", 
		"javax.portlet.name=" + AllertaKeys.AllertaHeaderPortlet,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" 
		}, 
		service = Portlet.class
		)
public class AllertaHeaderPortlet extends MVCPortlet {

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
			DynamicQuery query = userNotificationEventLocalService.dynamicQuery();
			query.add(PropertyFactoryUtil.forName("userId").eq(themeDisplay.getUserId()));
			query.add(PropertyFactoryUtil.forName("type").eq(PortletKeys.MY_WORKFLOW_TASK));
			query.add(PropertyFactoryUtil.forName("deliveryType").eq(UserNotificationDeliveryConstants.TYPE_WEBSITE));
			long notificationCount = userNotificationEventLocalService.dynamicQueryCount(query);
			
			query = userNotificationEventLocalService.dynamicQuery();
			query.add(PropertyFactoryUtil.forName("userId").eq(themeDisplay.getUserId()));
			query.add(PropertyFactoryUtil.forName("type").eq(PortletKeys.MY_WORKFLOW_TASK));
			query.add(PropertyFactoryUtil.forName("deliveryType").eq(UserNotificationDeliveryConstants.TYPE_WEBSITE));
			query.addOrder(OrderFactoryUtil.desc("timestamp"));
			query.setLimit(0, 5);
			
			List<UserNotificationEvent> notifications = userNotificationEventLocalService.dynamicQuery(query);
			
			renderRequest.setAttribute("notificationCount", notificationCount);
			renderRequest.setAttribute("notifications", notifications);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		super.render(renderRequest, renderResponse);
	
	}

	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		
		try {
			
			long userNotificationEventId = ParamUtil.getLong(resourceRequest, "userNotificationEventId");

			if (userNotificationEventId > 0) {
				userNotificationEventLocalService.deleteUserNotificationEvent(userNotificationEventId);
			}
			
		
		
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PrintWriter writer = resourceResponse.getWriter();
		writer.write("end");
		writer.flush();
		writer.close();
		
		
	}
	
	 @Reference
	 private UserNotificationEventLocalService userNotificationEventLocalService;

}