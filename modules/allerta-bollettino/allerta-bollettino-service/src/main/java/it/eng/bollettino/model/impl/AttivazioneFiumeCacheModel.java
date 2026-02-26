/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.bollettino.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import it.eng.bollettino.model.AttivazioneFiume;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing AttivazioneFiume in entity cache.
 *
 * @author GFAVINI
 * @generated
 */
public class AttivazioneFiumeCacheModel
	implements CacheModel<AttivazioneFiume>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AttivazioneFiumeCacheModel)) {
			return false;
		}

		AttivazioneFiumeCacheModel attivazioneFiumeCacheModel =
			(AttivazioneFiumeCacheModel)object;

		if (fiumeId.equals(attivazioneFiumeCacheModel.fiumeId)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, fiumeId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{fiumeId=");
		sb.append(fiumeId);
		sb.append(", attivo=");
		sb.append(attivo);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AttivazioneFiume toEntityModel() {
		AttivazioneFiumeImpl attivazioneFiumeImpl = new AttivazioneFiumeImpl();

		if (fiumeId == null) {
			attivazioneFiumeImpl.setFiumeId("");
		}
		else {
			attivazioneFiumeImpl.setFiumeId(fiumeId);
		}

		attivazioneFiumeImpl.setAttivo(attivo);

		attivazioneFiumeImpl.resetOriginalValues();

		return attivazioneFiumeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		fiumeId = objectInput.readUTF();

		attivo = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (fiumeId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(fiumeId);
		}

		objectOutput.writeBoolean(attivo);
	}

	public String fiumeId;
	public boolean attivo;

}