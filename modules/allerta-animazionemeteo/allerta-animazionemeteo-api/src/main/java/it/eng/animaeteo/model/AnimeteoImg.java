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

package it.eng.animaeteo.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the AnimeteoImg service. Represents a row in the &quot;animeteo_AnimeteoImg&quot; database table, with each column mapped to a property of this class.
 *
 * @author UTENTE
 * @see AnimeteoImgModel
 * @generated
 */
@ImplementationClassName("it.eng.animaeteo.model.impl.AnimeteoImgImpl")
@ProviderType
public interface AnimeteoImg extends AnimeteoImgModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>it.eng.animaeteo.model.impl.AnimeteoImgImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<AnimeteoImg, Long> ID_ACCESSOR =
		new Accessor<AnimeteoImg, Long>() {

			@Override
			public Long get(AnimeteoImg animeteoImg) {
				return animeteoImg.getId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<AnimeteoImg> getTypeClass() {
				return AnimeteoImg.class;
			}

		};

}