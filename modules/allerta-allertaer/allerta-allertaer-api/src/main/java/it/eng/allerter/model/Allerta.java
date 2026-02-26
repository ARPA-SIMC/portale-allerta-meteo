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
 * The extended model interface for the Allerta service. Represents a row in the &quot;ALLERTER_Allerta&quot; database table, with each column mapped to a property of this class.
 *
 * @author GFAVINI
 * @see AllertaModel
 * @generated
 */
@ImplementationClassName("it.eng.allerter.model.impl.AllertaImpl")
@ProviderType
public interface Allerta extends AllertaModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>it.eng.allerter.model.impl.AllertaImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Allerta, Long> ALLERTA_ID_ACCESSOR =
		new Accessor<Allerta, Long>() {

			@Override
			public Long get(Allerta allerta) {
				return allerta.getAllertaId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Allerta> getTypeClass() {
				return Allerta.class;
			}

		};

	public java.util.List<AllertaStato> getAllertaStato();

	public String getUrl();

	public String getFileLinkRelative(String folderName, String fileName);

	public com.liferay.portal.kernel.repository.model.FileEntry getFile(
		String folderName, String fileName);

	public java.io.File getReportAsFile();

}