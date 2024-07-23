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

package allerta.verifica.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the UtenteLavoro service. Represents a row in the &quot;VERIFICA_UtenteLavoro&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see UtenteLavoroModel
 * @generated
 */
@ImplementationClassName("allerta.verifica.model.impl.UtenteLavoroImpl")
@ProviderType
public interface UtenteLavoro extends PersistedModel, UtenteLavoroModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>allerta.verifica.model.impl.UtenteLavoroImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<UtenteLavoro, Long> ID_ACCESSOR =
		new Accessor<UtenteLavoro, Long>() {

			@Override
			public Long get(UtenteLavoro utenteLavoro) {
				return utenteLavoro.getId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<UtenteLavoro> getTypeClass() {
				return UtenteLavoro.class;
			}

		};

}