/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package it.eng.bollettino.model.impl;

import java.util.List;

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
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;

import aQute.bnd.annotation.ProviderType;
import it.eng.allerta.utils.AllertaKeys;
import it.eng.bollettino.model.BollettinoBacino;
import it.eng.bollettino.model.BollettinoParametro;
import it.eng.bollettino.service.BollettinoBacinoLocalServiceUtil;
import it.eng.bollettino.service.BollettinoParametroLocalServiceUtil;

/**
 * The extended model implementation for the Bollettino service. Represents a row in the &quot;BOLLETTINO_Bollettino&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>it.eng.bollettino.model.Bollettino<code> interface.
 * </p>
 *
 * @author GFAVINI
 */
@ProviderType
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