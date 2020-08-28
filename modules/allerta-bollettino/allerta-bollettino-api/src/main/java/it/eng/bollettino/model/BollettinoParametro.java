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

package it.eng.bollettino.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the BollettinoParametro service. Represents a row in the &quot;BOLLETTINO_BollettinoParametro&quot; database table, with each column mapped to a property of this class.
 *
 * @author GFAVINI
 * @see BollettinoParametroModel
 * @generated
 */
@ImplementationClassName("it.eng.bollettino.model.impl.BollettinoParametroImpl")
@ProviderType
public interface BollettinoParametro
	extends BollettinoParametroModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>it.eng.bollettino.model.impl.BollettinoParametroImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<BollettinoParametro, String>
		PARAMETRO_ID_ACCESSOR = new Accessor<BollettinoParametro, String>() {

			@Override
			public String get(BollettinoParametro bollettinoParametro) {
				return bollettinoParametro.getParametroId();
			}

			@Override
			public Class<String> getAttributeClass() {
				return String.class;
			}

			@Override
			public Class<BollettinoParametro> getTypeClass() {
				return BollettinoParametro.class;
			}

		};

}