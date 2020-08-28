package it.eng.allerta.backoffice.application.list;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.portal.kernel.model.Portlet;

import it.eng.allerta.backoffice.constants.AllertaBackofficeKeys;

@Component(
		immediate = true,
		property = {
			"panel.app.order:Integer=100",
			"panel.category.key=" + AllertaBackofficeKeys.CONTROL_PANEL_CATEGORY
		},
		service = PanelApp.class
	)
public class AllertaBOSchedulerPanelApp extends BasePanelApp  {
	
	@Override
	public String getPortletId() {
		return AllertaBackofficeKeys.ScheduledJobManagerPortlet;
	}

	@Override
	@Reference(
		target = "(javax.portlet.name=" + AllertaBackofficeKeys.ScheduledJobManagerPortlet + ")",
		unbind = "-"
	)
	public void setPortlet(Portlet portlet) {
		super.setPortlet(portlet);
	}

}
