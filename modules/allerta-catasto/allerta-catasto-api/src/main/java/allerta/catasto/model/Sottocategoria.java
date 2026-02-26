/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package allerta.catasto.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the Sottocategoria service. Represents a row in the &quot;CATASTO_Sottocategoria&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see SottocategoriaModel
 * @generated
 */
@ImplementationClassName("allerta.catasto.model.impl.SottocategoriaImpl")
@ProviderType
public interface Sottocategoria extends PersistedModel, SottocategoriaModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>allerta.catasto.model.impl.SottocategoriaImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Sottocategoria, Long> ID_ACCESSOR =
		new Accessor<Sottocategoria, Long>() {

			@Override
			public Long get(Sottocategoria sottocategoria) {
				return sottocategoria.getId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Sottocategoria> getTypeClass() {
				return Sottocategoria.class;
			}

		};
	public static final Accessor<Sottocategoria, Long> ID_CATEGORIA_ACCESSOR =
		new Accessor<Sottocategoria, Long>() {

			@Override
			public Long get(Sottocategoria sottocategoria) {
				return sottocategoria.getIdCategoria();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Sottocategoria> getTypeClass() {
				return Sottocategoria.class;
			}

		};

}