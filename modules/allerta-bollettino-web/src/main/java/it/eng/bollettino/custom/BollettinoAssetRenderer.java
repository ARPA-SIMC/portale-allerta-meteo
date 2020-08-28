package it.eng.bollettino.custom;

import java.util.Locale;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import com.liferay.asset.kernel.model.BaseJSPAssetRenderer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;

import it.eng.bollettino.model.Bollettino;

/**
 * Portlet implementation class FeedbackAction
 */
public class BollettinoAssetRenderer extends BaseJSPAssetRenderer<Bollettino> {

	private Bollettino _feedback;

	public BollettinoAssetRenderer(Bollettino feedback) {
		_feedback = feedback;
	}

	@Override
	public Bollettino getAssetObject() {
		// TODO Auto-generated method stub
		return _feedback;
	}

	@Override
	public long getGroupId() {
		// TODO Auto-generated method stub
		return _feedback.getGroupId();
	}

	@Override
	public long getUserId() {
		// TODO Auto-generated method stub
		return _feedback.getUserId();
	}

	@Override
	public String getUserName() {
		// TODO Auto-generated method stub
		String userName = null;
		try {
			userName = UserLocalServiceUtil.getUser(_feedback.getUserId()).getFullName();
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return userName;
		}
		return userName;
	}

	@Override
	public String getUuid() {
		return _feedback.getUuid();
	}

	@Override
	public String getClassName() {
		return Bollettino.class.getName();
	}

	@Override
	public long getClassPK() {
		return _feedback.getBollettinoId();
	}

	@Override
	public String getSummary(PortletRequest portletRequest, PortletResponse portletResponse) {
		return _feedback.getNoteMeteo();
	}

	@Override
	public String getTitle(Locale locale) {
		return "Monitoraggio n. " + _feedback.getNumero();
	}

	
	@Override
	public String getJspPath(HttpServletRequest request, String template) {
				
		request.setAttribute("bollettino", _feedback);
		return "/asset/monitoraggio/" + template + ".jsp";
	}
	
	

	/*
	 * 
	 * 
	 * public Bollettino getBollettino() { return _feedback; }
	 * 
	 * 
	 * public boolean hasViewPermission(PermissionChecker checker) { return true; }
	 * 
	 * 
	 * public String render(RenderRequest request, RenderResponse response, String
	 * template) throws Exception { System.out.println("render"); if (true ||
	 * template.equals(TEMPLATE_FULL_CONTENT)) {
	 * 
	 * request.setAttribute("bollettino",_feedback); //return null; return
	 * "/html/view_bollettino.jsp"; } else { return null; } }
	 * 
	 */

}
