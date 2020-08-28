package it.eng.comune.custom;

import java.util.Locale;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.servlet.http.HttpServletRequest;

import com.liferay.asset.kernel.model.BaseJSPAssetRenderer;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;

public class DLFileEntryAssetRenderer extends BaseJSPAssetRenderer<DLFileEntry> {
	
	public DLFileEntryAssetRenderer(DLFileEntry entry) {
		_entry = entry;
	}

	@Override
	public DLFileEntry getAssetObject() {
		return _entry;
	}

	@Override
	public long getGroupId() {
		return _entry.getGroupId();
	}

	@Override
	public long getUserId() {
		return _entry.getUserId();
	}

	@Override
	public String getUserName() {
		String userName = null;
		try {
			userName = UserLocalServiceUtil.getUser(_entry.getUserId()).getFullName();
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
		return _entry.getUuid();
	}

	@Override
	public String getClassName() {
		return DLFileEntry.class.getName();
	}

	@Override
	public long getClassPK() {
		return _entry.getFileEntryId();
	}

	@Override
	public String getSummary(PortletRequest portletRequest, PortletResponse portletResponse) {
		return _entry.getDescription();
	}

	@Override
	public String getTitle(Locale locale) {
		return _entry.getTitle();
	}

	@Override
	public String getJspPath(HttpServletRequest httpServletRequest, String template) {
		
		httpServletRequest.setAttribute("entry", _entry);
		return "/asset/dlFileEntry/" + template + ".jsp";
	}

	
	private DLFileEntry _entry;
}
