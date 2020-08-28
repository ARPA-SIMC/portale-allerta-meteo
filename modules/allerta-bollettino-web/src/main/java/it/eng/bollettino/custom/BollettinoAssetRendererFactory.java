package it.eng.bollettino.custom;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.asset.kernel.model.AssetRenderer;
import com.liferay.asset.kernel.model.AssetRendererFactory;
import com.liferay.asset.kernel.model.BaseAssetRendererFactory;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;

import it.eng.allerta.utils.AllertaKeys;
import it.eng.bollettino.model.Bollettino;
import it.eng.bollettino.service.BollettinoLocalService;

/**
 * Portlet implementation class FeedbackAction
 */
@Component(
		immediate = true,
		service = AssetRendererFactory.class
		)
public class BollettinoAssetRendererFactory extends BaseAssetRendererFactory<Bollettino> {
	
	public BollettinoAssetRendererFactory() {
	
		 setClassName(Bollettino.class.getName());
		 setCategorizable(true);
		 setLinkable(true);
		 setPortletId(AllertaKeys.AllertaAllerteMonitoraggioPortlet);
		 //setPortletId(BlogsPortletKeys.BLOGS);
		 setSearchable(true);
		 setSelectable(true);
		    
	}
	
    @Override
    public AssetRenderer<Bollettino> getAssetRenderer(long classPK, int type)
            throws PortalException, SystemException {
    	
        Bollettino feedback = bollettinoLocalService.getBollettino(classPK);
        return new BollettinoAssetRenderer(feedback);
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

    private static final boolean _LINKABLE = true;

    
    public static final String TYPE = "Bollettino";
    public static final String CLASS_NAME = Bollettino.class.getName();
    
    @Reference
    private BollettinoLocalService bollettinoLocalService;
}

