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

package it.eng.allerter.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

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

	public java.util.List<it.eng.allerter.model.AllertaValangheStato>
		getAllertaValangheStato();

	public String getUrl();

	public String getFileLinkRelative(String folderName, String fileName);

	public com.liferay.portal.kernel.repository.model.FileEntry getFile(
		String folderName, String fileName);

	public java.io.File getReportAsFile();

}