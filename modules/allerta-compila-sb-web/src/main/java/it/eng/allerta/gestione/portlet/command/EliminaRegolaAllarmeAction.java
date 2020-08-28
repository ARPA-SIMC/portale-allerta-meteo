package it.eng.allerta.gestione.portlet.command;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import it.eng.allerta.utils.AllertaKeys;
import it.eng.bollettino.service.RegolaAllarmeLocalServiceUtil;

@Component(
		immediate = true,
		property = {
				"javax.portlet.name=" + AllertaKeys.AllertaConfigurazioneAllarmiPortlet,
				"mvc.command.name=/allertaer/regola/elimina"
		},
		service = MVCActionCommand.class
	)
public class EliminaRegolaAllarmeAction extends BaseMVCActionCommand {


	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		long regolaId = ParamUtil.getLong(actionRequest, "regola", 0);
		
		RegolaAllarmeLocalServiceUtil.deleteRegolaAllarme(regolaId);

	}

}
