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
 * The extended model interface for the RubricaGruppoGruppi service. Represents a row in the &quot;rubrica_RubricaGruppoGruppi&quot; database table, with each column mapped to a property of this class.
 *
 * @author Pratola_L
 * @see RubricaGruppoGruppiModel
 * @generated
 */
@ImplementationClassName("it.eng.allerte.model.impl.RubricaGruppoGruppiImpl")
@ProviderType
public interface RubricaGruppoGruppi
	extends PersistedModel, RubricaGruppoGruppiModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>it.eng.allerte.model.impl.RubricaGruppoGruppiImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<RubricaGruppoGruppi, Long>
		FK_GRUPPO_PADRE_ACCESSOR = new Accessor<RubricaGruppoGruppi, Long>() {

			@Override
			public Long get(RubricaGruppoGruppi rubricaGruppoGruppi) {
				return rubricaGruppoGruppi.getFK_GRUPPO_PADRE();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<RubricaGruppoGruppi> getTypeClass() {
				return RubricaGruppoGruppi.class;
			}

		};
	public static final Accessor<RubricaGruppoGruppi, Long>
		FK_GRUPPO_FIGLIO_ACCESSOR = new Accessor<RubricaGruppoGruppi, Long>() {

			@Override
			public Long get(RubricaGruppoGruppi rubricaGruppoGruppi) {
				return rubricaGruppoGruppi.getFK_GRUPPO_FIGLIO();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<RubricaGruppoGruppi> getTypeClass() {
				return RubricaGruppoGruppi.class;
			}

		};

}