/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerter.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the Geografia service. Represents a row in the &quot;ALLERTER_Geografia&quot; database table, with each column mapped to a property of this class.
 *
 * @author GFAVINI
 * @see GeografiaModel
 * @generated
 */
@ImplementationClassName("it.eng.allerter.model.impl.GeografiaImpl")
@ProviderType
public interface Geografia extends GeografiaModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>it.eng.allerter.model.impl.GeografiaImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Geografia, String> GEOGRAFIA_ID_ACCESSOR =
		new Accessor<Geografia, String>() {

			@Override
			public String get(Geografia geografia) {
				return geografia.getGeografiaId();
			}

			@Override
			public Class<String> getAttributeClass() {
				return String.class;
			}

			@Override
			public Class<Geografia> getTypeClass() {
				return Geografia.class;
			}

		};
	public static final Accessor<Geografia, String> TIPO_ACCESSOR =
		new Accessor<Geografia, String>() {

			@Override
			public String get(Geografia geografia) {
				return geografia.getTipo();
			}

			@Override
			public Class<String> getAttributeClass() {
				return String.class;
			}

			@Override
			public Class<Geografia> getTypeClass() {
				return Geografia.class;
			}

		};
	public static final Accessor<Geografia, String> AREA_ACCESSOR =
		new Accessor<Geografia, String>() {

			@Override
			public String get(Geografia geografia) {
				return geografia.getArea();
			}

			@Override
			public Class<String> getAttributeClass() {
				return String.class;
			}

			@Override
			public Class<Geografia> getTypeClass() {
				return Geografia.class;
			}

		};
	public static final Accessor<Geografia, String> COMPLESSITA_ACCESSOR =
		new Accessor<Geografia, String>() {

			@Override
			public String get(Geografia geografia) {
				return geografia.getComplessita();
			}

			@Override
			public Class<String> getAttributeClass() {
				return String.class;
			}

			@Override
			public Class<Geografia> getTypeClass() {
				return Geografia.class;
			}

		};

}