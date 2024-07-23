package it.eng.allerter.custom;

import org.osgi.service.component.annotations.Component;

import com.liferay.asset.kernel.model.AssetRenderer;
import com.liferay.asset.kernel.model.AssetRendererFactory;
import com.liferay.asset.kernel.model.BaseAssetRendererFactory;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;

import it.eng.allerta.utils.AllertaKeys;
import it.eng.allerter.model.AllertaValanghe;
import it.eng.allerter.service.AllertaValangheLocalServiceUtil;

@Component(
		immediate = true,
		service = AssetRendererFactory.class
		)
public class ValangheAssetRendererFactory extends BaseAssetRendererFactory<AllertaValanghe> {

	public ValangheAssetRendererFactory() {
		
		 setClassName(AllertaValanghe.class.getName());
		 setCategorizable(true);
		 setLinkable(true);
		 setPortletId("AllertaValanghePortlet");
		 //setPortletId(BlogsPortletKeys.BLOGS);
		 setSearchable(true);
		 setSelectable(true);
		    
	}
	
	@Override
	public AssetRenderer<AllertaValanghe> getAssetRenderer(long classPK, int type) throws PortalException {
		 AllertaValanghe feedback = AllertaValangheLocalServiceUtil.getAllertaValanghe(classPK);
	        
		 return new ValangheAssetRenderer(feedback);
	}
	
	 
	@Override
	public String getClassName() {
		return CLASS_NAME;
	}

	@Override
	public String getType() {
		return TYPE;
	}
	
	@Override
    public boolean hasPermission(
                    PermissionChecker permissionChecker, long classPK, String actionId)
            throws Exception {

            return true;
    }

	
	/*
    @Override
    public AssetRenderer getAssetRenderer(long classPK, int type)
            throws PortalException, SystemException {
    	//System.out.println("getAssetRenderer");
       
    }
 
  
    @Override
	public String getType() {
		return TYPE;
	}
    
    @Override
    public boolean hasPermission(
                    PermissionChecker permissionChecker, long classPK, String actionId)
            throws Exception {

            return true;
    }

    @Override
    public boolean isLinkable() {
            return _LINKABLE;
    }

   */
	
	 //private static final boolean _LINKABLE = true;
	

	 public static final String TYPE = "AllertaValanghe-Bollettino";
	 public static final String CLASS_NAME = AllertaValanghe.class.getName();
	    
}

