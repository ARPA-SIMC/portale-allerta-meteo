/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.animazione.image.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import it.eng.animazione.image.model.Parametro;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Parametro in entity cache.
 *
 * @author UTENTE
 * @generated
 */
public class ParametroCacheModel
	implements CacheModel<Parametro>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ParametroCacheModel)) {
			return false;
		}

		ParametroCacheModel parametroCacheModel = (ParametroCacheModel)object;

		if (key.equals(parametroCacheModel.key)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, key);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{key=");
		sb.append(key);
		sb.append(", value=");
		sb.append(value);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Parametro toEntityModel() {
		ParametroImpl parametroImpl = new ParametroImpl();

		if (key == null) {
			parametroImpl.setKey("");
		}
		else {
			parametroImpl.setKey(key);
		}

		if (value == null) {
			parametroImpl.setValue("");
		}
		else {
			parametroImpl.setValue(value);
		}

		parametroImpl.resetOriginalValues();

		return parametroImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		key = objectInput.readUTF();
		value = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (key == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(key);
		}

		if (value == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(value);
		}
	}

	public String key;
	public String value;

}