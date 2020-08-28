package it.eng.allerta.backoffice.portlet;

import java.io.IOException;
import java.util.ArrayList;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.scheduler.SchedulerException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;


import it.eng.allerta.backoffice.constants.AllertaBackofficeKeys;
import it.eng.allerta.backoffice.scheduler.bean.SchedulerJobBean;
import it.eng.allerta.backoffice.scheduler.utils.QuartzSchedulerUtil;

@Component(
		immediate = true,
		property = {
			"com.liferay.portlet.add-default-resource=true",
			"com.liferay.portlet.display-category=category.hidden",
			"com.liferay.portlet.layout-cacheable=true",
			"com.liferay.portlet.private-request-attributes=false",
			"com.liferay.portlet.private-session-attributes=false",
			"com.liferay.portlet.render-weight=50",
			"com.liferay.portlet.use-default-template=true",
			"com.liferay.portlet.header-portlet-css=/css/scheduler.css",
			"com.liferay.portlet.footer-portlet-javascript=/js/scheduler.js",
			"javax.portlet.display-name=Scheduled Job Manager",
			"javax.portlet.expiration-cache=0",
			"javax.portlet.init-param.template-path=/scheduler/",
			"javax.portlet.init-param.view-template=/scheduler/view.jsp",
			"javax.portlet.name=" + AllertaBackofficeKeys.ScheduledJobManagerPortlet,
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=administrator",
			"javax.portlet.supports.mime-type=text/html"
		},
		service = Portlet.class
	)
public class ScheduledJobManagerPortlet extends MVCPortlet {
	
	public void render(RenderRequest request, RenderResponse response) throws IOException, PortletException {
		
        try {
            QuartzSchedulerUtil.getSchedulerJobs(request);
        } catch (SchedulerException e) {
            request.setAttribute(QuartzSchedulerUtil.ATTRIBUTE_JOBS_LIST, new ArrayList<SchedulerJobBean>());
            request.setAttribute(QuartzSchedulerUtil.ATTRIBUTE_COUNT, NOT_RESULTS);
            _log.error(e);
        }
        super.render(request, response);
    }
    
    private static final int NOT_RESULTS = 0;
    private static final Log _log = LogFactoryUtil.getLog(ScheduledJobManagerPortlet.class);

}
