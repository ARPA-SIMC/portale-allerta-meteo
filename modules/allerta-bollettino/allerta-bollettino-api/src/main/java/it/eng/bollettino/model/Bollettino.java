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

package it.eng.bollettino.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the Bollettino service. Represents a row in the &quot;BOLLETTINO_Bollettino&quot; database table, with each column mapped to a property of this class.
 *
 * @author GFAVINI
 * @see BollettinoModel
 * @generated
 */
@ImplementationClassName("it.eng.bollettino.model.impl.BollettinoImpl")
@ProviderType
public interface Bollettino extends BollettinoModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>it.eng.bollettino.model.impl.BollettinoImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Bollettino, Long> BOLLETTINO_ID_ACCESSOR =
		new Accessor<Bollettino, Long>() {

			@Override
			public Long get(Bollettino bollettino) {
				return bollettino.getBollettinoId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Bollettino> getTypeClass() {
				return Bollettino.class;
			}

		};

	public java.util.List<it.eng.bollettino.model.BollettinoBacino> getBacini();

	public String getFileLinkRelative(String folderName, String fileName);

	public String getFileLink(String folderName, String fileName);

	public com.liferay.portal.kernel.repository.model.FileEntry getFile(
		String folderName, String fileName);

	public com.liferay.document.library.kernel.model.DLFolder getDLFolder(
		String folderName);

	public com.liferay.portal.kernel.repository.model.Folder getFolder(
		String folderName);

}