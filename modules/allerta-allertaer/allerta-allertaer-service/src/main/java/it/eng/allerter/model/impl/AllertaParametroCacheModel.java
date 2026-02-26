/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerter.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import it.eng.allerter.model.AllertaParametro;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing AllertaParametro in entity cache.
 *
 * @author GFAVINI
 * @generated
 */
public class AllertaParametroCacheModel
	implements CacheModel<AllertaParametro>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AllertaParametroCacheModel)) {
			return false;
		}

		AllertaParametroCacheModel allertaParametroCacheModel =
			(AllertaParametroCacheModel)object;

		if (parametroId.equals(allertaParametroCacheModel.parametroId)) {
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
	public AllertaParametro toEntityModel() {
		AllertaParametroImpl allertaParametroImpl = new AllertaParametroImpl();

		if (parametroId == null) {
			allertaParametroImpl.setParametroId("");
		}
		else {
			allertaParametroImpl.setParametroId(parametroId);
		}

		if (valore == null) {
			allertaParametroImpl.setValore("");
		}
		else {
			allertaParametroImpl.setValore(valore);
		}

		allertaParametroImpl.resetOriginalValues();

		return allertaParametroImpl;
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