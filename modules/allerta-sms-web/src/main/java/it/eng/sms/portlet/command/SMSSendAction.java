package it.eng.sms.portlet.command;

import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import it.eng.allerta.utils.AllertaKeys;
import it.eng.allerter.service.SMSLocalServiceUtil;

/*
@Component(
	immediate = true,
	property= {
			"javax.portlet.name=" + AllertaKeys.AllertaElencoSmsPortlet,
			"mvc.command.name=/allerta/sms/service/invia"
	},
	service = MVCActionCommand.class
)
*/
public class SMSSendAction /*extends BaseMVCActionCommand*/ {

	/* DELETE CLASS
	@Override
	protected void doProcessAction(
					ActionRequest actionRequest, ActionResponse actionResponse) 
							throws Exception {
		
		String cmd = ParamUtil.getString(actionRequest, "cmd");
		
		long l = new Date().getTime();
		
		switch( cmd) {
		
			case "invioSms" :
				String invioDa = ParamUtil.getString(actionRequest, "invioDa");
				String invioA = ParamUtil.getString(actionRequest, "invioA");
				String testo = ParamUtil.getString(actionRequest, "testo");
				
				SMSLocalServiceUtil.creaSMS(invioDa, invioA, testo, "prova", "prova", l, 0);
				SMSLocalServiceUtil.inviaSMS("prova", "prova", l);
				break;
				
			case "shutdown" :
				
				SMSLocalServiceUtil.inviaSMS("shutdown", "shutdown", l);
				break;
				
			case "svuotaCoda" :
				
				SMSLocalServiceUtil.inviaSMS("emptyQueue", "emptyQueue", l);
				break;
		
		}

	}
	*/
}
