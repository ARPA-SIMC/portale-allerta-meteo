/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package allerta.catasto.model.impl;

import allerta.catasto.model.Fonte;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Fonte in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class FonteCacheModel implements CacheModel<Fonte>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof FonteCacheModel)) {
			return false;
		}

		FonteCacheModel fonteCacheModel = (FonteCacheModel)object;

		if (id == fonteCacheModel.id) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, id);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{id=");
		sb.append(id);
		sb.append(", descrizione=");
		sb.append(descrizione);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Fonte toEntityModel() {
		FonteImpl fonteImpl = new FonteImpl();

		fonteImpl.setId(id);

		if (descrizione == null) {
			fonteImpl.setDescrizione("");
		}
		else {
			fonteImpl.setDescrizione(descrizione);
		}

		fonteImpl.resetOriginalValues();

		return fonteImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		descrizione = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(id);

		if (descrizione == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(descrizione);
		}
	}

	public long id;
	public String descrizione;

}