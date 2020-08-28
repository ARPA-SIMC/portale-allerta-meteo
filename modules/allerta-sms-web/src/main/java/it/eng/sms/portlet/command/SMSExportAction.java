package it.eng.sms.portlet.command;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;

import it.eng.allerta.utils.AllertaKeys;

/*
@Component(
	immediate = true,
	property= {
			"javax.portlet.name=" + AllertaKeys.AllertaElencoSmsPortlet,
			"mvc.command.name=/allerta/sms/service/export"
	},
	service = MVCActionCommand.class
)
*/
public class SMSExportAction /*extends BaseMVCActionCommand*/ {

	/* DELETE CLASS
	@Override
	protected void doProcessAction(
				ActionRequest actionRequest, ActionResponse actionResponse) 
						throws Exception {
		
		

	}
	*/

}
