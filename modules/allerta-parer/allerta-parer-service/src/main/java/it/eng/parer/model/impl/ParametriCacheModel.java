/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.parer.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import it.eng.parer.model.Parametri;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Parametri in entity cache.
 *
 * @author Pratola_L
 * @generated
 */
public class ParametriCacheModel
	implements CacheModel<Parametri>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ParametriCacheModel)) {
			return false;
		}

		ParametriCacheModel parametriCacheModel = (ParametriCacheModel)object;

		if (chiave.equals(parametriCacheModel.chiave)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, chiave);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{chiave=");
		sb.append(chiave);
		sb.append(", valore=");
		sb.append(valore);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Parametri toEntityModel() {
		ParametriImpl parametriImpl = new ParametriImpl();

		if (chiave == null) {
			parametriImpl.setChiave("");
		}
		else {
			parametriImpl.setChiave(chiave);
		}

		if (valore == null) {
			parametriImpl.setValore("");
		}
		else {
			parametriImpl.setValore(valore);
		}

		parametriImpl.resetOriginalValues();

		return parametriImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		chiave = objectInput.readUTF();
		valore = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (chiave == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(chiave);
		}

		if (valore == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(valore);
		}
	}

	public String chiave;
	public String valore;

}