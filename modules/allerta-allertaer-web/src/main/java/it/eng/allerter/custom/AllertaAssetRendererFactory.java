package it.eng.allerter.custom;

import org.osgi.service.component.annotations.Component;

import com.liferay.asset.kernel.model.AssetRenderer;
import com.liferay.asset.kernel.model.AssetRendererFactory;
import com.liferay.asset.kernel.model.BaseAssetRendererFactory;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;

import it.eng.allerta.utils.AllertaKeys;
import it.eng.allerter.model.Allerta;
import it.eng.allerter.service.AllertaLocalServiceUtil;

@Component(
		immediate = true,
		service = AssetRendererFactory.class
		)
public class AllertaAssetRendererFactory extends BaseAssetRendererFactory<Allerta> {

	public AllertaAssetRendererFactory() {
		
		 setClassName(Allerta.class.getName());
		 setCategorizable(true);
		 setLinkable(true);
		 setPortletId(AllertaKeys.AllertaAllerteBollettiniPortlet);
		 //setPortletId(BlogsPortletKeys.BLOGS);
		 setSearchable(true);
		 setSelectable(true);
		    
	}
	
	@Override
	public AssetRenderer<Allerta> getAssetRenderer(long classPK, int type) throws PortalException {
		 Allerta feedback = AllertaLocalServiceUtil.getAllerta(classPK);
	        
		 return new AllertaAssetRenderer(feedback);
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
	

	 public static final String TYPE = "Allerta-Bollettino";
	 public static final String CLASS_NAME = Allerta.class.getName();
	    
}

