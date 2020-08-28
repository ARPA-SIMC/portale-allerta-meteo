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

package it.eng.allerter.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

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