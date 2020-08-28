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

package it.eng.animazione.image.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the PioggiaCumulativa service. Represents a row in the &quot;img_animazioni_PioggiaCumulativa&quot; database table, with each column mapped to a property of this class.
 *
 * @author UTENTE
 * @see PioggiaCumulativaModel
 * @generated
 */
@ImplementationClassName(
	"it.eng.animazione.image.model.impl.PioggiaCumulativaImpl"
)
@ProviderType
public interface PioggiaCumulativa
	extends PersistedModel, PioggiaCumulativaModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>it.eng.animazione.image.model.impl.PioggiaCumulativaImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<PioggiaCumulativa, Long> ID_ACCESSOR =
		new Accessor<PioggiaCumulativa, Long>() {

			@Override
			public Long get(PioggiaCumulativa pioggiaCumulativa) {
				return pioggiaCumulativa.getId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<PioggiaCumulativa> getTypeClass() {
				return PioggiaCumulativa.class;
			}

		};

}