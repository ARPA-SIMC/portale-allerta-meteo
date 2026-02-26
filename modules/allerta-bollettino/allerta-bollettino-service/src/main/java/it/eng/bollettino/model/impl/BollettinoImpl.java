/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.bollettino.model.impl;

import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.document.library.kernel.service.DLFolderLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import java.util.List;

import it.eng.allerta.utils.AllertaKeys;
import it.eng.bollettino.model.BollettinoBacino;
import it.eng.bollettino.model.BollettinoParametro;
import it.eng.bollettino.service.BollettinoBacinoLocalServiceUtil;
import it.eng.bollettino.service.BollettinoParametroLocalServiceUtil;

/**
 * @author GFAVINI
 */
public class BollettinoImpl extends BollettinoBaseImpl {
	

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a bollettino model instance should use the {@link it.eng.bollettino.model.Bollettino} interface instead.
	 */
	public BollettinoImpl() {
	}
	
	public List<BollettinoBacino> getBacini()  {
		return BollettinoBacinoLocalServiceUtil.getBaciniByBollettino(getBollettinoId());
	}
	

	public String getFileLinkRelative(String folderName, String fileName) {
		long repositoryId = getGroupId();
		Long parentFolderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;

		try {
			BollettinoParametro ap = BollettinoParametroLocalServiceUtil
					.fetchBollettinoParametro("BOLLETTINO_PARENT_FOLDER_ID");
			if (ap != null)
				parentFolderId = Long.parseLong(ap.getValore());
		} catch (Exception e) {
		}

		try {
			Folder folder = DLAppServiceUtil.getFolder(getGroupId(), parentFolderId, folderName);
			List<FileEntry> fileEntries = DLAppServiceUtil.getFileEntries(repositoryId, folder.getFolderId());
			for (FileEntry file : fileEntries) {
				String url = "/documents/" + getGroupId() + "/" + file.getFolderId() + "/" + file.getTitle();
				//System.out.println("Link=>" + url);
				if (file.getTitle().startsWith(fileName))
					return url;
			}
			return null;
		} catch (Exception e) {
			_log.error(e);

			return null;
		}
	}

	

	public String getFileLink(String folderName, String fileName) {
		long repositoryId = getGroupId();
		Long parentFolderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;

		try {
			BollettinoParametro ap = BollettinoParametroLocalServiceUtil
					.fetchBollettinoParametro("BOLLETTINO_PARENT_FOLDER_ID");
			if (ap != null)
				parentFolderId = Long.parseLong(ap.getValore());
		} catch (Exception e) {
		}

		try {
			Company company = CompanyLocalServiceUtil.getCompany(getCompanyId());
			
			String portalURL = PortalUtil.getPortalURL(
					company.getVirtualHostname(), PortalUtil.getPortalLocalPort(false), false);

			
			Folder folder = DLAppServiceUtil.getFolder(getGroupId(), parentFolderId, folderName);
			List<FileEntry> fileEntries = DLAppServiceUtil.getFileEntries(repositoryId, folder.getFolderId());
			for (FileEntry file : fileEntries) {

				String url = portalURL + "/c/documents/"
						+ getGroupId() + "/" + file.getFolderId() + "/" + file.getTitle();
				
				
				//System.out.println("Link=>" + url);
				if (file.getTitle().startsWith(fileName))
					return url;
			}
			return null;
		} catch (Exception e) {
			_log.error(e);

			return null;
		}
	}
	


	public FileEntry getFile(String folderName, String fileName) {
		long repositoryId = getGroupId();
		Long parentFolderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;

		try {
			BollettinoParametro ap = BollettinoParametroLocalServiceUtil
					.fetchBollettinoParametro(AllertaKeys.BollettinoParentFolderParamKey);
			if (ap != null)
				parentFolderId = Long.parseLong(ap.getValore());
		} catch (Exception e) {
		}

		try {
			Folder folder = DLAppServiceUtil.getFolder(getGroupId(), parentFolderId, folderName);
			List<FileEntry> fileEntries = DLAppServiceUtil.getFileEntries(repositoryId, folder.getFolderId());
			for (FileEntry file : fileEntries) {
				if (file.getTitle().equals(fileName))
					return file;
			}
			return null;
		} catch (Exception e) {
			_log.error(e);
			return null;
		}
	}


	public DLFolder getDLFolder(String folderName) {
		long groupId = getGroupId();
		Long parentFolderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;

		try {
			BollettinoParametro ap = BollettinoParametroLocalServiceUtil
					.fetchBollettinoParametro("BOLLETTINO_PARENT_FOLDER_ID");
			if (ap != null)
				parentFolderId = Long.parseLong(ap.getValore());
		} catch (Exception e) {
		}

		try {
			DLFolder dir = DLFolderLocalServiceUtil.getFolder(groupId, parentFolderId, folderName);
			System.out.println("Folder Id==>" + dir.getFolderId());
			return dir;
		} catch (Exception e) {
			_log.error(e);
			return null;
		}

	}
	
	public Folder getFolder(String folderName) {
		Long parentFolderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
		try {
			BollettinoParametro ap = BollettinoParametroLocalServiceUtil
					.fetchBollettinoParametro("BOLLETTINO_PARENT_FOLDER_ID");
			if (ap != null)
				parentFolderId = Long.parseLong(ap.getValore());
		} catch (Exception e) {
		}

		try {
			Folder dir = DLAppServiceUtil.getFolder(getGroupId(), parentFolderId, folderName);
			System.out.println("Folder Id==>" + dir.getFolderId());
			return dir;
		} catch (Exception e) {
			_log.error(e);
			return null;
		}
	}


	
	private Log _log = LogFactoryUtil.getLog(BollettinoImpl.class);
}