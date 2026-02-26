/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerter.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the AllertaValanghe service. Represents a row in the &quot;ALLERTER_AllertaValanghe&quot; database table, with each column mapped to a property of this class.
 *
 * @author GFAVINI
 * @see AllertaValangheModel
 * @generated
 */
@ImplementationClassName("it.eng.allerter.model.impl.AllertaValangheImpl")
@ProviderType
public interface AllertaValanghe extends AllertaValangheModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>it.eng.allerter.model.impl.AllertaValangheImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<AllertaValanghe, Long>
		ALLERTA_VALANGHE_ID_ACCESSOR = new Accessor<AllertaValanghe, Long>() {

			@Override
			public Long get(AllertaValanghe allertaValanghe) {
				return allertaValanghe.getAllertaValangheId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<AllertaValanghe> getTypeClass() {
				return AllertaValanghe.class;
			}

		};

	public java.util.List<AllertaValangheStato> getAllertaValangheStato();

	public String getUrl();

	public String getFileLinkRelative(String folderName, String fileName);

	public com.liferay.portal.kernel.repository.model.FileEntry getFile(
		String folderName, String fileName);

	public java.io.File getReportAsFile();

}