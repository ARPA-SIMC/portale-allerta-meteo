package it.eng.allerta.backoffice.application.list;

import it.eng.allerta.backoffice.constants.AllertaBackofficeKeys;

import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.portal.kernel.model.Portlet;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author VLPMRC80B
 */
@Component(
	immediate = true,
	property = {
		"panel.app.order:Integer=100",
		"panel.category.key=" + AllertaBackofficeKeys.CONTROL_PANEL_CATEGORY
	},
	service = PanelApp.class
)
public class AllertaBOProcedurePanelApp extends BasePanelApp {

	@Override
	public String getPortletId() {
		return AllertaBackofficeKeys.AllertaBOProcedurePortlet;
	}

	@Override
	@Reference(
		target = "(javax.portlet.name=" + AllertaBackofficeKeys.AllertaBOProcedurePortlet + ")",
		unbind = "-"
	)
	public void setPortlet(Portlet portlet) {
		super.setPortlet(portlet);
	}

}