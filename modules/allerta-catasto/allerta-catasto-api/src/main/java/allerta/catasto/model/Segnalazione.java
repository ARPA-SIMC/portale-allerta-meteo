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

package allerta.catasto.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the Segnalazione service. Represents a row in the &quot;CATASTO_Segnalazione&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see SegnalazioneModel
 * @generated
 */
@ImplementationClassName("allerta.catasto.model.impl.SegnalazioneImpl")
@ProviderType
public interface Segnalazione extends PersistedModel, SegnalazioneModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>allerta.catasto.model.impl.SegnalazioneImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Segnalazione, Long> ID_ACCESSOR =
		new Accessor<Segnalazione, Long>() {

			@Override
			public Long get(Segnalazione segnalazione) {
				return segnalazione.getId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Segnalazione> getTypeClass() {
				return Segnalazione.class;
			}

		};

}