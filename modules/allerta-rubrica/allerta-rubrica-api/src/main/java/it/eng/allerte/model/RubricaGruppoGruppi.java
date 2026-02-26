/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerte.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

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