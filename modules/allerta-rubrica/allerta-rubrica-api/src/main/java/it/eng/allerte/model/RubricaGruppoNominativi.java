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