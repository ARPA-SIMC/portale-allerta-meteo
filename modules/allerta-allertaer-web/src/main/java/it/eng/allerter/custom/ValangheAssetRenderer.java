package it.eng.allerter.custom;

import java.util.Locale;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liferay.asset.kernel.model.BaseJSPAssetRenderer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;

import it.eng.allerter.model.AllertaValanghe;

/**
 * Portlet implementation class FeedbackAction
 */
public class ValangheAssetRenderer extends BaseJSPAssetRenderer<AllertaValanghe>{

	 private AllertaValanghe _feedback;
     
	 public ValangheAssetRenderer(AllertaValanghe feedback) {
	        _feedback = feedback;
	 }
	 
	@Override
	public AllertaValanghe getAssetObject() {
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
		String userName=null;
        try {
        	userName= UserLocalServiceUtil.getUser(_feedback.getUserId()).getFullName();
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
		// TODO Auto-generated method stub
		return _feedback.getUuid();
	}

	@Override
	public String getClassName() {
		// TODO Auto-generated method stub
		return AllertaValanghe.class.getName();
	}

	@Override
	public long getClassPK() {
		// TODO Auto-generated method stub
		return _feedback.getAllertaValangheId();
	}

	@Override
	public String getSummary(PortletRequest portletRequest, PortletResponse portletResponse) {
		// TODO Auto-generated method stub
		return "Sommario "+_feedback.getDescrizioneFenomeni();
	}

	@Override
	public String getTitle(Locale locale) {
		// TODO Auto-generated method stub
		return _feedback.getTitolo();
	}

	
	public String __getJspPath(HttpServletRequest httpServletRequest, String template) {
		// TODO Auto-generated method stub
		return "/asset/valanghe/"+template+".jsp";
	}
	
	
	@Override
	public String getJspPath(HttpServletRequest request, String template) {
		
//		if (template.equals(TEMPLATE_FULL_CONTENT)) {
//			
//			
//		} else {
//			return null;
//		}
		
		request.setAttribute("allerta", _feedback);
		return "/asset/valanghe/" + template + ".jsp";
	}
	
	@Override
	public boolean hasViewPermission(PermissionChecker permissionChecker)
	throws PortalException {
		return true;
	}
	
	@Override
	public boolean include(
	        HttpServletRequest request, HttpServletResponse response,
	        String template)
	    throws Exception {

		request.setAttribute("allerta", _feedback);
	    return super.include(request, response, template);
	}
	
 
	/*
   
;
    
    public boolean hasViewPermission(PermissionChecker checker) {
    	return true;
    }
    
 
    public String render(RenderRequest request, RenderResponse response, String template)
        throws Exception 
    {
    	System.out.println("render");
        if (true || template.equals(TEMPLATE_FULL_CONTENT)) {

        	request.setAttribute("allerta",_feedback);
        	//return null;
            return "/html/view_allerta.jsp";
        }
        else
        {
            return null;
        }
    }
 
    @Override
    public String getUserName() {
        // TODO Auto-generated method stub
    	
    }

	@Override
	public String getClassName() {
		// TODO Auto-generated method stub
		return Allerta.class.getName();
	}

	@Override
	public String getSummary(Locale arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getTitle(Locale arg0) {
		
	}
	
	public Allerta getAllerta() {
		return _feedback;
	}
 
*/

}

