package it.eng.bollettino.custom;

import org.osgi.service.component.annotations.Component;

import com.liferay.asset.kernel.model.AssetRenderer;
import com.liferay.asset.kernel.model.AssetRendererFactory;
import com.liferay.asset.kernel.model.BaseAssetRendererFactory;
import com.liferay.portal.kernel.exception.PortalException;
import it.eng.bollettino.model.Allarme;
import it.eng.bollettino.service.AllarmeLocalServiceUtil;

@Component(
		immediate = true,
		service = AssetRendererFactory.class
		)
public class AllarmeAssetRendererFactory extends BaseAssetRendererFactory<Allarme> {
	
	public AllarmeAssetRendererFactory() {
		
		 setClassName(Allarme.class.getName());
		 setCategorizable(true);
		 setLinkable(true);
		 //setPortletId(BlogsPortletKeys.BLOGS);
		 setSearchable(true);
		 setSelectable(true);
		    
	}
	
	@Override
	public AssetRenderer<Allarme> getAssetRenderer(long classPK, int type) throws PortalException {
		
		Allarme feedback = AllarmeLocalServiceUtil.getAllarme(classPK);
	    return new AllarmeAssetRenderer(feedback);
	}
	
	@Override
	public String getClassName() {
		return CLASS_NAME;
	}
	
	@Override
	public String getType() {
		return TYPE;
	}
	
	/*
    @Override
    public Asset getAssetRenderer(long classPK, int type)
            throws PortalException, SystemException {
    	System.out.println("getAssetRenderer");
        Allarme feedback = AllarmeLocalServiceUtil.getAllarme(classPK);
        return new AllarmeAssetRenderer(feedback);
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

    @Override
    public boolean isLinkable() {
            return _LINKABLE;
    }
*/
    private static final boolean _LINKABLE = true;
    
    public static final String TYPE = "Allarme";
    public static final String CLASS_NAME = Allarme.class.getName();
	
}

