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
 * The extended model interface for the RubricaRuoloPermessi service. Represents a row in the &quot;rubrica_RubricaRuoloPermessi&quot; database table, with each column mapped to a property of this class.
 *
 * @author Pratola_L
 * @see RubricaRuoloPermessiModel
 * @generated
 */
@ImplementationClassName("it.eng.allerte.model.impl.RubricaRuoloPermessiImpl")
@ProviderType
public interface RubricaRuoloPermessi
	extends PersistedModel, RubricaRuoloPermessiModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>it.eng.allerte.model.impl.RubricaRuoloPermessiImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<RubricaRuoloPermessi, Long>
		FK_ID_RUOLO_ACCESSOR = new Accessor<RubricaRuoloPermessi, Long>() {

			@Override
			public Long get(RubricaRuoloPermessi rubricaRuoloPermessi) {
				return rubricaRuoloPermessi.getFK_ID_RUOLO();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<RubricaRuoloPermessi> getTypeClass() {
				return RubricaRuoloPermessi.class;
			}

		};
	public static final Accessor<RubricaRuoloPermessi, String>
		FK_ID_PERMESSO_ACCESSOR = new Accessor<RubricaRuoloPermessi, String>() {

			@Override
			public String get(RubricaRuoloPermessi rubricaRuoloPermessi) {
				return rubricaRuoloPermessi.getFK_ID_PERMESSO();
			}

			@Override
			public Class<String> getAttributeClass() {
				return String.class;
			}

			@Override
			public Class<RubricaRuoloPermessi> getTypeClass() {
				return RubricaRuoloPermessi.class;
			}

		};

}