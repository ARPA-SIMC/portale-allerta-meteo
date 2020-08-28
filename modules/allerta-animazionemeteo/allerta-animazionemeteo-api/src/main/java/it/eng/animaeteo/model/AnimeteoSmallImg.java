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
 * The extended model interface for the AnimeteoSmallImg service. Represents a row in the &quot;animeteo_AnimeteoSmallImg&quot; database table, with each column mapped to a property of this class.
 *
 * @author UTENTE
 * @see AnimeteoSmallImgModel
 * @generated
 */
@ImplementationClassName("it.eng.animaeteo.model.impl.AnimeteoSmallImgImpl")
@ProviderType
public interface AnimeteoSmallImg
	extends AnimeteoSmallImgModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>it.eng.animaeteo.model.impl.AnimeteoSmallImgImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<AnimeteoSmallImg, Long> ID_ACCESSOR =
		new Accessor<AnimeteoSmallImg, Long>() {

			@Override
			public Long get(AnimeteoSmallImg animeteoSmallImg) {
				return animeteoSmallImg.getId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<AnimeteoSmallImg> getTypeClass() {
				return AnimeteoSmallImg.class;
			}

		};

}