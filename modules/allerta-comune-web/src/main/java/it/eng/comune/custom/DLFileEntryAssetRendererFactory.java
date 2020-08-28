package it.eng.comune.custom;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.asset.kernel.model.AssetRenderer;
import com.liferay.asset.kernel.model.AssetRendererFactory;
import com.liferay.asset.kernel.model.BaseAssetRendererFactory;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.service.DLFileEntryLocalService;
import com.liferay.portal.kernel.exception.PortalException;

import it.eng.allerta.utils.AllertaKeys;

@Component(
	immediate = true,
	service = AssetRendererFactory.class
	)
public class DLFileEntryAssetRendererFactory extends BaseAssetRendererFactory<DLFileEntry> {
	
	public DLFileEntryAssetRendererFactory() {
		
		 setClassName(DLFileEntry.class.getName());
		 setCategorizable(false);
		 setLinkable(false);
		 setPortletId(AllertaKeys.AllertaStrumentiComunePortlet);
		 setSearchable(false);
		 setSelectable(true);
		    
	}

	@Override
	public AssetRenderer<DLFileEntry> getAssetRenderer(long classPK, int type) throws PortalException {
		
		DLFileEntry entry = dlFileEntryLocalService.getDLFileEntry(classPK);
		
		return new DLFileEntryAssetRenderer(entry) ;
	}

	@Override
    public String getClassName() {
		return CLASS_NAME;
	}
    @Override
	public String getType() {
		return TYPE;
	}
	    
    @Reference
    private DLFileEntryLocalService dlFileEntryLocalService;
    public static final String TYPE = "DLFileEntry";
    public static final String CLASS_NAME = DLFileEntry.class.getName();

}
