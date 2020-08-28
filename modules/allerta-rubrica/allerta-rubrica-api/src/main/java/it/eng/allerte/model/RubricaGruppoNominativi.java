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

package it.eng.allerte.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the RubricaGruppoNominativi service. Represents a row in the &quot;rubrica_RubricaGruppoNominativi&quot; database table, with each column mapped to a property of this class.
 *
 * @author Pratola_L
 * @see RubricaGruppoNominativiModel
 * @generated
 */
@ImplementationClassName(
	"it.eng.allerte.model.impl.RubricaGruppoNominativiImpl"
)
@ProviderType
public interface RubricaGruppoNominativi
	extends PersistedModel, RubricaGruppoNominativiModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>it.eng.allerte.model.impl.RubricaGruppoNominativiImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<RubricaGruppoNominativi, Long>
		FK_GRUPPO_ACCESSOR = new Accessor<RubricaGruppoNominativi, Long>() {

			@Override
			public Long get(RubricaGruppoNominativi rubricaGruppoNominativi) {
				return rubricaGruppoNominativi.getFK_GRUPPO();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<RubricaGruppoNominativi> getTypeClass() {
				return RubricaGruppoNominativi.class;
			}

		};
	public static final Accessor<RubricaGruppoNominativi, Long>
		FK_NOMINATIVO_ACCESSOR = new Accessor<RubricaGruppoNominativi, Long>() {

			@Override
			public Long get(RubricaGruppoNominativi rubricaGruppoNominativi) {
				return rubricaGruppoNominativi.getFK_NOMINATIVO();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<RubricaGruppoNominativi> getTypeClass() {
				return RubricaGruppoNominativi.class;
			}

		};

}