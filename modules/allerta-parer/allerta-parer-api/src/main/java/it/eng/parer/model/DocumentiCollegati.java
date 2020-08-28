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

package it.eng.parer.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the DocumentiCollegati service. Represents a row in the &quot;parer_DocumentiCollegati&quot; database table, with each column mapped to a property of this class.
 *
 * @author Pratola_L
 * @see DocumentiCollegatiModel
 * @generated
 */
@ImplementationClassName("it.eng.parer.model.impl.DocumentiCollegatiImpl")
@ProviderType
public interface DocumentiCollegati
	extends DocumentiCollegatiModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>it.eng.parer.model.impl.DocumentiCollegatiImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<DocumentiCollegati, String>
		DOC_COLLEGATO_NUMERO_ACCESSOR =
			new Accessor<DocumentiCollegati, String>() {

				@Override
				public String get(DocumentiCollegati documentiCollegati) {
					return documentiCollegati.getDOC_COLLEGATO_NUMERO();
				}

				@Override
				public Class<String> getAttributeClass() {
					return String.class;
				}

				@Override
				public Class<DocumentiCollegati> getTypeClass() {
					return DocumentiCollegati.class;
				}

			};
	public static final Accessor<DocumentiCollegati, Integer>
		DOC_COLLEGATO_ANNO_ACCESSOR =
			new Accessor<DocumentiCollegati, Integer>() {

				@Override
				public Integer get(DocumentiCollegati documentiCollegati) {
					return documentiCollegati.getDOC_COLLEGATO_ANNO();
				}

				@Override
				public Class<Integer> getAttributeClass() {
					return Integer.class;
				}

				@Override
				public Class<DocumentiCollegati> getTypeClass() {
					return DocumentiCollegati.class;
				}

			};
	public static final Accessor<DocumentiCollegati, String>
		DOC_COLLEGATO_TIPO_REGISTRO_ACCESSOR =
			new Accessor<DocumentiCollegati, String>() {

				@Override
				public String get(DocumentiCollegati documentiCollegati) {
					return documentiCollegati.getDOC_COLLEGATO_TIPO_REGISTRO();
				}

				@Override
				public Class<String> getAttributeClass() {
					return String.class;
				}

				@Override
				public Class<DocumentiCollegati> getTypeClass() {
					return DocumentiCollegati.class;
				}

			};
	public static final Accessor<DocumentiCollegati, Long> ID_INVIO_ACCESSOR =
		new Accessor<DocumentiCollegati, Long>() {

			@Override
			public Long get(DocumentiCollegati documentiCollegati) {
				return documentiCollegati.getID_INVIO();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<DocumentiCollegati> getTypeClass() {
				return DocumentiCollegati.class;
			}

		};

}