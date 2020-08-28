package it.eng.allertaer.cruscotto.action;

import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.PortalUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.eng.allerta.utils.AllertaKeys;
import it.eng.bollettino.cron.CaricaDBTask;

@Component(
		immediate = true,
		property= {
				"javax.portlet.name=" + AllertaKeys.AllertaCruscottoPortlet,
				"mvc.command.name=/cruscotto/rt_data/forza"
		},
		service = MVCActionCommand.class
	)
public class ForzaScaricamentoAction extends BaseMVCActionCommand {
	
	@Reference
	CaricaDBTask caricaTask;


	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		User u = PortalUtil.getUser(actionRequest);
		String s = "";
		if (u!=null) s = u.getFullName();
		
		
		caricaTask.forza(s);

		
	}

}
