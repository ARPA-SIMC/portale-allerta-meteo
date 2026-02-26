/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerta.messages.services.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import it.eng.allerta.messages.services.model.Auth;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Auth in entity cache.
 *
 * @author Giorgianni_F
 * @generated
 */
public class AuthCacheModel implements CacheModel<Auth>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AuthCacheModel)) {
			return false;
		}

		AuthCacheModel authCacheModel = (AuthCacheModel)object;

		if (key.equals(authCacheModel.key)) {
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
	public Auth toEntityModel() {
		AuthImpl authImpl = new AuthImpl();

		if (key == null) {
			authImpl.setKey("");
		}
		else {
			authImpl.setKey(key);
		}

		if (value == null) {
			authImpl.setValue("");
		}
		else {
			authImpl.setValue(value);
		}

		authImpl.resetOriginalValues();

		return authImpl;
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