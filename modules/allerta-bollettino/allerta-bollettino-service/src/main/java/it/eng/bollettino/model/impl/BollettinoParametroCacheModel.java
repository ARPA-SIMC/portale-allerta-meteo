/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.bollettino.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import it.eng.bollettino.model.BollettinoParametro;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing BollettinoParametro in entity cache.
 *
 * @author GFAVINI
 * @generated
 */
public class BollettinoParametroCacheModel
	implements CacheModel<BollettinoParametro>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof BollettinoParametroCacheModel)) {
			return false;
		}

		BollettinoParametroCacheModel bollettinoParametroCacheModel =
			(BollettinoParametroCacheModel)object;

		if (parametroId.equals(bollettinoParametroCacheModel.parametroId)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, parametroId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{parametroId=");
		sb.append(parametroId);
		sb.append(", valore=");
		sb.append(valore);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public BollettinoParametro toEntityModel() {
		BollettinoParametroImpl bollettinoParametroImpl =
			new BollettinoParametroImpl();

		if (parametroId == null) {
			bollettinoParametroImpl.setParametroId("");
		}
		else {
			bollettinoParametroImpl.setParametroId(parametroId);
		}

		if (valore == null) {
			bollettinoParametroImpl.setValore("");
		}
		else {
			bollettinoParametroImpl.setValore(valore);
		}

		bollettinoParametroImpl.resetOriginalValues();

		return bollettinoParametroImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		parametroId = objectInput.readUTF();
		valore = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (parametroId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(parametroId);
		}

		if (valore == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(valore);
		}
	}

	public String parametroId;
	public String valore;

}