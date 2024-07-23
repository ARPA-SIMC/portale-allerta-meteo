package allerta.catasto.web.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.PortalUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

import allerta.catasto.bean.CatastoBean;
import allerta.catasto.service.SegnalazioneLocalServiceUtil;
import allerta.catasto.web.constants.AllertaCatastoWebPortletKeys;

@Component(
		immediate = true,
		property = {
				"javax.portlet.name=" + AllertaCatastoWebPortletKeys.ALLERTACATASTOWEB,
				"mvc.command.name=/allertaer/catasto/delete"
		},
		service = MVCActionCommand.class
		)
public class CatastoCancellaCommand  extends BaseMVCActionCommand {
	

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
	

		
		boolean err = false;
		
		long id = -1;
		
		HttpServletRequest r = PortalUtil.getHttpServletRequest(actionRequest);
		id  =   Long.parseLong(PortalUtil.getOriginalServletRequest(r).getParameter("id"));
		try {
			SegnalazioneLocalServiceUtil.deleteSegnalazione(id);


		} catch (Exception e) {
			
			log.error(e);
			
			err = true;
			
			//LogInternoLocalServiceUtil.log("allertaBean", "salvaAllerta", e, "");

			SessionErrors.add(actionRequest, e.getClass(), e.getMessage());
		}
	}

	
	private Log log = LogFactoryUtil.getLog(CatastoCancellaCommand.class);
}
