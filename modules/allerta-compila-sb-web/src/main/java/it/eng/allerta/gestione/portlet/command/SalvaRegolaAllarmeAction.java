package it.eng.allerta.gestione.portlet.command;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import it.eng.allerta.utils.AllertaKeys;
import it.eng.allerter.allerta.AllarmeBean;

@Component(
		immediate = true,
		property = {
				"javax.portlet.name=" + AllertaKeys.AllertaConfigurazioneAllarmiPortlet,
				"mvc.command.name=/allertaer/regola/salva"
		},
		service = MVCActionCommand.class
	)
public class SalvaRegolaAllarmeAction extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		AllarmeBean allarme = new AllarmeBean( themeDisplay.getUserId());
		long idRegola = ParamUtil.getLong(actionRequest, "idRegola", 0);
		if( idRegola == 0)
			allarme.nuovaRegola(actionRequest);
		else
			allarme.modificaRegola(actionRequest);
		allarme.salva();

	}

}
