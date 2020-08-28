package it.eng.bollettino.custom;

import java.util.Locale;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.servlet.http.HttpServletRequest;

import com.liferay.asset.kernel.model.BaseJSPAssetRenderer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;

import it.eng.bollettino.model.Allarme;
import it.eng.bollettino.model.RegolaAllarme;
import it.eng.bollettino.service.RegolaAllarmeLocalServiceUtil;

/**
 * Portlet implementation class FeedbackAction
 */
public class AllarmeAssetRenderer  extends BaseJSPAssetRenderer<Allarme>{
    
	private Allarme _feedback;
    private RegolaAllarme regola;
	
  	public AllarmeAssetRenderer(Allarme feedback) {
        _feedback = feedback;
    }
        
	@Override
	public Allarme getAssetObject() {
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
		return _feedback.getGroupId();
	}

	@Override
	public String getUserName() {
		
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
		// TODO Auto-generated method stub
		return Allarme.class.getName();
	}

	@Override
	public long getClassPK() {
		return _feedback.getAllarmeId();
	}

	@Override
	public String getSummary(PortletRequest portletRequest, PortletResponse portletResponse) {
		// TODO Auto-generated method stub
		try {
			if (regola==null) {
				regola = RegolaAllarmeLocalServiceUtil.fetchRegolaAllarme(_feedback.getIdRegola());
				if (regola==null) return "";
			}

			return "Notifica automatica per la regola "+regola.getNome();
		} catch (Exception e) {
			log.error(e);
			return "";
		}
	}

	@Override
	public String getTitle(Locale locale) {
		try {
			if (regola==null) {
				regola = RegolaAllarmeLocalServiceUtil.fetchRegolaAllarme(_feedback.getIdRegola());
				if (regola==null) return "";
			}

			return "Superamento regola "+regola.getNome();
		} catch (Exception e) {
			log.error(e);
			return "";
		}
	}

	@Override
	public String getJspPath(HttpServletRequest httpServletRequest, String template) {
		return "/html/view_bollettino.jsp";

	}
	
	
 
	private Log log = LogFactoryUtil.getLog(AllarmeAssetRenderer.class);
	
	/*
 
    public String render(RenderRequest request, RenderResponse response, String template)
        throws Exception 
    {
    	System.out.println("render");
    	if (1==1) return null;
        if (true || template.equals(TEMPLATE_FULL_CONTENT)) {

        	request.setAttribute("bollettino",_feedback);
        	//return null;
            return "/html/view_bollettino.jsp";
        }
        else
        {
            return null;
        }
    }
 

*/
	

}

