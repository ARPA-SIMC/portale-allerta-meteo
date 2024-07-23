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

package it.eng.allerter.model.impl;

import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.File;
import java.util.List;

import aQute.bnd.annotation.ProviderType;
import it.eng.allerta.utils.AllertaKeys;
import it.eng.allerter.model.AllertaParametro;
import it.eng.allerter.model.AllertaStato;
import it.eng.allerter.model.AllertaValangheStato;
import it.eng.allerter.service.AllertaParametroLocalServiceUtil;
import it.eng.allerter.service.AllertaStatoLocalServiceUtil;
import it.eng.allerter.service.AllertaValangheStatoLocalServiceUtil;
import it.eng.allerter.service.LogInternoLocalServiceUtil;

/**
 * The extended model implementation for the AllertaValanghe service. Represents a row in the &quot;ALLERTER_AllertaValanghe&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>it.eng.allerter.model.AllertaValanghe<code> interface.
 * </p>
 *
 * @author GFAVINI
 */
@ProviderType
public class AllertaValangheImpl extends AllertaValangheBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a allerta valanghe model instance should use the {@link it.eng.allerter.model.AllertaValanghe} interface instead.
	 */
	public AllertaValangheImpl() {
	}
	
	public List<AllertaValangheStato> getAllertaValangheStato() {
		return AllertaValangheStatoLocalServiceUtil.getAllertaValangheStatoByAllertaValanghe(getAllertaValangheId());
	}
	
	public String getUrl() {	
		return getFileLink();
	}
	
	private String getFileLink() {		
		long companyId = getCompanyId();
		long groupId = getGroupId();
		
		String folderName = "allerta-valanghe-" + getAllertaValangheId();
		String fileName = isTipoAllerta() ? "allerta_valanghe" : "bollettino_valanghe";
		
		long repositoryId = groupId;
		Long parentFolderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;

		try {
			AllertaParametro ap = AllertaParametroLocalServiceUtil.fetchAllertaParametro("VALANGHE_PARENT_FOLDER_ID");
			
			if (ap != null)
				parentFolderId = Long.parseLong(ap.getValore());
		} catch (Exception e) {
		}

		try {
			Company company = CompanyLocalServiceUtil.getCompany(companyId);			
			String portalURL = PortalUtil.getPortalURL(company.getVirtualHostname(), PortalUtil.getPortalLocalPort(false), false);

			Folder folder = DLAppServiceUtil.getFolder(groupId, parentFolderId, folderName);
			List<FileEntry> fileEntries = DLAppServiceUtil.getFileEntries(repositoryId, folder.getFolderId());
			
			for (FileEntry file : fileEntries) {				
				String url = portalURL + "/documents/" + groupId + "/" + file.getFolderId() + "/" + file.getTitle();
				_log.debug("Link=>" + url);
				
				if (file.getTitle().startsWith(fileName))
					return url;
			}
			
			return null;
		} catch (Exception e) {
			LogInternoLocalServiceUtil.log("allertaValangheBean", "getFileLink", e, "");
			
			return null;
		}
	}

	public String getFileLinkRelative(String folderName, String fileName) {
		long repositoryId = getGroupId();
		Long parentFolderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;

		try {
			AllertaParametro ap = AllertaParametroLocalServiceUtil.fetchAllertaParametro("VALANGHE_PARENT_FOLDER_ID");
			
			if (ap != null)
				parentFolderId = Long.parseLong(ap.getValore());
		} catch (Exception e) {
		}

		try {
			Folder folder = DLAppServiceUtil.getFolder(getGroupId(), parentFolderId, folderName);
			List<FileEntry> fileEntries = DLAppServiceUtil.getFileEntries(repositoryId, folder.getFolderId());
			
			for (FileEntry file : fileEntries) {
				String url = "/documents/" + getGroupId() + "/" + file.getFolderId() + "/" + file.getTitle();
				_log.debug("Link=>" + url);
				
				if (file.getTitle().equals(fileName))
					return url;
			}
			
			return null;
		} catch (Exception e) {
			_log.error(e);
			LogInternoLocalServiceUtil.log("allertaValangheBean", "getFileLinkRelative", e, "");
			
			return null;
		}
	}
	
	public FileEntry getFile(String folderName, String fileName) {		
		long repositoryId = getGroupId();
		Long parentFolderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;

		try {
			AllertaParametro ap = AllertaParametroLocalServiceUtil.fetchAllertaParametro("VALANGHE_PARENT_FOLDER_ID");
			
			if (ap != null)
				parentFolderId = Long.parseLong(ap.getValore());
		} catch (Exception e) {
		}

		try {
			Folder folder = DLAppServiceUtil.getFolder(repositoryId, parentFolderId, folderName);
			List<FileEntry> fileEntries = DLAppServiceUtil.getFileEntries(repositoryId, folder.getFolderId());
			
			for (FileEntry file : fileEntries) {
				if (file.getTitle().equals(fileName))
					return file;
			}
			
			return null;
		} catch (Exception e) {
			_log.error(e);
			LogInternoLocalServiceUtil.log("allertaValangheBean", "getFile", e, "");
			
			return null;
		}
	}
	
	public File getReportAsFile() {
		try {
			Long parentFolderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;

			try {
				AllertaParametro ap = AllertaParametroLocalServiceUtil.fetchAllertaParametro("VALANGHE_PARENT_FOLDER_ID");
				
				if (ap != null)
					parentFolderId = Long.parseLong(ap.getValore());
			} catch (Exception e) {
			}

			Folder folder = DLAppServiceUtil.getFolder(20181, parentFolderId, "allerta-valanghe-" + getAllertaValangheId());
			List<FileEntry> fileEntries = DLAppServiceUtil.getFileEntries(20181, folder.getFolderId());

			for (FileEntry f : fileEntries) {
				if (f.getTitle().startsWith("allerta_valanghe") || f.getTitle().startsWith("bollettino_valanghe")) {
					File ff = FileUtil.createTempFile(f.getContentStream());
					
					return ff;
				}
			}

			return null;

		} catch (Exception e) {
			_log.error(e);
			LogInternoLocalServiceUtil.log("AllertaWorkflow", "getReportAsFile", e, "");
			
			return null;
		}
	}

	private Log _log = LogFactoryUtil.getLog(AllertaValangheImpl.class);
}